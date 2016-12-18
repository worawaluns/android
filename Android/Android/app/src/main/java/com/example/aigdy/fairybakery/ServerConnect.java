package com.example.aigdy.fairybakery;

import android.os.StrictMode;
import android.util.Log;

import com.example.aigdy.fairybakery.Model.EntityModel;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by aigdy on 11/27/2016 AD.
 */

public class ServerConnect {
    public final static String http = "http://";
    public final static String ip = "192.168.1.2"; //ถ้าเอาลง host จริงจะใช้เป็น "www.xxx.com"
    public final static String dir = "fairy_bakery";
    public final static String seturl = http+ip+"/"+dir;

    public ServerConnect(){
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
    }

    public String connect(String page,boolean response){

        //1.Create StringBuilder for response streaming data
        //String เราจะเพิ่มมันไม่ได้แต่มันจะเอาข้อความเข้าไปใหม่ แต่ StringBuilder จะมีโครงสร้างแบบลิสต์ คือ
        //สามารถเอาคำมาต่อกันได้ ที่ต้องใช้เพราะว่าอาจจะไม่ได้ response ครั้งเดียวคุณจะต้องเอามาต่อกันเรื่อยๆ
        StringBuilder result = new StringBuilder();

        //2.Create url + page :: http://172.24.0.118/314/index.php
        //page มาจาก (String page,boolean response)
        String url = seturl+"/"+page;

        //3.Create variable for URL data
        try {
            URL urlcon = new URL(url);

            //4.Create variable for HttpURLConnect
            HttpURLConnection connection = (HttpURLConnection) urlcon.openConnection();

            //5.Setting HttpURLConnect
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.setRequestMethod("POST");
            connection.setConnectTimeout(5000);
            connection.setRequestProperty("charset","utf-8");

            //6.Create variable for DataOutputStream
            DataOutputStream outstream = new DataOutputStream(connection.getOutputStream());

            //7.Condition of response
            if (response == true){
                //7.1 Create variable of string for line
                String line;

                //7.2 Create variable of BufferReader
                BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(),"UTF-8"));

                //7.3 Create Loop for read data
                while ((line = br.readLine())!=null){
                    result.append(line);
                }
                Log.e("Result",result.toString());
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //8.return data from StringBuilder
        return result.toString();
    }

    ////////////// Connect adding EntityModel Parameter ///////////////

    public String connect(String page, boolean response, EntityModel entityModel) {

        //Create StringBuilder for response

        //1. Create variable fo StringBuilder for response streaming data
        StringBuilder result = new StringBuilder();

        //2. Create variable for seturl+page :: http://172.24.0.162/285/index.php
        String url = seturl+"/"+page;

        //3. Create variable for URL data
        try {
            URL urlcon = new URL(url);

            //4. Create variable for HttpURLConnect
            HttpURLConnection connection = (HttpURLConnection) urlcon.openConnection();

            //5. Setting HttpURLConnect
            connection.setDoInput(true);
            connection.setDoInput(true);
            connection.setRequestMethod("POST");
            connection.setConnectTimeout(5000);
            connection.setRequestProperty("charset","utf-8");

            //6. Create DataOutputStream
            DataOutputStream outstream = new DataOutputStream(connection.getOutputStream());

            // 6.1
            outstream.write(entityModel.getDataEncode());




            //7. Condition of response
            if(response == true)
            {
                //7.1 Create variable of String for line
                String line;

                //7.2 Create variable of BufferReader
                BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(),"UTF-8"));

                //7.3 Create Loop for read data
                while ((line = br.readLine())!=null)
                {
                    result.append(line);
                }

            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //8. return data from StringBuilder
        return result.toString();
    }
}
