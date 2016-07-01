package by.mvcom.smartfeed.util.http;

import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * http ответ от сервера
 * Created by puma on 01.07.16.
 */
public class HttpResponse {

    private ArrayList<Cookie> cookies;
    private int code;
    private ArrayList<HttpParam> header;
    private String body;

    public HttpResponse(HttpURLConnection connection){
        Map<String, List<String>> fields = connection.getHeaderFields();
        List<String> responseCookies = fields.get("Cookie");
        cookies = new ArrayList<>();
        if (responseCookies != null){
            Cookie cookie;
            try {
                for (String sCookie : responseCookies) {
                    cookie = new Cookie();
                    Scanner scanner = new Scanner(URLDecoder.decode(sCookie, "UTF-8"));
                    scanner.useDelimiter("=");
                    cookie.setKey(scanner.next());
                    cookie.setValue(scanner.next());
                    scanner.close();
                }
            }catch (UnsupportedEncodingException e) {

            }
        }
    }
}
