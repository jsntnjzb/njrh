package com.njrhzn.ew.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.njrhzn.ew.Model.Product;
import com.njrhzn.ew.R;

import java.lang.ref.WeakReference;
import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter {
    private WeakReference<Context> contextWeakReference;
    private List<Product> productList;

    public ProductAdapter(WeakReference<Context> contextWeakReference, List<Product> productList) {
        this.contextWeakReference = contextWeakReference;
        this.productList = productList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(contextWeakReference.get()).inflate(R.layout.product_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Product product = productList.get(position);
        ViewHolder viewHolder =  ((ViewHolder)holder);
        viewHolder.tv_product_name.setText(product.getProductName());
        viewHolder.tv_product_price.setText("¥"+product.getPrice().toString());
        //viewHolder.rg_select_cold_or_hot.setOnCheckedChangeListener((RadioGroup.OnCheckedChangeListener) new OnCheckedChanged());
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    private class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tv_product_name;
        private RadioGroup rg_select_cold_or_hot;
        private TextView tv_product_price;
        private ImageButton img_btn_minus;
        private ImageButton img_btn_add;

        public ViewHolder(View itemView) {
            super(itemView);
            tv_product_name = itemView.findViewById(R.id.tv_product_name);
            rg_select_cold_or_hot = itemView.findViewById(R.id.rg_select_cold_or_hot);
            tv_product_price = itemView.findViewById(R.id.tv_product_price);
            img_btn_minus = itemView.findViewById(R.id.img_btn_minus);
            img_btn_add = itemView.findViewById(R.id.img_btn_add);
        }
    }

    private class OnCheckedChanged implements CompoundButton.OnCheckedChangeListener{
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (isChecked){
                switch (buttonView.getId()){
                    case R.id.rb_cold:
                        //冷

                        break;
                    case R.id.rb_hot:
                        //热

                        break;
                }
            }
        }
    }
}
