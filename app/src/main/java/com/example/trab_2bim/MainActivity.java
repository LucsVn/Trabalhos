package com.example.trab_2bim;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    Bundle pacote = new Bundle();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        pacote.putString("Temperatura","Quente");
    }

    public void mudardetela (View view){
        Intent intent = new Intent(this, SegundaActivity.class);
        intent.putExtras(pacote);
        startActivity(intent);
    }

    public void temperatura(View view) {
        RadioButton radioButton =(RadioButton) view;
        int  id = radioButton.getId();
        switch(id) {
            case R.id.quente:
                pacote.putString("Temperatura","Quente");
                break;
            case R.id.frio:
                pacote.putString("Temperatura","Frio");
                break;
        }
    }



}
