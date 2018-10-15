package br.com.leonixsoftware.roommanager;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppLeonixActivity {
    FloatingActionButton adicionar = null;
    public static ListView lstViewSalas = null;
    public static ArrayList<Sala> arraySalas = null;
    public static SalaAdapter salaAdapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Toolbar.
        Toolbar toolbar = super.load(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Lista
        arraySalas = new ArrayList<Sala>();
        // Elementos
        this.adicionar = super.load(R.id.add);
        this.lstViewSalas = super.load(R.id.lstSalas);

        // Adicionar
        this.adicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getBaseContext(), SalaEditorActivity.class));
            }
        });
        // Adapter.
        this.salaAdapter = new SalaAdapter(arraySalas, MainActivity.this);
        this.lstViewSalas.setAdapter(salaAdapter);
    }

}
