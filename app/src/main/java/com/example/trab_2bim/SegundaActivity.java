package com.example.trab_2bim;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class SegundaActivity extends AppCompatActivity {

 Intent intent;
 Bundle pacote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.segunda_activity);


pacote = getIntent().getExtras();

        ListView listViewDaTela = findViewById(R.id.campi);


        listViewDaTela.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                switch (position) {
                    case 0:
                        fazerToast( "Selecione seu Pão");
                        proximaEtapa("TipoDePao");

                        break;
                    case 1:
                        fazerToast( "Selecione seu Recheio");
                        proximaEtapa("TipoDeRecheio");

                        break;
                    case 2:

                        fazerToast( "Selecione sua Queijo");
                        proximaEtapa("TipoDeQueijo");

                        break;

                    case 3:

                        fazerToast( "Selecione seu Salada");
                        proximaEtapa("TipoDeSalada");

                        break;

                    case 4:

                        fazerToast( "Selecione seu Molho");
                        proximaEtapa("TipoDeMolho");

                        break;
                }
            }
        });
    }

    public void proximaEtapa(String escolha){
        intent = new Intent(this, TerceiraActivity.class);
        pacote.putString("escolha",escolha);
        intent.putExtras(pacote);
        startActivity(intent);
    }

    public void confimarPedido(View v){
        intent = new Intent(this, QuartaActivity.class);
        intent.putExtras(pacote);
        startActivity(intent);
    }

    public void fazerToast(String texto){
        Toast.makeText(getApplicationContext(),
                texto,
                Toast.LENGTH_SHORT).show();
    }

}



