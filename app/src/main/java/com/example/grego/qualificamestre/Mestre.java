package com.example.grego.qualificamestre;

import java.util.List;

public class Mestre {

    public Mestre(){}

    public Mestre(String id, String nome, String instituição, int matrerial, int networking, int ajuda,int conhecimentosExtra, int assiduidade, String disciplina){
        this.id = id;
        this.nome = nome;
        this.instituição = instituição;
        this.matrerial = matrerial;
        this.networking = networking;
        this.ajuda = ajuda;
        this.conhecimentosExtra = conhecimentosExtra;
        this.assiduidade = assiduidade;
        this.disciplina = disciplina;
    }

    String id;
    String nome;
    String instituição;
    String disciplina;
    List<String> alunosQueVotados;
    //de 0 a 5
    int matrerial;
    int networking;
    int ajuda;
    int conhecimentosExtra;
    int assiduidade;

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
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

    public String getInstituição() {
        return instituição;
    }

    public void setInstituição(String instituição) {
        this.instituição = instituição;
    }

    public List<String> getAlunosQueVotados() {
        return alunosQueVotados;
    }

    public void setAlunosQueVotados(List<String> alunosQueVotados) {
        this.alunosQueVotados = alunosQueVotados;
    }

    public int getMatrerial() {
        return matrerial;
    }

    public void setMatrerial(int matrerial) {
        this.matrerial = matrerial;
    }

    public int getNetworking() {
        return networking;
    }

    public void setNetworking(int networking) {
        this.networking = networking;
    }

    public int getAjuda() {
        return ajuda;
    }

    public void setAjuda(int ajuda) {
        this.ajuda = ajuda;
    }

    public int getConhecimentosExtra() {
        return conhecimentosExtra;
    }

    public void setConhecimentosExtra(int conhecimentosExtra) {
        this.conhecimentosExtra = conhecimentosExtra;
    }

    public int getAssiduidade() {
        return assiduidade;
    }

    public void setAssiduidade(int assiduidade) {
        this.assiduidade = assiduidade;
    }
}
