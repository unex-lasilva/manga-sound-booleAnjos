package br.com.mangarosa.collections;
public class Musica {
    private String nome;
    private String caminhoArquivo;
    private int duracaoSegundos;  // Em segundos
    private String genero;


    public Musica(String nome, String caminhoArquivo, int duracaoSegundos, String genero) {
        this.nome = nome;
        this.caminhoArquivo = caminhoArquivo;
        this.duracaoSegundos = duracaoSegundos;
        this.genero = genero;
    }


    public String getNome() {
        return nome;
    }

    public String getCaminhoArquivo() {
        return caminhoArquivo;
    }

    public int getDuracaoSegundos() {
        return duracaoSegundos;
    }

    public String getGenero() {
        return genero;
    }


    @Override
    public String toString() {
        return nome + " (" + genero + ") - " + duracaoSegundos + "s";
    }
}