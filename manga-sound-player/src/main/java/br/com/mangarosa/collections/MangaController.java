package br.com.mangarosa.collections;

public class MangaController {
    public ListaEncadeada repositorMusica;
    public ListaEncadeada listasReproducao;
    public ListaEncadeada artistas;
    public ReprodutorLista reprodutorLista;

    public void adicionarMusica(String titulo, String path, String nomeArtista) {
        if (repositorMusica == null) repositorMusica = new ListaEncadeada();
        if (artistas == null) artistas = new ListaEncadeada();
        Musica m = new Musica(titulo, 0, path, nomeArtista);
        repositorMusica.append(m);
        if (!artistas.contains(nomeArtista)) {
            artistas.append(nomeArtista);
        }
    }

    public void CriarListaReproducao(String titulo) {
        if (listasReproducao == null) listasReproducao = new ListaEncadeada();
        ListaReproducao lr = new ListaReproducao(titulo);
        listasReproducao.append(lr);
    }

    public void excluirListaReproducao(String titulo) {
        if (listasReproducao == null) return;
        for (int i = 0; i < listasReproducao.size(); i++) {
            ListaReproducao lr = (ListaReproducao) listasReproducao.get(i);
            if (lr.getTitulo().equals(titulo)) {
                listasReproducao.remove(i);
                break;
            }
        }
    }

    public void adicionarMusicaListaReproducao(String tituloMusica, String tituloLista) {
        if (repositorMusica == null || listasReproducao == null) return;
        Musica m = null;
        for (int i = 0; i < repositorMusica.size(); i++) {
            Musica mm = (Musica) repositorMusica.get(i);
            if (mm.getTitulo().equals(tituloMusica)) {
                m = mm;
                break;
            }
        }
        if (m == null) return;
        for (int i = 0; i < listasReproducao.size(); i++) {
            ListaReproducao lr = (ListaReproducao) listasReproducao.get(i);
            if (lr.getTitulo().equals(tituloLista)) {
                lr.addMusica(m);
                break;
            }
        }
    }

    public void adicionarMusicaListaReproducaoEmPosicao(String tituloMusica, String tituloLista, int posicao) {
        if (repositorMusica == null || listasReproducao == null) return;
        Musica m = null;
        for (int i = 0; i < repositorMusica.size(); i++) {
            Musica mm = (Musica) repositorMusica.get(i);
            if (mm.getTitulo().equals(tituloMusica)) {
                m = mm;
                break;
            }
        }
        if (m == null) return;
        for (int i = 0; i < listasReproducao.size(); i++) {
            ListaReproducao lr = (ListaReproducao) listasReproducao.get(i);
            if (lr.getTitulo().equals(tituloLista)) {
                lr.inserirMusicaEm(posicao, m);
                break;
            }
        }
    }

    public void removerMusicaListaReproducao(String tituloMusica, String tituloLista) {
        if (listasReproducao == null) return;
        for (int i = 0; i < listasReproducao.size(); i++) {
            ListaReproducao lr = (ListaReproducao) listasReproducao.get(i);
            if (lr.getTitulo().equals(tituloLista)) {
                for (int j = 0; j < lr.tamanho(); j++) {
                    Musica m = lr.obterMusica(j);
                    if (m.getTitulo().equals(tituloMusica)) {
                        lr.removerMusica(j);
                        return;
                    }
                }
                break;
            }
        }
    }

    public void removerMusicaListaReproducaoEmPosicao(String tituloLista, int posicao) {
        if (listasReproducao == null) return;
        for (int i = 0; i < listasReproducao.size(); i++) {
            ListaReproducao lr = (ListaReproducao) listasReproducao.get(i);
            if (lr.getTitulo().equals(tituloLista)) {
                lr.removerMusica(posicao);
                break;
            }
        }
    }

    public void reproduzirListaDeReproducao(String tituloLista) {
        if (listasReproducao == null) return;
        for (int i = 0; i < listasReproducao.size(); i++) {
            ListaReproducao lr = (ListaReproducao) listasReproducao.get(i);
            if (lr.getTitulo().equals(tituloLista)) {
                if (reprodutorLista == null) {
                    reprodutorLista = new ReprodutorLista(lr);
                } else {
                    reprodutorLista.setListaReproducao(lr);
                }
                reprodutorLista.play();
                break;
            }
        }
    }

    public void pausarMusica() {
        if (reprodutorLista != null) reprodutorLista.pause();
    }

    public void executarMusica() {
        if (reprodutorLista != null) reprodutorLista.play();
    }

    public void voltarMusica() {
        if (reprodutorLista != null) reprodutorLista.restartMusica();
    }

    public void passarMusica() {
        if (reprodutorLista != null) reprodutorLista.restartLista();
    }

    public void reiniciarMusica() {
        if (reprodutorLista != null) reprodutorLista.restartMusica();
    }

    public void pararLista() {
        if (reprodutorLista != null) reprodutorLista.stop();
    }
}
