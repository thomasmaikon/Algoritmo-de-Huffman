# Algoritmo-de-Huffman
O algoritmo de huffman e bastante popular e eficiente para compressão de dados presente em arquivos. Neste ele foi implementado para realizar compressao em arquivos **.txt** 

## :gear: Funcionamento
O algoritmo de ruffman le e contabiliza todas as letras presentes no arquivo e as separa em folhas, seguindo alguns conceitos da estrutura de dados conhecida como arvore, posteriormente ele separa em diferentes nós de forma crescente.  

Um arquivo de texto tendo por exemplo a seguinte sequencia de letras: ABCDDABOK

<Imagem exemplo>

Posteriormente ele junta cada nó folha de forma crescete, os soma e reorganiza a posicao dos elementos até que a arvore esteja completa.

<giph demostrando a soma e reorganizando>

## Utilização
No arquivo **HuffmanTeste** são implementadas 3(três) métodos diferentes, no primeiro é demonstrando como é realizada a leitura do arquivo **.txt** através da classe Huffman.  

```java 
    Huffman c = new Huffman();    
     c.lerArquivo("caminho do arquivo") //ex:/Documentos/src/file.txt
``` 

No segundo é demonstrado o metodo utilizado para gerar a arvore referente ao arquivo lido.  

```java 
    c.gerarArvore()
``` 

No terceiro e ultimo caso é demonstrado o metodo utilizado para gerar a tabela dos simbolos que foram gerados para cada letra identificada no arquivo **.txt**

```java 
    c.tabelaDeSimbolos()
``` 


### :warning: OBS:
Caso seja gerada uma tabela sem antes gerar a arvore haverá o famoso aviso de NullPointerException.
