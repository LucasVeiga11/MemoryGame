package com.example.memorygame;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

public class respostas extends AppCompatActivity {
    private ConstraintLayout layout;
    private ImageView img;


    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_respostas);
        final Bundle extras = getIntent().getExtras();
        final int[] num = extras.getIntArray("valor");
        layout =(ConstraintLayout) findViewById(R.id.layout);
        // txt.setText(Arrays.toString(num).replaceAll("0", ""));
        final Intent intent = new Intent(respostas.this, MainActivity.class);
        final Intent intent2 = new Intent(respostas.this, Menu.class);

        final String teste = "pos5.2";
        int teste2 = getResources().getIdentifier(teste,"id",getPackageName());
        img = ((ImageView) findViewById(teste2));
        img.setImageResource(R.drawable.quadrado_dot2);




        layout.setOnTouchListener( new OnSwipeTouchListener(this) {

            int i = 0;
            int x = 5, y = 2;
            int a = extras.getInt("rodadas");

            @Override
            public void onSwipeBottom() {

                if (num[i] == 2) {
                    String testee = "pos" + x + "." + y;
                    int teste2 = getResources().getIdentifier(testee, "id", getPackageName());
                    img = ((ImageView) findViewById(teste2));
                    img.setImageResource(R.drawable.quadrado2);
                    if (x < 7)
                        x++;

                    testee = "pos" + x + "." + y;
                    teste2 = getResources().getIdentifier(testee, "id", getPackageName());
                    img = ((ImageView) findViewById(teste2));
                    img.setImageResource(R.drawable.quadrado_dot2);
                    super.onSwipeBottom();
                    i++;
                } else {
                    Highscore score = new Highscore();
                    score.setNome("teste");
                    score.setScore(a);
                    highscoreDAO.inserir(score, respostas.this);
                    startActivity(intent2);
                }

                if(num[i] == 0){
                    a++;
                    intent.putExtra("rodadas",a);
                    startActivity(intent);
                }
        }



            @Override
            public void onSwipeTop() {

                if (num[i] == 1) {
                    String testee = "pos" + x + "." + y;
                    int teste2 = getResources().getIdentifier(testee, "id", getPackageName());
                    img = ((ImageView) findViewById(teste2));
                    img.setImageResource(R.drawable.quadrado2);
                    if (x > 1)
                        x--;
                    testee = "pos" + x + "." + y;
                    teste2 = getResources().getIdentifier(testee, "id", getPackageName());
                    img = ((ImageView) findViewById(teste2));
                    img.setImageResource(R.drawable.quadrado_dot2);

                    super.onSwipeTop();
                    i++;
                } else {
                    Highscore score = new Highscore();
                    score.setNome("teste");
                    score.setScore(a);
                    highscoreDAO.inserir(score, respostas.this);
                    startActivity(intent2);
                }

                if(num[i] == 0){
                    a++;
                    intent.putExtra("rodadas",a);
                    startActivity(intent);
                }
            }

            @Override
            public void onSwipeLeft() {

                            if(num[i] == 4) {
                String testee = "pos"+x+"."+y;
                int teste2 = getResources().getIdentifier(testee,"id",getPackageName());
                img = ((ImageView) findViewById(teste2));
                img.setImageResource(R.drawable.quadrado2);
                if(y > 1)
                y--;
                testee = "pos"+x+"."+y;
                teste2 = getResources().getIdentifier(testee,"id",getPackageName());
                img = ((ImageView) findViewById(teste2));
                img.setImageResource(R.drawable.quadrado_dot2);
                super.onSwipeLeft();
                            i++;
                        }else {
                                Highscore score = new Highscore();
                                score.setNome("teste");
                                score.setScore(a);
                                highscoreDAO.inserir(score, respostas.this);
                                startActivity(intent2);
                }
                if(num[i] == 0){
                    a++;
                    intent.putExtra("rodadas",a);
                    startActivity(intent);
                }
            }

            @Override
            public void onSwipeRight() {

                                if(num[i] == 3) {
                String testee = "pos"+x+"."+y;
                int teste2 = getResources().getIdentifier(testee,"id",getPackageName());
                img = ((ImageView) findViewById(teste2));
                img.setImageResource(R.drawable.quadrado2);
                if(y < 4)
                    y++;

                testee = "pos"+x+"."+y;
                teste2 = getResources().getIdentifier(testee,"id",getPackageName());
                img = ((ImageView) findViewById(teste2));
                img.setImageResource(R.drawable.quadrado_dot2);
                super.onSwipeRight();
                                i++;
                            }else {
                                    Highscore score = new Highscore();
                                    score.setNome("teste");
                                    score.setScore(a);
                                    highscoreDAO.inserir(score, respostas.this);
                                    startActivity(intent2);
            }
                if(num[i] == 0){
                    a++;
                    intent.putExtra("rodadas",a);
                    startActivity(intent);
                }
            }


        });



/*
        for(int i = 0;i< num.length;i++){

            if(num[i] != 0)
            txt.append(String.valueOf(num[i]));


        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(respostas.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
    */
    }
}
