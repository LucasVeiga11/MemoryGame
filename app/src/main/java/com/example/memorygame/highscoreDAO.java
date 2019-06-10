package com.example.memorygame;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class highscoreDAO {

    public static final void inserir(Highscore iten, Context context){

        Banco banco = new Banco (context);
        ContentValues valores = new ContentValues();

        valores.put("id", iten.getId_score());
        valores.put("nome", iten.getNome() );
        valores.put("pontos", iten.getScore() );
        SQLiteDatabase db = banco.getWritableDatabase();
        db.insert("highscores", null, valores);
    }

    public static final List<Highscore> mostrar(Context context, int idLista) {
        List<Highscore> listar = new ArrayList<>();
        Banco banco = new Banco(context);
        SQLiteDatabase db = banco.getReadableDatabase();
        String sql = "SELECT * FROM highscores ORDER BY pontos DESC";
        Cursor cursor = db.rawQuery(sql, null);
        if(cursor.getCount() > 0){
            cursor.moveToFirst();
            do {
                Highscore itens = new Highscore();
                itens.setId_score(cursor.getInt(0));
                itens.setNome(cursor.getString(1));
                itens.setScore(cursor.getInt(2));
                listar.add(itens);
            }while(cursor.moveToNext());
        }

        return listar;
    }

}
