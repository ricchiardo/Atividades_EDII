public class Resultado {
    private int[] vetor;
    private long trocas;
    private long comparacoes;

    public Resultado(int[] vetor, long trocas, long comparacoes) {
        this.vetor = vetor;
        this.trocas = trocas;
        this.comparacoes = comparacoes;
    }

    public int[] getVetor() {
        return vetor;
    }

    public long getTrocas() {
        return trocas;
    }

    public long getComparacoes() {
        return comparacoes;
    }

    public void setVetor(int[] vetor) {
        this.vetor = vetor;
    }

    public void setTrocas(int trocas) {
        this.trocas = trocas;
    }

    public void setComparacoes(int comparacoes) {
        this.comparacoes = comparacoes;
    }
    

}
