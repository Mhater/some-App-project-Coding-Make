package com.example.myshop20190509;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;

import com.example.myshop20190509.Adapter.MyFragmentAdapter;
import com.example.myshop20190509.fragment.FirstFragment;
import com.example.myshop20190509.fragment.SecondFragment;
import com.example.myshop20190509.fragment.ThirdFragment;
import com.example.myshop20190509.loginFragmet.SignInFragment;
import com.example.myshop20190509.loginFragmet.SignUpFragment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SignInAndUpActivity extends AppCompatActivity {

    public static final String []sTitle = new String[]{"ITEM 登录","ITEM 注册"};


    public static final String TAG = "SIGN_LOGIN_Activity";

    private TabLayout mTabLayout;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in_and_up);
        //隐藏状态栏
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //设置toolbar
        Toolbar toolbar=(Toolbar)findViewById(R.id.sign_toolbar);
        setSupportActionBar(toolbar);




            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });








        //实例化view
        initView();
    }

    private void initView(){
        mTabLayout=findViewById(R.id.sign_tablayout);
        mViewPager=findViewById(R.id.sign_view_pager);

        mTabLayout.addTab(mTabLayout.newTab().setText(sTitle[0]));
        mTabLayout.addTab(mTabLayout.newTab().setText(sTitle[1]));


        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Log.i(TAG, "onTabSelected: "+tab.getText());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        mTabLayout.setupWithViewPager(mViewPager);
        List<Fragment> fragments=new ArrayList<>();
        fragments.add(SignInFragment.newInstaces());
        fragments.add(SignUpFragment.newInstaces());


        MyFragmentAdapter adapter=new MyFragmentAdapter(getSupportFragmentManager(),
                fragments, Arrays.asList(sTitle));
        mViewPager.setAdapter(adapter);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {
            }

            @Override
            public void onPageSelected(int position) {
                Log.i(TAG, "onPageSelected: "+position);
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }
}
