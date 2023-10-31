package com.app.apnadukanapp.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.apnadukanapp.DetailActivity;
import com.app.apnadukanapp.Models.PopularModel;
import com.app.apnadukanapp.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.GranularRoundedCorners;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class PopularAdapter extends RecyclerView.Adapter<PopularAdapter.viewHolder> {
    ArrayList<PopularModel> list;
    DecimalFormat decimalFormat;
    Context context;

    public PopularAdapter(ArrayList<PopularModel> list) {
        this.list = list;
        decimalFormat=new DecimalFormat("###,###,###,###");
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_popular_sample,parent,false);
        context= parent.getContext();
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        holder.textView.setText(list.get(position).getTitle());
        holder.textView2.setText("$"+""+list.get(position).getPicURL());
        holder.textView3.setText(""+list.get(position).getScore());

        int drawableResourceId=holder.itemView.getResources().getIdentifier(list.get(position).getPicURL(),"drawable",holder.itemView.getContext().getPackageName());

        Glide.with(holder.itemView.getContext())
                .load(drawableResourceId)
                .transform(new GranularRoundedCorners(30,30,0,0))
                .into(holder.imageView);

        holder.itemView.setOnClickListener(view -> {
            Intent intent=new Intent(holder.itemView.getContext(), DetailActivity.class);
            intent.putExtra("object",list.get(position));
            holder.itemView.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class viewHolder extends RecyclerView.ViewHolder{
        TextView textView,textView2,textView3;
        ImageView imageView;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.titlePopularViewHolder);
            textView2=itemView.findViewById(R.id.pricepoputxt);
            textView3=itemView.findViewById(R.id.scoretxt);
            imageView=itemView.findViewById(R.id.itempopuimg);
        }
    }
}