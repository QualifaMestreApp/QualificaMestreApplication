package com.example.grego.qualificamestre;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {

    private static final String TAG = "Login";
    EditText inputEmail, inputPassword;
    Button cadastrar, login;
    private FirebaseAuth mAuth;

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();

        cadastrar = findViewById(R.id.Btn_cadastra_login);
        login = findViewById(R.id.Btn_logar_login);

        inputEmail = findViewById(R.id.Input_email_login);
        inputPassword = findViewById(R.id.Input_password_login);

        cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, CadastroActivity.class);
                startActivity(intent);
            }
        });


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!inputEmail.getText().toString().isEmpty() && !inputPassword.getText().toString().isEmpty()) {
                    String email = inputEmail.getText().toString();
                    String password = inputPassword.getText().toString();
                    mAuth.signInWithEmailAndPassword(email, password)
                            .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        FirebaseUser user = mAuth.getCurrentUser();
                                        Toast.makeText(LoginActivity.this, "Bem vindo!", Toast.LENGTH_LONG).show();
                                    } else {
                                        // If sign in fails, display a message to the user.
                                        Toast.makeText(LoginActivity.this, "Authentication failed : " + task.getException().getMessage(),
                                                Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });;
                }
            }
        });
    }
    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
    }

    public void goProf(View view) {
        intent = new Intent(LoginActivity.this, MestrePerfilActivity.class);
        startActivity(intent);
    }
}
