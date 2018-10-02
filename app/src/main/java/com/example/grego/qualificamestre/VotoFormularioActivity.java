package com.example.grego.qualificamestre;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class VotoFormularioActivity extends AppCompatActivity {

    Intent intent = getIntent();

    AlunoVoto alunoLogado=new AlunoVoto();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voto_formulario);

        if (savedInstanceState == null) {
            Intent intentGeter = getIntent();
            Bundle extras = intentGeter.getExtras();
            if(extras == null) {
                alunoLogado= new AlunoVoto("0");
            } else {
                alunoLogado= (AlunoVoto) intentGeter.getSerializableExtra("VotoJaFeito");
            }
        } else {
            alunoLogado= (AlunoVoto) savedInstanceState.getSerializable("VotoJaFeito");
        }
    }
}
