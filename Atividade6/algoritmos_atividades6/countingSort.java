public class countingSort {
  
  public static Resultado sort(int[] vetor, int maior) {

    int[] counts = new int[maior + 1];
    for (int item : vetor) {
        counts[item] += 1;
    }

    int numItemsBefore = 0;
    for (int i = 0; i < counts.length; i++) {
        int count = counts[i];
        counts[i] = numItemsBefore;
        numItemsBefore += count;
    }

    int[] sortedArray = new int[vetor.length];

    for (int item : vetor) {
        sortedArray[ counts[item] ] = item;

    counts[item] += 1;
    }
    return new Resultado(sortedArray, 0,0);
  }
}
