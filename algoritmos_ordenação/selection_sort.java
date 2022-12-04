package algoritmos_ordenação;

public class selection_sort {
    
  public static Resultado sort(int[] vetor) {

    int posicao_menor, aux;
    int trocas = 0;

    for(int i=0; i < vetor.length; i++){ //começa a percorrer o vetor da primeira posição.
      posicao_menor = i; //atribui a menor posição para o primeiro elemento do vetor.

      for(int j = i+1; j < vetor.length; j++){ //percorre o vetor para comparar qual é a menor posição.
        if (vetor[j] < vetor[posicao_menor]){ //compara os elementos.
          posicao_menor = j; //atribui o real menor valor do vetor.
        }
      }

    aux = vetor[posicao_menor]; //guarda o numero menor encontrado ao percorrer o vetor.
    vetor[posicao_menor] = vetor[i]; //leva o elemento que era o posicao_menor para a outra posição que foi encontrado um numero menor.
    vetor[i] = aux; //traz o menor numero encontrado para a sua posição.
    trocas++;
    }

  return new Resultado(vetor, trocas);
  }
}