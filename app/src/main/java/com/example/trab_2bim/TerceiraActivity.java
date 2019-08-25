package com.example.trab_2bim;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.AlertDialog;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class TerceiraActivity extends AppCompatActivity {

    Bundle pacote;
    Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.terceira_activity);


        pacote = getIntent().getExtras();

        Spinner spinner = (Spinner)findViewById(R.id.escolha);
        Integer idArray = R.array.TipoDePao;
        switch (pacote.getString("escolha")){
            case "TipoDePao":
                idArray = R.array.TipoDePao;
                break;
            case "TipoDeRecheio":
                idArray = R.array.TiposDeRecheio;
                break;
            case "TipoDeQueijo":
                idArray = R.array.TiposDeQuiejo;
                break;
            case "TipoDeSalada":
                idArray = R.array.TipoDeSalada;
                break;
            case "TipoDeMolho":
                idArray = R.array.TipoDeMolho;
                break;
        }

        String[] listaItens = getResources().getStringArray(idArray);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                listaItens
        );
        spinner.setAdapter(adapter);


        intent = new Intent(this, SegundaActivity.class);


    }

    public void voltarParaSegundaTela (View v){
        String option = ((Spinner)findViewById(R.id.escolha)).getSelectedItem().toString();
        pacote.putString(pacote.getString("escolha"),option);
        intent.putExtras(pacote);
        startActivity(intent);
    }
}