package com.example.memorygame;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Menu extends AppCompatActivity {
    EditText teste;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);


        Button btnJogar = (Button) findViewById(R.id.btnJogar);
                Button btnHighscores = (Button)findViewById(R.id.btnHighscores);
                Button btnSair = (Button)findViewById(R.id.btnSair);



                btnJogar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent intent = new Intent(Menu.this, MainActivity.class);
                        int a = 0;
                        intent.putExtra("rodadas", a);
                        startActivity(intent);

                    }
                });

                btnHighscores.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(Menu.this, MostrarHighscore.class);
                        startActivity(intent);



                    }
                });

                btnSair.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                        System.exit(0);
                    }
                });





    }
}
