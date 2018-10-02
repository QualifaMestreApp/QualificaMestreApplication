package com.example.grego.qualificamestre;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MestrePerfilActivity extends AppCompatActivity {

    private Mestre mestreTeste=new Mestre();

    private boolean ALunoVotou=false;

    private int matrerial=0;
    private int networking=0;
    private int ajuda=0;
    private int conhecimentosExtra=0;
    private int assiduidade=0;

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mestre_perfil);

        //Todo: Fazer funcção que pege o Professor do FB (verção final)
        //Todo: Pegar id do aluno Logado(verção final)

        AlunoVoto alunoLogado= new AlunoVoto("0",4,0,3,4,5);

        List<AlunoVoto> alunosJaVotados= new ArrayList<>();
        AlunoVoto aluno1=new AlunoVoto("1",3,2,4,5,3);
        AlunoVoto aluno2=new AlunoVoto("2",3,2,4,5,3);
        AlunoVoto aluno3=new AlunoVoto("3",3,3,1,4,4);
        alunosJaVotados.add(aluno1);
        alunosJaVotados.add(aluno2);
        alunosJaVotados.add(aluno3);
        //Todo:Fazer um if para ver se o intend esta nulo ou nao se nao adicionar alunoLogado na lista de ja votados (verção TESTE)
        //mestreTeste.alunosQueVotaram=alunosJaVotados;
        mestreTeste = new Mestre("1","Mestre Infnetisimo","Infnet","ads",alunosJaVotados);

        for (AlunoVoto aluno: mestreTeste.getAlunosQueVotaram()){
            if (aluno.getId()==alunoLogado.getId()){
                ALunoVotou=true;
            }
            matrerial+=aluno.getMatrerial();
            networking+=aluno.getNetworking();
            ajuda+=aluno.getAjuda();
            conhecimentosExtra+=aluno.getConhecimentosExtra();
            assiduidade=aluno.getAssiduidade();
        }
    }

    public void votar(View view) {
        intent = new Intent(MestrePerfilActivity.this, null/*MestrePerfilActivity.class*/);
        startActivity(intent);
    }

    public void mudarVoto(View view) {
        intent = new Intent(MestrePerfilActivity.this, null);
        startActivity(intent);
    }
}
