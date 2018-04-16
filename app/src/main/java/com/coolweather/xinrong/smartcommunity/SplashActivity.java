package com.coolweather.xinrong.smartcommunity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import static com.coolweather.xinrong.smartcommunity.Debug.toMainlogin;

public class SplashActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //全屏
        getWindow().setFlags(WindowManager.LayoutParams. FLAG_FULLSCREEN ,
                WindowManager.LayoutParams. FLAG_FULLSCREEN);
//
//        Button login = (Button)findViewById(R.id.splash_login);
//        Button register = (Button)findViewById(R.id.splash_register);


        new Thread(){
            @Override
            public void run(){
                try{  sleep(1000);
                }
                catch (InterruptedException e){ }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {


                        Button login = (Button)findViewById(R.id.splash_login);
                        Button register = (Button)findViewById(R.id.splash_register);


                        login.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(SplashActivity.this,LoginActivity.class);
                                startActivity(intent);
                            }
                        });


                    }
                });
            }

        }.start();
    }
}
