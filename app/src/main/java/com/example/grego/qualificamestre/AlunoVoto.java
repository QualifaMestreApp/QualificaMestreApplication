package com.example.grego.qualificamestre;

public class AlunoVoto {

    public AlunoVoto(){}

    public AlunoVoto(String id,int matrerial, int networking,int ajuda,int conhecimentosExtra,int assiduidade){
        this.id = id;
        this.matrerial = matrerial;
        this.networking = networking;
        this.ajuda = ajuda;
        this.conhecimentosExtra = conhecimentosExtra;
        this.assiduidade = assiduidade;
    }

    private String id;
    //de 0 a 5
    private int matrerial;
    private int networking;
    private int ajuda;
    private int conhecimentosExtra;
    private int assiduidade;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
