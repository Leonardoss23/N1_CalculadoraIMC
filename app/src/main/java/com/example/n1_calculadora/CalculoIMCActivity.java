package com.example.n1_calculadora;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CalculoIMCActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_calculoimc);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    @Override
    protected void onResume(){
        super.onResume();
        Log.i("Ciclo da vida", "Tela1 - onResume");

    }
    @Override
    protected  void onPause(){
        super.onPause();
        Log.i("Ciclo da vida","Tela1 - onPause");

    }
    @Override
    protected  void onDestroy(){
        super.onDestroy();
        Log.i("Ciclo da vida","Tela1 - onDestroy");

    }
    @Override
    protected  void onStop(){
        super.onStop();
        Log.i("Ciclo da vida","Tela1 - onStop");

    }
    @Override
    protected  void onRestart(){
        super.onRestart();
        Log.i("Ciclo da vida","Tela1 - onRestart");

    }
    @Override
    protected  void onStart(){
        super.onStart();
        Log.i("Ciclo da vida","Tela1 - onStart");

    }
    public void calculo(View view){
        @SuppressLint("WrongViewCast") EditText peso = findViewById(R.id.peso);
        @SuppressLint("WrongViewCast") EditText altura = findViewById(R.id.altura);

        String valorPeso = peso.getText().toString();
        String valorAltura = altura.getText().toString();
        double intPeso = Double.parseDouble(valorPeso);
        double intAltura = Double.parseDouble(valorAltura);
        String strNivel;

        double imc = (intPeso / (intAltura * intAltura));

        if(imc < 18.5){
            strNivel = "Abaixo do peso!";
            redirecionarParaActivity(AbaixoDoPesoActivity.class, imc, valorPeso, valorAltura);
        } else if(imc < 24.9){
            strNivel = "Peso normal";
            redirecionarParaActivity(PesoNormalActivity.class, imc, valorPeso, valorAltura);
        } else if(imc < 29.9){
            strNivel = "Sobrepeso";
            redirecionarParaActivity(SobrepesoActivity.class, imc, valorPeso, valorAltura);
        } else if(imc < 34.9){
            strNivel = "Obesidade grau 1";
            redirecionarParaActivity(Obesidade1Activity.class, imc, valorPeso, valorAltura);
        } else if(imc < 39.9){
            strNivel = "Obesidade grau 2";
            redirecionarParaActivity(Obesidade2Activity.class, imc, valorPeso, valorAltura);
        } else{
            strNivel = "Obesidade grau 3";
            redirecionarParaActivity(Obesidade3Activity.class, imc, valorPeso, valorAltura);
        }

        @SuppressLint("DefaultLocale") String str = String.format("%.2f", imc);

    }

    private void redirecionarParaActivity(Class<?> activityClass, double imc, String peso, String altura){
        Intent intent = new Intent(CalculoIMCActivity.this, activityClass);
        intent.putExtra("imc", imc);
        intent.putExtra("peso", peso);
        intent.putExtra("altura", altura);
        startActivity(intent);
    }

}


