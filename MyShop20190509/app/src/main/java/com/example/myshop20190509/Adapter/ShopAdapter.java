package com.example.myshop20190509.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.myshop20190509.R;
import com.example.myshop20190509.StoreActivity;
import com.example.myshop20190509.entity.Shop;

import java.util.List;

public class ShopAdapter extends RecyclerView.Adapter<ShopAdapter.ViewHolder> {

    private Context mContext;
    private List<Shop> mShopList;
    public class ViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        ImageView shopImage;
        TextView shopName;
        TextView shopDescription;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView=(CardView) itemView;
            shopDescription=(TextView)itemView.findViewById(R.id.store_description_text);
            shopImage=(ImageView)itemView.findViewById(R.id.store_image_view);
            shopName=(TextView)itemView.findViewById(R.id.store_name_text);
        }


    }

    public ShopAdapter(List<Shop> shopList){mShopList=shopList;}

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, final int i) {
        if (mContext==null){
            mContext=viewGroup.getContext();
        }
        View view= LayoutInflater.from(mContext).inflate(R.layout.shop_item,
                viewGroup,false);
        final  ViewHolder holder=new ViewHolder(view);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position=holder.getAdapterPosition();
                Shop shop=mShopList.get(position);
                Intent intent=new Intent(mContext, StoreActivity.class);
                intent.putExtra(StoreActivity.SHOP_IMAGE_ID,shop.getImageId());
                intent.putExtra(StoreActivity.SHOP_DESCRIPTION,shop.getDescription());
                intent.putExtra(StoreActivity.SHOP_NAME,shop.getName());
                mContext.startActivity(intent);
            }
        });

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ShopAdapter.ViewHolder viewHolder, int i) {

        Shop shop=mShopList.get(i);
        viewHolder.shopDescription.setText(shop.getDescription());
        viewHolder.shopName.setText(shop.getName());
        Glide.with(mContext).load(shop.getImageId()).into(viewHolder.shopImage);
    }



    @Override
    public int getItemCount() {
        return mShopList.size();
    }


}
