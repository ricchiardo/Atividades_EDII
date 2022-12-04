package algoritmos_ordenação;

public class insertion_sort {
    
    public static Resultado sort(int[] vetor) {

        int j, key, i;
        long trocas = 0;
        
        for (j = 1; j < vetor.length; j++) {  //irá percorrer todo o vetor começando do segundo elemento.
            key = vetor[j]; //guarda o primeiro valor lido no vetor (no caso, o segundo elemento).
            for (i = j - 1; (i >= 0) && (vetor[i] > key); i--) { //condição de continuidade e de substituição.
                vetor[i + 1] = vetor[i]; // troca conforme a segunda iteração do for seja verdadeira.
                trocas++;
            }
            vetor[i + 1] = key; //substitui o valor que foi guardado na posição correta.
            trocas++;
        }
        return new Resultado(vetor, trocas);
    }

}