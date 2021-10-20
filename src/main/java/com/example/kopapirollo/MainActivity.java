package com.example.kopapirollo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private ImageView imgView1, imgView2;
    private Button btn1,btn2,btn3;
    private TextView textView3;
    int tipp,gep,jatekos,szamitogep;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    tipp=1;
                    kepvalt(tipp);
                    szamitogepValt();
                    winOrLose(szamitogep,tipp);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    tipp=2;
                    kepvalt(tipp);
                    szamitogepValt();
                    winOrLose(szamitogep,tipp);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    tipp=3;
                    kepvalt(tipp);
                    szamitogepValt();
                    winOrLose(szamitogep,tipp);
            }
        });


    }

    private void kepvalt(int tipp){
        if(tipp == 1){
            imgView1.setImageResource(R.drawable.rock);
        }else if(tipp == 2){
            imgView1.setImageResource(R.drawable.paper);
        }else if(tipp == 3){
            imgView1.setImageResource(R.drawable.scissors);
        }
    }
    private void szamitogepValt(){
        szamitogep = (int) (Math.random() * 3+1);
        if(szamitogep == 1){
            imgView2.setImageResource(R.drawable.rock);
        }else if(szamitogep == 2){
            imgView2.setImageResource(R.drawable.paper);
        }else if (szamitogep == 3){
            imgView2.setImageResource(R.drawable.scissors);
        }
    }

    @SuppressLint("SetTextI18n")
    private void winOrLose(int szamitogep, int tipp){

        if (szamitogep == tipp) {
            Toast.makeText(MainActivity.this, "Döntetlen", Toast.LENGTH_SHORT).show();
        } else if (szamitogep == 1 && tipp== 2) {
            Toast.makeText(MainActivity.this, "VICTORY", Toast.LENGTH_SHORT).show();
            jatekos++;
            textView3.setText("Eredmény: Ember: " + jatekos + " Computer: " + gep);
        } else if (szamitogep == 1 && tipp== 3) {
            Toast.makeText(MainActivity.this, "DEFEAT", Toast.LENGTH_SHORT).show();
            gep++;
            textView3.setText("Eredmény: Ember: " + jatekos + " Computer: " + gep);
        } else if (szamitogep == 2 && tipp== 1) {
            Toast.makeText(MainActivity.this, "DEFEAT", Toast.LENGTH_SHORT).show();
            gep++;
            textView3.setText("Eredmény: Ember: " + jatekos + " Computer: " + gep);
        } else if (szamitogep == 2 && tipp== 3) {
            Toast.makeText(MainActivity.this, "VICTORY", Toast.LENGTH_SHORT).show();
            jatekos++;
            textView3.setText("Eredmény: Ember: " + jatekos + " Computer: " + gep);
        } else if (szamitogep == 3 && tipp== 1) {
            Toast.makeText(MainActivity.this, "VICTORY", Toast.LENGTH_SHORT).show();
            jatekos++;
            textView3.setText("Eredmény: Ember: " + jatekos + " Computer: " + gep);
        } else if (szamitogep == 3 && tipp== 2) {
            Toast.makeText(MainActivity.this, "DEFEAT", Toast.LENGTH_SHORT).show();
            gep++;
            textView3.setText("Eredmény: Ember: " + jatekos + " Computer: " + gep);
        }

        if (gep == 3 || jatekos == 3){
            vege();
        }

    }
    public void vege(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setMessage("Szeretné csapatni egy új gameszkót?");
        if (gep > jatekos){
            builder.setTitle("Vereség");
        } else{
            builder.setTitle("Győzelem");
        }
        builder.setPositiveButton("Igen", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                uj();
            }
        });
        builder.setNegativeButton("Nem", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });


        builder.create().show();
    }

    @SuppressLint("SetTextI18n")
    private void uj(){
        gep = 0;
        jatekos = 0;
        textView3.setText("Eredmény: Ember: 0 Computer: 0");
        imgView1.setImageResource(R.drawable.rock);;
        imgView2.setImageResource(R.drawable.rock);;
    }

    private void init(){
        imgView1 = findViewById(R.id.imgView1);
        imgView2 = findViewById(R.id.imgView2);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        textView3 = findViewById(R.id.textView3);
    }
}