package com.example.brunomarques.calculonotab2;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Notas np1 = new Notas();
    Notas np2 = new Notas();
    Notas pim = new Notas();
    double valorCorteNPs = 0.4;
    double valorCortePIM = 0.2;

    TextView viewResultadoNota;
    Double Resultado;
    String ErrorNotasNecessarias = "Digite no minimo 2 notas";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewResultadoNota = findViewById(R.id.TxtResultado);
        np1.setEditNota((EditText) findViewById(R.id.NotaNP1));
        np2.setEditNota((EditText) findViewById(R.id.NotaNP2));
        pim.setEditNota((EditText) findViewById(R.id.NotaPIM));
        np1.setValueNota(0.4);
        np2.setValueNota(0.4);
        pim.setValueNota(0.2);
        np1.setResultadoNotaBase("Você precisa tirar na NP1: ");
        np2.setResultadoNotaBase("Você precisa tirar na NP2: ");
        pim.setResultadoNotaBase("Você precisa tirar no PIM: ");
    }

    public void testeValores(View v){
        if(np1.getEditNota().getText().toString().trim().equals("")){
            testes(np2, pim, np1, valorCorteNPs, valorCortePIM, valorCorteNPs);
        }else if(np2.getEditNota().getText().toString().trim().equals("")){
            testes(np1, pim, np2, valorCorteNPs, valorCortePIM, valorCorteNPs);
        }else if(pim.getEditNota().getText().toString().trim().equals("")){
            testes(np1, np2, pim, valorCorteNPs, valorCorteNPs, valorCortePIM);
        }
    }

    public void testes(Notas ValorA, Notas ValorB, Notas ValorC, double valor1, double valor2, double valor3) {
        if (ValorA.getEditNota().getText().toString().trim().equals("")) {
            Toast.makeText(this, ErrorNotasNecessarias, Toast.LENGTH_SHORT).show();
        } else {
            if (ValorB.getEditNota().getText().toString().trim().equals("")) {
                Toast.makeText(this, ErrorNotasNecessarias, Toast.LENGTH_SHORT).show();
            } else {
                ValorB.setValueNota(Double.valueOf(ValorB.getEditNota().getText().toString()));
                ValorA.setValueNota(Double.valueOf(ValorA.getEditNota().getText().toString()));
                Resultado = (5 - (ValorB.getValueNota() * valor1) - (ValorA.getValueNota() * valor2));
                if(Resultado < 0) {
                    Resultado = 0.00;
                }
                if((Resultado < 1) && (ValorC == pim)) {
                    Resultado = 1.00;
                }
                if((Resultado > 2) && (ValorC == pim)) {
                    viewResultadoNota.setText("Pegará DP pois você precisa de: " + String.format("%.2f", Resultado) + " no pim");
                }else if((Resultado > 10) && (ValorC == np1)){
                    viewResultadoNota.setText("Pegará DP pois você precisa de :" + String.format("%.2f", Resultado) + " na NP1");
                }else if((Resultado > 10) && (ValorC == np2)){
                    viewResultadoNota.setText("Pegará DP pois você precisa de :" + String.format("%.2f", Resultado) + " na NP2");
                }else{
                    viewResultadoNota.setText(ValorC.getResultadoNotaBase().toString() + String.format("%.2f", Resultado));
                }
            }
        }
    }
}
