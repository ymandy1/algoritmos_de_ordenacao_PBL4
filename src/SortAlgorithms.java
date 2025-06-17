//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

public class SortAlgorithms {
    public SortAlgorithms() {
    }

    public static void insertionSort(int[] array) {
        for(int i = 1; i < array.length; ++i) {
            int key = array[i];

            int j;
            for(j = i; j > 0 && array[j - 1] > key; --j) {
                array[j] = array[j - 1];
            }

            array[j] = key;
        }

    }

    public static void bubbleSort(int[] array) {
        for(int i = 0; i < array.length - 1; ++i) {
            boolean swapped = false;

            for(int j = 0; j < array.length - 1 - i; ++j) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            }
        }

    }

    public static void quickSort(int[] array, int start, int end) {
        if (start < end) {
            int pivotIndex = partition(array, start, end);
            quickSort(array, start, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, end);
        }

    }

    private static int partition(int[] array, int start, int end) {
        int pivot = array[end];
        int i = start - 1;

        int j;
        for(j = start; j < end; ++j) {
            if (array[j] <= pivot) {
                ++i;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        j = array[i + 1];
        array[i + 1] = array[end];
        array[end] = j;
        return i + 1;
    }
}
