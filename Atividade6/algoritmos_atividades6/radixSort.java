import java.util.Arrays;

public class radixSort {

  static int getMax(int vetor[], int n)
    {
        int mx = vetor[0];
        for (int i = 1; i < n; i++)
            if (vetor[i] > mx)
                mx = vetor[i];
        return mx;
    }

  public static Resultado sort(int[] vetor, int n) {

    int m = getMax(vetor, n);
      for (int exp = 1; m / exp > 0; exp *= 10)
        countSort(vetor, n, exp);
    
    return new Resultado(vetor, 0,0);
  }

    static void countSort(int vetor[], int n, int exp) {
      int output[] = new int[n];
      int i;
      int count[] = new int[10];
      Arrays.fill(count, 0);

      for (i = 0; i < n; i++)
          count[(vetor[i] / exp) % 10]++;

      for (i = 1; i < 10; i++)
          count[i] += count[i - 1];

      for (i = n - 1; i >= 0; i--) {
          output[count[(vetor[i] / exp) % 10] - 1] = vetor[i];
          count[(vetor[i] / exp) % 10]--;
      }

      for (i = 0; i < n; i++)
          vetor[i] = output[i];
    }
}
