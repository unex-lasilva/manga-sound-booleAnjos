package br.com.mangarosa.collections;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class ReprodutorLista {
    public ListaReproducao listaReproducao;
    public String status;
    public Clip clip;

    public ReprodutorLista() {}

    public ReprodutorLista(ListaReproducao listaReproducao) {
        this.listaReproducao = listaReproducao;
    }

    public ListaReproducao getListaReproducao() {
        return listaReproducao;
    }

    public void setListaReproducao(ListaReproducao listaReproducao) {
        this.listaReproducao = listaReproducao;
    }

    public void play(){
        if (listaReproducao == null || listaReproducao.isVazia()) {
            System.out.println("Playlist vazia.");
            return;
        }
        try {
            if (clip == null || status == null || "STOPPED".equals(status)) {
                Musica musica = listaReproducao.obterMusica(0);
                javax.sound.sampled.AudioInputStream stream = javax.sound.sampled.AudioSystem
                        .getAudioInputStream(new java.io.File(musica.getPath()));
                clip = javax.sound.sampled.AudioSystem.getClip();
                clip.open(stream);
            }
            clip.start();
            status = "PLAYING";
        } catch (javax.sound.sampled.LineUnavailableException |
                 java.io.IOException |
                 javax.sound.sampled.UnsupportedAudioFileException e) {
            e.printStackTrace();
        }
    }

    public void pause(){
        if (clip != null && "PLAYING".equals(status)) {
            clip.stop();
            status = "PAUSED";
        }
    }
    public void restartMusica(){
        if (clip != null) {
            clip.stop();
            clip.setFramePosition(0);
            clip.start();
            status = "PLAYING";
        }
    }
    public void restartLista(){
        if (clip != null) {
            clip.stop();
            clip.setFramePosition(0);
        }
        play();
    }
    public void stop(){
        if (clip != null) {
            clip.stop();
            clip.setFramePosition(0);
            status = "STOPPED";
        }
    }
}