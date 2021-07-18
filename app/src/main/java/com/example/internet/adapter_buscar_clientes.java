package com.example.internet;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class adapter_buscar_clientes extends BaseAdapter {
    private Activity activity;
    private ArrayList<usuarios_db> usuarios_dbs = new ArrayList<>();
    private LayoutInflater layoutInflater = null;
    private static DecimalFormat df = new DecimalFormat("0.00");

    public adapter_buscar_clientes(Activity activity, ArrayList<usuarios_db> usuarios_dbs) {
        this.activity = activity;
        this.usuarios_dbs = usuarios_dbs;
        this.layoutInflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return this.usuarios_dbs.size();
    }

    @Override
    public usuarios_db getItem(int position) {
        return this.usuarios_dbs.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    private static class ViewHolder{
        TextView nombre;
        TextView telefono;
        TextView id;
        TextView localidad;
        TextView renta;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View vi = convertView;
        ViewHolder viewHolder;

        final int pos = position;
        if(vi == null){

            viewHolder = new ViewHolder();
            // inflate list_rowcell for each row
            vi = layoutInflater.inflate(R.layout.layout_clientes,null);
            viewHolder.nombre = vi.findViewById(R.id.tv_name_bc);
            viewHolder.telefono = vi.findViewById(R.id.tv_telefono_bc);
            viewHolder.id = vi.findViewById(R.id.tv_id_firebase);
            viewHolder.localidad = vi.findViewById(R.id.tv_localidad_bc);
            viewHolder.renta = vi.findViewById(R.id.tv_renta_bc);


            vi.setTag(viewHolder);
        }else{
            viewHolder= (ViewHolder) vi.getTag();
        }

        viewHolder.nombre.setText(usuarios_dbs.get(pos).getNombre());
        if(usuarios_dbs.get(pos).getTelefono_2().equals(""))
            viewHolder.telefono.setText(usuarios_dbs.get(pos).getTelefono());
        else
            viewHolder.telefono.setText(usuarios_dbs.get(pos).getTelefono()+","+usuarios_dbs.get(pos).getTelefono_2());
        viewHolder.id.setText(usuarios_dbs.get(pos).getId());
        viewHolder.localidad.setText(usuarios_dbs.get(pos).getLocalidad());
        viewHolder.renta.setText(usuarios_dbs.get(pos).getRenta().toString());

        return vi;
    }


}
