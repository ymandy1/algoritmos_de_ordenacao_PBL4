import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main extends SortAlgorithms {

    public static void main(String[] args) throws FileNotFoundException {
        String[] arquivos = {
                "aleatorio_100.csv", "aleatorio_1000.csv", "aleatorio_10000.csv",
                "crescente_100.csv", "crescente_1000.csv", "crescente_10000.csv",
                "decrescente_100.csv", "decrescente_1000.csv", "decrescente_10000.csv"
        };

        for (String nomeArquivo : arquivos) {
            File arquivo = new File("src/dados/" + nomeArquivo);

            List<Integer> lista = new ArrayList<>();
            Scanner scanner = new Scanner(arquivo);

            while (scanner.hasNextLine()) {
                String linha = scanner.nextLine().trim();
                if (!linha.isEmpty() && !linha.contains("Value")) {
                    lista.add(Integer.parseInt(linha));
                }
            }

            scanner.close();

            int[] original = lista.stream().mapToInt(i -> i).toArray();

            int[] bubble = original.clone();
            int[] insertion = original.clone();
            int[] quick = original.clone();

            System.out.println("\nArquivo: " + nomeArquivo);

            long inicioBubble = System.nanoTime();
            bubbleSort(bubble);
            long fimBubble = System.nanoTime();
            System.out.printf("Resultado de tempo de processamento do Bubble Sort: %.2f ms\n", (fimBubble - inicioBubble) / 1e6);

            long inicioInsertion = System.nanoTime();
            insertionSort(insertion);
            long fimInsertion = System.nanoTime();
            System.out.printf("Resultado de tempo de processamento do Insertion Sort: %.2f ms\n", (fimInsertion - inicioInsertion) / 1e6);

            long inicioQuick = System.nanoTime();
            quickSort(quick, 0, quick.length - 1);
            long fimQuick = System.nanoTime();
            System.out.printf("Resultado de tempo de processamento do Quick Sort: %.2f ms\n", (fimQuick - inicioQuick) / 1e6);
        }
    }
}