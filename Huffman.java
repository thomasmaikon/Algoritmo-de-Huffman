package Compressao;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class Huffman {
    private Letras letra[];
    private Integer quantidadePalavras = 4;
    private ArvoreBinaria<Letras> arvore;

    public Huffman() { letra = new Letras[quantidadePalavras]; }

    public void lerArquivo(String caminho) throws FileNotFoundException {
        File arquivo = new File(caminho);
        Scanner leitor = new Scanner(arquivo);
        while (leitor.hasNextLine()){
            String str = leitor.nextLine();
            for (int i=0; i<str.length(); i++){
                this.cadastrarLetra(String.valueOf(str.charAt(i)));
            }
        }
    }

    private void cadastrarLetra(String str){
        Function<String, Boolean> letraExiste = ((x)->{
            for (int i=0; i<this.quantidadeDeElementosPresentes(this.letra);i++){
                if(this.letra[i].getLetra().equals(x)){
                    this.letra[i].incrementar();
                    return true;
                }
            }
            return false;
        });

        if(this.letra[0] == null){ this.letra[0] = new Letras(String.valueOf(str));}
        else{
            if(!letraExiste.apply(str)){
                this.letra[quantidadeDeElementosPresentes(this.letra)] = new Letras(String.valueOf(str));
            }
        }
        this.ordenar(this.letra);
    }

    private Integer quantidadeDeElementosPresentes(Letras letras[]){
        Integer i=0;
        for (Letras l: letras){
            if(l != null){ i++; }
        }
        return i;
    }

    private void ordenar(Letras letras[]){// lembrete, select sort
        for(int j=0; j<this.quantidadeDeElementosPresentes(letras);j++){
            for (int i=0; i<this.quantidadeDeElementosPresentes(letras);i++){
                if(letra[j].getQuantidade() < letra[i].getQuantidade()){
                    var buffer = letra[j];
                    letra[j] = letra[i];
                    letra[i] = buffer;
                }
            }
        }
    }

    public ArvoreBinaria gerarArvore(){
        ArvoreBinaria<Letras> listaDeArvores [] = new ArvoreBinaria[quantidadePalavras];
        for (int i=0; i< quantidadeDeElementosPresentes(this.letra);i++){
            listaDeArvores[i] = new ArvoreBinaria<Letras>(this.letra[i]);
        }

        listaDeArvores = juntarArovres(listaDeArvores[0], listaDeArvores[1], listaDeArvores);
        while (quantidadeDeElementosPresentes(listaDeArvores) != 1) {
            listaDeArvores = juntarArovres(listaDeArvores[0], listaDeArvores[1], listaDeArvores);
        }
        this.arvore = listaDeArvores[0];
        return arvore;
    }

    private ArvoreBinaria[] juntarArovres(ArvoreBinaria<Letras> a1, ArvoreBinaria<Letras> a2, ArvoreBinaria<Letras>[] arvores){
        String novoNome = a1.getConteudo().getLetra()+ a2.getConteudo().getLetra();
        Integer novaQuantidade =a1.getConteudo().getQuantidade()+a2.getConteudo().getQuantidade();
        Letras noDaArvore = new Letras(novoNome,novaQuantidade);

        var novaArvore =new ArvoreBinaria<Letras>(noDaArvore);
        novaArvore.setEsquerda(a1);
        novaArvore.setDireita(a2);

        arvores[0] = null;
        arvores[1] = null;

        ArvoreBinaria novaListaDeArvores [] = new ArvoreBinaria[quantidadePalavras];

        for (int i=0,j=0; i<quantidadePalavras;i++){
            if(arvores[i] != null){
                novaListaDeArvores[j] = arvores[i];
                j++;
            }
        }
        novaListaDeArvores[quantidadeDeElementosPresentes(novaListaDeArvores)] = novaArvore;
        ordenar(novaListaDeArvores);

        return novaListaDeArvores;
    }

    private Integer quantidadeDeElementosPresentes(ArvoreBinaria<Letras> arvoreBinaria[]){
        Integer i=0;
        for (ArvoreBinaria a: arvoreBinaria){
            if(a != null){ i++; }
        }
        return i;
    }

    private void ordenar(ArvoreBinaria<Letras> arvoreBinarias[]){// lembrete, select sort para arvores
        for(int j=0; j<this.quantidadeDeElementosPresentes(arvoreBinarias);j++){
            for (int i=0; i<this.quantidadeDeElementosPresentes(arvoreBinarias);i++){
                if(arvoreBinarias[j].getConteudo().getQuantidade() < arvoreBinarias[i].getConteudo().getQuantidade()){
                    var buffer = arvoreBinarias[j];
                    arvoreBinarias[j] = arvoreBinarias[i];
                    arvoreBinarias[i] = buffer;
                }
            }
        }
    }

    public void tabelaDeSimbolos() {
        for (Letras l : this.letra){
            System.out.println(l.getLetra() + " " + ordem(this.arvore, " Nº ", l.getLetra()));
        }
    }

    private String ordem(ArvoreBinaria<Letras> proxima,String numero,String letra){
        if (proxima!= null) {

            if (proxima.getConteudo().getLetra().equals(letra)) {

                return numero;
            }
            String esquerdo = ordem(proxima.getEsquerda(), numero + "0", letra);
            if (esquerdo!=null){return esquerdo;}
            String direito = ordem(proxima.getDireita(), numero + "1", letra);
            if (direito!=null){return direito;}

        }
        return null;
    }


    @Override
    public String toString() {
        return "Huffman{" +
                "letra=" + Arrays.toString(letra) +
                '}';
    }

    public Letras[] getLetra() {
        return letra;
    }

    public void setLetra(Letras[] letra) {
        this.letra = letra;
    }
}
