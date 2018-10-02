package com.example.grego.qualificamestre;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MestrePerfilActivity extends AppCompatActivity {

    private Mestre mestreTeste=new Mestre();

    AlunoVoto alunoLogado=new AlunoVoto();

    private boolean ALunoVotou=false;

    private final int numeroDeQuestoes = 5;

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

        //Todo: Fazer funcção que pege o Professor do FB (verção FINAL)
        //Todo: Pegar id do aluno Logado(verção FINAL)

        List<AlunoVoto> alunosJaVotados= new ArrayList<>();

        //alunoLogado= new AlunoVoto("0");

        if (savedInstanceState == null) {
            Intent intentGeter = getIntent();
            Bundle extras = intentGeter.getExtras();
            if(extras == null) {
                alunoLogado= new AlunoVoto("0");
            } else {
                alunoLogado= (AlunoVoto) intentGeter.getSerializableExtra("VotoJaFeito");
                alunosJaVotados.add(alunoLogado);
            }
        } else {
            alunoLogado= (AlunoVoto) savedInstanceState.getSerializable("VotoJaFeito");
            alunosJaVotados.add(alunoLogado);
        }

        AlunoVoto aluno1=new AlunoVoto("1",3,3,3,3,3);
        AlunoVoto aluno2=new AlunoVoto("2",3,3,3,3,3);
        AlunoVoto aluno3=new AlunoVoto("3",3,3,3,3,3);
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

        int mediaFinal = ((matrerial+networking+ajuda+conhecimentosExtra+assiduidade)/mestreTeste.getAlunosQueVotaram().size())/numeroDeQuestoes;
    }

    public void votar(View view) {
        intent = new Intent(this, VotoFormularioActivity.class);
        intent.putExtra("nomeProf", mestreTeste.getNome());
        startActivity(intent);
    }

    public void mudarVoto(View view) {
        //Todo:Caso ja exista o voto proucurar ele no FB por id em Mestre e enviar para a proxima activity ou envia so o id do aluno logado (verção FINAL)
        intent = new Intent(this, VotoFormularioActivity.class);
        intent.putExtra("VotoJaFeito", (Serializable) alunoLogado);
        intent.putExtra("nomeProf", mestreTeste.getNome());
        startActivity(intent);
    }
}
