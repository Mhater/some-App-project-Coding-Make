package com.example.myshop20190509;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.Toast;

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


    private DrawerLayout mDrawerLayout;
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //隐藏状态栏
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //设置toolbar
        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mDrawerLayout=findViewById(R.id.drawer_layout);
        NavigationView navView=(NavigationView)findViewById(R.id.nav_view);

        navView.setItemTextColor(getResources().getColorStateList(R.color.selector));
        navView.setItemIconTintList(getResources().getColorStateList(R.color.selector));
        ActionBar actionBar=getSupportActionBar();
        //在activity_main.xml中设置了静态actionBar.setHomeAsUpIndicator图片，
        //若在此处重新设置会将其覆盖
//        if(actionBar!=null){
//            actionBar.setDisplayHomeAsUpEnabled(true);
//            actionBar.setHomeAsUpIndicator(R.drawable.icon_mu);
//
//        }
        navView.setCheckedItem(R.id.nav_account);
        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                mDrawerLayout.closeDrawers();
                switch (menuItem.getItemId()){
                    case R.id.nav_account:
                        Log.i(TAG, "onNavigationItemSelected: account");
                        Intent signInAndUp=new Intent(MainActivity.this,
                                LoginActivity.class);
                        startActivity(signInAndUp);
                        break;
                    case R.id.nav_cart:
                        Log.i(TAG, "onNavigationItemSelected: cart");
                        Intent shopCart=new Intent(MainActivity.this, ShoppingCartActivity.class);
                        startActivity(shopCart);
                        break;
                    case R.id.nav_others:
                        Log.i(TAG, "onNavigationItemSelected: OTHERS");
                        break;
                        
                }
                return true;
            }
        });


        //实例化view
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


    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.toolbar,menu);
        return  true;
    }

    public  boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                break;
            case R.id.toolbar_cart:
                Toast.makeText(this,"you clicked toolbar_cart",
                        Toast.LENGTH_SHORT).show();
                Intent shopCart=new Intent(MainActivity.this, ShoppingCartActivity.class);
                startActivity(shopCart);
                break;
            case R.id.toolbar_shield:
                Toast.makeText(this,"you clicked toolbar_shield",
                        Toast.LENGTH_SHORT).show();
                break;
            case R.id.toolbar_calendar:
                Toast.makeText(this,"you clicked toolbar_calendar",
                        Toast.LENGTH_SHORT).show();
                break;
            case R.id.others_01:
                Toast.makeText(this,"you clicked others_01",
                        Toast.LENGTH_SHORT).show();
                break;
            case R.id.others_02:
                Toast.makeText(this,"you clicked others_01",
                        Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }

        return true;
    }
}
