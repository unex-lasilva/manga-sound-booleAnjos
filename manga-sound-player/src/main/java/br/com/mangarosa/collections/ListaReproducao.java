package br.com.mangarosa.collections;

import java.util.ArrayList;
import java.util.List;

public class ListaReproducao {
    private String titulo;
    private List<Musica> musicas;

    public ListaReproducao(String titulo) {
        this.titulo = titulo;
        this.musicas = new ArrayList<>();
    }

    public void addMusica(Musica musica) {
        musicas.add(musica);
    }

    public boolean removerMusica(int posicao) {
        if (posicao < 0 || posicao >= musicas.size()) {
            return false;
        }
        musicas.remove(posicao);
        return true;
    }

    public void inserirMusicaEm(int posicao, Musica musica) {
        if (posicao < 0 || posicao > musicas.size()) {
            throw new IndexOutOfBoundsException("Posição inválida: " + posicao);
        }
        musicas.add(posicao, musica);
    }

    public boolean isVazia() {
        return musicas.isEmpty();
    }

    public int tamanho() {
        return musicas.size();
    }

    public void criarListaApartirDe(ListaReproducao outra) {
        this.musicas.clear();
        this.musicas.addAll(outra.musicas);
    }

    public int posicaoDa(Musica musica) {
        return musicas.indexOf(musica);
    }

    public boolean contemMusica(Musica musica) {
        return musicas.contains(musica);
    }

    public boolean limparLista() {
        musicas.clear();
        return true;
    }

    public Musica obterMusica(int posicao) {
        if (posicao < 0 || posicao >= musicas.size()) {
            return null;
        }
        return musicas.get(posicao);
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
