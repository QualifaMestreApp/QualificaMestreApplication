package com.example.grego.qualificamestre;

import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Master implements Serializable{

    public Master() {
    }

    public Master(String name, String institution, String grade, String id) {
        this.id = id;
        this.nome = name;
        this.institution = institution;
        this.Voters = new ArrayList<>();
    }

    private String id;
    private String nome;
    private String institution;
    private List<AlunoVoto> Voters;

    public int getVotersCount() {
        return Voters.size();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public List<AlunoVoto> getVoters() {
        return Voters;
    }

    public void setVoters(List<AlunoVoto> voters) {
        Voters = voters;
    }
}
