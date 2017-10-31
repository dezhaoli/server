package com.dyz.gameserver.pojo;

import java.util.ArrayList;
import java.util.List;

import com.dyz.myBatis.model.Account;
import com.dyz.persist.util.StringUtil;

/**
 * Created by kevin on 2016/6/23.
 */
public class AvatarVO {
    /**
     * 用户基本信息
     */
    private Account account;
    /**
     * 房间号
     */
    private int roomId;
    /**
     * 是否准备
     */
    private boolean isReady = false;
    /**
     * 是否是庄家
     */
    private boolean isMain = false;
    /**
     * 是否在线
     */
    private boolean isOnLine = false;
    /**
     * 当前分数，起始分1000
     */
    private int scores = 1000;
    /**
     * 打了的牌的字符串  1,2,3,4,5,6,1,3,5 格式
     */
    private List<Integer>  chupais = new ArrayList<Integer>();
    /**
     * 普通牌张数
     */
    private int commonCards;
    /**
     * 摸牌出牌状态 
     * 摸了牌/碰/杠 true  出牌了false
     * 为true 表示该出牌了    为false表示不该出牌
     */
    private boolean hasMopaiChupai = false;
    /**
     * 划水麻将  胡牌的类型(1:普通小胡(点炮/自摸)    2:大胡(点炮/自摸))
     * 放弃操作，摸牌，出牌，都需要重置
     */
    private int huType = 0;
    /**
     * 牌数组
     * /碰 1  杠2  胡3  吃4
     */
    private int[][] paiArray;

    public int getMoPaiCount() {
        return moPaiCount;
    }

    public void setMoPaiCount(int moPaiCount) {
        this.moPaiCount = moPaiCount;
    }

    /**
     * 摸的牌数
     */
    private int moPaiCount = 0;

    public boolean isTianHu() {
        return isTianHu;
    }

    public void setTianHu(boolean tianHu) {
        isTianHu = tianHu;
    }

    private boolean isTianHu = false;

    public boolean isRenHu() {
        return isRenHu;
    }

    public void setRenHu(boolean renHu) {
        isRenHu = renHu;
    }

    private boolean isRenHu = false;

    public boolean isDiHu() {
        return isDiHu;
    }

    public void setDiHu(boolean diHu) {
        isDiHu = diHu;
    }

    private boolean isDiHu = false;

    public boolean isHaiDiLaoYue() {
        return isHaiDiLaoYue;
    }

    public void setHaiDiLaoYue(boolean haiDiLaoYue) {
        isHaiDiLaoYue = haiDiLaoYue;
    }

    private boolean isHaiDiLaoYue = false;

    public boolean isGangHu() {
        return isGangHu;
    }

    public void setGangHu(boolean gangHu) {
        isGangHu = gangHu;
    }

    private boolean isGangHu = false;

    public int[] getChiArray() {
        return chiArray;
    }

    public int[] getPengArray() {
        return pengArray;
    }

    public int[] getGangArray() {
        return gangArray;
    }

    public void setChiArray(int[] chiArray) {
        this.chiArray = chiArray;
    }

    public void setPengArray(int[] pengArray) {
        this.pengArray = pengArray;
    }

    public void setGangArray(int[] gangArray) {
        this.gangArray = gangArray;
    }

    /**
     * 吃牌组
     */

    private int[] chiArray;

    /**
     * 碰牌组
     */

    private int[] pengArray;


    /**
     * 杠牌组
     */

    private int[] gangArray;

    public int getFengWei() {
        return fengWei;
    }

    public void setFengWei(int fengWei) {
        this.fengWei = fengWei;
    }

    /**
     * 风位，0：东，1：南，2：西，3：北
     */
    private int fengWei = 0;

    /**
     * 存储整局牌的 杠，胡以及得分情况的对象，游戏结束时直接返回对象
     */
    private HuReturnObjectVO  huReturnObjectVO;
    
    private String IP;

    
   public HuReturnObjectVO getHuReturnObjectVO() {
		return huReturnObjectVO;
	}

	public void setHuReturnObjectVO(HuReturnObjectVO huReturnObjectVO) {
		this.huReturnObjectVO = huReturnObjectVO;
	}
	public Account getAccount() {
        return account;
    }

	public void setAccount(Account account) {
        this.account = account;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public boolean getIsReady() {
        return isReady;
    }

    public void setIsReady(boolean ready) {
        isReady = ready;
    }

    public boolean isMain() {
        return isMain;
    }

    public void setMain(boolean main) {
        isMain = main;
    }

    public boolean getIsOnLine() {
        return isOnLine;
    }

    public void setIsOnLine(boolean onLine) {
        isOnLine = onLine;
    }

    public int[][] getPaiArray() {
        return paiArray;
    }

    public void setPaiArray(int[][] paiArray) {
        this.paiArray = paiArray;
    }

	public List<Integer> getChupais() {
		return chupais;
	}
	/**
	 * 出了的牌添加到数组中
	 * @param chupai
	 */
	public void updateChupais(Integer chupai) {
		chupais.add(chupai);
 	}
	/**
	 * 移除最后一张牌
//	 * @param chupai
	 */
	public void removeLastChupais() {
		int inde = chupais.size();
		chupais.remove(inde-1);
 	}
	
	public int getCommonCards() {
		return commonCards;
	}

	public void setCommonCards(int commonCards) {
		this.commonCards = commonCards;
	}

	public int getScores() {
		return scores;
	}
	/**
	 * 修改分数  正加  负减
	 * @param score
	 */
	public void supdateScores(int score) {
		this.scores = this.scores +score;
	}

	public boolean isHasMopaiChupai() {
		return hasMopaiChupai;
	}

	public void setHasMopaiChupai(boolean hasMopaiChupai) {
		this.hasMopaiChupai = hasMopaiChupai;
	}

	public int getHuType() {
		return huType;
	}

	public void setHuType(int huType) {
		this.huType = huType;
	}

	public String getIP() {
		return IP;
	}

	public void setIP(String iP) {
		IP = iP;
	}

	public void Init(int paiCount) {
        this.setMoPaiCount(0);
        this.setDiHu(false);
        this.setTianHu(false);
        this.setRenHu(false);
        this.setHaiDiLaoYue(false);
        this.setGangHu(false);

        this.setPaiArray(new int[2][paiCount]);
        for (int j = 0; j < 2; j++) {
            for (int k = 0; k < paiCount; k++) {
                this.getPaiArray()[j][k] = 0;
            }
        }

        this.setChiArray(new int[paiCount]);
        this.setPengArray(new int[paiCount]);
        this.setGangArray(new int[paiCount]);

        for (int j = 0; j < paiCount; j++) {
            this.getChiArray()[j] = 0;
            this.getPengArray()[j] = 0;
            this.getGangArray()[j] = 0;
        }
    }
	
	
}
