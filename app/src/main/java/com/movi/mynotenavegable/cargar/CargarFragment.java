
package com.movi.mynotenavegable.cargar;

import androidx.lifecycle.ViewModelProvider;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.movi.mynotenavegable.databinding.FragmentCargarBinding;

public class CargarFragment extends Fragment {

    private CargarViewModel mViewModel;
    private FragmentCargarBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        mViewModel = new ViewModelProvider(this).get(CargarViewModel.class);
        binding = FragmentCargarBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

       //metodo onclick boton guardar
       binding.guardarButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {

               //cargamos y ejecutamos el metodo que esta en el viewmodel
               mViewModel.agregarAuto(binding.etPatente.getText().toString(),
                       binding.etMarca.getText().toString(),
                       binding.etModelo.getText().toString(),
                       binding.etPrecio.getText().toString());
               //limpiamos campos
               binding.etPatente.setText("");
               binding.etMarca.setText("");
               binding.etModelo.setText("");
               binding.etPrecio.setText("");
           }
       });



        return root;

    }

}


