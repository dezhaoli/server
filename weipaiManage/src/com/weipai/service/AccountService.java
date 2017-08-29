package com.weipai.service;

import java.util.List;
import java.util.Map;

import com.weipai.model.Account;


public interface AccountService {

	/**
     * 代理商/零售商得到其下面的所有普通用户
     * @param map
     * @return
     */
     List<Account> selectObjectsByMap(Map<String ,Integer> map);
     /**
      * !-- 对得到条件代理商/零售商下面所有的用户个数 -->
      * @param map
      * @return
      */
     Integer selectObjectCountByMap(Map<String, Integer> map);
     /**
      * 获取所有玩家
      * @param map
      * @return
      */
     List<Account> selectAllAccount(Map<String , Integer> map);
}
