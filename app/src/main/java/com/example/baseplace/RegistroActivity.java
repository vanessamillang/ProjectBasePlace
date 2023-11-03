package com.example.baseplace;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.baseplace.utilidades.Utilidades;

public class RegistroActivity extends AppCompatActivity {

    private RadioButton btnUser;
    private RadioButton btnChofer;
    EditText campoUsername, campoCorreo, campoContraseña, campoTelefono, campoUnidad;
    Button btnRegistrar;
    private RadioButton lastSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        btnUser = findViewById(R.id.btn_user);
        btnChofer = findViewById(R.id.btn_chofer);
        lastSelected = null;
        //CAMPOS DE LAS TABLAS
        campoUsername = findViewById(R.id.username);
        campoCorreo = findViewById(R.id.email);
        campoContraseña = findViewById(R.id.password);
        campoTelefono = findViewById(R.id.telefono);
        campoUnidad = findViewById(R.id.unidad);
        btnRegistrar = findViewById(R.id.btn_registrar);

        //CLICK EN RADIO BUTTON USUARIO NORMAL
        btnUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (lastSelected != null) {
                    lastSelected.setChecked(false); // Desmarcar el RadioButton previamente seleccionado
                }
                lastSelected = btnUser;
                campoUnidad.setVisibility(View.GONE);
            }
        });

        //CLICK RADIO BUTTON CONDUCTOR
        btnChofer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (lastSelected != null) {
                    lastSelected.setChecked(false); // Desmarcar el RadioButton previamente seleccionado
                }
                lastSelected = btnChofer;
                campoUnidad.setVisibility(View.VISIBLE);
            }
        });

        //CLICK BUTTON REGISTRAR
        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registrarUsuarios();
            }
        });
    }

    //METODO PARA REGISTRO DE USUARIOS EN LA BD
    private void registrarUsuarios() {
        //CONEXION CON LA BASE DE DATOS
        ConexionSQLiteHelper conn = new ConexionSQLiteHelper(this, "bd_usuarios", null, 1);
        SQLiteDatabase db = conn.getWritableDatabase();
        try {
            //INSERTAR DATOS EN LA TABLA
            ContentValues values = new ContentValues();
            values.put(Utilidades.CAMPO_USUARIO, campoUsername.getText().toString());
            values.put(Utilidades.CAMPO_CORREO, campoCorreo.getText().toString());
            values.put(Utilidades.CAMPO_CONTRASEÑA, campoContraseña.getText().toString());
            values.put(Utilidades.CAMPO_TELEFONO, campoTelefono.getText().toString());
            values.put(Utilidades.CAMPO_UNIDAD, campoUnidad.getText().toString());

            //NOTIFICACIÓN DEL REGISTRO
            long idResultante = db.insert(Utilidades.TABLA_USUARIO, null, values);
            Toast.makeText(getApplicationContext(), "Id Registro: " + idResultante, Toast.LENGTH_SHORT).show();
            db.close(); //CERRAR BASE DE DATOS
        } catch (Exception e) {
            // Manejo de excepciones
            e.printStackTrace();
            Toast.makeText(getApplicationContext(), "Error al registrar usuario", Toast.LENGTH_SHORT).show();
        }
    }
}
