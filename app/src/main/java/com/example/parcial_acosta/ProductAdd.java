package com.example.parcial_acosta;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

public class ProductAdd extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_add);

        Fragment fragment=new ProductAddFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.flbody,fragment).commit();

    }
}