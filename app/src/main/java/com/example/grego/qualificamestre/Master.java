package com.example.grego.qualificamestre;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Master{

    public Master() {
    }

    public Master(String name, String institution, String grade, String id) {
        this.id = id;
        this.nome = name;
        this.institution = institution;
        this.voters = new ArrayList<>();
    }

    private String id;
    private String nome;
    private String institution;
    private List<AlunoVoto> voters;

    public int getVotersCount() {
        return voters.size();
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
        return voters;
    }

    public void setVoters(List<AlunoVoto> voters) {
        this.voters = voters;
    }
}
