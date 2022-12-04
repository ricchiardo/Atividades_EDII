package algoritmos_ordenação;

public class Resultado {
    private int[] vetor;
    private long trocas;

    public Resultado(int[] vetor, long trocas) {
        this.vetor = vetor;
        this.trocas = trocas;
    }

    public int[] getVetor() {
        return vetor;
    }

    public long getTrocas() {
        return trocas;
    }

    public void setVetor(int[] vetor) {
        this.vetor = vetor;
    }

    public void setTrocas(int trocas) {
        this.trocas = trocas;
    }

}
