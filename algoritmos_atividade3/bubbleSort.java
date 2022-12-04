public class bubbleSort {

  public static Resultado sort (int[] vetor) {
    int aux;
    int trocas = 0, comparacoes = 0;

    for(int i = 0; i < vetor.length; i++){ // variavel i que fica parada enquanto o proximo for compara as outras posições
      comparacoes++;
      for(int j = i + 1; j < vetor.length; j++){ //variavel j que fica comparando as posições procurando por uma menor para trocar com vetor[i]
        comparacoes++;
        if (vetor[i] > vetor[j]){ //condição para troca
          aux = vetor[j]; //guarda o valor que será trocado
          vetor[j] = vetor[i]; //substitui o valor da posição encontrada
          vetor[i] = aux; //coloca o valor que foi guardado na posição trocada
          trocas++;
        }
      }
    }
    
    return new Resultado(vetor, trocas, comparacoes);
  }
}
