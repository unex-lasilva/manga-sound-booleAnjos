package br.com.mangarosa.collections;

/**
 * A classe {@code ListaEncadeada} implementa uma estrutura de dados de lista encadeada simples.
 * Ela permite adicionar, remover e acessar elementos de maneira eficiente. Esta lista pode armazenar
 * qualquer tipo de objeto e oferece funcionalidades típicas de listas, como adicionar ao final,
 * inserir em posições específicas, remover elementos, verificar a presença de elementos e mais.
 *
 * <p>Os principais métodos incluem:</p>
 * <ul>
 *   <li>{@link #append(Object)} - Adiciona um elemento ao final da lista.</li>
 *   <li>{@link #insertAt(int, Object)} - Insere um elemento em uma posição específica.</li>
 *   <li>{@link #addAll(ListaEncadeada)} - Adiciona todos os elementos de outra lista à lista atual.</li>
 *   <li>{@link #remove(int)} - Remove um elemento de uma posição específica.</li>
 *   <li>{@link #clear()} - Limpa todos os elementos da lista.</li>
 *   <li>{@link #get(int)} - Retorna o elemento na posição especificada.</li>
 *   <li>{@link #isEmpty()} - Verifica se a lista está vazia.</li>
 *   <li>{@link #size()} - Retorna o número de elementos na lista.</li>
 *   <li>{@link #indexOf(Object)} - Retorna o índice da primeira ocorrência do valor especificado.</li>
 *   <li>{@link #contains(Object)} - Verifica se o valor especificado está na lista.</li>
 * </ul>
 *
 * @author Mangarosa
 * @version 1.0
 */
public class ListaEncadeada {
    private No inicio;
    private int tamanho;


    public void append(Object value) {
        No novo = new No(value);
        if (inicio == null){
            inicio = novo;
        } else {
            No atual = inicio;
            while (atual.getProx() != null){
                atual = atual.getProx();
            }
            atual.setProx(novo);
        }
        tamanho++;
    }

    public void insertAt(int position, Object value) {
        if (position < 0 || position > tamanho){
            throw new IndexOutOfBoundsException("Posição invalida");
        }

        No novo = new No(value);

        if (position == 0) {
            novo.setProx(inicio);
            inicio = novo;
        } else {
            No anterior = inicio;
            for (int i = 0; i < position - 1; i++){
                anterior = anterior.getProx();
            }
            novo.setProx(anterior.getProx());
            anterior.setProx(novo);
        }
        tamanho++;
    }

    public void addAll(ListaEncadeada list) {
        for (int i = 0; i < list.size(); i++) {
            append(list.get(i));
        }
    }


    public boolean remove(int position) {
        if (position < 0 || position >= tamanho) {
            return false;
        }

        if (position == 0) {
            inicio = inicio.getProx();
        } else {
            No anterior = inicio;
            for (int i = 0; i < position - 1; i++) {
                anterior = anterior.getProx();
            }
            No atual = anterior.getProx();
            anterior.setProx(atual.getProx());
        }

        tamanho--;
        return true;
    }

    public boolean clear() {
        inicio = null;
        tamanho = 0;
        return true;
    }

    public Object get(int position) {
        if (position < 0 || position >= tamanho) {
            throw new IndexOutOfBoundsException("Posição inválida");
        }

        No atual = inicio;
        for (int i = 0; i < position; i++) {
            atual = atual.getProx();
        }
        return atual.getValor();
    }

    public boolean isEmpty() {
        return tamanho == 0;
    }

    public int size() {
        return tamanho;
    }

    public int indexOf(Object value) {
        No atual = inicio;
        int index = 0;
        while (atual != null) {
            if ((atual.getValor() == null && value == null) ||
                (atual.getValor() != null && atual.getValor().equals(value))) {
                return index;
            }
            atual = atual.getProx();
            index++;
        }
        return -1;
    }

    public boolean contains(Object value) {
        return indexOf(value) != -1;
    }
}