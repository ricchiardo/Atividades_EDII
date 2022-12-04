public class quickSort {

  static long trocas=0;
  static long comparacoes=0;
  
  public static Resultado sort(int[] vetor, int esquerda, int direita) {
    if (esquerda < direita){
      int p = particao(vetor, esquerda, direita);
      sort(vetor, esquerda, p);
      sort(vetor, p + 1, direita);
    }
    return new Resultado(vetor, trocas, comparacoes);
  }

  static int particao(int[] vetor, int esquerda, int direita){
    int meio = (int) (esquerda + direita) / 2;
    int pivot = vetor[meio];
    int i = esquerda - 1;
    int j = direita + 1;
    while(true){
      do{
        i++;
        comparacoes++;
        }while(vetor[i] < pivot);
          do{
          j--;
        }while(vetor[j] > pivot);
          if (i >= j){
            comparacoes++;
            return j;
          }
      int aux = vetor[i];
      vetor[i] = vetor[j];
      vetor[j] = aux;
      trocas++;
    }
  }
}
