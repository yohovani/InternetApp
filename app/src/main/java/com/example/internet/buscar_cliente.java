package com.example.internet;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static java.util.Objects.*;

public class buscar_cliente extends AppCompatActivity {
    private FirebaseFirestore db;
    private ArrayList<usuarios_db> users;
    private ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar_cliente);
        this.db = FirebaseFirestore.getInstance();
        this.users = new ArrayList<>();


        CollectionReference usuarios = db.collection("usuarios");
        lv = findViewById(R.id.lv_listar_clientes);

        usuarios.get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                for (DocumentSnapshot ds:queryDocumentSnapshots.getDocuments()) {
                    String aux = ds.getId();
                    users.add(new usuarios_db(
                            ds.getId(),
                            ds.getData().get("Desc. Equipo").toString(),
                            ds.getData().get("Direccion").toString(),
                            ds.getData().get("Fecha").toString(),
                            ds.getData().get("Instalador").toString(),
                            ds.getData().get("Localidad").toString(),
                            ds.getData().get("Nombre").toString(),
                            ds.getData().get("Renta").toString(),
                            ds.getData().get("Sector").toString(),
                            ds.getData().get("Telefono").toString(),
                            ds.getData().get("Telefono_2").toString()));

                }
                adapter_buscar_clientes adapter = new adapter_buscar_clientes(buscar_cliente.this,users);
                lv.setAdapter(adapter);
            }
        });


        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                usuarios_db o = users.get(position);
                Bundle bundle = new Bundle();
                bundle.putString("Id", o.getId());
                bundle.putString("Nombre", o.getNombre());
                bundle.putString("Direccion", o.getDireccion());
                bundle.putString("Desc_Equipo", o.getDesc_Equipo());
                bundle.putString("Fecha", o.getFecha());
                bundle.putString("Instalador", o.getInstalador());
                bundle.putString("Localidad", o.getLocalidad());
                bundle.putString("Renta", o.getRenta());
                bundle.putString("Sector", o.getSector());
                bundle.putString("Telefono", o.getTelefono());
                bundle.putString("Telefono_2", o.getTelefono_2());


                getSupportFragmentManager().beginTransaction()
                        .setReorderingAllowed(true)
                        .add(R.id.fragment_container_view, detalle_cliente.class, bundle)
                        .commit();
            }
        });



    }

    public void getData(QuerySnapshot queryDocumentSnapshots){
        for (DocumentSnapshot ds:queryDocumentSnapshots.getDocuments()) {
            users.add(new usuarios_db(ds.getId(),ds.getData().get("Desc. Equipo").toString(),
                    ds.getData().get("Direccion").toString(),
                    ds.getData().get("Fecha").toString(),
                    ds.getData().get("Instalador").toString(),
                    ds.getData().get("Localidad").toString(),
                    ds.getData().get("Nombre").toString(),
                    ds.getData().get("Renta").toString(),
                    ds.getData().get("Sector").toString(),
                    ds.getData().get("Telefono").toString(),
                    ds.getData().get("Telefono_2").toString()));

        }

        adapter_buscar_clientes adapter = new adapter_buscar_clientes(buscar_cliente.this,this.users);
        lv.setAdapter(adapter);
    }
}