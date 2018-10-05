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
import com.google.firebase.database.DatabaseReference;
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
    DatabaseReference mdb;

    private TextView Nome, Instituição, Didatica, Conteudo, Flexibilidade, Temperamento, Assiduidade, Votos, Media;
    private Button votar;
    List<AlunoVoto> votos;
    String masterId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mestre_perfil);

        votar = findViewById(R.id.Btn_votar);

        mdb = FirebaseDatabase.getInstance().getReference("Votos");

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

        masterId = intent.getStringExtra("MasterId");


        mdb.child(masterId).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                votos = new ArrayList<>();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    AlunoVoto voto = snapshot.getValue(AlunoVoto.class);
                    votos.add(voto);
                }
                GetMasterPerfil();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        userId = mAuth.getCurrentUser().getUid().toString();

        if(userId.equals(masterId)){
            votar.setText("Logout");
        }
    }

    private void GetMasterPerfil() {
        mdb = FirebaseDatabase.getInstance().getReference("Professores");
        mdb.child(masterId).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                master = dataSnapshot.getValue(Master.class);
                PreencherPerfil();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    //CALCULO DA MÉDIA
    public void PreencherPerfil() {

        Nome.setText(master.getNome());

        Votos.setText(String.valueOf(votos.size()));
        Instituição.setText(master.getInstitution());
        if(CalculeDidatica() > 0.0){
            Didatica.setText(String.valueOf(CalculeDidatica()));
        }
        if(CalculeTemperamento() > 0.0) {
            Temperamento.setText(String.valueOf(CalculeTemperamento()));
        }
        if(CalculeConteudo() > 0.0) {
            Conteudo.setText(String.valueOf(CalculeConteudo()));
        }
        if(CalculeAssiduidade() > 0.0) {
            Assiduidade.setText(String.valueOf(CalculeAssiduidade()));
        }
        if(CalculeFlexibilidade() > 0.0) {
            Flexibilidade.setText(String.valueOf(CalculeFlexibilidade()));
        }
        if(SomaparaMedia > 0.0){
            Media.setText(String.valueOf((SomaparaMedia / (votos.size() * 5))/2));
        }else{
            Media.setText(String.valueOf(0.0));
        }

    }

    public float CalculeDidatica() {
        float soma = 0;
        for (AlunoVoto voto : votos) {
            soma += voto.getDidatica();
        }
        SomaparaMedia += soma;
        return soma / votos.size();
    }

    public float CalculeFlexibilidade() {
        float soma = 0;
        for (AlunoVoto voto : votos) {
            soma += voto.getFlexibilidade();
        }
        SomaparaMedia += soma;
        return soma / votos.size();
    }

    public float CalculeConteudo() {
        float soma = 0;
        for (AlunoVoto voto : votos) {
            soma += voto.getConteudo();
        }
        SomaparaMedia += soma;
        return soma / votos.size();
    }

    public float CalculeTemperamento() {
        float soma = 0;
        for (AlunoVoto voto : votos) {
            soma += voto.getTemperamento();
        }
        SomaparaMedia += soma;
        return soma / votos.size();
    }

    public float CalculeAssiduidade() {
        float soma = 0;
        for (AlunoVoto voto : votos) {
            soma += voto.getAssiduidade();
        }
        SomaparaMedia += soma;
        return soma / votos.size();
    }

    public boolean IsAlunoVoted() {
        for (AlunoVoto voto : votos) {
            if (voto.getId().equals(userId)) {
                return true;
            }
        }
        return false;
    }

    public void votarButton(View view) {

        if(userId.equals(masterId)){
            mAuth.getInstance().signOut();
            Intent intent = new Intent(MestrePerfilActivity.this, LoginActivity.class);
            startActivity(intent);
        }else{
            Intent intent = getIntent();

            String masterId = intent.getStringExtra("MasterId");
            //String currentFirebaseUser = FirebaseAuth.getInstance().getCurrentUser().getUid() ;
            Intent intentParaVoto = new Intent(this, VotoFormularioActivity.class);

            intentParaVoto.putExtra("MasterId", masterId);
            intentParaVoto.putExtra("MasterNome", master.getNome());
            intentParaVoto.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intentParaVoto);
        }
    }
}
