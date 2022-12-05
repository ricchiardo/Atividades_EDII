import java.io.*;

public class principal {

    public static void main(String[] args) throws IOException {
        
        Timer timer = new Timer();
        String path = "C:\\Users\\richa\\OneDrive\\Área de Trabalho\\AtividadesEDII\\Atividade5\\arquivos_dados\\1-dados5.txt";
        //String path = "C:\\Users\\richa\\OneDrive\\Área de Trabalho\\AtividadesEDII\\Atividade5\\arquivos_dados\\2-dados100.txt";
        //String path = "C:\\Users\\richa\\OneDrive\\Área de Trabalho\\AtividadesEDII\\Atividade5\\arquivos_dados\\3-dados1000.txt";
        //String path = "C:\\Users\\richa\\OneDrive\\Área de Trabalho\\AtividadesEDII\\Atividade5\\arquivos_dados\\4-dados10_mil.txt";
        //String path = "C:\\Users\\richa\\OneDrive\\Área de Trabalho\\AtividadesEDII\\Atividade5\\arquivos_dados\\5-dados50_mil.txt";
        //String path = "C:\\Users\\richa\\OneDrive\\Área de Trabalho\\AtividadesEDII\\Atividade5\\arquivos_dados\\6-dados100_mil_melhor_caso.txt";
        //String path = "C:\\Users\\richa\\OneDrive\\Área de Trabalho\\AtividadesEDII\\Atividade5\\arquivos_dados\\7-dados100_mil.txt";
        //String path = "C:\\Users\\richa\\OneDrive\\Área de Trabalho\\AtividadesEDII\\Atividade5\\arquivos_dados\\8-dados100_mil_pior_caso.txt";
        //String path = "C:\\Users\\richa\\OneDrive\\Área de Trabalho\\AtividadesEDII\\Atividade5\\arquivos_dados\\9-dados500_mil.txt";
        int vetor [] = ler_dados(path);
        //int auxiliar [] = new int[vetor.length];
        Resultado resultado;

        resultado = heapSort.sort(vetor);
        //resultado = mergeSort.sort(vetor, auxiliar, 0, vetor.length-1);

        gravar_Dados(vetor);
    
        System.out.println("Tempo de execução (em minutos, segundos e milisegundos): " + timer);
        System.out.println("Trocas realizadas: " + resultado.getTrocas());
        System.out.println("Comparações realizadas: " + resultado.getComparacoes());
    }

public static int[] ler_dados(String path) {
    
    try (BufferedReader br = new BufferedReader(new FileReader(path))) {

        String line = br.readLine();
        String [] vect = line.split(", ");
        int [] vetor = new int [vect.length];
        for (int i=0;i< vect.length;i++) {
            int aux = Integer.parseInt(vect[i]);
            vetor[i]+=aux;
        }
        return vetor;

    } catch (IOException e) {
        System.out.println("Error: " + e.getMessage());
    }
    return null;

}

public static void gravar_Dados (int [] vetor) throws IOException {
    
    FileWriter novo_dados = new FileWriter("C:\\Users\\richa\\OneDrive\\Área de Trabalho\\AtividadesEDII\\Atividade5\\dados_ordenados\\1-dados5_ordenados_hs.txt");
    //FileWriter novo_dados = new FileWriter("C:\\Users\\richa\\OneDrive\\Área de Trabalho\\AtividadesEDII\\Atividade5\\dados_ordenados\\2-dados100_ordenados_hs.txt");
    //FileWriter novo_dados = new FileWriter("C:\\Users\\richa\\OneDrive\\Área de Trabalho\\AtividadesEDII\\Atividade5\\dados_ordenados\\3-dados1000_ordenados_hs.txt");
    //FileWriter novo_dados = new FileWriter("C:\\Users\\richa\\OneDrive\\Área de Trabalho\\AtividadesEDII\\Atividade5\\dados_ordenados\\4-dados10_mil_ordenados_hs.txt");
    //FileWriter novo_dados = new FileWriter("C:\\Users\\richa\\OneDrive\\Área de Trabalho\\AtividadesEDII\\Atividade5\\dados_ordenados\\5-dados50_mil_ordenados_hs.txt");
    //FileWriter novo_dados = new FileWriter("C:\\Users\\richa\\OneDrive\\Área de Trabalho\\AtividadesEDII\\Atividade5\\dados_ordenados\\6-dados100_mil_melhor_caso_ordenados_hs.txt");
    //FileWriter novo_dados = new FileWriter("C:\\Users\\richa\\OneDrive\\Área de Trabalho\\AtividadesEDII\\Atividade5\\dados_ordenados\\7-dados100_mil_ordenados_hs.txt");
    //FileWriter novo_dados = new FileWriter("C:\\Users\\richa\\OneDrive\\Área de Trabalho\\AtividadesEDII\\Atividade5\\dados_ordenados\\8-dados100_mil_pior_caso_ordenados_hs.txt");
    //FileWriter novo_dados = new FileWriter("C:\\Users\\richa\\OneDrive\\Área de Trabalho\\AtividadesEDII\\Atividade5\\dados_ordenados\\9-dados500_mil_ordenados_hs.txt");
    PrintWriter gravarDados = new PrintWriter(novo_dados);
    for (int j=0; j<vetor.length; j++) {
        gravarDados.print(vetor[j] + ", ");
    }
    gravarDados.close();
}

}
