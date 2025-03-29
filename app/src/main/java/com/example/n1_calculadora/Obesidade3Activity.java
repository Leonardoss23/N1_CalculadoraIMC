package com.example.n1_calculadora;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class Obesidade3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_obesidade3);

        // Pegando os dados enviados via Intent
        double imc = getIntent().getDoubleExtra("imc", 0.0);
        String peso = getIntent().getStringExtra("peso");
        String altura = getIntent().getStringExtra("altura");

        TextView textoIMC = findViewById(R.id.textoIMC);
        TextView textoDetalhes = findViewById(R.id.textoDetalhes);

        // Exibindo os dados na tela
        textoIMC.setText("IMC: " + String.format("%.2f", imc));
        textoDetalhes.setText("Peso: " + peso + "\nAltura: " + altura);

        // Configurando o botão "Voltar"
        Button btn_Voltar = findViewById(R.id.btn_fechar);
        btn_Voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                voltarAoMenu();
            }
        });
    }


    private void voltarAoMenu() {
        Intent intent = new Intent(Obesidade3Activity.this, MainActivity.class);
        startActivity(intent);
    }
}
