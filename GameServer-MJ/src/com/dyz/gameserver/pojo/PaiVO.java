package com.dyz.gameserver.pojo;

/**
 * Created by howe on 2017/9/29.
 */
public class PaiVO {
    public int getWanCount() {
        int count = 0;
        for (int i = 0; i <= 8; i++) {
            count += pais[i];
        }
        return count;
    }

    public int getTiaoCount() {
        int count = 0;
        for (int i = 9; i <= 17; i++) {
            count += pais[i];
        }
        return count;
    }

    public int getBingCount() {
        int count = 0;
        for (int i = 18; i <= 26; i++) {
            count += pais[i];
        }
        return count;
    }

    public int getFengCount() {

        return getDongCount() + getNanCount() + getXiCount() + getBeiCount();
    }

    public int getZfbCount() {

        return getZhongCount() + getFaCount() + getBaiCount();
    }

    public int getZhongCount() {
        return pais[31];
    }

    public int getFaCount() {
        return pais[32];
    }

    public int getBaiCount() {
        return pais[33];
    }

    public int getDongCount() {
        return pais[27];
    }

    public int getNanCount() {
        return pais[28];
    }

    public int getXiCount() {
        return pais[29];
    }

    public int getBeiCount() {
        return pais[30];
    }

    public int getYaojiuCount() {
        return getWanNCount(1) + getWanNCount(9) + getTiaoNCount(1) + getTiaoNCount(9) + getBingNCount(1) + getBingNCount(9);
    }

    public int getNotyaojiuCount() {
        return pais.length - getYaojiuCount() - getFengCount() + getZfbCount();
    }

    public int getWanNCount(int n) {
        return pais[n - 1];
    }

    public int getTiaoNCount(int n) {
        return pais[9 + n - 1];
    }

    public int getBingNCount(int n) {
        return pais[18 + n - 1];
    }

    public int getPaiSize() {
        return pais.length;
    }

    public int getPaiCount(int i) {
        return pais[i];
    }

    private int pais[];

    public PaiVO(int[] pai) {
        pais = pai;
    }
}
