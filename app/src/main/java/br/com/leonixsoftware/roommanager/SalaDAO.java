package br.com.leonixsoftware.roommanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by leondenis on 15/10/18.
 */

public class SalaDAO {

    private SQLiteDatabase db;
    private SQLiteHelper helper;

    private static final String TABLE_NAME = "SALA";

    // Colunas
    private static final String KEY_ID = "ID";
    private static final String KEY_NUMERO = "NUMERO";
    private static final String KEY_APELIDO = "APELIDO";
    private static final String KEY_BLOCO = "BLOCO";
    private static final String KEY_ANDAR = "ANDAR";

    // Array Colunas
    private static final String[] COLUMNS = {KEY_ID, KEY_NUMERO, KEY_APELIDO, KEY_BLOCO, KEY_ANDAR};

    public SalaDAO(Context context) {
        helper = new SQLiteHelper(context);
        db = helper.openDatabase();
    }

    // Insert.
    public void addSala(Sala sala) {
        // Criador de parâmentros.
        ContentValues contentValues = new ContentValues();

        contentValues.put(KEY_NUMERO, sala.getNumero());
        contentValues.put(KEY_APELIDO, sala.getApelido());
        contentValues.put(KEY_BLOCO, sala.getBloco());
        contentValues.put(KEY_ANDAR, sala.getAndar());

        db.insert(TABLE_NAME, null, contentValues);
    }

    public Sala getSala(Long id) {

        Cursor cursor = db.query(TABLE_NAME, COLUMNS, " ID = ?",
                new String[]{String.valueOf(id)},
                null, null, null, null);

        if (cursor != null) cursor.moveToFirst();

        Sala sala = new Sala(Long.parseLong(cursor.getString(0)),
                Integer.parseInt(cursor.getString(1)),
                cursor.getString(2),
                cursor.getString(3),
                Integer.parseInt(cursor.getString(4)));

        return sala;
    }


    public ArrayList<Sala> getAllSalas() {
        ArrayList<Sala> salas = new ArrayList<Sala>();

        String query = "SELECT * FROM " + TABLE_NAME;

        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            do {
                salas.add(new Sala(Long.parseLong(cursor.getString(0)),
                        Integer.parseInt(cursor.getString(1)),
                        cursor.getString(2),
                        cursor.getString(3),
                        Integer.parseInt(cursor.getString(4))));
            } while (cursor.moveToNext());
        }

        return salas;
    }

    public int updateSala(Sala sala) {

        // Criador de parâmentros.
        ContentValues contentValues = new ContentValues();

        contentValues.put(KEY_NUMERO, sala.getNumero());
        contentValues.put(KEY_APELIDO, sala.getApelido());
        contentValues.put(KEY_BLOCO, sala.getBloco());
        contentValues.put(KEY_ANDAR, sala.getAndar());

        return db.update(TABLE_NAME, contentValues, KEY_ID + " = ? ", new String[]{String.valueOf(sala.getId())});
    }

    public void deleteSala(Sala sala) {
        db.delete(TABLE_NAME, KEY_ID + " = ? ", new String[]{String.valueOf(sala.getId())});
    }

}
