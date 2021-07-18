package com.example.internet.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.example.internet.Alta_cliente;
import com.example.internet.Cobrar;
import com.example.internet.R;
import com.example.internet.buscar_cliente;


public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        return root;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button cobrar = getView().findViewById(R.id.btnCobrar);
        cobrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), Cobrar.class);
                intent.putExtra("usuario", getActivity().getIntent().getExtras().getString("usuario"));
                startActivity(intent);
            }
        });
        Button alta_cliente = getView().findViewById(R.id.btnAlta);
        alta_cliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), Alta_cliente.class);
                intent.putExtra("usuario", getActivity().getIntent().getExtras().getString("usuario"));
                startActivity(intent);
            }
        });
        final Button buscar_cliente = getView().findViewById(R.id.btnBuscar);
        buscar_cliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(getContext(), com.example.internet.buscar_cliente.class);
                intent.putExtra("usuario", getActivity().getIntent().getExtras().getString("usuario"));
                startActivity(intent);
            }
        });
    }
}