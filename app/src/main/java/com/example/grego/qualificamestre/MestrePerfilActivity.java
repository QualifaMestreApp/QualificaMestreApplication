package com.example.grego.qualificamestre;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MestrePerfilActivity extends AppCompatActivity {

    Mestre mestreTeste=new Mestre();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mestre_perfil);

        AlunoVoto alunoLogado= new AlunoVoto("0",4,0,3,4,5);

        List<AlunoVoto> alunosJaVotados= new ArrayList<>();
        AlunoVoto aluno1=new AlunoVoto("1",3,2,4,5,3);
        AlunoVoto aluno2=new AlunoVoto("2",3,2,4,5,3);
        AlunoVoto aluno3=new AlunoVoto("3",3,3,1,4,4);
        alunosJaVotados.add(aluno1);
        alunosJaVotados.add(aluno2);
        alunosJaVotados.add(aluno3);
        //Todo:Fazer um if para ver se o intend esta nulo ou nao se nao adicionar alunoLogado na lista de ja votados
        mestreTeste.alunosQueVotaram=alunosJaVotados;
    }

    public void votar(View view) {
    }

    public void mudarVoto(View view) {
    }
}
