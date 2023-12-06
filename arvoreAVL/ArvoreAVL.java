package arvoreAVL;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class No {
    int dado;
    No esquerda, direita;
    int altura;

    No(int dado) {
        this.dado = dado;
        this.altura = 1;
    }
}

public class ArvoreAVL {
    private No raiz;

    private int obterAltura(No no) {
        if (no == null)
            return 0;
        return no.altura;
    }

    private int maximo(int a, int b) {
        return (a > b) ? a : b;
    }

    private No rotacionarDireita(No y) {
        No x = y.esquerda;
        No T2 = x.direita;

        x.direita = y;
        y.esquerda = T2;

        y.altura = maximo(obterAltura(y.esquerda), obterAltura(y.direita)) + 1;
        x.altura = maximo(obterAltura(x.esquerda), obterAltura(x.direita)) + 1;

        return x;
    }

    private No rotacionarEsquerda(No x) {
        No y = x.direita;
        No T2 = y.esquerda;

        y.esquerda = x;
        x.direita = T2;

        x.altura = maximo(obterAltura(x.esquerda), obterAltura(x.direita)) + 1;
        y.altura = maximo(obterAltura(y.esquerda), obterAltura(y.direita)) + 1;

        return y;
    }

    private int obterBalanceamento(No no) {
        if (no == null)
            return 0;
        return obterAltura(no.esquerda) - obterAltura(no.direita);
    }

    private No inserirNo(No raiz, int dado) {
        if (raiz == null)
            return new No(dado);

        if (dado < raiz.dado)
            raiz.esquerda = inserirNo(raiz.esquerda, dado);
        else if (dado > raiz.dado)
            raiz.direita = inserirNo(raiz.direita, dado);
        else
            return raiz;

        raiz.altura = 1 + maximo(obterAltura(raiz.esquerda), obterAltura(raiz.direita));

        int balanceamento = obterBalanceamento(raiz);

        if (balanceamento > 1 && dado < raiz.esquerda.dado)
            return rotacionarDireita(raiz);

        if (balanceamento < -1 && dado > raiz.direita.dado)
            return rotacionarEsquerda(raiz);

        if (balanceamento > 1 && dado > raiz.esquerda.dado) {
            raiz.esquerda = rotacionarEsquerda(raiz.esquerda);
            return rotacionarDireita(raiz);
        }

        if (balanceamento < -1 && dado < raiz.direita.dado) {
            raiz.direita = rotacionarDireita(raiz.direita);
            return rotacionarEsquerda(raiz);
        }

        return raiz;
    }

    private void percorrerEmOrdem(No raiz) {
        if (raiz != null) {
            percorrerEmOrdem(raiz.esquerda);
            System.out.print(raiz.dado + " ");
            percorrerEmOrdem(raiz.direita);
        }
    }

    private void inserirDoArquivo(String nomeArquivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                int num = Integer.parseInt(linha);
                raiz = inserirNo(raiz, num);
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ArvoreAVL arvoreAVL = new ArvoreAVL();

        String nomeArquivo = "C:/Users/richa/Downloads/dados100_mil_definitive.txt";

        long inicio = System.nanoTime();
        arvoreAVL.inserirDoArquivo(nomeArquivo);
        long tempoInsercao = System.nanoTime() - inicio;

        inicio = System.nanoTime();
        System.out.print("Elementos da árvore AVL: ");
        arvoreAVL.percorrerEmOrdem(arvoreAVL.raiz);
        System.out.println();
        long tempoImpressao = System.nanoTime() - inicio;

        double tempoInsercaoSegundos = tempoInsercao / 1e9;
        double tempoImpressaoSegundos = tempoImpressao / 1e9;

        System.out.println("Tempo para inserção na árvore AVL: " + tempoInsercaoSegundos + " segundos");
        System.out.println("Tempo para impressão da árvore AVL: " + tempoImpressaoSegundos + " segundos");
    }
}
