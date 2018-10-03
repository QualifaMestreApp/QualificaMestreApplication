package com.example.grego.qualificamestre;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Intent intent = getIntent();

        Master master = (Master)intent.getSerializableExtra("Master_OBJ");


        TextView nome = findViewById(R.id.nome);
        TextView escola = findViewById(R.id.institution);
        TextView grade = findViewById(R.id.grade);

        if(master != null) {

            nome.setText(master.getNome().toString());
            escola.setText(master.getInstitution().toString());

            //grade.setText(master.getGrade().toString());
        }


    }


    public void gogogo(View view){
        Intent intent = new Intent(MainActivity.this, MasterMainActivity.class);
        startActivity(intent);
    }


}
