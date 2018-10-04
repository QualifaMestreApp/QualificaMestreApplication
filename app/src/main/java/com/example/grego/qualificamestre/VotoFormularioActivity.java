package com.example.grego.qualificamestre;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class VotoFormularioActivity extends AppCompatActivity {

    //private Intent intent = getIntent();

    RadioGroup radioGroup0;
    RadioButton radioButton0;

    RadioGroup radioGroup1;
    RadioButton radioButton1;

    RadioGroup radioGroup2;
    RadioButton radioButton2;

    RadioGroup radioGroup3;
    RadioButton radioButton3;

    RadioGroup radioGroup4;
    RadioButton radioButton4;

    private int didatica=0;
    private int conteudo=0;
    private int flexibilidade=0;
    private int temperamento=0;
    private int assiduidade=0;

    private String nomeProf = "Voto de Pupilo";

    String alunoId;
    String profId;

    AlunoVoto votoConcluido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voto_formulario);

        radioGroup0 = (RadioGroup)findViewById(R.id.matrerialSelect);
        radioGroup0.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId)
            {
                radioButton0 = (RadioButton) findViewById(checkedId);
            }
        });

        radioGroup1 = (RadioGroup)findViewById(R.id.networkingSelect);
        radioGroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId)
            {
                radioButton1 = (RadioButton) findViewById(checkedId);
            }
        });

        radioGroup2 = (RadioGroup)findViewById(R.id.ajudaSelect);
        radioGroup2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId)
            {
                radioButton2 = (RadioButton) findViewById(checkedId);
            }
        });

        radioGroup3 = (RadioGroup)findViewById(R.id.conhecimentoSelect);
        radioGroup3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId)
            {
                radioButton3 = (RadioButton) findViewById(checkedId);
            }
        });

        radioGroup4 = (RadioGroup)findViewById(R.id.assiduidadeSelect);
        radioGroup4.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId)
            {
                radioButton4 = (RadioButton) findViewById(checkedId);
            }
        });

        Intent intentGeter = getIntent();
        alunoId = FirebaseAuth.getInstance().getCurrentUser().getUid();
        profId = getIntent().getExtras().getString("MasterId");

//        Query searchQuery = (Query) FirebaseDatabase.getInstance()
//                .getReference("Professores")
//                .orderByChild("id")
//                .equalTo(profId)
//                .limitToFirst(1)
//                .addChildEventListener(new ChildEventListener() {
//
//                    @Override
//                    public void onChildAdded(DataSnapshot dataSnapshot, String s) {
//                        Master mestre = dataSnapshot.getValue(Master.class);
//                        nomeProf= "Votando Em: "+mestre.getNome();
//                    }
//
//
//                    @Override
//                    public void onChildChanged(DataSnapshot dataSnapshot, String s) {
//
//                    }
//
//                    @Override
//                    public void onChildRemoved(DataSnapshot dataSnapshot) {
//
//                    }
//
//                    @Override
//                    public void onChildMoved(DataSnapshot dataSnapshot, String s) {
//
//                    }
//
//                    @Override
//                    public void onCancelled(DatabaseError databaseError) {
//
//                    }
//                });
    }

    public void terminarVoto(View view) {
//        if (radioButton0==null||radioButton1==null||radioButton2==null||radioButton3==null||radioButton4==null){
//            Toast.makeText(this, "Por favor Preencha todos os campos", Toast.LENGTH_LONG).show();
//        }
        if ((radioButton0.isChecked()==false||radioButton1.isChecked()==false||radioButton2.isChecked()==false||radioButton3.isChecked()==false||radioButton4.isChecked()==false)
                ||
                (radioButton0==null||radioButton1==null||radioButton2==null||radioButton3==null||radioButton4==null)){
            Toast.makeText(this, "Por favor Preencha todos os campos", Toast.LENGTH_LONG).show();
        }else{
            switch (radioButton0.getId()) {
                    case R.id.radio_inutil0:  didatica=1;
                        break;
                    case R.id.radio_antiguado0:  didatica=2;
                        break;
                    case R.id.radio_razoavel0:  didatica=3;
                        break;
                    case R.id.radio_bom0:  didatica=4;
                        break;
                    case R.id.radio_mudou_a_minha_vida0: didatica=5;
                        break;
                    default: didatica=0;
                        break;
            }
            switch (radioButton1.getId()) {
                case R.id.radio_inutil1:  conteudo=1;
                    break;
                case R.id.radio_antiguado1:  conteudo=2;
                    break;
                case R.id.radio_razoavel1:  conteudo=3;
                    break;
                case R.id.radio_bom1:  conteudo=4;
                    break;
                case R.id.radio_mudou_a_minha_vida1: conteudo=5;
                    break;
                default: conteudo=0;
                    break;
            }
            switch (radioButton2.getId()) {
                case R.id.radio_inutil2:  flexibilidade=1;
                    break;
                case R.id.radio_antiguado2:  flexibilidade=2;
                    break;
                case R.id.radio_razoavel2:  flexibilidade=3;
                    break;
                case R.id.radio_bom2:  flexibilidade=4;
                    break;
                case R.id.radio_mudou_a_minha_vida2: flexibilidade=5;
                    break;
                default: flexibilidade=0;
                    break;
            }
            switch (radioButton3.getId()) {
                case R.id.radio_inutil0:  temperamento=1;
                    break;
                case R.id.radio_antiguado3:  temperamento=2;
                    break;
                case R.id.radio_razoavel3:  temperamento=3;
                    break;
                case R.id.radio_bom3:  temperamento=4;
                    break;
                case R.id.radio_mudou_a_minha_vida3: temperamento=5;
                    break;
                default: temperamento=0;
                    break;
            }
            switch (radioButton4.getId()) {
                case R.id.radio_inutil4:  assiduidade=1;
                    break;
                case R.id.radio_antiguado4:  assiduidade=2;
                    break;
                case R.id.radio_razoavel4:  assiduidade=3;
                    break;
                case R.id.radio_bom4:  assiduidade=4;
                    break;
                case R.id.radio_mudou_a_minha_vida4: assiduidade=5;
                    break;
                default: assiduidade=0;
                    break;
            }

            votoConcluido = new AlunoVoto(alunoId,didatica,conteudo,flexibilidade,temperamento,assiduidade);

            //Todo:Adicionar votoConcluido na lista de alunos votos em professosr
            DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference("Professores");
           // mDatabase.child("users").child(userId).setValue(user);
            //mDatabase.child(profId).child("voters").setValue(votoConcluido);
        }
    }
}
