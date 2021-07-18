package com.example.internet;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Alta_cliente extends AppCompatActivity {
    private FirebaseFirestore db;
    private static DecimalFormat df = new DecimalFormat("0.00");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alta_cliente);
        this.db = FirebaseFirestore.getInstance();

        Button btnAltaCliente = findViewById(R.id.btn_ac_Alta);
        btnAltaCliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save_client();
            }
        });

    }

    public void save_client(){
        EditText nombre = findViewById(R.id.et_ac_Nombre);
        EditText localidad = findViewById(R.id.et_ac_Loacalidad);
        EditText direccion = findViewById(R.id.et_ac_Direccion);
        EditText monto = findViewById(R.id.et_ac_monto_pagar);
        EditText desc_equipo = findViewById(R.id.et_ac_desc_equipo);
        EditText ac_sector = findViewById(R.id.et_ac_sector);
        EditText ac_tel = findViewById(R.id.et_ac_tel);
        EditText ac_tel_2 = findViewById(R.id.et_ac_tel_2);
        String instalador = getIntent().getExtras().getString("usuario");

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String currentDateandTime = simpleDateFormat.format(new Date());


        Map<String, Object> user = new HashMap<>();
        user.put("Nombre", nombre.getText().toString());
        user.put("Localidad", localidad.getText().toString());
        user.put("Direccion", direccion.getText().toString());
        user.put("Renta", df.format(Float.parseFloat(String.valueOf(monto.getText()))));
        user.put("Desc. Equipo", desc_equipo.getText().toString());
        user.put("Sector", ac_sector.getText().toString());
        user.put("Telefono", ac_tel.getText().toString());
        user.put("Telefono_2", ac_tel_2.getText().toString());
        user.put("Instalador", instalador);
        user.put("Fecha", currentDateandTime);
        db.collection("usuarios")
                .add(user)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Toast.makeText(getApplicationContext(),"DocumentSnapshot added with ID: " + documentReference.getId(),Toast.LENGTH_LONG).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(getApplicationContext(),"Error adding document "+ e ,Toast.LENGTH_LONG).show();
                    }
                });

    }
}