package com.example.test1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

@SuppressWarnings("deprecation")
public class ProductsAdapter extends BaseAdapter {
    private final ProductsActivity ProductsActivity;

    private Context context;
    private ArrayList<Product> products;

    public ProductsAdapter(ProductsActivity productsActivity, ArrayList<Product> productList) {

        this.ProductsActivity = productsActivity;
        this.products = products;
    }

    @Override
    public int getCount() {
        return products.size();
    }

    @Override
    public Object getItem(int position) {
        return products.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).
                    inflate(R.layout.layout_product, parent, false);
            viewHolder = new ViewHolder(convertView) {
                public ViewHolder setTag(ViewHolder viewHolder) {
                    return null;
                }

                @Override
                public String toString() {
                    return super.toString();
                }
            }.setTag(viewHolder);

        }

    }
}