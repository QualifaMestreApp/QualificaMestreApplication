package com.example.grego.qualificamestre;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class TelaDeSelecaoPagerAdapter extends FragmentPagerAdapter {

    private int numeroDeTelas = 2;

    public TelaDeSelecaoPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return null;//Fragment1 - "Proucura Mestre"
            case 1:
                return null;//Fragment2 - "Top Mestres"
            default:
                return null;
        }
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "Proucura Mestre";
            case 1:
                return "Top Mestres";
            default:
                return "ErroTituloNãoEncontrado";
        }
    }

    @Override
    public int getCount() {
        return numeroDeTelas;
    }
}
