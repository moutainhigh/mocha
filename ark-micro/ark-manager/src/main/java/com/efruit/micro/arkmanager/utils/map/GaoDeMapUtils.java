package com.efruit.micro.arkmanager.utils.map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.util.*;
import java.util.Map.Entry;

public class GaoDeMapUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(GaoDeMapUtils.class);

    //key
    private static final String KEY = "9e6f0cf645ecdfc4150a77ab4f3cedb4";
    //步行路径规划
    private static final String WALKING_PATH_PLANNING_URL = "https://restapi.amap.com/v3/direction/walking";
    private static final String OK = "1";
    private static final String OUTPUT = "JSON";

    /**
     * 到目的地的 步行路径规划总距离
     * @param oLonLat 出发点 "116.314423,40.042801"
     * @param dLonLat 目的地 "116.290168,40.050704"
     * @return
     */
    public static double getLonLarByAddress(String oLonLat, String dLonLat) {
        Map<String, String> params = new HashMap<>();
        params.put("key", KEY);
        params.put("origin", oLonLat);
        params.put("destination", dLonLat);
        String url = null;
        try {
            // 拼装url
            url = jointUrl(params, OUTPUT, KEY, WALKING_PATH_PLANNING_URL);
        } catch (Exception e) {
            LOGGER.error("getLonLarByAddress  joinURL  error....");
            e.printStackTrace();
        }
        // 调用高德地图SDK
        String jsonResult = MapHttpUtils.doPost(url, params);
        LOGGER.info("GaoDeMap get data :{}",jsonResult);
        // 解析JSON字符串
        JSONObject jsonObject = JSON.parseObject(jsonResult);
        if (jsonObject.getString("status").equals(OK)) {
            JSONArray pathArray = jsonObject.getJSONObject("route").getJSONArray("paths");
            String distanceString = pathArray.getJSONObject(0).getString("distance");
            double distance = Double.parseDouble(distanceString);
            return distance;
        }
        return 0;
    }



    public static void main(String[] args) {
        String oLonLat = "116.314423,40.042801";
        String dLonLot = "116.290168,40.050704";
        //System.out.println(getLonLarByAddress(oLonLat, dLonLot));

        double lat =40.050484;
        double lon =116.290241;
        System.out.println(baidu2AMap(lat,lon)[0]+"\t"+baidu2AMap(lat,lon)[1]);

    }

    /**
     * 拼接请求字符串
     *
     * @param params
     * @param output
     * @param key
     * @param url
     * @return
     */
    private static String jointUrl(Map<String, String> params, String output, String key, String url) throws IOException {
        StringBuilder baseUrl = new StringBuilder();
        baseUrl.append(url);

        int index = 0;
        Set<Entry<String, String>> entrys = params.entrySet();
        for (Map.Entry<String, String> param : entrys) {
            // 判断是否是第一个参数
            if (index == 0) {
                baseUrl.append("?");
            } else {
                baseUrl.append("&");
            }
            baseUrl.append(param.getKey()).append("=").append(URLEncoder.encode(param.getValue(), "utf-8"));
            index++;
        }
        baseUrl.append("&output=").append(output).append("&key=").append(key);

        return baseUrl.toString();
    }

    public static double[] baidu2AMap(double lat, double lon) {
        try {
            if (lat != 0 && lon != 0) {
                double var4 = 0.006401062D;
                double var6 = 0.0060424805D;
                double[] var2 = null;
                for (int var3 = 0; var3 < 2; ++var3) {
                    var2 = new double[2];
                    double var16 = lon - var4;
                    double var18 = lat - var6;
                    double[] var29 = new double[2];
                    double var24 = Math.cos(b(var16) + Math.atan2(var18, var16)) * (a(var18) + Math.sqrt(var16 * var16 + var18 * var18)) + 0.0065D;
                    double var26 = Math.sin(b(var16) + Math.atan2(var18, var16)) * (a(var18) + Math.sqrt(var16 * var16 + var18 * var18)) + 0.006D;
                    var29[1] = (c(var24));
                    var29[0] = (c(var26));
                    var2[1] = (c(lon + var16 - var29[1]));
                    var2[0] = (c(lat + var18 - var29[0]));
                    var4 = lon - var2[1];
                    var6 = lat - var2[0];
                }

                return var2;
            }
        } catch (Throwable var28) {
            // ll.a(var28, "OffsetUtil", "B2G");
        }

        return new double[]{lat, lon};
    }
    private static double a = 3.141592653589793D;
    private static double a(double var0) {
        return Math.sin(var0 * 3000.0D * (a / 180.0D)) * 2.0E-5D;
    }
    private static double b(double var0) {
        return Math.cos(var0 * 3000.0D * (a / 180.0D)) * 3.0E-6D;
    }
    private static double c(double var0) {
        return (new BigDecimal(var0)).setScale(8, 4).doubleValue();
    }


}
