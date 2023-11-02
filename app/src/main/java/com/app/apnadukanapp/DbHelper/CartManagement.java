package com.app.apnadukanapp.DbHelper;

import android.content.Context;
import android.widget.Toast;

import com.app.apnadukanapp.Models.PopularModel;

import java.util.ArrayList;

public class CartManagement {
    private Context context;
    private TinyDB tinyDB;

    public CartManagement(Context context) {
        this.context = context;
        this.tinyDB=new TinyDB(context);
    }

    public void insertFoodItem(PopularModel item){
        ArrayList<PopularModel> list=new ArrayList<>();
        list=getListCart();
        boolean existAlready=false;
        int n=0;
        for (int i=0;i< list.size();i++){
            if (list.get(i).getTitle().equals(item.getTitle())){
                existAlready=true;
                n=i;
                break;
            }
        }
        if (existAlready){
            list.get(n).setNumberInCart(item.getNumberInCart());
        } else {
            list.add(item);
        }
        tinyDB.putListObject("CartList",list);
        Toast.makeText(context.getApplicationContext(),"Added to Cart",Toast.LENGTH_SHORT).show();
    }
    public ArrayList<PopularModel> getListCart(){
        return tinyDB.getListObject("CartList");
    }
}
