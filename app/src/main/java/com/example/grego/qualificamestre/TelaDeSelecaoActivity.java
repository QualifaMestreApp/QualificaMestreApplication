package com.example.grego.qualificamestre;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class TelaDeSelecaoActivity extends AppCompatActivity {

    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_de_selecao);

        viewPager=findViewById(R.id.view_pager);
        TelaDeSelecaoPagerAdapter adapter = new TelaDeSelecaoPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
    }
}
