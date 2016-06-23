package by.mvcom.smartfeed.socnet.vkapi;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by puma on 23.06.16.
 */
public class VKRequest {

    public static final String CAPTCHA_SID = "captcha_sid";
    public static final String CAPTCHA_KEY = "captcha_key";
    public static final String IP_H = "ip_h";
    public static final String LG_H = "lg_h";
    public static final String ORIGIN = "_origin";

    private static final String FIND_PATTERN = "<input type=\"hidden\" name=\"%s\" value=\"[^\"]*\" />";

    private String captchaSid;
    private String captchaKey;
    private String iph;
    private String lgh;
    private String origin;

    public VKRequest(String vkResponse){
        String iphInput = findInput(vkResponse, String.format(FIND_PATTERN, IP_H));
        String lghInput = findInput(vkResponse, String.format(FIND_PATTERN, LG_H));
        iph = findValue(iphInput);
        lgh = findValue(lghInput);
        origin = "https://new.vk.com";
        captchaKey = "";
        captchaSid = "";

    }

    private String findValue(String input){
        return input.substring(input.indexOf("value") + 7, input.indexOf("\" />"));
    }

    private String findInput(String vkResponse, String regPattern){
        Pattern pattern = Pattern.compile(regPattern);
        Matcher matcher = pattern.matcher(vkResponse);
        if (matcher.find()){
            int startIndex = matcher.start();
            int finishIndex = matcher.end();
            return vkResponse.substring(startIndex, finishIndex);
        }
        return null;
    }

    public void makeRequestParams(Map<String, Object> params){
        params.put(CAPTCHA_SID, captchaSid);
        params.put(CAPTCHA_KEY, captchaKey);
        params.put(IP_H, iph);
        params.put(LG_H, lgh);
        params.put(ORIGIN, origin);
    }

    public String getCaptchaSid() {
        return captchaSid;
    }

    public void setCaptchaSid(String captchaSid) {
        this.captchaSid = captchaSid;
    }

    public String getCaptchaKey() {
        return captchaKey;
    }

    public void setCaptchaKey(String captchaKey) {
        this.captchaKey = captchaKey;
    }

    public String getIph() {
        return iph;
    }

    public void setIph(String iph) {
        this.iph = iph;
    }

    public String getLgh() {
        return lgh;
    }

    public void setLgh(String lgh) {
        this.lgh = lgh;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }
}
