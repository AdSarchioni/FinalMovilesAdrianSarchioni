
package com.movi.mynotenavegable.ui.auto;

import android.app.Application;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.movi.mynotenavegable.MainActivity;
import com.movi.mynotenavegable.modelo.Auto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class AutoViewModel extends AndroidViewModel {

    private MutableLiveData<Boolean> mAutos;
    private ArrayList<Auto>misAutos=MainActivity.autos;

    public AutoViewModel(@NonNull Application application) {
        super(application);
    }
    public LiveData<Boolean> getMAuto(){
        if(mAutos ==null){
            mAutos =new MutableLiveData<>();
        }
        return mAutos;
    }
    private void ordenarAutosPorPrecio() {
        Collections.sort(misAutos, new Comparator<Auto>() {
            @Override
            public int compare(Auto auto1, Auto auto2) {
                // Suponiendo que 'getPrecio()' devuelve un valor numérico (por ejemplo, double o float)
                return Double.compare(auto2.getPrecio(), auto1.getPrecio()); // Orden del más caro al más barato
            }
        });
    }


     public void mandarLista(){
        if(misAutos.size()>0){
            ordenarAutosPorPrecio();
            mAutos.setValue(true);
        }else{
            Toast.makeText(getApplication(), "No hay autos guardados.", Toast.LENGTH_LONG).show();

        }
}
}



