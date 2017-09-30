package com.dyz.persist.util;

import com.context.ErrorCode;
import com.dyz.gameserver.commons.session.GameSession;
import com.dyz.gameserver.msg.response.ErrorResponse;

import java.io.IOException;

/**
 * Created by kevin on 2016/6/23.
 */
public class GlobalUtil {

    public static boolean checkIsLogin(GameSession session){
        if(session.isLogin() == false){
            System.out.println("账户未登录或已经掉线!");
            try {
                session.sendMsg(new ErrorResponse(ErrorCode.Error_000002));
            } catch (IOException e) {
                e.printStackTrace();
            }
            return false;
        }
        return true;
    }

    public static int getRandomUUid(){
        double d = Math.random();
        //System.out.println(d);
        String subStr = String.valueOf(d).substring(7,13);
        int result = Integer.parseInt(subStr);
        return result;
    }

    public static int[] CloneIntList(int[] List) {
        int[] result = new int[List.length];
        for(int i=0;i<List.length;i++){
            result[i] = List[i];
        }
        return result;
    }

    public static String PrintPaiList(int[] list) {
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < list.length; i++) {
            String s = "";
            if (list[i] > 0) {
                for (int j = 0; j < list[i]; j++) {
                    if (i >= 0 && i <= 8) {
                        s = Integer.toString(i + 1) + "万";
                    } else if (i >= 9 && i <= 17) {
                        s = Integer.toString(i - 9 + 1) + "索";
                    } else if (i >= 18 && i <= 26) {
                        s = Integer.toString(i - 18 + 1) + "筒";
                    } else if (i == 27) {
                        s = "东";
                    } else if (i == 28) {
                        s = "南";
                    } else if (i == 29) {
                        s = "西";
                    } else if (i == 30) {
                        s = "北";
                    } else if (i == 31) {
                        s = "中";
                    } else if (i == 32) {
                        s = "发";
                    } else if (i == 33) {
                        s = "白";
                    }

                    buf.append(s + ",");
                }
            }
        }

        return buf.toString();
    }
}
