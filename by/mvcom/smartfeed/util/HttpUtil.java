package by.mvcom.smartfeed.util;

import by.mvcom.smartfeed.util.http.HttpRequest;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

/**
 * Created by puma on 22.06.16.
 *
 */
public class HttpUtil {

    public static String sendPost(HttpRequest request) throws UtilException{
        try {
            URL url = new URL(request.getUrl());

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            request.fillConnection(conn);
            conn.setDoOutput(true);

            Reader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            System.out.println("Response cod: " + conn.getResponseCode());
            System.out.println("Response message: " + conn.getResponseMessage());
            Map<String, List<String>> res = conn.getHeaderFields();
            for (String str : res.keySet()){
                System.out.println(str + ": "  + res.get(str));
            }
            StringBuilder response = new StringBuilder();
            for (int c; (c = in.read()) >= 0; ) {
                response.append((char) c);
                //System.out.print((char)c);
            }
            return response.toString();
        }catch (IOException ex){
            throw new UtilException(ex);
        }
    }
}
