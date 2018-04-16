package com.coolweather.xinrong.smartcommunity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

/**
 * Created by xinrong on 2018/4/13.
 */

public class LoginActivity extends AppCompatActivity{
    private Button yes;
    private Button no;

    private EditText name;
    private EditText pwd;

    String strn="";
    String strp="";



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);


        UI_init();
    }

    //setActionBarBackgroundColor(getResources().getColor(R.color.transparent));

    private void UI_init() {

        //全屏
        getWindow().setFlags(WindowManager.LayoutParams. FLAG_FULLSCREEN ,
                WindowManager.LayoutParams. FLAG_FULLSCREEN);

        yes = (Button) findViewById(R.id.login_yes);
        no = (Button)findViewById(R.id.login_no);
        name =(EditText) findViewById(R.id.login_name);
        pwd = (EditText) findViewById(R.id.login_pwd);
        strn=name.getText().toString();
        strp=pwd.getText().toString();


            yes.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                    startActivity(intent);
                }
            });




    }



}
