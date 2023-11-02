package com.app.apnadukanapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.apnadukanapp.DbHelper.CartManagement;
import com.app.apnadukanapp.DbHelper.ItemNumberChangeListener;
import com.app.apnadukanapp.Models.PopularModel;
import com.app.apnadukanapp.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.GranularRoundedCorners;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.viewHolder> {
    ArrayList<PopularModel> list;
    private CartManagement cartManagement;
    ItemNumberChangeListener listener;
    Context context;

    public CartAdapter(ArrayList<PopularModel> list,Context context,ItemNumberChangeListener listener) {
        this.list = list;
        this.context=context;
        this.listener=listener;
        cartManagement=new CartManagement(context);
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholdercartitem,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        holder.textView.setText(list.get(position).getTitle());
        holder.textView2.setText("$"+""+list.get(position).getPrice());
        holder.textView3.setText("$"+Math.round((list.get(position).getPrice()*list.get(position).getNumberInCart())));
        holder.textView6.setText(""+list.get(position).getNumberInCart());
        int drawableResourceId=holder.itemView.getResources().getIdentifier(list.get(position).getPicURL(),"drawable",holder.itemView.getContext().getPackageName());

        Glide.with(holder.itemView.getContext())
                .load(drawableResourceId)
                .transform(new GranularRoundedCorners(30,30,30,30))
                .into(holder.imageView);

        holder.textView4.setOnClickListener(view -> cartManagement.plusNumberItem(list, position, () -> {
            notifyDataSetChanged();
            listener.change();
        }));

        holder.textView5.setOnClickListener(view -> cartManagement.minusNumberItem(list, position, () -> {
            notifyDataSetChanged();
            listener.change();
        }));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class viewHolder extends RecyclerView.ViewHolder{
        TextView textView,textView2,textView3,textView4,textView5,textView6;
        ImageView imageView;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.cartItemTitle);
            textView2=itemView.findViewById(R.id.cartItemCost);
            textView3=itemView.findViewById(R.id.totalEachItemcart);
            textView4=itemView.findViewById(R.id.plusItem);
            textView5=itemView.findViewById(R.id.decItem);
            textView6=itemView.findViewById(R.id.itemCount);
            imageView=itemView.findViewById(R.id.cartItemPic);
        }
    }
}