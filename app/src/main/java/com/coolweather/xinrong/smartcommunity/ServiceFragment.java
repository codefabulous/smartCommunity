package com.coolweather.xinrong.smartcommunity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * Created by xinrong on 2018/4/11.
 */

public class ServiceFragment extends Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View serviceLayout = inflater.inflate(R.layout.service, container, false);
        return serviceLayout;
    }
}
