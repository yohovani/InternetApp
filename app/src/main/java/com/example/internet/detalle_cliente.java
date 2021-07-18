package com.example.internet;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import org.jetbrains.annotations.NotNull;

public class detalle_cliente extends Fragment {
    private Button btnRegresar;
    private FragmentActivity myContext;

    public detalle_cliente() {
        super(R.layout.fragment_detalle_cliente);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_detalle_cliente, container, false);
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btnRegresar = getView().findViewById(R.id.btnRegresarDC);
        String Id = requireArguments().getString("Id");
        String Desc_Equipo = requireArguments().getString("Desc_Equipo");
        String Direccion = requireArguments().getString("Direccion");
        String Fecha = requireArguments().getString("Fecha");
        String Instalador = requireArguments().getString("Instalador");
        String Localidad = requireArguments().getString("Localidad");
        String Nombre = requireArguments().getString("Nombre");
        String Renta = requireArguments().getString("Renta");
        String Sector = requireArguments().getString("Sector");
        String Telefono = requireArguments().getString("Telefono");
        String Telefono_2 = requireArguments().getString("Telefono_2");


        TextView tv_id = getView().findViewById(R.id.tvIdDc);
        TextView tv_name = getView().findViewById(R.id.tvNameDc);
        TextView tv_direccion = getView().findViewById(R.id.tvDireccionDc);
        TextView tvDesc_EquipoDc = getView().findViewById(R.id.tvDesc_EquipoDc);
        TextView tvFechaDc = getView().findViewById(R.id.tvFechaDc);
        TextView tvInstaladorDc = getView().findViewById(R.id.tvInstaladorDc);
        TextView tvLocalidadDc = getView().findViewById(R.id.tvLocalidadDc);
        TextView tvRentaDc = getView().findViewById(R.id.tvRentaDc);
        TextView tvSectorDc = getView().findViewById(R.id.tvSectorDc);
        TextView tvTelefonoDc = getView().findViewById(R.id.tvTelefonoDc);
        TextView tvTelefono_2Dc = getView().findViewById(R.id.tvTelefono_2Dc);

        tv_id.setText(Id);
        tv_name.setText(Nombre);
        tv_direccion.setText(Direccion);
        tvDesc_EquipoDc.setText(Desc_Equipo);
        tvFechaDc.setText(Fecha);
        tvInstaladorDc.setText(Instalador);
        tvLocalidadDc.setText(Localidad);
        tvRentaDc.setText(Renta);
        tvSectorDc.setText(Sector);
        tvTelefonoDc.setText(Telefono);
        tvTelefono_2Dc.setText(Telefono_2);
        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getView().setVisibility(View.GONE);
            }
        });

    }
}