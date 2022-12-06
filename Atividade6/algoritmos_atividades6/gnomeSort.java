public class gnomeSort {
  public static Resultado sort(int[] vetor, int n) {
    long trocas = 0;
    long comparacoes = 0;

    int index = 0;
    while (index < n) {
      
      if (index == 0) {
        index++;
        comparacoes++;
      }
      if (vetor[index] >= vetor[index-1]) {
        index = index+1;
        comparacoes++;
      }
      else {
        int aux = 0;
        aux = vetor[index];
        vetor[index] = vetor[index - 1];
        vetor[index - 1] = aux;
        index--;
        trocas++;
      }
    }

    return new Resultado(vetor, trocas, comparacoes);
  }  
}