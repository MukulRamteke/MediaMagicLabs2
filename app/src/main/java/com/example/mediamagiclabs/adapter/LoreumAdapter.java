package com.example.mediamagiclabs.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mediamagiclabs.Model.Loreum;
import com.example.mediamagiclabs.R;
//import com.example.mediamagiclabs.utils.Utils;
import com.koushikdutta.ion.Ion;

import java.awt.font.TextAttribute;
import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class LoreumAdapter extends RecyclerView.Adapter<LoreumAdapter.ViewHolder> {

Loreum loreum;
    private final Context context;
    private final ArrayList<Loreum> products;



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);

        return new ViewHolder(inflater.inflate(R.layout.recylerview_item_product_grid,null));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Loreum loreum = products.get(position);
        holder.textname.setText(loreum.getAuthor());
        //String url = Utils.getImageUrl("/" + loreum.getId());
        //Ion.with(context).load(url).withBitmap().intoImageView(holder.imageView);

    }

    public LoreumAdapter(Context context, ArrayList<Loreum> products)
    {

        this.context = context;
        this.products = products;

    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textname ;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView);
            textname = itemView.findViewById(R.id.authorname);

        }
    }

}
