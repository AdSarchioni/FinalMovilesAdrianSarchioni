
package com.movi.mynotenavegable.ui.auto;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;

import com.movi.mynotenavegable.MainActivity;
import com.movi.mynotenavegable.databinding.FragmentAutoBinding;


public class AutoFragment extends Fragment {

    private FragmentAutoBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        AutoViewModel autoViewModel =
                new ViewModelProvider(this).get(AutoViewModel.class);

        // Infla el layout del fragmento y configura el binding
        binding = FragmentAutoBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

   // Observa el LiveData que indica si hay una nueva lista de autos
    autoViewModel.getMAuto().observe(getViewLifecycleOwner(), new Observer<Boolean>() {

    @Override
    public void onChanged(Boolean aBoolean) {
        // Crea un nuevo adaptador para mostrar la lista de autos
        AutoAdapter adapter = new AutoAdapter(MainActivity.autos, inflater);
        // Configura el GridLayoutManager para el RecyclerView
        GridLayoutManager glm = new GridLayoutManager(getContext(), 1, GridLayoutManager.VERTICAL, false);
        binding.lista.setAdapter(adapter);
        binding.lista.setLayoutManager(glm);
    }
});
    // Llama a mandarLista() en el ViewModel para cargar o actualizar la lista
     autoViewModel.mandarLista();
        return root;
    }

}




