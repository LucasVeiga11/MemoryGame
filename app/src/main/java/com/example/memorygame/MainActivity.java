package com.example.memorygame;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;
import java.util.Random;
import java.util.Arrays;



public class MainActivity extends AppCompatActivity {

    private int position = -1;
    private Handler handler;
    Random rand = new Random();
    private int[] nums = new int[50];
    private volatile Thread thread;


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView img = (ImageView) findViewById(R.id.imageView);
        final Intent intent = new Intent(MainActivity.this, respostas.class);

        final Timer mTimer = new Timer();
        mTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                // As timer is not a Main/UI thread need to do all UI task on runOnUiThread
               runOnUiThread(new Runnable() {

                        @Override
                    public void run() {
                        ImageView img = (ImageView) findViewById(R.id.imageView);
                        position++;

                        int n = rand.nextInt(4) + 1;

                            int a;
                            if(savedInstanceState == null) {
                                Bundle extras = getIntent().getExtras();
                                if(extras == null){
                                    a = 0;
                                } else{
                                    a = extras.getInt("rodadas");
                                }
                            } else{
                                a = (Integer) savedInstanceState.getSerializable("rodadas");
                            }
                        if (n == 1) {
                            Animation fadeInAnimation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.fade_in);
                          //  Animation fadeInAnimation = AnimationUtils.loadAnimation(this, R.anim.your_fade_in_anim);
                            img.startAnimation(fadeInAnimation);
                            img.setImageResource(R.drawable.uparrow);
                        }
                        if (n == 2) {
                            Animation fadeInAnimation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.fade_in);
                            //  Animation fadeInAnimation = AnimationUtils.loadAnimation(this, R.anim.your_fade_in_anim);
                            img.startAnimation(fadeInAnimation);
                            img.setImageResource(R.drawable.downarrow);
                        }
                        if (n == 3) {
                            Animation fadeInAnimation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.fade_in);
                            //  Animation fadeInAnimation = AnimationUtils.loadAnimation(this, R.anim.your_fade_in_anim);
                            img.startAnimation(fadeInAnimation);

                            img.setImageResource(R.drawable.rightarrow);
                        }
                        if (n == 4) {
                            Animation fadeInAnimation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.fade_in);
                            //  Animation fadeInAnimation = AnimationUtils.loadAnimation(this, R.anim.your_fade_in_anim);
                            img.startAnimation(fadeInAnimation);
                            img.setImageResource(R.drawable.leftarrow);
                        }
                            Animation fadeInAnimation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.fade_in);

                        for(int i = 0; i <nums.length; i++) {
                            if(nums[i] == 0) {
                                nums[i] = n;
                                break;
                            }
                        }
                        if(position >= 4) {
                            String texto = String.valueOf(nums[0]);

                            intent.putExtra("valor",nums);
                            intent.putExtra("rodadas",a);
                            mTimer.cancel();
                            position = 0;
                            startActivity(intent);



                        }
                    }


                });


            }


        }, 0, 2000);







    }
/*
    @Override
    protected void onStart() {

        super.onStart();
        Arrays.fill(nums,0);
        final Intent intent = new Intent(this, respostas.class);
        final Timer mTimer = new Timer();
        mTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                // As timer is not a Main/UI thread need to do all UI task on runOnUiThread
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        ImageView img = (ImageView) findViewById(R.id.imageView);
                        TextView txt = (TextView)findViewById(R.id.textView);
                        position++;

                        int n = rand.nextInt(4) + 1;
                        if (n == 1)
                            img.setImageResource(R.drawable.uparrow);
                        if (n == 2)
                            img.setImageResource(R.drawable.downarrow);
                        if (n == 3)
                            img.setImageResource(R.drawable.rightarrow);
                        if (n == 4)
                            img.setImageResource(R.drawable.leftarrow);
                        txt.setText(String.valueOf(n));

                        for(int i = 0; i <nums.length; i++) {
                            if(nums[i] == 0) {
                                nums[i] = n;
                                break;
                            }
                        }
                        if(position > 5) {
                            String texto = String.valueOf(nums[0]);
                            txt.setText("primeiro numero "+texto);

                            intent.putExtra("valor",nums);
                            startActivity(intent);
                            position = 0;
                            mTimer.cancel();


                        }
                    }


                });


            }


        }, 0, 2000);

    }

*/



public void onBackPressed(){



    }
}

