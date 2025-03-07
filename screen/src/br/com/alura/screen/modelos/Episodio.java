package br.com.alura.screen.modelos;

public class Episodio implements Cassificavel {
    private int numero;
    private String nome;
    private String serie;
    private int totalVisualizacoes;

    public int getTotalVisualizacoes() {
        return totalVisualizacoes;
    }

    public void setTotalVisualizacoes(int totalVisualizacoes) {
        this.totalVisualizacoes = totalVisualizacoes;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }
    @Override
    plublic int getClassificacao() {
        if (totalVisualizacoes > 100)
            return 4;
    }  else {

        return 2 ;
    }
}

}