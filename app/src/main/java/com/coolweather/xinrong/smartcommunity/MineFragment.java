package com.coolweather.xinrong.smartcommunity;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by xinrong on 2018/4/11.
 */

public class MineFragment extends Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View mineLayout = inflater.inflate(R.layout.minetest, container, false);
        return mineLayout;

    }

}
