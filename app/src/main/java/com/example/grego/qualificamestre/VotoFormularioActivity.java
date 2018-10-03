package com.example.grego.qualificamestre;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class VotoFormularioActivity extends AppCompatActivity {

    private Intent intent = getIntent();

    //Todo:Pegar id de quem esta logado pelo FB
    String idAlunoLogado;

    private String nomeProf = "Error";
    private AlunoVoto alunoLogado = new AlunoVoto();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voto_formulario);

        Intent intentGeter = getIntent();
        String extras = intentGeter.getExtras("iddoAluno");
    }
}
