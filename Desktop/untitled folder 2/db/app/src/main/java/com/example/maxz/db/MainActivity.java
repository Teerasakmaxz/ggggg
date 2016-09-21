package com.example.maxz.db;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import android.os.Bundle;
import android.os.StrictMode;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends Activity {
    @SuppressLint("NewApi")
    int ans = 0, et = 0;
    ImageView gg;
    @Override

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

     final   Button btn1=(Button)findViewById(R.id.btn1);
       final Button btn2=(Button)findViewById(R.id.btn2);
      final TextView tex=(TextView)findViewById(R.id.tex);
         gg=(ImageView)findViewById(R.id.img);
        btn1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                et = 1;
                String ree = String.valueOf(et);


                ans = ans + 1;
               ch(ans);
                String str = String.valueOf(ans);


                String url = "http://www.appdd.jiumjee.com/ques.php";
                String rt = "http://www.appdd.jiumjee.com/ans_one.php";
                String tt = "http://www.appdd.jiumjee.com/ans_two.php";
                String ff = "http://www.appdd.jiumjee.com/in.php";
                List<NameValuePair> params = new ArrayList<NameValuePair>();
                params.add(new BasicNameValuePair("tex1", str.toString()));
                params.add(new BasicNameValuePair("ans", ree.toString()));
                String resultServer = getHttpPost(url, params);
                getHttpPost(ff, params);
                String x = getHttpPost(rt, params);
                String y = getHttpPost(tt, params);
                btn1.setText(y);
                btn2.setText(x);
                tex.setText(resultServer);

            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et = 2;
                String ree = String.valueOf(et);

                ans = ans + 1;
                ch(ans);
                String str = String.valueOf(ans);



                String url = "http://www.appdd.jiumjee.com/ques.php";
                String rt = "http://www.appdd.jiumjee.com/ans_one.php";
                String tt = "http://www.appdd.jiumjee.com/ans_two.php";
                String ff = "http://www.appdd.jiumjee.com/in.php";
                List<NameValuePair> params = new ArrayList<NameValuePair>();
                params.add(new BasicNameValuePair("tex1", str.toString()));
                params.add(new BasicNameValuePair("ans", ree.toString()));
                String resultServer = getHttpPost(url, params);
                String x = getHttpPost(rt, params);
                String y = getHttpPost(tt, params);
                getHttpPost(ff, params);
                btn1.setText(y);
                btn2.setText(x);
                tex.setText(resultServer);
            }
        });
    }


    public String getHttpPost(String url, List<NameValuePair> params) {
        StringBuilder str = new StringBuilder();
        HttpClient client = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(url);
        try {
            httpPost.setEntity(new UrlEncodedFormEntity(params));
            HttpResponse response = client.execute(httpPost);
            StatusLine statusLine = response.getStatusLine();
            int statusCode = statusLine.getStatusCode();
            if (statusCode == 200) { // Status OK
                HttpEntity entity = response.getEntity();
                InputStream content = entity.getContent();
                BufferedReader reader = new BufferedReader(new InputStreamReader(content));
                String line;
                while ((line = reader.readLine()) != null) {
                    str.append(line);
                }
            } else {
                Log.e("Log", "Failed to download result..");
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str.toString();
    }

    public void ch (int ans){

        switch (ans){
            case 1:gg.setImageResource(R.drawable.a);break;
            case 2:gg.setImageResource(R.drawable.b);break;
            case 3:gg.setImageResource(R.drawable.c);break;
            case 4:gg.setImageResource(R.drawable.d);break;
            case 5:gg.setImageResource(R.drawable.e);break;
            case 6:gg.setImageResource(R.drawable.f);break;
            case 7:gg.setImageResource(R.drawable.g);break;
            case 8:gg.setImageResource(R.drawable.h);break;
            case 9:gg.setImageResource(R.drawable.i);break;
            case 10:gg.setImageResource(R.drawable.j);break;
            case 11:gg.setImageResource(R.drawable.k);break;
            case 12:gg.setImageResource(R.drawable.l);break;
            case 13:gg.setImageResource(R.drawable.m);break;
            case 14:gg.setImageResource(R.drawable.n);break;
            case 15:gg.setImageResource(R.drawable.o);break;
            case 16:gg.setImageResource(R.drawable.p);break;
            case 17:gg.setImageResource(R.drawable.q);break;
            case 18:gg.setImageResource(R.drawable.r);break;
            case 19:gg.setImageResource(R.drawable.s);break;
            case 20:gg.setImageResource(R.drawable.t);break;
            case 21:gg.setImageResource(R.drawable.u);break;
            case 22:gg.setImageResource(R.drawable.v);break;
            case 23:gg.setImageResource(R.drawable.w);break;
            case 24:gg.setImageResource(R.drawable.x);break;
            case 25:gg.setImageResource(R.drawable.y);break;
            case 26:gg.setImageResource(R.drawable.z);break;
            case 27:gg.setImageResource(R.drawable.aa);break;
            case 28:gg.setImageResource(R.drawable.ab);break;
            case 29:gg.setImageResource(R.drawable.ac);break;
            case 30:gg.setImageResource(R.drawable.ad);break;
            case 31:gg.setImageResource(R.drawable.ae);break;
            case 32:gg.setImageResource(R.drawable.af);break;
            case 33:gg.setImageResource(R.drawable.ag);break;
//            case 34:gg.setImageResource(R.drawable.a);break;
//            case 35:gg.setImageResource(R.drawable.a);break;
//            case 36:gg.setImageResource(R.drawable.a);break;
//            case 37:gg.setImageResource(R.drawable.a);break;
//            case 38:gg.setImageResource(R.drawable.a);break;
//            case 39:gg.setImageResource(R.drawable.a);break;
//            case 40:gg.setImageResource(R.drawable.a);break;
//            case 41:gg.setImageResource(R.drawable.a);break;
//            case 42:gg.setImageResource(R.drawable.a);break;
//            case 43:gg.setImageResource(R.drawable.a);break;
//            case 44:gg.setImageResource(R.drawable.a);break;
//            case 45:gg.setImageResource(R.drawable.a);break;
//            case 46:gg.setImageResource(R.drawable.a);break;
//            case 47:gg.setImageResource(R.drawable.a);break;
//            case 48:gg.setImageResource(R.drawable.a);break;
//            case 49:gg.setImageResource(R.drawable.a);break;
//            case 50:gg.setImageResource(R.drawable.a);break;
//            case 51:gg.setImageResource(R.drawable.a);break;
//            case 52:gg.setImageResource(R.drawable.a);break;
//            case 53:gg.setImageResource(R.drawable.a);break;
//            case 54:gg.setImageResource(R.drawable.a);break;
//            case 55:gg.setImageResource(R.drawable.a);break;
//            case 56:gg.setImageResource(R.drawable.a);break;
//            case 57:gg.setImageResource(R.drawable.a);break;
//            case 58:gg.setImageResource(R.drawable.a);break;
//            case 59:gg.setImageResource(R.drawable.a);break;
//            case 60:gg.setImageResource(R.drawable.a);break;



        }
    }
}

