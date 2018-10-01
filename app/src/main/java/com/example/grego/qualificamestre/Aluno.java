package com.example.grego.qualificamestre;

public class Aluno {

    public Aluno() {
    }

    public Aluno(String id, String nome, String instituição) {
        this.id = id;
        this.nome = nome;
        this.instituição = instituição;
    }

    String id;
    String nome;
    String instituição;

    public String getInstituição() {
        return instituição;
    }

    public void setInstituição(String instituição) {
        this.instituição = instituição;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        nome = nome;
    }
}
