package com.example.grego.qualificamestre;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(intent);
    }


    public void gogogo(View view){
        Intent intent = new Intent(MainActivity.this, MasterMainActivity.class);
        startActivity(intent);
    }


}
