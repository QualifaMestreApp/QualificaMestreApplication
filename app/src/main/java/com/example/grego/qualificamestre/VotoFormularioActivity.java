package com.example.grego.qualificamestre;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

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

    private int matrerial=0;
    private int networking=0;
    private int ajuda=0;
    private int conhecimentosExtra=0;
    private int assiduidade=0;

    //Todo:Pegar id de quem esta logado pelo FB
    String idAlunoLogado;

    private String nomeProf = "Error";
    private AlunoVoto alunoLogado = new AlunoVoto();

    String alunoId;
    String profId;

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
        alunoId = intentGeter.getStringExtra("iddoAluno");
        profId = intentGeter.getStringExtra("iddoProfesor");

    }

    public void terminarVoto(View view) {
        if (radioButton0.isChecked()==false&&radioButton1.isChecked()==false&&radioButton2.isChecked()==false&&radioButton3.isChecked()==false&&radioButton4.isChecked()==false){
            Toast.makeText(this, "Por favor Preencha todos os campos", Toast.LENGTH_LONG).show();
        }else{
            switch (radioButton0.getId()) {
                    case R.id.radio_inutil0:  matrerial=1;
                        break;
                    case R.id.radio_antiguado0:  matrerial=2;
                        break;
                    case R.id.radio_razoavel0:  matrerial=3;
                        break;
                    case R.id.radio_bom0:  matrerial=4;
                        break;
                    case R.id.radio_mudou_a_minha_vida0: matrerial=5;
                        break;
                    default: matrerial=0;
                        break;
            }
            switch (radioButton1.getId()) {
                case R.id.radio_inutil1:  networking=1;
                    break;
                case R.id.radio_antiguado1:  networking=2;
                    break;
                case R.id.radio_razoavel1:  networking=3;
                    break;
                case R.id.radio_bom1:  networking=4;
                    break;
                case R.id.radio_mudou_a_minha_vida1: networking=5;
                    break;
                default: networking=0;
                    break;
            }
            switch (radioButton2.getId()) {
                case R.id.radio_inutil2:  ajuda=1;
                    break;
                case R.id.radio_antiguado2:  ajuda=2;
                    break;
                case R.id.radio_razoavel2:  ajuda=3;
                    break;
                case R.id.radio_bom2:  ajuda=4;
                    break;
                case R.id.radio_mudou_a_minha_vida2: ajuda=5;
                    break;
                default: ajuda=0;
                    break;
            }
            switch (radioButton3.getId()) {
                case R.id.radio_inutil0:  conhecimentosExtra=1;
                    break;
                case R.id.radio_antiguado3:  conhecimentosExtra=2;
                    break;
                case R.id.radio_razoavel3:  conhecimentosExtra=3;
                    break;
                case R.id.radio_bom3:  conhecimentosExtra=4;
                    break;
                case R.id.radio_mudou_a_minha_vida3: conhecimentosExtra=5;
                    break;
                default: conhecimentosExtra=0;
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

            AlunoVoto votoConcluido = new AlunoVoto(alunoId,matrerial,networking,ajuda,conhecimentosExtra,assiduidade);

            //Todo:Adicionar votoConcluido na lista de alunos votos em professosr
        }
    }
}
