package com.weipai.service;

import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.weipai.model.Manager;
import com.weipai.model.Resources;

public interface ManagerService {
	int deleteByPrimaryKey(Integer id);

    int save(Manager record);

    int saveSelective(Manager record);

    Manager selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Manager record);

    int updateByPrimaryKey(Manager record);
	/**
	 * 根据用户名得到密码
	 * @param username
	 * @return
	 */
	Manager selectManagerByUsername(String username);
	  /**
     * 根据不同条件得到代理商/零售商列表
     * @param map
     * @return
     */
    List<Manager> selectObjectsByMap(Map<String ,Integer> map);
    /**
     * @param id  被充值玩家的id
     * @param manager  充值管理员
     * @param payCardNum  充值房卡的数量
     * @return
     */
    JSONObject  updateAccountRoomCard(Integer id,Manager manager,Integer payCardNum);
    /**
     * @param id  被充值玩家的id
     * @param manager  充值管理员
     * @param payCardNum  充值房卡的数量
     * @return
     */
    JSONObject  updateManagerRoomCard(Integer id,Manager manager,Integer payCardNum);
	/**
	 * 获取中奖人信息
	 * @param status
	 * @return
	 */
    JSONArray getWinnersInfo(String status);
    /**
     * 获取所有精品信息
     * @return
     */
    JSONArray getPrizesInfo();
    /**
     * 修改单个奖品信息
     * @param map
     * @return
     */
    JSONObject updatePrizeInfo(Map<String,Integer> map);
    /**
     * 增加公告
     * @param notice
     * @return
     */
    JSONObject saveNewNotice(String notice);
}
