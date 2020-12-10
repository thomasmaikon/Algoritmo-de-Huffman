package Compressao;

public class Letras {
    private String letra;
    private Integer quantidade;

    public Letras(String letra) {
        setLetra(letra);
        quantidade = 1;
    }

    public Letras(String letra, Integer qtd) {
        setLetra(letra);
        quantidade = qtd;
    }
    public void incrementar(){ quantidade++; }

    @Override
    public String toString() {
        return "Vetor{" +
                "letra='" + letra + '\'' +
                ", quantidade=" + quantidade +
                '}';
    }

    public String getLetra() {
        return letra;
    }

    public void setLetra(String letra) {
        this.letra = letra;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
}
