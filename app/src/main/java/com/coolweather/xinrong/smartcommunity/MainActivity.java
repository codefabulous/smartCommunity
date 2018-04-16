package com.coolweather.xinrong.smartcommunity;


import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity implements View.OnClickListener {

//Fragment
    private ServiceFragment serviceFragment;

    private InformFragment informFragment;

    private ShopFragment shopFragment;

    private MineFragment mineFragment;

//View
    private View serviceLayout;

    private View informLayout;

    private View shopLayout;

    private View mineLayout;

//在Tab布局上显示图标的控件

    private ImageView serviceImage;

    private ImageView informImage;

    private ImageView shopImage;

    private ImageView mineImage;

//在Tab布局上显示标题的控件

    private TextView serviceText;

    private TextView informText;

    private TextView shopText;

    private TextView mineText;



    /**
     * 用于对Fragment进行管理 
     */
    private FragmentManager fragmentManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        // 初始化布局元素  
        initViews();
        fragmentManager = getSupportFragmentManager();
        // 第一次启动时选中第0个tab  
        setTabSelection(0);
    }

    /**
     * 在这里获取到每个需要用到的控件的实例，并给它们设置好必要的点击事件。 
     */
    private void initViews() {
        //Layout
        serviceLayout = findViewById(R.id.service_layout);
        informLayout = findViewById(R.id.inform_layout);
        shopLayout = findViewById(R.id.shop_layout);
        mineLayout = findViewById(R.id.mine_layout);
        //Image
        serviceImage = (ImageView) findViewById(R.id.service_image);
        informImage = (ImageView) findViewById(R.id.inform_image);
        shopImage = (ImageView) findViewById(R.id.shop_image);
        mineImage = (ImageView) findViewById(R.id.mine_image);
        //Text
        serviceText = (TextView)findViewById(R.id.service_text);
        informText = (TextView)findViewById(R.id.inform_text);
        shopText = (TextView)findViewById(R.id.shop_text);
        mineText = (TextView)findViewById(R.id.mine_text);
        /**
        *为什么要这样？
         */
        serviceLayout.setOnClickListener(this);
        informLayout.setOnClickListener(this);
        shopLayout.setOnClickListener(this);
        mineLayout.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.service_layout:
                setTabSelection(0);
                break;
            case R.id.inform_layout:
                setTabSelection(1);
                break;
            case R.id.shop_layout:
                setTabSelection(2);
                break;
            case R.id.mine_layout:
                setTabSelection(3);
                break;
            default:
                break;
        }
    }

    /**
     * 根据传入的index参数来设置选中的tab页。 
     *
     * @param index
     *            每个tab页对应的下标。0表示服务，1表示通知，2表示购物，3表示我的。
     */
    private void setTabSelection(int index) {
        // 每次选中之前先清楚掉上次的选中状态  
        clearSelection();
        // 开启一个Fragment事务  
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        // 先隐藏掉所有的Fragment，以防止有多个Fragment显示在界面上的情况  
        hideFragments(transaction);
        switch (index) {
            case 0:
                // 当点击了服务tab时，改变控件的图片和文字颜色
                ////serviceImage.setImageResource(R.drawable.service_selected);
                serviceText.setTextColor(Color.parseColor("#57352d"));
                if (serviceFragment == null) {
                    // 如果ServiceFragment为空，则创建一个并添加到界面上
                    serviceFragment = new ServiceFragment();
                    transaction.add(R.id.content, serviceFragment);
                } else {
                    // 如果ServiceFragment不为空，则直接将它显示出来
                    transaction.show(serviceFragment);
                }
                break;
            case 1:
                // 当点击了通知tab时，改变控件的图片和文字颜色
                ////informImage.setImageResource(R.drawable.inform_selected);
                informText.setTextColor(Color.parseColor("#57352d"));
                if (informFragment == null) {
                    // 如果InformFragment为空，则创建一个并添加到界面上
                    informFragment = new InformFragment();
                    transaction.add(R.id.content, informFragment);
                } else {
                    // 如果InformFragment不为空，则直接将它显示出来
                    transaction.show(informFragment);
                }
                break;
            case 2:
                // 当点击了购物tab时，改变控件的图片和文字颜色
                ////shopImage.setImageResource(R.drawable.shop_selected);
                shopText.setTextColor(Color.parseColor("#57352d"));
                if (shopFragment == null) {
                    // 如果ShopFragment为空，则创建一个并添加到界面上
                    shopFragment = new ShopFragment();
                    transaction.add(R.id.content, shopFragment);
                } else {
                    // 如果ShopFragment不为空，则直接将它显示出来
                    transaction.show(shopFragment);
                }
                break;
            case 3:
            default:
                // 当点击了我的tab时，改变控件的图片和文字颜色
                ////settingImage.setImageResource(R.drawable.setting_selected);
                mineText.setTextColor(Color.parseColor("#57352d"));
                if (mineFragment == null) {
                    // 如果MineFragment为空，则创建一个并添加到界面上
                    mineFragment = new MineFragment();
                    transaction.add(R.id.content, mineFragment);
                } else {
                    // 如果MineFragment不为空，则直接将它显示出来
                    transaction.show(mineFragment);
                }
                break;
        }
        transaction.commit();
    }

    /**
     * 清除掉所有的选中状态。 
     */
    private void clearSelection() {
        serviceImage.setImageResource(R.drawable.service_unselected);
        serviceText.setTextColor(Color.parseColor("#82858b"));
        informImage.setImageResource(R.drawable.inform_unselected);
        informText.setTextColor(Color.parseColor("#82858b"));
        ////shopImage.setImageResource(R.drawable.shop_unselected);
        shopText.setTextColor(Color.parseColor("#82858b"));
        ////mineImage.setImageResource(R.drawable.mine_unselected);
        mineText.setTextColor(Color.parseColor("#82858b"));
    }

    /**
     * 将所有的Fragment都置为隐藏状态。 
     *
     * @param transaction
     *            用于对Fragment执行操作的事务 
     */
    private void hideFragments(FragmentTransaction transaction) {
        if (serviceFragment != null) {
            transaction.hide(serviceFragment);
        }
        if (informFragment != null) {
            transaction.hide(informFragment);
        }
        if (shopFragment != null) {
            transaction.hide(shopFragment);
        }
        if (mineFragment != null) {
            transaction.hide(mineFragment);
        }
    }


}