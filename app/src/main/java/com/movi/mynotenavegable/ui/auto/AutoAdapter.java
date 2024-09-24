
package com.movi.mynotenavegable.ui.auto;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.movi.mynotenavegable.R;
import com.movi.mynotenavegable.modelo.Auto;
import java.util.ArrayList;
import java.util.List;

public class AutoAdapter extends RecyclerView.Adapter<AutoAdapter.ViewHolderAuto> {

    // Lista de autos que se mostrarán en el RecyclerView
    private List<Auto> listAutos;
    private LayoutInflater li;

    // Constructor del adaptador
    public AutoAdapter(ArrayList<Auto> listAutos, LayoutInflater li) {
        this.li = li;
        this.listAutos = listAutos;
    }

    @NonNull
    @Override
    public ViewHolderAuto onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflamos la vista para cada ítem del RecyclerView
        View view = li.inflate(R.layout.tarjeta, parent, false);
        return new ViewHolderAuto(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderAuto holder, int position) {
        // Obtenemos el auto correspondiente y la mostramos en los TextViews
        Auto auto = listAutos.get(position);
        holder.tvPatente.setText(auto.getPatente());
        holder.tvMarca.setText(auto.getModelo());
        holder.tvModelo.setText(auto.getMarca());
        //holder.tvPrecio.setText(String.valueOf(auto.getPrecio()));
        holder.tvPrecio.setText(String.format("%.2f", auto.getPrecio()));
    }

    @Override
    public int getItemCount() {
        return listAutos.size();  // Devolvemos el tamaño de la lista
    }

    // Método para actualizar la lista de autos
    public void setNotas(List<Auto> autos) {
        this.listAutos = autos;
        notifyDataSetChanged();  // Notificamos al adaptador que los datos han cambiado
    }

    // ViewHolder que contiene los TextViews de cada tarjeta del auto
    public class ViewHolderAuto extends RecyclerView.ViewHolder {
        TextView tvPatente, tvMarca, tvModelo, tvPrecio;

        public ViewHolderAuto(@NonNull View itemView) {
            super(itemView);
            tvPatente = itemView.findViewById(R.id.tvPatente);
            tvMarca = itemView.findViewById(R.id.tvMarca);
            tvModelo = itemView.findViewById(R.id.tvModelo);
            tvPrecio = itemView.findViewById(R.id.tvPrecio);
        }
    }
}


