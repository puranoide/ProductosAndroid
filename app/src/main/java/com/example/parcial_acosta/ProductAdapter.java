package com.example.parcial_acosta;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ProductAdapter extends RecyclerView.Adapter<ProductPrototype> {
    private ArrayList<Product> products;
   public ProductAdapter(ArrayList<Product> products){this.products=products;};

    @Override
    public int getItemCount() {
        return products.size();
    }

    @NonNull
    @Override
    public ProductPrototype onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.prototype_product, parent, false);
        return new ProductPrototype(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductPrototype holder, int position) {
    holder.bindTo(products.get(position));
    }


}
