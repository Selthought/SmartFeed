package by.mvcom.smartfeed.socnet.vkapi;

import by.mvcom.smartfeed.util.HttpUtil;
import by.mvcom.smartfeed.util.http.HttpParam;
import by.mvcom.smartfeed.util.http.HttpRequest;
import by.mvcom.smartfeed.util.http.HttpResponse;


/**
 * Created by puma on 22.06.16.
 *
 */
public class Start {

    public static void main(String[] argv){
        try{
            HttpRequest httpRequest = new HttpRequest("https://new.vk.com/");
            HttpResponse response = HttpUtil.sendPost(httpRequest);
            //System.out.println(response);

            VKRequest r = new VKRequest(response.getBody());
            /*params = new HashMap<>();
            params.put("role", "al_frame");
            params.put("expire", "");
            params.put("act", "login");
            params.put("email", "+375291175663");
            params.put("pass", "hearthstone");
            r.makeRequestParams(params);
            response = HttpUtil.sendPost(params, "https://login.vk.com/?act=login");
            System.out.print(response);*/
            System.out.println("-------------------------------------------------");
            httpRequest = new HttpRequest("https://login.vk.com/?act=login");
            httpRequest.setCookies(response.getCookies());
            httpRequest.addParam(new HttpParam("role", "al_frame"));
            httpRequest.addParam(new HttpParam("expire", ""));
            httpRequest.addParam(new HttpParam("act", "login"));
            httpRequest.addParam(new HttpParam("email", "+375291175663"));
            httpRequest.addParam(new HttpParam("pass", "hearthstone"));
            r.makeRequestParams(httpRequest);
            response = HttpUtil.sendPost(httpRequest);
            System.out.println(response.getBody());
        }catch (Exception ex){
            System.out.print(ex);
        }
    }
}
