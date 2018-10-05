package com.example.grego.qualificamestre;

public class AlunoVoto {

    public AlunoVoto() {
    }

    public AlunoVoto(String id, int didatica, int conteudo, int flexibilidade, int temperamento, int assiduidade) {
        this.id = id;
        this.didatica = didatica;
        this.conteudo = conteudo;
        this.flexibilidade = flexibilidade;
        this.temperamento = temperamento;
        this.assiduidade = assiduidade;
    }

    private String id;
    private int didatica;
    private int conteudo;
    private int flexibilidade;
    private int temperamento;
    private int assiduidade;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getDidatica() {
        return didatica;
    }

    public void setDidatica(int didatica) {
        this.didatica = didatica;
    }

    public int getConteudo() {
        return conteudo;
    }

    public void setConteudo(int conteudo) {
        this.conteudo = conteudo;
    }

    public int getFlexibilidade() {
        return flexibilidade;
    }

    public void setFlexibilidade(int flexibilidade) {
        this.flexibilidade = flexibilidade;
    }

    public int getTemperamento() {
        return temperamento;
    }

    public void setTemperamento(int temperamento) {
        this.temperamento = temperamento;
    }

    public int getAssiduidade() {
        return assiduidade;
    }

    public void setAssiduidade(int assiduidade) {
        this.assiduidade = assiduidade;
    }
}
