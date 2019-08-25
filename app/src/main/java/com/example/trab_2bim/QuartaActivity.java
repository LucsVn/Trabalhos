package com.example.trab_2bim;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class QuartaActivity extends AppCompatActivity {

    Intent intent;
    Bundle pacote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quarta_activity);

        intent = getIntent();
        pacote = intent.getExtras();

        String tipoDePao = pacote.getString("TipoDePao");
        TextView TipoDePao = (TextView) findViewById(R.id.TipoDePao);
        TipoDePao.setText(tipoDePao);

        String tipoDeRecheio =  pacote.getString("TipoDeRecheio");
        TextView TipoDeRecheio = (TextView) findViewById(R.id.TipoDeRecheio);
        TipoDeRecheio.setText(tipoDeRecheio);

        String tipoDeQueijo = pacote.getString("TipoDeQueijo");
        TextView TipoDeQueijo = (TextView) findViewById(R.id.TipoDeQueijo);
        TipoDeQueijo.setText(tipoDeQueijo);

        String tipoDeSalada = pacote.getString("TipoDeSalada");
        TextView TipoDeSalada = (TextView) findViewById(R.id.TipoDeSalada);
        TipoDeSalada.setText(tipoDeSalada);

        String tipoDeMolho = pacote.getString("TipoDeMolho");
        TextView TipoDeMolho = (TextView) findViewById(R.id.TipoDeMolho);
        TipoDeMolho.setText(tipoDeMolho);

        String temperaturaSanduiche = pacote.getString("Temperatura");
        TextView temperatura = (TextView) findViewById(R.id.temperatura);
        temperatura.setText(temperaturaSanduiche);
    }

    public void alertDialog(View v){
        AlertDialog.Builder builderAlert = new AlertDialog.Builder(this);
        builderAlert.setTitle("Confirmação");
        builderAlert.setMessage("Confirmar Pedido");

        DialogInterface.OnClickListener botaoSim = new DialogInterface.OnClickListener() {
            @Override
            public void onClick (DialogInterface dialog,int which) {
                notificacao();
            }
        };
        builderAlert.setPositiveButton( "Sim", botaoSim);
        builderAlert.create().show();
            }

    public void notificacao(){
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O) {
            NotificationChannel channel =
                    new NotificationChannel("my_channel_id",
                            "my_channel",
                            NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager nm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            nm.createNotificationChannel(channel);
        }

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this,"my_channel_id");
        builder.setSmallIcon(R.drawable.ic_launcher_background);
        builder.setContentTitle("confirmacao");
        builder.setContentText("Pedido Realizado com Sucesso!");
        builder.setPriority(NotificationCompat.PRIORITY_DEFAULT);
        NotificationManager nm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        nm.notify(123456, builder.build());
    }

}