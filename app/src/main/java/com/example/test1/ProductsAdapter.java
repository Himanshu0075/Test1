package com.example.test1;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.ProductViewHolder> implements ListAdapter {

    private Context context;
    private ArrayList<Product> products;

    public ProductsAdapter(Context context, ArrayList<Product> products) {
        this.context = context;
        this.products = products;
    }

    @Override
    public void registerDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public int getCount() {
        return products.size();
    }

    @Override
    public Object getItem(int position) {
        return products.get(position);
    }

    @NonNull
    @Override
    public ProductsAdapter.ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ProductsAdapter.ProductViewHolder holder, int position) {

    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){


        ViewHolder viewHolder;
        // inflate the layout for each list row
        if (convertView == null) {
            convertView = LayoutInflater.from(context).
                    inflate(R.layout.layout_product, parent, false);
            viewHolder = new ViewHolder(convertView);

            convertView.setTag(viewHolder);

        }
        else {
            viewHolder= (ViewHolder) convertView.getTag();
        }


        Product currentItem = (Product) getItem(position);
        viewHolder.setText(currentItem.getName());
        viewHolder.setText(currentItem.getDescription());
        return convertView;


    }

    @Override
    public int getViewTypeCount() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean areAllItemsEnabled() {
        return false;
    }

    @Override
    public boolean isEnabled(int position) {
        return false;
    }

    private class ViewHolder {
        TextView name;
        TextView Description;

        public ViewHolder(View view) {
            name = (TextView)view.findViewById(R.id.text_view_item_name);
            Description = (TextView) view.findViewById(R.id.text_view_item_description);
        }

        public void setText(String name) {
        }
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder {
        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}


