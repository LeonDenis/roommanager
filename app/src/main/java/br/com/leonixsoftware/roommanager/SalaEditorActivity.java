package br.com.leonixsoftware.roommanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SalaEditorActivity extends AppLeonixActivity {

    EditText numero = null, apelido = null, bloco = null, andar = null;
    Button btnCancelar = null, btnAdicionar = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sala_editor);
        // Componentes.
        this.numero = super.load(R.id.txtNumero);
        this.apelido = super.load(R.id.txtApelido);
        this.bloco = super.load(R.id.txtApelido);
        this.andar = super.load(R.id.txtAndar);
        this.btnAdicionar = super.load(R.id.btnAdd);
        this.btnCancelar = super.load(R.id.btnCancelar);
        // Cancelar.
        this.btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        // Adicionar
        this.btnAdicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer num = Integer.parseInt(numero.getText().toString());
                String ape = apelido.getText().toString();
                String blq = bloco.getText().toString();
                Integer and = Integer.parseInt(andar.getText().toString());
                // Auto incremento.
                Long id = MainActivity.arraySalas.size() + 1L;
                // Mudando o contexto.
                MainActivity.salaAdapter.setContext(SalaEditorActivity.this);
                // Adicionando a sala.
                MainActivity.arraySalas.add(new Sala(id, num, ape, blq, and));
                // Setando o adptador com o novo contexto.
                MainActivity.lstViewSalas.setAdapter(MainActivity.salaAdapter);
                // Notificando o usuário da adição.
                Toast.makeText(SalaEditorActivity.this, "Sala adicionada com sucesso!", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}
