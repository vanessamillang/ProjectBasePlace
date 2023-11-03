package com.example.baseplace;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.baseplace.utilidades.Utilidades;

public class RegistroActivity extends AppCompatActivity {
    EditText campoUsername, campoCorreo, campoContraseña, campoTelefono, campoUnidad;
    Button btnRegistrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        campoUsername = findViewById(R.id.username);
        campoCorreo = findViewById(R.id.email);
        campoContraseña = findViewById(R.id.password);
        campoTelefono = findViewById(R.id.telefono);
        campoUnidad = findViewById(R.id.unidad);
        btnRegistrar = findViewById(R.id.btn_registrar);

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registrarUsuarios();
            }
        });
    }

    private void registrarUsuarios() {
        ConexionSQLiteHelper conn = new ConexionSQLiteHelper(this, "bd_usuarios", null, 1);
        SQLiteDatabase db = conn.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Utilidades.CAMPO_USUARIO, campoUsername.getText().toString());
        values.put(Utilidades.CAMPO_CORREO, campoCorreo.getText().toString());
        values.put(Utilidades.CAMPO_CONTRASEÑA, campoContraseña.getText().toString());
        values.put(Utilidades.CAMPO_TELEFONO, campoTelefono.getText().toString());
        values.put(Utilidades.CAMPO_UNIDAD, campoUnidad.getText().toString());

        long idResultante = db.insert(Utilidades.TABLA_USUARIO, null, values);
        Toast.makeText(getApplicationContext(), "Id Registro: " + idResultante, Toast.LENGTH_SHORT).show();
        db.close();

    }
}
