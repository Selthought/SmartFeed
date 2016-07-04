package by.mvcom.smartfeed.util.http;

import by.mvcom.smartfeed.util.UtilException;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;

/**
 *
 * Created by puma on 01.07.16.
 */
public class HttpRequest {

    private static final String COOKIES = "Cookie";

    private ArrayList<Cookie> cookies;
    private String url;
    private ArrayList<HttpParam> params;
    private ArrayList<HttpParam> headers;

    public HttpRequest(String url){
        this.url = url;
        cookies = new ArrayList<>();
        params = new ArrayList<>();
        headers = new ArrayList<>();
    }

    public ArrayList<Cookie> getCookies() {
        return cookies;
    }

    public String getUrl() {
        return url;
    }

    public ArrayList<HttpParam> getParams() {
        return params;
    }

    public ArrayList<HttpParam> getHeaders() {
        return headers;
    }

    public void addCookie(Cookie cookie){
        cookies.add(cookie);
    }

    public void addParam(HttpParam param){
        params.add(param);
    }

    public void addHeaderParam(HttpParam param){
        headers.add(param);
    }

    public void setCookies(ArrayList<Cookie> cookies) {
        this.cookies = cookies;
    }

    public void setParams(ArrayList<HttpParam> params) {
        this.params = params;
    }

    public void setHeaders(ArrayList<HttpParam> headers) {
        this.headers = headers;
    }

    /**
     * метод заполняет http соединение
     * добавляет параметры и кукли для пост запроса
     * @param connection
     */
    public void fillConnection(HttpURLConnection connection) throws UtilException{
        try {
            byte[] postDataBytes = makePostData(params);
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            connection.setRequestProperty("Content-Length", String.valueOf(postDataBytes.length));
            connection.setRequestProperty(COOKIES, makeCookies(cookies));
            connection.getOutputStream().write(postDataBytes);
        }catch (IOException ex){
            throw new UtilException(ex);
        }
    }

    private static byte[] makePostData(ArrayList<HttpParam> params) throws UnsupportedEncodingException {
        StringBuilder postData = new StringBuilder();
        for (HttpParam param : params) {
            if (postData.length() != 0) postData.append('&');
            postData.append(URLEncoder.encode(param.getKey(), "UTF-8"));
            postData.append('=');
            postData.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
        }
        System.out.println(postData.toString());
        return postData.toString().getBytes("UTF-8");
    }

    private  String makeCookies(ArrayList<Cookie> cookies) throws UnsupportedEncodingException {
        StringBuilder cookiesString = new StringBuilder();
        for (Cookie cookie : cookies){
            cookiesString.append(URLEncoder.encode(cookie.getKey(), "UTF-8"));
            cookiesString.append("=");
            cookiesString.append(URLEncoder.encode(cookie.getValue(), "UTF-8"));
            cookiesString.append(";");
        }
        return cookiesString.toString();
    }
}
