package com.hafizramiz.catchthejerry;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;


public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    ImageView imageView1;
    ImageView imageView2;
    ImageView imageView3;
    ImageView imageView4;
    ImageView imageView5;
    ImageView imageView6;
    ImageView imageView7;
    ImageView imageView8;
    ImageView[] imageViewArray;
    int score;
    TextView textViewScore;
    TextView textViewCountDownTimer;
    CountDownTimer countDownTimer;
    Handler handler;
    Runnable runnable;
    int randomNumber;
    Random random;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        System.out.println("on Create Called");
        WorkerThread workerThread = new WorkerThread("Birinci Worker Thread");
        workerThread.start();
        System.out.println(" Worker Thread Ismi:"+workerThread.getName());
        Yazici yazici=new Yazici(100);


        Computer2 c2=new Computer2(yazici,"Computer 2 Threadi");
        c2.start();
        System.out.println(" Computer2 Thread Ismi:"+c2.getName());

        Computer1 c1=new Computer1(yazici,"Computer 1 Threadi");
        c1.start();
        System.out.println(" Computer1 Thread Ismi:"+c1.getName());



        score = 0;
        textViewScore = findViewById(R.id.textViewScore);
        textViewCountDownTimer = findViewById(R.id.textViewCountDown);
        imageView = findViewById(R.id.imageView);
        imageView1 = findViewById(R.id.imageView1);
        imageView2 = findViewById(R.id.imageView2);
        imageView3 = findViewById(R.id.imageView3);
        imageView4 = findViewById(R.id.imageView4);
        imageView5 = findViewById(R.id.imageView5);
        imageView6 = findViewById(R.id.imageView6);
        imageView7 = findViewById(R.id.imageView7);
        imageView8 = findViewById(R.id.imageView8);
        imageViewArray = new ImageView[]{imageView, imageView1, imageView2, imageView3, imageView4, imageView5, imageView6, imageView7, imageView8};


        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                score++;
                System.out.println("score: " + score);
                textViewScore.setText("Score: " + score);
            }
        });
        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                score++;
                System.out.println("score: " + score);
                textViewScore.setText("Score: " + score);
            }
        });
        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                score++;
                System.out.println("score: " + score);
                textViewScore.setText("Score: " + score);
            }
        });
        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                score++;
                System.out.println("score: " + score);
                textViewScore.setText("Score: " + score);
            }
        });
        imageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                score++;
                System.out.println("score: " + score);
                textViewScore.setText("Score: " + score);
            }
        });
        imageView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                score++;
                System.out.println("score: " + score);
                textViewScore.setText("Score: " + score);
            }
        });
        imageView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                score++;
                System.out.println("score: " + score);
                textViewScore.setText("Score: " + score);
            }
        });
        imageView7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                score++;
                System.out.println("score: " + score);
                textViewScore.setText("Score: " + score);
            }
        });
        imageView8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                score++;
                System.out.println("score: " + score);
                textViewScore.setText("Score: " + score);
            }
        });


        countDownTimer = new CountDownTimer(10000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                textViewCountDownTimer.setText("Seconds Remaining: " + millisUntilFinished / 1000);
            }

            @Override
            public void onFinish() {
                handler.removeCallbacks(runnable);

                textViewCountDownTimer.setText("Done!");
                imageViewArray[randomNumber].setVisibility(View.INVISIBLE);
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
                alertDialog.setMessage("Your Score: " + score + "\n" +
                        "Would you like to try again?");
                alertDialog.setTitle("NEW GAME");
                alertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = getIntent();
                        finish();
                        startActivity(intent);
                    }
                });
                alertDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast toast = Toast.makeText(MainActivity.this, "Game Over! Thank you", Toast.LENGTH_LONG);
                        toast.show();
                    }
                });
                alertDialog.show();
            }
        }.start();
        hideImages();
    }

    public void hideImages() {
        handler = new Handler();
        random = new Random();

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                randomNumber = random.nextInt(9);
                System.out.println("Random sayi:" + randomNumber);
                for (int i = 0; i < 9; i++) {
                    imageViewArray[i].setVisibility(View.INVISIBLE);
                }
                imageViewArray[randomNumber].setVisibility(View.VISIBLE);
                System.out.println("runnable calisiyor");
                handler.postDelayed(this, 500);
            }
        };

        handler.post(runnable);
    }
}