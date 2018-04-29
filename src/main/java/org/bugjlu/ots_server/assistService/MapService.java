package org.bugjlu.ots_server.assistService;

import net.sf.json.JSONObject;
import org.bugjlu.ots_server.po.User;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapService {

    public static JSONObject httpRequest(String requestUrl) {
        String requestMethod = "GET";
        JSONObject jsonObject = null;
        StringBuffer buffer = new StringBuffer();
        try {

            URL url = new URL(requestUrl);
            // http协议传输
            HttpURLConnection httpUrlConn = (HttpURLConnection) url.openConnection();

            httpUrlConn.setDoOutput(true);
            httpUrlConn.setDoInput(true);
            httpUrlConn.setUseCaches(false);
            // 设置请求方式（GET/POST）
            httpUrlConn.setRequestMethod(requestMethod);

            if ("GET".equalsIgnoreCase(requestMethod))
                httpUrlConn.connect();
            // 将返回的输入流转换成字符串
            InputStream inputStream = httpUrlConn.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String str = null;
            while ((str = bufferedReader.readLine()) != null) {
                buffer.append(str);
            }
            bufferedReader.close();
            inputStreamReader.close();
            // 释放资源
            inputStream.close();
            inputStream = null;
            httpUrlConn.disconnect();
            jsonObject = JSONObject.fromObject(buffer.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

    public static int getDistanceByPoints(String startX, String startY, String endX, String endY) {
        String url =  String.format("http://api.map.baidu.com/routematrix/v2/walking?"+
                "output=json&origins=" + startY + "," + startX +
                "&destinations=" + endY + "," + endX +
                "&ak=mWWGDtWYDCcAZ769nhiNZYMEbBuyiyrM");
        try {
            JSONObject json = httpRequest(url);

            Integer dist = json.getJSONArray("result").getJSONObject(0).getJSONObject("distance").getInt("value");
            return dist;
        } catch (Exception e) {
            return -1;
        }
    }

    public static double distanceToCoefficient(int dist) {
        if (dist > 0 && dist <= 1000) {
            return 1;
        } else if (dist > 1000 && dist <= 2000) {
            return 0.97;
        } else if (dist > 2000 && dist <= 3000) {
            return 0.94;
        } else if (dist > 3000 && dist <= 4000) {
            return 0.90;
        } else if (dist > 4000 && dist <= 5000) {
            return 0.85;
        } else if (dist > 5000 && dist <= 10000) {
            return 0.65;
        } else {
            return 0;
        }
    }

}
