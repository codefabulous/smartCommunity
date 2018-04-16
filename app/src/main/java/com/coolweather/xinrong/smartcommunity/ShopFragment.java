package com.coolweather.xinrong.smartcommunity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by xinrong on 2018/4/11.
 */

public class ShopFragment extends Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View shopLayout = inflater.inflate(R.layout.shop, container, false);
        return shopLayout;
    }

}
