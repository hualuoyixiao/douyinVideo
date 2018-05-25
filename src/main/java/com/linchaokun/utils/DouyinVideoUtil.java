package com.linchaokun.utils;

/**
 * Created by linchaokun on 2018/5/24.
 */
public class DouyinVideoUtil {
    private static final String BASE_URL = "https://aweme.snssdk.com/aweme/v1/play/?video_id=%s";
    public static void main(String[] args) {
        String shareUrl = "https://www.iesdouyin.com/share/video/6559002106999606532/?region=CN&mid=6416547849739176705&titleType=title_CN_1&utm_source=copy_link&utm_campaign=client_share&utm_medium=android&app=aweme&iid=33421751655&timestamp=1527156305";
        String douyin = douyin(shareUrl);
        System.out.println(douyin);
    }
    public static String douyin(String url){
        try {
            String html = HttpClientUtil.doGet(url);
            int len = html.indexOf("video_id");
            String end = html.substring(len);
            int indexOf = end.indexOf("\",");
            String videoId = end.substring(9, indexOf);
            videoId = videoId.replace("\\u0026", "&");
            return String.format(BASE_URL, videoId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
