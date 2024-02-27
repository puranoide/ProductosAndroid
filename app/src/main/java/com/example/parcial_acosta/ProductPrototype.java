package com.example.parcial_acosta;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;



public class ProductPrototype  extends RecyclerView.ViewHolder {

    TextView etName,etAmount,etBrand;

    Product product;

    private void initview(){
        etName=itemView.findViewById(R.id.tvName);
        etAmount=itemView.findViewById(R.id.tvamount);
        etBrand=itemView.findViewById(R.id.tvBrand);
    }
    public ProductPrototype(@NonNull View itemView) {
        super(itemView);
        initview();
    }

    public void bindTo(Product product) {

        this.product=product;
        etName.setText(this.product.getNameProduct());
        etAmount.setText(this.product.getAmountProduct());
        etBrand.setText(this.product.getBrandProduct());
    }
}
