package br.com.leonixsoftware.roommanager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

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
        Sala sala = getItem(position);
        // Obtendo o inflador master blaster mega power.
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // Criando view baseada no layout.
        View view = layoutInflater.inflate(R.layout.sala_item, null);
        // Obtendo text view.
        TextView textSalaIno = (TextView) view.findViewById(R.id.txtSalaInfo);
        // Setando o textview.
        textSalaIno.setText("Número: " + sala.getNumero() + " | Apelido: " + sala.getApelido());

        return view;
    }
}
