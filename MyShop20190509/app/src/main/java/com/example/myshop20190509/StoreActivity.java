package com.example.myshop20190509;

import android.content.Intent;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;


public class StoreActivity extends AppCompatActivity {

    public static final String SHOP_NAME="shop_name";
    public static final String SHOP_DESCRIPTION="shop_description";
    public static final String SHOP_IMAGE_ID="shop_image_id";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);
        Intent intent=getIntent();
        String shopName=intent.getStringExtra(SHOP_NAME);
        String shopDescription=intent.getStringExtra(SHOP_DESCRIPTION);
        int shopImageId=intent.getIntExtra(SHOP_IMAGE_ID,0);

        //toolbar
        Toolbar toolbar=findViewById(R.id.sign_toolbar);
        //collapsing
        CollapsingToolbarLayout collapsingToolbar=(CollapsingToolbarLayout)
                findViewById(R.id.store_coolapsing_tooolbar);
        //nei rong
        ImageView shopImageView=findViewById(R.id.store_image_view);
        TextView shopContextTextTop=findViewById(R.id.store_name_text);
        TextView shopContextTextBottom=findViewById(R.id.store_description_text);

        setSupportActionBar(toolbar);

        ActionBar actionBar=getSupportActionBar();
        if (actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        collapsingToolbar.setTitle(shopName);
        Glide.with(this).load(shopImageId).into(shopImageView);
        String shopContextTop=generateShopContent(shopName);
        shopContextTextTop.setText(shopContextTop);
        String shopContextBottom=generateShopContent(shopDescription);
        shopContextTextBottom.setText(shopContextBottom);
    }

    private String generateShopContent(String shopName){
        StringBuilder shopContent=new StringBuilder();
        for(int i=0;i<50;i++){
            shopContent.append(shopName);
        }
        return  shopContent.toString();
    }

    public  boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
