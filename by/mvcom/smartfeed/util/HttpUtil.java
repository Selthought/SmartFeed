package by.mvcom.smartfeed.util;

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

    public static String sendPost(Map<String, Object> params, String sUrl) throws UtilException{
        try {
            URL url = new URL(sUrl);

            StringBuilder postData = new StringBuilder();
            for (Map.Entry<String, Object> param : params.entrySet()) {
                if (postData.length() != 0) postData.append('&');
                postData.append(URLEncoder.encode(param.getKey(), "UTF-8"));
                postData.append('=');
                postData.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
            }
            byte[] postDataBytes = postData.toString().getBytes("UTF-8");

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.setRequestProperty("Content-Length", String.valueOf(postDataBytes.length));
            conn.setDoOutput(true);
            conn.getOutputStream().write(postDataBytes);

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
