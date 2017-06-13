package com.tfr.fatez.singlefood;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by miku1 on 9/20/2016.
 */
public class AlbumsAdapter extends RecyclerView.Adapter<AlbumsAdapter.MyViewHolder> {
    private Context mContext;
    private List<Album> albumList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, count;
        public ImageView thumbnail;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            thumbnail = (ImageView) view.findViewById(R.id.thumbnail);

        }
    }
    public AlbumsAdapter(Context mContext, List<Album> albumList) {
        this.mContext = mContext;
        this.albumList = albumList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.album_card, parent, false);

        return new MyViewHolder(itemView);
    }
    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        Album album = albumList.get(position);
        holder.title.setText(album.getName());


        // loading album cover using Glide library
        Glide.with(mContext).load(album.getThumbnail()).into(holder.thumbnail);

        // When user the touch the picture on it will send the value of food to TheNextAct

        holder.thumbnail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (position == 0) {
                    String greenCurry = "0";
                    Intent a = new Intent(view.getContext(), TheNextAct.class);
                    a.putExtra("mFood",greenCurry);
                    mContext.startActivity(a);
                    ((MainActivity) mContext).finish();
                }
                if (position == 1) {
                    String sweetPork = "1";
                    Intent a = new Intent(view.getContext(), TheNextAct.class);
                    a.putExtra("mFood",sweetPork);
                    mContext.startActivity(a);
                    ((MainActivity) mContext).finish();
                }
                if (position == 2) {
                    String eggPalow = "2";
                    Intent a = new Intent(view.getContext(), TheNextAct.class);
                    a.putExtra("mFood",eggPalow);
                    mContext.startActivity(a);
                    ((MainActivity) mContext).finish();
                }

                if (position == 3) {
                    String shrimp = "3";
                    Intent a = new Intent(view.getContext(), TheNextAct.class);
                    a.putExtra("mFood",shrimp);
                    mContext.startActivity(a);
                    ((MainActivity) mContext).finish();
                }
                if (position == 4) {
                    String taohoo = "4";
                    Intent a = new Intent(view.getContext(), TheNextAct.class);
                    a.putExtra("mFood",taohoo);
                    mContext.startActivity(a);
                    ((MainActivity) mContext).finish();
                }
                if (position == 5) {
                    String chicken_takai = "5";
                    Intent a = new Intent(view.getContext(), TheNextAct.class);
                    a.putExtra("mFood",chicken_takai);
                    mContext.startActivity(a);
                    ((MainActivity) mContext).finish();
                }
                if (position == 6) {
                    String harapa = "6";
                    Intent a = new Intent(view.getContext(), TheNextAct.class);
                    a.putExtra("mFood",harapa);
                    mContext.startActivity(a);
                    ((MainActivity) mContext).finish();
                }
                if (position == 7) {
                    String lap = "7";
                    Intent a = new Intent(view.getContext(), TheNextAct.class);
                    a.putExtra("mFood",lap);
                    mContext.startActivity(a);
                    ((MainActivity) mContext).finish();
                }
                if (position == 8) {
                    String hoi = "8";
                    Intent a = new Intent(view.getContext(), TheNextAct.class);
                    a.putExtra("mFood",hoi);
                    mContext.startActivity(a);
                    ((MainActivity) mContext).finish();
                }
                if (position == 9) {
                    String yumhoi = "9";
                    Intent a = new Intent(view.getContext(), TheNextAct.class);
                    a.putExtra("mFood",yumhoi);
                    mContext.startActivity(a);
                    ((MainActivity) mContext).finish();
                }
                //showPopupMenu(holder.overflow);
            }
        });

    }
    @Override
    public int getItemCount() {
        return albumList.size();
    }
}
