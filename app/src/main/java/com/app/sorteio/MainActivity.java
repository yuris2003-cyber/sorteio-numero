package com.app.sorteio;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    EditText edtMinimo, edtMaximo;
    TextView txtResultado;
    Button btnSortear;

    Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtMinimo = findViewById(R.id.edtMinimo);
        edtMaximo = findViewById(R.id.edtMaximo);
        txtResultado = findViewById(R.id.txtResultado);
        btnSortear = findViewById(R.id.btnSortear);

        btnSortear.setOnClickListener(v -> {

            String minimoTexto = edtMinimo.getText().toString();
            String maximoTexto = edtMaximo.getText().toString();


            if (minimoTexto.isEmpty() || maximoTexto.isEmpty()) {
                Toast.makeText(this,
                        "Preencha os dois campos!",
                        Toast.LENGTH_SHORT).show();
                return;
            }

            try {
                int minimo = Integer.parseInt(minimoTexto);
                int maximo = Integer.parseInt(maximoTexto);

                if (minimo > maximo) {
                    Toast.makeText(this,
                            "O mínimo deve ser menor ou igual ao máximo!",
                            Toast.LENGTH_SHORT).show();
                    return;
                }


                int numero = random.nextInt(maximo - minimo + 1) + minimo;

                txtResultado.setText(String.valueOf(numero));

            } catch (NumberFormatException e) {
                Toast.makeText(this,
                        "Digite números inteiros válidos!",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}


