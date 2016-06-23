package by.mvcom.smartfeed.socnet.vkapi;

import by.mvcom.smartfeed.util.HttpUtil;

import java.util.HashMap;

/**
 * Created by puma on 22.06.16.
 *
 */
public class Start {

    public static void main(String[] argv){
        try{
            HashMap<String, Object> params = new HashMap<>();
            String response = HttpUtil.sendPost(params, "https://new.vk.com/");
            System.out.println(response);

            VKRequest r = new VKRequest(response);
            params = new HashMap<>();
            params.put("role", "al_frame");
            params.put("expire", "");
            params.put("act", "login");
            params.put("email", "+375291175663");
            params.put("pass", "hearthstone");
            r.makeRequestParams(params);
            response = HttpUtil.sendPost(params, "https://login.vk.com/?act=login");
            System.out.print(response);
        }catch (Exception ex){
            System.out.print(ex);
        }
    }
}
