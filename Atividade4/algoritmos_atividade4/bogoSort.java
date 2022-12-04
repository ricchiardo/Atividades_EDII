import java.util.Random;

public class bogoSort {
  
  public static Resultado sort(int[] vetor) {
    long trocas =0;
    while (!rightOrder(vetor)) {
      trocas++;
      randomSort(vetor);
    }
    return new Resultado(vetor, trocas,0);
  }

  public static void randomSort (int[] vetor) {
    Random rnd = new Random();
    for (int i=0; i <vetor.length; i++) {
      int swapPos = rnd.nextInt(vetor.length);
      int temp = vetor[i];
      vetor[i] = vetor[swapPos];
      vetor[swapPos] = temp;
    }
  }

  public static boolean rightOrder(int[] vetor) {
    for (int i=0; i < vetor.length - 1; i++) {
      if (vetor[i] > vetor[i+1]) {
        return false;
      }
    }
    return true;
  }
}