package com.example.grego.qualificamestre;

import android.os.Parcelable;

import java.io.Serializable;
import java.util.List;


public class Master implements Serializable{

    public Master() {
    }

    public Master(String name, String institution, String grade, List<String> voters) {
        this.Nome = name;
        this.Institution = institution;
        this.Grade = grade;
        this.Voters = voters;
    }

    private String Nome;
    private String Institution;
    private String Grade;
    private List<String> Voters;
    private int VotersCount;

    public int getVotersCount() {
        return Voters.size();
    }

    public void setVotersCount(int votersCount) {
        VotersCount = votersCount;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getInstitution() {
        return Institution;
    }

    public void setInstitution(String institution) {
        Institution = institution;
    }

    public String getGrade() {
        return Grade;
    }

    public void setGrade(String grade) {
        Grade = grade;
    }

    public List<String> getVoters() {
        return Voters;
    }

    public void setVoters(List<String> voters) {
        Voters = voters;
    }







}
