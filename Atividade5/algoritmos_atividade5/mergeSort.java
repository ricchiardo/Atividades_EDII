public class mergeSort {

  static long trocas = 0;
  static long comparacoes = 0;

  public static Resultado sort(int[] vetor, int[] auxiliar, int ini, int fim) {
    if (ini < fim) {
      int meio = (ini + fim) / 2;
      sort(vetor, auxiliar, ini, meio);
      sort(vetor, auxiliar, meio+1, fim);
      intercalar(vetor, auxiliar, ini, meio, fim);
    }
    return new Resultado(vetor, trocas, comparacoes);
  }

  private static void intercalar(int[] vetor, int[] auxiliar, int ini, int meio, int fim) {
    for (int i = ini; i <= fim; i++) {
      auxiliar[i] = vetor[i];
    }
    int esq = ini;
    int dir = meio + 1;

    for(int i = ini; i <= fim; i++) {
      if (esq > meio) {
        vetor[i] = auxiliar[dir++];
        trocas++;
      }else if (dir > fim) {
        vetor[i] = auxiliar[esq++];
        trocas++;
      }else if (auxiliar[esq] < auxiliar[dir]) {
        vetor[i] = auxiliar[esq++];
        comparacoes++;
      }else {
        vetor [i] = auxiliar[dir++];
        comparacoes++;
      }
    }
  }
}