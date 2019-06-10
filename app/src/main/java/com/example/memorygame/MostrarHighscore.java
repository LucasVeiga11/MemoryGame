package com.example.memorygame;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.List;

public class MostrarHighscore extends AppCompatActivity {
    ListView lvIten;
    List<Highscore> itens;
    adapterHighscore adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_highscore);
        lvIten = (ListView) findViewById(R.id.lvItens);



    }
    private void carregarLista(int idlista){

        itens = highscoreDAO.mostrar(this,idlista);
//        adapter = new ArrayAdapter(this,
//                android.R.layout.simple_list_item_1, lista );
        adapter = new adapterHighscore(this, itens);
        lvIten.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        final int sessionId= getIntent().getIntExtra("EXTRA_SESSION_ID",0);
        carregarLista(sessionId);
    }
}

