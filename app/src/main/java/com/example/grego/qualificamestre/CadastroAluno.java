package com.example.grego.qualificamestre;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CadastroAluno extends Fragment implements View.OnClickListener{

    EditText inome, iemail, iinstituicao, ipassword;
    Button btn_cadastrar;
    private FirebaseAuth mAuth;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("Alunos");

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.cadastro_aluno, container, false);

        inome = view.findViewById(R.id.Input_nome_cadaluno);
        iemail = view.findViewById(R.id.Input_email_cadaluno);
        iinstituicao = view.findViewById(R.id.Input_instituicao_cadaluno);
        ipassword = view.findViewById(R.id.Input_password_cadaluno);
        mAuth = FirebaseAuth.getInstance();

        btn_cadastrar = view.findViewById(R.id.Btn_cadastrar_cadaluno);

        btn_cadastrar.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.Btn_cadastrar_cadaluno:
                if(!inome.getText().toString().isEmpty() && !iemail.getText().toString().isEmpty() && !iinstituicao.getText().toString().isEmpty() && !ipassword.getText().toString().isEmpty())
                {
                    if(iemail.getText().toString().matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")){
                        if(ipassword.getText().toString().length() >= 6){
                             mAuth.createUserWithEmailAndPassword(iemail.getText().toString(), ipassword.getText().toString())
                                    .addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
                                        @Override
                                        public void onComplete(@NonNull Task<AuthResult> task) {
                                            if (task.isSuccessful()) {
                                                FirebaseUser user = mAuth.getCurrentUser();
                                                Aluno aluno = new Aluno();
                                                aluno.nome = inome.getText().toString();
                                                aluno.instituição = iinstituicao.getText().toString();
                                                myRef.child(user.getUid()).setValue(aluno);
                                                Toast.makeText(getActivity(), "Conta criada! Bem vindo!.", Toast.LENGTH_SHORT).show();
                                                Intent intent = new Intent(getActivity(), MasterMainActivity.class);
                                                startActivity(intent);
                                            } else {
                                                Toast.makeText(getActivity(), "Erro!." + task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                                            }
                                        }
                                    });
                        }
                        else{
                            Toast.makeText(getActivity(), "A senha deve possuir no minimo 6 caracteres.", Toast.LENGTH_LONG).show();
                        }
                    }else {
                        Toast.makeText(getActivity(), "Informe um email valido.", Toast.LENGTH_LONG).show();
                    }

                }
                else{
                    Toast.makeText(getActivity(), "É necessario preencher todos os campos.", Toast.LENGTH_LONG).show();
                }
                break;
        }
    }
}
