public class comboSort {
  
  public static Resultado sort (int[] vetor) {
    int trocas = 0, comparacoes = 0;
    int intervalo = (int) (vetor.length/1.3);
    int indice = 0;

    while (intervalo > 0 && indice != vetor.length-1) {
      indice = 0;
      comparacoes++;
      while ((indice + intervalo) < vetor.length) {
        comparacoes++;
        if (vetor[indice] > vetor[indice + intervalo]) {
          int aux = vetor[indice];
          vetor[indice] = vetor[indice + intervalo];
          vetor [indice + intervalo] = aux;
          trocas++;
        }
        indice++;
      }
      intervalo = (int) (intervalo / 1.3);
    }
      return new Resultado(vetor, trocas, comparacoes);
  }
}
