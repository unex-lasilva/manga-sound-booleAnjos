package br.com.mangarosa.collections;
public class Musica {
    
    //Seria bom seguir as nomeclaturas do diagrama de classe para ficar padrão para outros da equipe
    private String nome;
    private String caminhoArquivo;
    private int duracaoSegundos;  // Em segundos
    private String genero;
    // E o artista?

    //Faltou o construtor default
    //Quando tem um contrutor declarado explicitamentre, precisa declarar o construtor de defaoult explicitamente tbm
    public Musica(String nome, String caminhoArquivo, int duracaoSegundos, String genero) {
        this.nome = nome;
        this.caminhoArquivo = caminhoArquivo;
        this.duracaoSegundos = duracaoSegundos;
        this.genero = genero;
    }


    //Como vai atribuir os valores para as variaives? 
    
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

    //Acredito que não precise desta função, mas tudo bem
    @Override
    public String toString() {
        return nome + " (" + genero + ") - " + duracaoSegundos + "s";
    }
}
