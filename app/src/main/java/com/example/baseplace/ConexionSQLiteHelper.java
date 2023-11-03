package com.example.baseplace;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import com.example.baseplace.utilidades.Utilidades;

public class ConexionSQLiteHelper extends SQLiteOpenHelper {

    public ConexionSQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Registra un mensaje cuando el método onCreate se ejecuta
        Log.d("SQLite", "Método onCreate se está ejecutando.");
        db.execSQL(Utilidades.CREAR_TABLA_USUARIO);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int versionAntigua, int versionNueva) {
        // Registra un mensaje cuando el método onUpgrade se ejecuta
        Log.d("SQLite", "Método onUpgrade se está ejecutando, versión antigua: " + versionAntigua + ", versión nueva: " + versionNueva);

        // Realiza cambios específicos para cada versión de la base de datos
        if (versionAntigua < 2) {
            // Realiza cambios específicos para la versión 2 de la base de datos, si es necesario
            Log.d("SQLite", "Realizando cambios para la versión 2 de la base de datos.");
            db.execSQL("ALTER TABLE " + Utilidades.TABLA_USUARIO + " ADD COLUMN nueva_columna TEXT");
        }
        // Agrega condiciones para otras versiones anteriores si es necesario y actualiza la versión de la base de datos
        db.setVersion(versionNueva);
    }
}
