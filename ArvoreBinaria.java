package Compressao;

public class ArvoreBinaria<T> {

    private T conteudo;
    private ArvoreBinaria esquerda;
    private ArvoreBinaria direita;

    public ArvoreBinaria(T conteudo){ this.conteudo = conteudo;}

    @Override
    public String toString() {
        return "ArvoreBinaria{" +
                "conteudo=" + conteudo +
                ", esquerda=" + esquerda +
                ", direita=" + direita +
                '}';
    }

    public ArvoreBinaria getEsquerda() {
        return esquerda;
    }

    public void setEsquerda(ArvoreBinaria esquerda) {
        this.esquerda = esquerda;
    }

    public ArvoreBinaria getDireita() {
        return direita;
    }

    public void setDireita(ArvoreBinaria direita) {
        this.direita = direita;
    }

    public T getConteudo() {
        return conteudo;
    }

    public void setConteudo(T conteudo) {
        this.conteudo = conteudo;
    }
}
