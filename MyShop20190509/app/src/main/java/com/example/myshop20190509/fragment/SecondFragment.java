package com.example.myshop20190509.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myshop20190509.Adapter.ShopAdapter;
import com.example.myshop20190509.R;
import com.example.myshop20190509.entity.Shop;

import java.util.ArrayList;
import java.util.List;

public class SecondFragment extends Fragment {

    private Shop[] fruits = {
            new Shop("shop_01","shop_01_description", R.drawable.shop_01),
            new Shop("shop_02","shop_02_description", R.drawable.shop_02),
            new Shop("shop_03","shop_03_description", R.drawable.shop_03),
            new Shop("shop_04","shop_04_description", R.drawable.shop_04),
            new Shop("shop_05","shop_05_description", R.drawable.shop_05),
            new Shop("shop_06","shop_06_description", R.drawable.shop_06),
            new Shop("shop_07","shop_07_description", R.drawable.shop_07),
            new Shop("shop_08","shop_08_description", R.drawable.shop_08)};
    private List<Shop> shopList=new ArrayList<>();
    private ShopAdapter adapter;


    public static Fragment newInstance(){
        SecondFragment fragment = new SecondFragment();
        return fragment;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.second_fragment,null);


        initShops();




        adapter=new ShopAdapter(shopList);





        return view;
    }

    private void refreshShops(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try{Thread.sleep(2000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        initShops();adapter.notifyDataSetChanged();

                    }
                });
            }
        }).start();
    }
    private void initShops(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try{Thread.sleep(2000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        initShops();adapter.notifyDataSetChanged();

                    }
                });
            }
        }).start();
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }





}
