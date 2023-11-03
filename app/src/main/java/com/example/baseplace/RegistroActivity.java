package com.example.baseplace;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import androidx.appcompat.app.AppCompatActivity;

public class RegistroActivity extends AppCompatActivity {
    private EditText editTextUnidad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextUnidad = findViewById(R.id.unidad);
        RadioButton btnUser = findViewById(R.id.btn_user);
        RadioButton btnChofer = findViewById(R.id.btn_chofer);

        btnUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextUnidad.setVisibility(View.GONE);
            }
        });

        btnChofer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextUnidad.setVisibility(View.VISIBLE);
            }
        });
    }
}
