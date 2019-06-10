package com.example.memorygame;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class adapterHighscore extends BaseAdapter {

    private Context context;
    private List<Highscore> itens;
    private LayoutInflater inflater;

    public adapterHighscore(Context context, List<Highscore> itens){
        this.context = context;
        this.itens = itens;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return itens.size();
    }

    @Override
    public Object getItem(int position) {
        return itens.get(position);
    }

    @Override
    public long getItemId(int position) {
        return itens.get(position).getId_score();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Suporte item;

        if( convertView == null ){
            convertView = inflater.inflate
                    (R.layout.highscore, null);
            item = new Suporte();
            item.tvNome = (TextView)
                    convertView.findViewById(R.id.tvNome);
            item.tvScore = (TextView)
                    convertView.findViewById(R.id.tvScore);

            convertView.setTag(item);
        }else {
            item = (Suporte) convertView.getTag();
        }

        Highscore nota = itens.get( position );
        item.tvNome.setText(  nota.getNome() );
        item.tvScore.setText( String.valueOf(nota.getScore())  );



        return convertView;
    }
    private class Suporte{
        TextView tvNome, tvScore;
    }
}
