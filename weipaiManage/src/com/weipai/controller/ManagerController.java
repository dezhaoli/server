package com.weipai.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.weipai.common.Params;
import com.weipai.controller.base.BaseController;
import com.weipai.model.Account;
import com.weipai.model.Manager;
import com.weipai.model.NoticeTable;
import com.weipai.service.AccountService;
import com.weipai.service.ManagerService;
import com.weipai.service.NoticeTableService;
import com.weipai.utils.StringUtil;

@Controller
@RequestMapping("/controller/manager")
public class ManagerController extends BaseController {

	@Autowired
	private ManagerService managerService;
	@Autowired
	private AccountService accountService;
	@Autowired
	private NoticeTableService noticeTableService;

	/**
	 * 后台登录
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/login")
	public void login(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		JSONObject json = new JSONObject();
		if (StringUtil.isNotEmpty(username) && StringUtil.isNotEmpty(password)) {
			Manager manager = managerService.selectManagerByUsername(username);
			if (manager != null
					&& StringUtil.MD5(password).equals(manager.getPassword())) {
				json.put("mess", "0");
				//登录成功 用户信息放入缓存
				session.setAttribute("manager", manager);
				session.setAttribute("type", manager.getPowerId());
				if(manager.getPowerId() == 1){
					//如果是超管登录  则需要返回最新公告
					NoticeTable notice = noticeTableService.selectRecentlyObject();
					if(notice != null){
						session.setAttribute("notice", notice.getContent()+"");
					}
				}
			} else {
				json.put("mess", "1");
			}
		} else {
			json.put("mess", "2");
		}
		returnMessage(response, json);
	}
	
	/**
	 * 获取所有玩家
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/getAccounts")
	public void getAccounts(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		JSONArray array = new JSONArray();
		Manager manager = (Manager) session.getAttribute("manager");
		if(manager != null){
			Map<String , Integer> map = new HashMap<String, Integer>();
			map.put("startNum", 1);
			map.put("pageNumber", Params.pageNumber);
			//获取所有玩家   
			List<Account> accounts = accountService.selectAllAccount(map);
			for (Account account : accounts) {
				array.add(account);
			}
			returnMessage(response, array);
		}
	}
	
	/**
	 * 获取所有经销商 代理商
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/getManagers")
	public void getManagers(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		JSONArray array = new JSONArray();
		Manager manager = (Manager) session.getAttribute("manager");
		if(manager != null){
			Map<String , Integer> map = new HashMap<String, Integer>();
			map.put("pageNumber", Params.pageNumber);
			if(manager.getPowerId() != 1){
				map.put("startNum", 0);
				//超级管理员可以获取所有
				map.put("managerUpId", manager.getId());
			}else{
				map.put("startNum", 1);
			}
			//获取所有玩家   
			List<Manager> managers = managerService.selectObjectsByMap(map);
			for (Manager m : managers) {
				array.add(m);
			}
			returnMessage(response, array);
		}
	}
	
	
	/**
	 * 添加代理商/零售商账号
	 * @param request
	 * @param response
	 */
	@RequestMapping("/addProxyAccount")
	public void addProxyAccount(HttpServletRequest request, HttpServletResponse response){
		String  newManagerName = request.getParameter("newManagerName");
		String  newManagerPwd = request.getParameter("newManagerPwd");
		String  newManagerTel = request.getParameter("newManagerTel");
		String  newManagerType = request.getParameter("newManagerType");
		JSONObject json = new JSONObject();
		HttpSession session = request.getSession();
		//后期考虑  代理商是否能添加代理商，零售商是否能添加零售商
		if(session != null ){
			if(StringUtil.isPhone(newManagerTel) && StringUtil.isNotEmpty(newManagerName) && StringUtil.isNotEmpty(newManagerPwd)){
				Manager managerOld = managerService.selectManagerByUsername(newManagerName);
				if(managerOld == null){
					//判断账户是否已经被注册
					managerOld = new Manager();
					managerOld. setName(newManagerName);
					managerOld. setPowerId(Integer.parseInt(newManagerType)); 
					managerOld.setTelephone(newManagerTel);
					managerOld.setPassword(StringUtil.MD5(newManagerPwd));
					managerOld. setManagerUpId(((Manager)session.getAttribute("manager")).getId());
					try {
						int result = managerService.saveSelective(managerOld);
						if(result > 0){
							json.put("status", "0");
						}else{
							json.put("status", "1");
							json.put("error", "用户添加失败");
						}
					} catch (Exception e) {
						e.printStackTrace();
						json.put("status", "1");
						json.put("error", "用户添加异常");
					}
				}
				else{
					json.put("status", "1");
					json.put("error", "账户已经被注册");
				}
			}
			else{
				json.put("status", "1");
				json.put("error", "传入参数有误");
			}
		}
		else{
			json.put("status", "1");
			json.put("error", "账户未登录");
		}
		returnMessage(response,json);
	}
	
	
	/**
	 * 查询自己下面所有的用户
	 * @param request
	 * @param response
	 */
	@RequestMapping("/selectAllProxyByMyself")
	public void selectAllProxyByMyself(HttpServletRequest request, HttpServletResponse response){
		
	}
	
	/**
	 * 查询自己下面所有的充值记录
	 * @param request
	 * @param response
	 */
	@RequestMapping("/selectAllLogByMyself")
	public void selectAllLogByMyself(HttpServletRequest request, HttpServletResponse response){
		
	}
	/**
	 *超级管理员可以为所有用户充值房卡
	 *零售商只为玩家充值
	 *代理商只为零售商充值
	 * @param request
	 * @param response
	 */
	@RequestMapping("/addActualCardToAccount")
	public void addActualCardToAccount(HttpServletRequest request, HttpServletResponse response){
		int userid = Integer.parseInt(request.getParameter("userid"));
		int managerid = Integer.parseInt(request.getParameter("managerid"));
		String paycardnum = request.getParameter("payCardNum");
		JSONObject json = new JSONObject();
		if(StringUtil.isInteger(paycardnum, 0, 0)){
			int payCardNum = Integer.parseInt(paycardnum);
			HttpSession session = request.getSession();
			if(session != null){
				Manager manager = (Manager) session.getAttribute("manager");
				if(manager != null && payCardNum != 0){
					//检查mananger的房卡是否够充值
					if(userid != 0 && managerid == 0){
						//说明是为玩家充值
						json = managerService.updateAccountRoomCard(userid, manager, payCardNum);
					}
					else if(managerid != 0 && userid ==0){
						//说明是为代理商或者经销商充值
						json = managerService.updateManagerRoomCard(managerid, manager, payCardNum);
					}
					else{
						System.out.println("传入参数有误");
						json.put("status", "1");
						json.put("error", "传入参数有误");
					}
				}
				else{
					System.out.println("未登录就进行充值的非法操作");
					json.put("status", "1");
					json.put("error", "未登录就进行充值的非法操作");
				}
			}
			else{
				System.out.println("未建立链接就进行充值的非法操作");
				json.put("status", "1");
				json.put("error", "未建立链接就进行充值的非法操作");	
			}
		}
		else{
			json.put("status", "1");
			json.put("error", "请输入正确的充值房卡数量");	
		}
		returnMessage(response,json);
	}
	
	/**
	 * 为代理商或者零售商用户充值房卡
	 * @param request
	 * @param response
	 */
	@RequestMapping("/addActualCardToProxy")
	public void addActualCardToProxy(HttpServletRequest request, HttpServletResponse response){
		int id = Integer.parseInt(request.getParameter("id"));
		int addCardNum = Integer.parseInt(request.getParameter("addCardNum"));
	}
	/**
	 * 设置用户状态
	 * @param request
	 * @param response
	 */
	@RequestMapping("/setAccountStatus")
	public void setAccountStatus(HttpServletRequest request, HttpServletResponse response){
		int uuid = Integer.parseInt(request.getParameter("uuid"));
		int status = Integer.parseInt(request.getParameter("status"));
	}
	
	/**
	 * 删除代理商用户
	 * @param request
	 * @param response
	 */
	@RequestMapping("/deleteProxyAccount")
	public void deleteProxyAccount(HttpServletRequest request, HttpServletResponse response){
		int id = Integer.parseInt(request.getParameter("id"));
		int result = managerService.deleteByPrimaryKey(id);
		
		JSONObject json = new JSONObject();
		if(result > 0){
			json.put("mess", "删除代理商用户成功");
			System.out.println("删除代理商用户成功");
		}else{
			json.put("mess", "删除代理商用户失败");
		}
		returnMessage(response,json);
	}
	
	/**
	 * 获取所有奖品信息
	 * @param request
	 * @param response
	 */
	@RequestMapping("/prizesInfo")
	public void prizesInfo(HttpServletRequest request, HttpServletResponse response){
		HttpSession session = request.getSession();
		JSONArray array = new JSONArray();
		if(session != null){
			Manager manager = (Manager) session.getAttribute("manager");
			if(manager != null){
				try {
					array = managerService.getPrizesInfo();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		returnMessage(response,array);
	}	
	
	/**
	 * 修改单个奖品信息概率，等信息
	 * @param request
	 * @param response
	 */
	@RequestMapping("/updatePrizeInfo")
	public void updatePrizeInfo(HttpServletRequest request, HttpServletResponse response){
		HttpSession session = request.getSession();
		String probability = request.getParameter("probability");
		String id = request.getParameter("id");
		JSONObject json = new JSONObject();
		if(session != null){
			Manager manager = (Manager) session.getAttribute("manager");
			if(manager != null){
				Map<String,Integer> map = new HashMap<String, Integer>();
				map.put("id",Integer.parseInt(id));
				map.put("probability", Integer.parseInt(probability));
				try {
					json = managerService.updatePrizeInfo(map);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		returnMessage(response,json);
	}	
	
	/**
	 * 获取抽奖信息
	 * @param request
	 * @param response
	 */
	@RequestMapping("/winnersInfo")
	public void winnersInfo(HttpServletRequest request, HttpServletResponse response){
		HttpSession session = request.getSession();
		JSONArray array = new JSONArray();
		if(session != null){
			Manager manager = (Manager) session.getAttribute("manager");
			if(manager != null){
				String status = request.getParameter("status");
				try {
					array = managerService.getWinnersInfo(status);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			/*else{
				System.out.println("未登录就进行充值的非法操作");
				json.put("status", "1");
				json.put("error", "未登录就进行充值的非法操作");
			}*/
		}
		/*else{
			System.out.println("未建立链接就进行充值的非法操作");
			json.put("status", "1");
			json.put("error", "未建立链接就进行充值的非法操作");	
		}*/
		returnMessage(response,array);
	}
	
	/**
	 * 发送公告，通知游戏后台，发送公告
	 * @param request
	 * @param response
	 */
	@RequestMapping("/sendNotice")
	public void sendNotice(HttpServletRequest request, HttpServletResponse response){
		HttpSession session = request.getSession();
		JSONObject json = new JSONObject();
		if(session != null){
			Manager manager = (Manager) session.getAttribute("manager");
			if(manager != null){
				String notice = request.getParameter("notice");
				try {
					json = managerService.saveNewNotice(notice);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		returnMessage(response,json);
	}
	
}
