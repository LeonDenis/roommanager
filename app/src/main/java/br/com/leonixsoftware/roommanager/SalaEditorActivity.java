package br.com.leonixsoftware.roommanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by leondenis on 14/10/18.
 */

public class SalaEditorActivity extends AppLeonixActivity {

    // Controles.
    EditText numero = null, apelido = null, bloco = null, andar = null;
    Button btnCancelar = null, btnAdicionar = null;
    // Modo de salvar.
    boolean editar = false;
    // Sala.
    Sala sala = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sala_editor);
        // Banco.
        final SalaDAO salaDAO = new SalaDAO(this);
        // Componentes.
        this.numero = load(R.id.txtNumero);
        this.apelido = load(R.id.txtApelido);
        this.bloco = load(R.id.txtBloco);
        this.andar = load(R.id.txtAndar);
        this.btnAdicionar = load(R.id.btnAdd);
        this.btnCancelar = load(R.id.btnCancelar);
        // Verificando parametros.
        Bundle bundle = getIntent().getBundleExtra("info");
        if (bundle != null) {
            sala = (Sala) bundle.getSerializable("sala");
            if (sala != null) {
                this.numero.setText(sala.getNumero().toString());
                this.apelido.setText(sala.getApelido().toString());
                this.andar.setText(sala.getAndar().toString());
                this.bloco.setText(sala.getBloco().toString());
                this.numero.setEnabled(false);
                editar = true;
            }
        }
        // Cancelar.
        this.btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        // Salvar.
        this.btnAdicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer num = Integer.parseInt(numero.getText().toString());
                String ape = apelido.getText().toString();
                String blq = bloco.getText().toString();
                Integer and = Integer.parseInt(andar.getText().toString());
                // Verificando salas.
                if (!editar) {
                    for (Sala salaVrf : MainActivity.arraySalas) {
                        if (salaVrf.getNumero().equals(num) && salaVrf.getBloco().equals(blq)) {
                            Toast.makeText(SalaEditorActivity.this, "A sala " + num + " já existe no bloco " + blq + " .", Toast.LENGTH_LONG).show();
                            return;
                        }
                    }
                }
                if (!editar) {
                    // Mudando o contexto.
                    MainActivity.salaAdapter.setContext(SalaEditorActivity.this);
                    // Nova Sala.
                    sala = new Sala(num, ape, blq, and);
                    // Adicionando a sala na lista.
                    // MainActivity.arraySalas.add(sala);
                    // Limpando o array.
                    MainActivity.arraySalas.clear();
                    // Adicionando a sala no banco.
                    salaDAO.addSala(sala);
                    // Marrentando a tela.
                    MainActivity.loadList();
                } else {
                    // Editando a sala na lista.
                    for (Sala salaEdit : MainActivity.arraySalas) {
                        if (salaEdit.getId().equals(sala.getId())) {
                            salaEdit.setApelido(ape);
                            salaEdit.setNumero(num);
                            salaEdit.setBloco(blq);
                            salaEdit.setAndar(and);
                            // Editando a sala no banco.
                            salaDAO.updateSala(salaEdit);
                        }
                    }
                }
                // Setando o adptador com o novo contexto.
                MainActivity.lstViewSalas.setAdapter(MainActivity.salaAdapter);
                // Notificando o usuário.
                if (!editar) {
                    Toast.makeText(SalaEditorActivity.this, "Sala adicionada com sucesso!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(SalaEditorActivity.this, "Sala alterada com sucesso!", Toast.LENGTH_SHORT).show();
                }
                // Fechando Activity.
                finish();
            }
        });
    }
}
