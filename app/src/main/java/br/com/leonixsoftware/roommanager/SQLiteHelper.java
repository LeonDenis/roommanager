package br.com.leonixsoftware.roommanager;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLiteHelper extends SQLiteOpenHelper {


    // Versão do banco.
    private static final int DATABASE_VERSION = 1;
    // Nome do Banco.
    private static final String DATABASE_NAME = "roommanager.db";
    // Nome da tabela
    private static final String TABLE_NAME = "SALA";

    public SQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public SQLiteDatabase openDatabase() {
        return this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " (" +
                "ID INTEGER PRIMARY KEY AUTO INCREMENT, " +
                "NUMERO INTEGER, " +
                "APELIDO TEXT, " +
                "BLOCO TEXT, " +
                "ANDAR INTEGER" +
                ")";

        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Dropa a tabela se existir.
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);

        // Cria outra nova.
        this.onCreate(db);
    }

}
