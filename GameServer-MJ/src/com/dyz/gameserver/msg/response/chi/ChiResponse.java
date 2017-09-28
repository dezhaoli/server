package com.dyz.gameserver.msg.response.chi;

import com.context.ConnectAPI;
import com.dyz.gameserver.commons.message.ServerResponse;
import net.sf.json.JSONObject;

import java.io.IOException;

/**
 * 
 * @author luck
 *
 */
public class ChiResponse extends ServerResponse {
    /**
     * 必须调用此方法设置消息号
     *
     * @param status
     */
    public ChiResponse(int status, int cardPoint, int onePoint, int twoPoint, int AvatarId) {
        super(status, ConnectAPI.CHIPAI_RESPONSE);
        if(status >0){
            try {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("cardPoint",cardPoint);
                jsonObject.put("onePoint",onePoint);
                jsonObject.put("twoPoint",twoPoint);
                jsonObject.put("avatarId",AvatarId);

                output.writeUTF(jsonObject.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
            finally {
            	 output.close();
			}
        }
        //entireMsg();
    }
}
