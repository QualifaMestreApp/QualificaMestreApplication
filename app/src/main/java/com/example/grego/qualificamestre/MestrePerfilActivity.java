package com.example.grego.qualificamestre;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Float.parseFloat;

public class MestrePerfilActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    String userId;

    private Master master;
    float SomaparaMedia = 0;

    FirebaseDatabase db = FirebaseDatabase.getInstance();

    private TextView Nome, Instituição, Didatica, Conteudo, Flexibilidade, Temperamento, Assiduidade, Votos, Media;
    private Button votar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mestre_perfil);

       votar = findViewById(R.id.Btn_votar);

        mAuth = FirebaseAuth.getInstance();

        Nome = findViewById(R.id.NomedoProfessor);
        Instituição = findViewById(R.id.NomeInstituicao);
        Didatica = findViewById(R.id.didatica);
        Conteudo = findViewById(R.id.conteudo);
        Flexibilidade = findViewById(R.id.flexibilidade);
        Temperamento = findViewById(R.id.temperamento);
        Assiduidade = findViewById(R.id.assiduidade);
        Votos = findViewById(R.id.votos);
        Media = findViewById(R.id.NotaFinal);

        Intent intent = getIntent();

        String masterId = intent.getStringExtra("MasterId");

        Query searchQuery = FirebaseDatabase.getInstance()
                .getReference("Professores")
                .orderByChild("id")
                .equalTo(masterId);


        searchQuery.addListenerForSingleValueEvent(valueEventListener);

        userId = mAuth.getCurrentUser().getUid().toString();
    }

    ValueEventListener valueEventListener = new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            for (DataSnapshot professores : dataSnapshot.getChildren()
                    ) {
                master = professores.getValue(Master.class);
                master.setId(dataSnapshot.getKey());
                PreencherPerfil();
                if (IsAlunoVoted()) {
                    votar.setVisibility(View.INVISIBLE);
                }
            }
        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {

        }
    };


    //CALCULO DA MÉDIA
    public void PreencherPerfil() {
//        int numeroDeAlunosqueVotaram = master.getVotersCount();
//        float mediaFinal = ((matrerial + networking + ajuda + conhecimentosExtra + assiduidade) / numeroDeAlunosqueVotaram) / numeroDeQuestoes;

        Nome.setText(master.getNome());
        if (master.getVoters() != null) {
            Votos.setText(String.valueOf(master.getVotersCount()));
        } else {
            Votos.setText("0");
        }
        Instituição.setText(master.getInstitution());

        Didatica.setText(String.valueOf(CalculeDidatica()));
        Temperamento.setText(String.valueOf(CalculeTemperamento()));
        Conteudo.setText(String.valueOf(CalculeConteudo()));
        Assiduidade.setText(String.valueOf(CalculeAssiduidade()));
        Flexibilidade.setText(String.valueOf(CalculeFlexibilidade()));
        Media.setText(String.valueOf(SomaparaMedia / (master.getVoters().size() * 5)));
    }

    public float CalculeDidatica(){
        float soma = 0;
        for (AlunoVoto voto:master.getVoters()) {
            soma += voto.getDidatica();
        }
        SomaparaMedia += soma;
        return soma / master.getVoters().size();
    }

    public float CalculeFlexibilidade(){
        float soma = 0;
        for (AlunoVoto voto:master.getVoters()) {
            soma += voto.getFlexibilidade();
        }
        SomaparaMedia += soma;
        return soma / master.getVoters().size();
    }

    public float CalculeConteudo(){
        float soma = 0;
        for (AlunoVoto voto:master.getVoters()) {
            soma += voto.getConteudo();
        }
        SomaparaMedia += soma;
        return soma / master.getVoters().size();
    }

    public float CalculeTemperamento(){
        float soma = 0;
        for (AlunoVoto voto:master.getVoters()) {
            soma += voto.getTemperamento();
        }
        SomaparaMedia += soma;
        return soma / master.getVoters().size();
    }

    public float CalculeAssiduidade(){
        float soma = 0;
        for (AlunoVoto voto:master.getVoters()) {
            soma += voto.getAssiduidade();
        }
        SomaparaMedia += soma;
        return soma / master.getVoters().size();
    }
    public boolean IsAlunoVoted(){
        for (AlunoVoto voto:master.getVoters()) {
            if(voto.getId().equals(userId)){
                return true;
            }
        }
        return false;
    }
}
