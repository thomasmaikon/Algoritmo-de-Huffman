package Compressao;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class HuffmanTest {

    @Test
    void lerArquivoEcontaLetras() throws FileNotFoundException {
        Huffman c = new Huffman();
        c.lerArquivo("caminhoDoArquivo"); // exemplo: /Documentos/src/teste-trabalho3.txt
        for (Letras l: c.getLetra()){
            System.out.println(l);
        }
    }
    @Test
    void arvore() throws FileNotFoundException {
        Huffman c = new Huffman();
        c.lerArquivo("caminhoDoArquivo");

        System.out.println(c.gerarArvore());
    }
    @Test
    void tabelaDeSimbolos() throws FileNotFoundException {
        Huffman c = new Huffman();
        c.lerArquivo("caminhoDoArquivo");

        c.gerarArvore();
        c.tabelaDeSimbolos();
    }
}
