package by.mvcom.smartfeed.util;

import by.mvcom.smartfeed.util.http.HttpRequest;
import by.mvcom.smartfeed.util.http.HttpResponse;

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

    public static HttpResponse sendPost(HttpRequest request) throws UtilException{
        try {
            URL url = new URL(request.getUrl());

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            request.fillConnection(conn);

            HttpResponse response = new HttpResponse(conn);

            return response;
        }catch (IOException ex){
            throw new UtilException(ex);
        }
    }
}
