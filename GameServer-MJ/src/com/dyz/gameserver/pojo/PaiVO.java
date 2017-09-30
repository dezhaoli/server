package com.dyz.gameserver.pojo;

/**
 * Created by howe on 2017/9/29.
 */
public class PaiVO {
    public int getWanCount() {
        return wanCount;
    }

    public int getTiaoCount() {
        return tiaoCount;
    }

    public int getTongCount() {
        return tongCount;
    }

    public int getFengCount() {
        return fengCount;
    }

    public int getZfbCount() {
        return zfbCount;
    }

    public int getZhongCount() {
        return zhongCount;
    }

    public int getFaCount() {
        return faCount;
    }

    public int getBaiCount() {
        return baiCount;
    }

    private int wanCount = 0; // 万子牌数
    private int tiaoCount = 0; // 条子牌数
    private int tongCount = 0; // 筒子牌数
    private int fengCount = 0; // 风牌数
    private int zfbCount = 0; // 中发白牌数
    private int zhongCount = 0; // 中牌数
    private int faCount = 0; // 发牌数
    private int baiCount = 0; // 白牌数

    public PaiVO(int[] pai) {
        for (int i = 0; i < pai.length; i++) {
            if (pai[i] == 0) {
                continue;
            }

            if (i >= 0 && i <= 8) {
                wanCount += pai[i];
            } else if (i >= 9 && i <= 17) {
                tiaoCount += pai[i];
            } else if (i >= 18 && i <= 26) {
                tongCount += i;
            } else if (i >= 27 && i <= 30) {
                fengCount += i;
            } else {
                switch (i) {
                    case 31: zhongCount++; break;
                    case 32: faCount++; break;
                    case 33: baiCount++; break;
                    default:break;
                }
                zfbCount += i;
            }
        }
    }



}
