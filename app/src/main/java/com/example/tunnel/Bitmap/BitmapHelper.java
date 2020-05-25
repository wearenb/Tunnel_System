package com.example.tunnel.Bitmap;//package com.example.tunnle.Bitmap;
//
//import java.io.IOException;
//import java.io.InputStream;
//import java.net.HttpURLConnection;
//import java.net.MalformedURLException;
//import java.net.URL;
//
//import android.graphics.Bitmap;
//import android.graphics.BitmapFactory;
//
//public class BitmapHelper {
//    public static Bitmap getBitmap(String path) {
//        try {
//            URL url = new URL(path);
//            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//            conn.setConnectTimeout(5000);
//            conn.setRequestMethod("GET");
//            if (conn.getResponseCode() == 200) {
//                InputStream inputStream = conn.getInputStream();
//                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
//                return bitmap;
//            }
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            System.out.println("读取失败");
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//}