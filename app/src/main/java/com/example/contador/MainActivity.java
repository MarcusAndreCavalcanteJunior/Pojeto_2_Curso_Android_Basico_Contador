package com.example.contador;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button btnSoma, btnSubtrair;
    TextView tvwResultado;
    int intResultado = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        btnSoma = findViewById(R.id.btn_soma);
        btnSubtrair = findViewById(R.id.btn_subtrair);
        tvwResultado = findViewById(R.id.tvw_resultado);

        btnSoma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Incrementa a varíável
                intResultado += 1;
                tvwResultado.setText(String.valueOf(intResultado));
            }
        });

        btnSubtrair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Decrementa a variável
                if (intResultado > 0) {
                    intResultado -= 1;
                    tvwResultado.setText(String.valueOf(intResultado));
                } else {
                    Toast.makeText(MainActivity.this, "Impossível subtrair",
                            Toast.LENGTH_SHORT).show();
                }

            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}