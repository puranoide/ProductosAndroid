package com.example.parcial_acosta;

import static android.app.Activity.RESULT_OK;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;


public class ProductListFragment extends Fragment {

    private ArrayList<Product> Products;
    private RecyclerView rvProductList;
    private FloatingActionButton faAdd;

    private ProductAdapter productAdapter;
    private ActivityResultLauncher<Intent> launcher;



    private static final String KEY_NAME="name";
    private static final String KEY_AMOUNT="amount";
    private static final String KEY_BRAND="brand";

    private void registerLauncher(){
        launcher=registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),result -> {
           if (result.getResultCode()==RESULT_OK){
               Intent intent=result.getData();
               if (intent!=null){
                   String name=intent.getStringExtra(KEY_NAME);
                   String amount= intent.getStringExtra(KEY_AMOUNT);
                   String brand=intent.getStringExtra(KEY_BRAND);
                   Product product=new Product();
                   product.setNameProduct(name);
                   product.setBrandProduct(brand);
                   product.setAmountProduct(amount);
                   Products.add(product);
                   productAdapter.notifyItemChanged(Products.size()-1);
               }
           }
        });
    }
    private void setupAdapter(){
        productAdapter=new ProductAdapter(Products);
        rvProductList.setLayoutManager(new LinearLayoutManager(requireContext()));
        rvProductList.setAdapter(productAdapter);
    }
    private void initViews(){
        rvProductList=requireView().findViewById(R.id.rvProductList);
        faAdd=requireView().findViewById(R.id.faAdd);
    }
    private void initViewsListener(){
        faAdd.setOnClickListener(view->{
            Intent intent=new Intent(getActivity(),ProductAdd.class);
            launcher.launch(intent);
        });
    }

    private void loadProducts(){
        Products=new ArrayList<>();
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_product_list,container,false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view,savedInstanceState);
        registerLauncher();
        initViews();
        initViewsListener();
        loadProducts();
        setupAdapter();
    }
}