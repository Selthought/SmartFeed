package by.mvcom.smartfeed.util.http;

import by.mvcom.smartfeed.util.UtilException;

import java.io.*;
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
        for(Map.Entry<String, List<String>> entry : fields.entrySet()){
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        List<String> responseCookies = fields.get("Set-Cookie");
        cookies = new ArrayList<>();
        if (responseCookies != null){
            Cookie cookie;
            try {
                //ищем все куки
                for (String sCookie : responseCookies) {
                    cookie = new Cookie();
                    Scanner scanner = new Scanner(URLDecoder.decode(sCookie, "UTF-8"));
                    //устанавливаем разделити "=" или "; "
                    scanner.useDelimiter("=|;\\ ");
                    // получаем имя кука
                    cookie.setKey(scanner.next());
                    // значение
                    cookie.setValue(scanner.next());
                    // пропускаем имя expires
                    scanner.next();
                    // получаем значение expires
                    cookie.setExpires(scanner.next());
                    scanner.next();
                    cookie.setPath(scanner.next());
                    scanner.next();
                    cookie.setDomain(scanner.next());
                    scanner.close();
                    System.out.println(cookie);
                    cookies.add(cookie);
                }
            }catch (UnsupportedEncodingException e) {

            }
        }
        // читаем тело ответа
        try{
            Reader in = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
            StringBuilder response = new StringBuilder();
            for (int c; (c = in.read()) >= 0; ) {
                response.append((char) c);
            }
            body = response.toString();
        } catch (IOException e) {
            body = null;
        }
    }

    public ArrayList<Cookie> getCookies() {
        return cookies;
    }

    public int getCode() {
        return code;
    }

    public ArrayList<HttpParam> getHeader() {
        return header;
    }

    public String getBody() {
        return body;
    }
}
