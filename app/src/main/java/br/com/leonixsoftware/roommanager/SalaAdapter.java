package br.com.leonixsoftware.roommanager;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteAbortException;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by leondenis on 14/10/18.
 */

public class SalaAdapter extends BaseAdapter {

    private ArrayList<Sala> salas = null;
    private Context context;


    public SalaAdapter(ArrayList<Sala> salas, Context context) {
        this.salas = salas;
        this.context = context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return this.salas.size();
    }

    @Override
    public Sala getItem(int index) {
        return this.salas.get(index);
    }

    @Override
    public long getItemId(int index) {
        return this.salas.get(index).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        // Obtendo minha sala.
        final Sala sala = getItem(position);
        // Obtendo o inflador master blaster mega power.
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // Criando view baseada no layout.
        View view = layoutInflater.inflate(R.layout.sala_item, null);
        // Objetos.
        TextView textSalaIno = (TextView) view.findViewById(R.id.txtSalaInfo);
        ImageButton btnExcluir = (ImageButton) view.findViewById(R.id.btnExcluir);
        ImageButton btnEditar = (ImageButton) view.findViewById(R.id.btnEditar);
        // Setando o textview.
        textSalaIno.setText("Número: " + sala.getNumero() + " | Apelido: " + sala.getApelido());
        // Excluir.
        btnExcluir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Banco.
                final SalaDAO salaDAO = new SalaDAO(context);
                // Setando contexto.
                MainActivity.salaAdapter.setContext(context);
                // Removendo a sala da lista.
                MainActivity.arraySalas.remove(sala);
                // Setando o adptador com o novo contexto.
                MainActivity.lstViewSalas.setAdapter(MainActivity.salaAdapter);
                // Removendo a sala do banco.
                salaDAO.deleteSala(sala);
                Toast.makeText(context, "Sala excluída com sucesso!", Toast.LENGTH_SHORT).show();
            }
        });
        // Editar.
        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, SalaEditorActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("sala", sala);
                intent.putExtra("info", bundle);
                context.startActivity(intent);
            }
        });
        return view;
    }
}
