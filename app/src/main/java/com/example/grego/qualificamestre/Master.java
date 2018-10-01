package com.example.grego.qualificamestre;

public class Master {



    private String key;
    private String name;
    private String institution;
    private String grade;


    //TODO Decidir como contabilizar os votos, se fazer uma conta simples ou se pegar o tamanho do array de alunos votantes.;
    private String voters;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getVoters() {
        return voters;
    }

    public void setVoters(String voters) {
        this.voters = voters;
    }
}
