
package com.movi.mynotenavegable.cargar;

import android.app.Application;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.movi.mynotenavegable.MainActivity;
import com.movi.mynotenavegable.modelo.Auto;

import java.util.List;

public class CargarViewModel extends AndroidViewModel {

    //instanciamos la lista de autos que esta en el main para usarla aca
    private List<Auto> autos = MainActivity.autos;

    public CargarViewModel(@NonNull Application application) {
        super(application);
    }

    //metodo para agregar autos y hacemos validaciones
    public void agregarAuto(String patente, String marca, String modelo, String precioStr) {
        //controlamos los campos no esten vacios
        if (patente.isEmpty() || marca.isEmpty() || modelo.isEmpty() || precioStr.isEmpty()) {

            Toast.makeText(getApplication(), "Por favor completa todos los campos.", Toast.LENGTH_SHORT).show();
        } else {

            try {
                //controlamos precio no este vacio y sea un valor correcto
                double precio = Double.parseDouble(precioStr);


                if (precio <= 0) {
                    Toast.makeText(getApplication(), "El precio debe ser mayor que cero.", Toast.LENGTH_SHORT).show();
                }
               //controlamos que la patente no este repetida en la lista
                else if (isPatenteRepetida(patente)) {
                    Toast.makeText(getApplication(), "La patente ya existe.", Toast.LENGTH_SHORT).show();
                }

                else {
                    //si todo va bien agregamos el auto
                    autos.add(new Auto(patente, marca, modelo, precio));
                    Toast.makeText(getApplication(), "!Auto agregado con éxito!", Toast.LENGTH_SHORT).show();
                }
            } catch (NumberFormatException e) {

                Toast.makeText(getApplication(), "El precio debe ser un número válido.", Toast.LENGTH_SHORT).show();
            }
        }
    }

     //metodo para controlar que la patente no este repetida
    private boolean isPatenteRepetida(String patente) {
        for (Auto auto : autos) {
            if (auto.getPatente().equalsIgnoreCase(patente)) {
                return true;
            }
        }
        return false;
    }

}

