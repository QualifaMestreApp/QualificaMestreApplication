package com.example.grego.qualificamestre;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Master{

    public Master() {
    }

    public Master(String name, String institution, String id) {
        this.id = id;
        this.nome = name;
        this.institution = institution;
        this.votersCount = 0;
    }

    private String id;
    private String nome;
    private String institution;
    private int votersCount;

    public int getVotersCount() {
        return votersCount;
    }

    public void setVotersCount(int votersCount) {
        this.votersCount = votersCount;
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

 }
