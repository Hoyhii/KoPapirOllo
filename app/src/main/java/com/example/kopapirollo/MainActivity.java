package com.example.kopapirollo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private ImageView imgView1, imgView2;
    private Button btn1,btn2,btn3;
    private TextView textView1,textView2,textView3;
    private boolean valaszt;
    private Random rnd;
    int min = 1;
    int max = 3;
    int szamitogep = (int)Math.floor(Math.random()*(max-min+1)+min);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(valaszt){
                    valaszt = false;
                    kepvalt(1);
                    szamitogepValt();
                }
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(valaszt){
                    valaszt = false;
                    kepvalt(2);
                    szamitogepValt();
                }
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(valaszt){
                    valaszt = false;
                    kepvalt(3);
                    szamitogepValt();
                }
            }
        });


    }

    private void kepvalt(int tipp){
        if(tipp == 1){
            imgView1.setImageResource(R.drawable.rock);
        }if(tipp == 2){
            imgView1.setImageResource(R.drawable.paper);
        }if(tipp == 3){
            imgView1.setImageResource(R.drawable.scissors);
        }
    }
    private void szamitogepValt(){

        if(szamitogep == 1){
            imgView2.setImageResource(R.drawable.rock);
        }if(szamitogep == 2){
            imgView2.setImageResource(R.drawable.paper);
        }if(szamitogep == 3){
            imgView2.setImageResource(R.drawable.scissors);
        }
    }

    private void eldontes(){
        return;
    }

    private void init(){
        imgView1 = findViewById(R.id.imgView1);
        imgView2 = findViewById(R.id.imgView2);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        textView1 = findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView2);
        textView3 = findViewById(R.id.textView3);
    }
}