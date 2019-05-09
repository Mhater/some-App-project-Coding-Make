package com.example.myshop20190509;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;

import com.example.myshop20190509.Adapter.MyFragmentAdapter;
import com.example.myshop20190509.fragment.FirstFragment;
import com.example.myshop20190509.fragment.SecondFragment;
import com.example.myshop20190509.fragment.ThirdFragment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    public static final String TAG = "TabActivity";
    public static final String []sTitle = new String[]{"ITEM FIRST","ITEM SECOND","ITEM THIRD"};

    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        initView();
    }
    private void initView(){
        mTabLayout=findViewById(R.id.tablayout);
        mViewPager=findViewById(R.id.view_pager);

        mTabLayout.addTab(mTabLayout.newTab().setText(sTitle[0]).setIcon(R.drawable.icon_active));
        mTabLayout.addTab(mTabLayout.newTab().setText(sTitle[1]).setIcon(R.drawable.icon_active));
        mTabLayout.addTab(mTabLayout.newTab().setText(sTitle[2]).setIcon(R.drawable.icon_active));

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
        fragments.add(FirstFragment.newInstance());
        fragments.add(SecondFragment.newInstance());
        fragments.add(ThirdFragment.newInstance());

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
