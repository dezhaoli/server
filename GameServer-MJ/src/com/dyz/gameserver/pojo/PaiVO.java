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

    public int getDongCount() {
        return dongCount;
    }

    public int getNanCount() {
        return nanCount;
    }

    public int getXiCount() {
        return xiCount;
    }

    public int getBeiCount() {
        return beiCount;
    }

    private int wanCount = 0; // 万子牌数
    private int tiaoCount = 0; // 条子牌数
    private int tongCount = 0; // 筒子牌数
    private int fengCount = 0; // 风牌数
    private int dongCount = 0; //东风牌数
    private int nanCount = 0; // 南风牌数
    private int xiCount = 0; // 西风牌数
    private int beiCount = 0; // 北风牌数
    private int zfbCount = 0; // 中发白牌数
    private int zhongCount = 0; // 中牌数
    private int faCount = 0; // 发牌数
    private int baiCount = 0; // 白牌数

    public int getYaojiuCount() {
        return yaojiuCount;
    }

    public int getNotyaojiuCount() {
        return notyaojiuCount;
    }

    private int yaojiuCount = 0; // 幺九牌数
    private int notyaojiuCount = 0; // 非幺九牌数

    public PaiVO(int[] pai) {
        for (int i = 0; i < pai.length; i++) {
            if (pai[i] == 0) {
                continue;
            }

            if (i >= 0 && i <= 8) {
                if (pai[i] == 0 || pai[i] == 8) {
                    yaojiuCount++;
                } else {
                    notyaojiuCount++;
                }

                wanCount += pai[i];
            } else if (i >= 9 && i <= 17) {
                if (pai[i] == 9 || pai[i] == 17) {
                    yaojiuCount++;
                } else {
                    notyaojiuCount++;
                }

                tiaoCount += pai[i];
            } else if (i >= 18 && i <= 26) {
                if (pai[i] == 18 || pai[i] == 26) {
                    yaojiuCount++;
                } else {
                    notyaojiuCount++;
                }

                tongCount += i;
            } else if (i >= 27 && i <= 30) {
                switch (i) {
                    case 27: dongCount++; break;
                    case 28: nanCount++; break;
                    case 29: xiCount++; break;
                    case 30: beiCount++; break;
                    default:break;
                }

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
