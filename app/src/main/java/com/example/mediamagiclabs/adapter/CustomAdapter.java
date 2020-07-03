package com.example.mediamagiclabs.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mediamagiclabs.Model.Loreum;
import com.example.mediamagiclabs.R;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;

import static com.example.mediamagiclabs.MainActivity.imageView;

public class CustomAdapter extends BaseAdapter {

    Context applicationContext;
    int recylerview_item_product_grid;
    ArrayList<Loreum> loreums;
    Loreum loreum = new Loreum();

    public CustomAdapter(Context applicationContext, int recylerview_item_product_grid, ArrayList<Loreum> loreums) {
        this.applicationContext = applicationContext;
        this.recylerview_item_product_grid = recylerview_item_product_grid;
        this.loreums = loreums;
    }


    @Override
    public int getCount() {
        return loreums.size();
    }

    @Override
    public Object getItem(int position) {
        return loreums.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {


        {

            LayoutInflater inflater;

            if (view == null) {
                inflater = (LayoutInflater) applicationContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                view = inflater.inflate(R.layout.recylerview_item_product_grid, parent, false);
            }
            TextView t1;
            ImageView img;

            t1 = view.findViewById(R.id.authorname);
            img = view.findViewById(R.id.imageView);
            t1.setText(loreums.get(position).getAuthor());

            ImageLoader.getInstance().displayImage(loreums.get(position).getThumbnail(), img);
            return view;
        }
    }
}
