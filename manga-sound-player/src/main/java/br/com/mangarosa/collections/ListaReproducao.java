package br.com.mangarosa.collections;


public class ListaReproducao {
    private String titulo;
    private ListaEncadeada lista;

    public ListaReproducao(String titulo) {
        this.titulo = titulo;
        this.lista = new ListaEncadeada();
    }

    public void addMusica(Musica musica) {
        lista.append(musica);
    }

    public boolean removerMusica(int posicao) {
        return lista.remove(posicao);
    }

    public void inserirMusicaEm(int posicao, Musica musica) {
        lista.insertAt(posicao, musica);
    }

    public boolean isVazia() {
        return lista.isEmpty();
    }

    public int tamanho() {
        return lista.size();
    }

    public void criarListaApartirDe(ListaReproducao outra) {
        lista.clear();
        for (int i = 0; i < outra.tamanho(); i++) {
            lista.append(outra.obterMusica(i));
        }
    }

    public int posicaoDa(Musica musica) {
        return lista.indexOf(musica);
    }

    public boolean contemMusica(Musica musica) {
        return lista.contains(musica);
    }

    public boolean limparLista() {
        return lista.clear();
    }

    public Musica obterMusica(int posicao) {
        Object obj = lista.get(posicao);
        if (obj instanceof Musica) {
            return (Musica) obj;
        }
        return null;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}