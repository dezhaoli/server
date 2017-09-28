package com.weipai.service.impl;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.weipai.client.ClientSendRequest;
import com.weipai.mapper.AccountMapper;
import com.weipai.mapper.ManagerMapper;
import com.weipai.mapper.NoticeTableMapper;
import com.weipai.mapper.PrizeMapper;
import com.weipai.mapper.WinnersInfoMapper;
import com.weipai.model.Account;
import com.weipai.model.Manager;
import com.weipai.model.NoticeTable;
import com.weipai.model.Prize;
import com.weipai.model.WinnersInfo;
import com.weipai.service.ManagerService;
import com.weipai.utils.DateUtil;

@Service
@Transactional(propagation=Propagation.REQUIRED,rollbackFor=RuntimeException.class)
public class ManagerServiceImpl implements ManagerService {

	
	public static final String IP_ADDR = "localhost";//服务器地址 
	public static final int PORT = 10123;//服务器端口号  

	@Resource
	ManagerMapper managerMapper;
	@Resource
	AccountMapper accountMapper;
	@Resource
	WinnersInfoMapper winnersInfoMapper;
	@Resource
	PrizeMapper prizeMapper;
	@Resource
	NoticeTableMapper noticeTableMapper;
	
	public Manager selectManagerByUsername(String username) {
		
		return managerMapper.selectObjectByUsername(username);
	}
	
	public List<Manager> selectObjectsByMap(Map<String, Integer> map) {
		
		return managerMapper.selectObjectsByMap(map);
	}

	public int deleteByPrimaryKey(Integer id){
		return managerMapper.deleteByPrimaryKey(id);
	}

	public int save(Manager record){
    	return managerMapper.save(record);
    }

	public int saveSelective(Manager record){
    	return managerMapper.saveSelective(record);
    }

	public Manager selectByPrimaryKey(Integer id){
    	return managerMapper.selectByPrimaryKey(id);
    }

	public int updateByPrimaryKeySelective(Manager record){
    	return managerMapper.updateByPrimaryKeySelective(record);
    }

	public int updateByPrimaryKey(Manager record){
    	return managerMapper.updateByPrimaryKey(record);
    }

	
	/**
     * @param accountid  被充值玩家
     * @param manager 充值管理员
     * @param payCardNum  充值房卡的数量
     * @return
     */
	@Override
	public JSONObject updateAccountRoomCard(Integer accountid,Manager manager,
			Integer payCardNum) {
		JSONObject json = new JSONObject();
		if(manager.getPowerId() != 1){
			//1：不是超级管理元的情况下，检查mananger的房卡是否够充值
				if(manager.getActualcard() >= payCardNum){
					//修改玩家用户房卡，同时修改代理商或经销商房卡数量
					Account account = accountMapper.selectByPrimaryKey(accountid);
					Map<String, Integer> param = new HashMap<String, Integer>();
					int finishRoomCard = account.getRoomcard() + payCardNum;
					int finishTotalcard = account.getTotalcard() + payCardNum;
					param.put("roomcard", finishRoomCard);
					param.put("totalcard", finishTotalcard);
					param.put("id", account.getId());
					manager = managerMapper.selectByPrimaryKey(manager.getId());
					Map<String, Integer> map = new HashMap<String, Integer>();
					map.put("actualcard", manager.getActualcard() - payCardNum);
					map.put("id", manager.getId());
					try {
						//修改玩家房卡
						accountMapper.updateRoomCard(param);
						//代理商/经销商房卡
						managerMapper.updateActualcard(map);
						json.put("status", "0");
						//修改完玩家房卡之后通知游戏后台
						String sendInfo = account.getId()+","+finishRoomCard;
						//发送消息给游戏后台
						Socket socket = null;
			        	try {
			        		//创建一个流套接字并将其连接到指定主机上的指定端口号
			        		socket = new Socket(IP_ADDR, PORT);
				            //读取服务器端数据  
				            DataInputStream input = new DataInputStream(socket.getInputStream());  
				            //向服务器端发送数据  
				            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
				            Thread.sleep(1000);
							//不同操作不同的ConnectAPI.CREATEROOM_REQUEST值    消息处理方式
							ClientSendRequest loginSend = new ClientSendRequest(0x158888);

							loginSend.output.writeUTF(sendInfo);
							out.write(loginSend.entireMsg().array());
							
							out.flush();
							out.close();
				            input.close();
			        	} catch (Exception e) {
			        		System.out.println("客户端异常:" + e.getMessage()); 
				            json.put("status", "1");
				            json.put("error", "游戏端发送消息异常");
			        	} finally {
			        		if (socket != null) {
			        			try {
									socket.close();
								} catch (IOException e) {
									socket = null; 
									System.out.println("客户端 finally 异常:" + e.getMessage()); 
								}
			        		}
			        	}
					} catch (Exception e) {
						e.printStackTrace();
						json.put("status", "1");
						json.put("error", "数据处理有误");
					}
				}
				else{
					System.out.println("代理商/经销商房卡不足!");
					json.put("status", "1");
					json.put("error", "你的房卡不足");
				}
		}
		else{
			//超级管理员修改玩家用户房卡,但不修改超级管理员房卡数量
			Account account = accountMapper.selectByPrimaryKey(accountid);
			Map<String, Integer> param = new HashMap<String, Integer>();
			int finishRoomCard = account.getRoomcard() + payCardNum;
			int finishTotalcard = account.getTotalcard() + payCardNum;
			param.put("roomcard", finishRoomCard);
			param.put("totalcard", finishTotalcard);
		
//			param.put("roomcard", account.getRoomcard() + payCardNum);
//			param.put("totalcard", account.getTotalcard() + payCardNum);
			param.put("id", account.getId());
			try {
				accountMapper.updateRoomCard(param);
				json.put("status", "0");
				//修改完玩家房卡之后通知游戏后台
				String sendInfo = account.getId()+","+finishRoomCard;
				//发送消息给游戏后台
				Socket socket = null;
	        	try {
	        		//创建一个流套接字并将其连接到指定主机上的指定端口号
	        		socket = new Socket(IP_ADDR, PORT);  
		            //读取服务器端数据  
		            DataInputStream input = new DataInputStream(socket.getInputStream());  
		            //向服务器端发送数据  
		            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
		            Thread.sleep(1000);
					//不同操作不同的ConnectAPI.CREATEROOM_REQUEST值    消息处理方式
					ClientSendRequest loginSend = new ClientSendRequest(0x158888);
					
					loginSend.output.writeUTF(sendInfo);
					out.write(loginSend.entireMsg().array());
					
					out.close();
		            input.close();
	        	} catch (Exception e) {
	        		System.out.println("客户端异常:" + e.getMessage()); 
		            json.put("status", "1");
		            json.put("error", "游戏端发送消息异常");
	        	} finally {
	        		if (socket != null) {
	        			try {
							socket.close();
						} catch (IOException e) {
							socket = null; 
							System.out.println("客户端 finally 异常:" + e.getMessage()); 
						}
	        		}
	        	}
			} catch (Exception e) {
				e.printStackTrace();
				json.put("status", "1");
				json.put("error", "数据处理有误");
			}
		}
		return json;
	}

	 /**
     * @param id  代理商/经销商的id
     * @param manager 充值管理员
     * @param payCardNum  充值房卡的数量
     * @return
     */
	@Override
	public JSONObject updateManagerRoomCard(Integer managerid,Manager manager,
			Integer payCardNum) {
		JSONObject json = new JSONObject();
		//1：不是超级管理元的情况下，检查mananger的房卡是否够充值
		if(manager.getPowerId() != 1){
				if(manager.getActualcard() >= payCardNum){
					//修改经销商房卡
					Manager managered = managerMapper.selectByPrimaryKey(managerid);
					Map<String, Integer> param = new HashMap<String, Integer>();
					param.put("actualcard", managered.getActualcard() + payCardNum);
					param.put("totalcards", managered.getTotalcards() + payCardNum);
					param.put("id", managered.getId());
					manager = managerMapper.selectByPrimaryKey(manager.getId());
					Map<String, Integer> map = new HashMap<String, Integer>();
					map.put("actualcard", manager.getActualcard() - payCardNum);
					map.put("id", manager.getId());
					try {
						managerMapper.updateActualcard(param);
						//修改管理员/代理商/经销商房卡
						managerMapper.updateActualcard(map);
						json.put("status", "0");
					} catch (Exception e) {
						e.printStackTrace();
						json.put("status", "1");
						json.put("error", "数据处理有误");
					}
				}
				else{
					System.out.println("代理商/经销商房卡不足!");
					json.put("status", "1");
					json.put("error", "你的房卡不足");
				}
		}
		else{
			Manager managered = managerMapper.selectByPrimaryKey(managerid);
			Map<String, Integer> param = new HashMap<String, Integer>();
			param.put("actualcard", managered.getActualcard() + payCardNum);
			param.put("totalcards", managered.getTotalcards() + payCardNum);
			param.put("id", managered.getId());
			try {
				managerMapper.updateActualcard(param);
				json.put("status", "0");
			} catch (Exception e) {
				e.printStackTrace();
				json.put("status", "1");
				json.put("error", "数据处理有误");
			}
		}
		return json;
	}
	/**
	 * 根据状态status获取中奖人信息
	 * @param status
	 * @return
	 */
	public JSONArray getWinnersInfo(String status){
		JSONArray array = new JSONArray();
		
		List<WinnersInfo> winnersinfo = winnersInfoMapper.selectWinnersInfoByMap(status);
		JSONObject json;
		Account account;
		Prize prize;
		for (WinnersInfo winnerinfo : winnersinfo) {
			//微信账号weixin  	微信昵称nickName 	 奖品id:prizeId 	奖品名称:prizeName 
			//奖品数量（不需要） 	获奖时间createTime  发奖时间awardTime 	状态status
			json = new JSONObject();
			account = accountMapper.selectByPrimaryKey(winnerinfo.getAccountId());
			prize = prizeMapper.selectByPrimaryKey(winnerinfo.getPrizeId());
			json.put("weixin", "");
			json.put("nickName", account.getNickname());
			json.put("prizeId", winnerinfo.getPrizeId());
			json.put("prizeName", prize.getPrizeName());
			json.put("createTime", DateUtil.toDefineString(winnerinfo.getCreatetime(), DateUtil.maskC));
			json.put("awardTime", DateUtil.toDefineString(winnerinfo.getAwardtime(), DateUtil.maskC));
			json.put("status", winnerinfo.getStatus());
			array.add(json);
		}
		return array;
	}
	/**
	 * 获取所有奖品信息
	 */
	@Override
	public JSONArray getPrizesInfo() {
		JSONArray array = new JSONArray();
		List<Prize> prizes = prizeMapper.selectPrizes();
		for (Prize prize : prizes) {
			array.add(prize);
		}
		return array;
	}
	/**
	 * 修改单个奖品信息
	 */
	@Override
	public JSONObject updatePrizeInfo(Map<String, Integer> map) {
		
		JSONObject json = new  JSONObject();
		try {
			
			prizeMapper.updatePrizeByMap(map);
			json.put("status_code","0");
		} catch (Exception e) {
			e.printStackTrace();
			json.put("status_code", "1");
		}
		return json;
	}

	@Override
	public JSONObject saveNewNotice(String notice) {
		JSONObject json = new JSONObject();
		NoticeTable noticeTable = new NoticeTable();
		noticeTable.setContent(notice);
		noticeTable.setType(0);
		try {
			int count  = noticeTableMapper.insertSelective(noticeTable);
			if(count >= 1){
				//发送消息给游戏后台
				Socket socket = null;
	        	try {
	        		//创建一个流套接字并将其连接到指定主机上的指定端口号
	        		socket = new Socket(IP_ADDR, PORT);  
		            //读取服务器端数据  
		            DataInputStream input = new DataInputStream(socket.getInputStream());  
		            //向服务器端发送数据  
		            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
		            Thread.sleep(3000);
					//不同操作不同的ConnectAPI.CREATEROOM_REQUEST值    消息处理方式
					ClientSendRequest loginSend = new ClientSendRequest(0x158888);
					loginSend.output.writeUTF("notice");
					out.write(loginSend.entireMsg().array());
					
					out.close();
		            input.close();
		            json.put("status_code", "0");
	        	} catch (Exception e) {
	        		System.out.println("客户端异常:" + e.getMessage()); 
		            json.put("status_code", "1");
		            json.put("error", "游戏端发送消息异常");
	        	} finally {
	        		if (socket != null) {
	        			try {
							socket.close();
						} catch (IOException e) {
							socket = null; 
							System.out.println("客户端 finally 异常:" + e.getMessage()); 
						}
	        		}
	        	}
			}
			else{
				json.put("status_code", "1");
				json.put("error", "信息录入失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
			json.put("status_code", "1");
			json.put("error", "信息录入异常");
		}
		return json;
	}
	
}
