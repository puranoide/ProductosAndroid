package com.example.parcial_acosta;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;

import java.util.Objects;


public class ProductAddFragment extends Fragment {
    private Product product;

    private TextInputEditText etname;
    private TextInputEditText etamount;
    private Spinner spBrand;
    private FloatingActionButton fasave;

    private static final String KEY_NAME="name";
    private static final String KEY_AMOUNT="amount";
    private static final String KEY_BRAND="brand";
    private void initViews(){
        etname=requireView().findViewById(R.id.etProductName);
        etamount=requireView().findViewById(R.id.etAmountProduct);
        spBrand=requireView().findViewById(R.id.spBrand);
        fasave=requireView().findViewById(R.id.faSave);
        // Definir las opciones para el Spinner (puedes cargarlas desde recursos si lo prefieres)
        String[] opciones = getResources().getStringArray(R.array.brandsList);

        // Crear un ArrayAdapter usando las opciones y un diseño predefinido para el spinner
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                requireContext(),
                android.R.layout.simple_spinner_item,
                opciones
        );

        // Especificar el diseño que se usará cuando se desplieguen las opciones
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Configurar el adaptador en el Spinner
        spBrand.setAdapter(adapter);

        // Configurar el listener para manejar la selección del Spinner


    }
    private void initViewsListeners(){

        fasave.setOnClickListener(view->{
            Intent intent=new Intent(getActivity(), MainActivity.class);
            String name= Objects.requireNonNull(etname.getText().toString());
            String amount=Objects.requireNonNull(etamount.getText().toString());
            // Obtener la opción seleccionada del Spinner
            String brand = spBrand.getSelectedItem().toString();
            intent.putExtra(KEY_NAME,name);
            intent.putExtra(KEY_AMOUNT,amount);
            intent.putExtra(KEY_BRAND,brand);
            requireActivity().setResult(Activity.RESULT_OK,intent);
            requireActivity().finish();
        });
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
            product=new Product();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_product_add,container,false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews();
        initViewsListeners();
    }
}