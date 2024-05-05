public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        int[] arr = {49, 34, 45, 67, 14, 15, 6, 8, 10};
        
        int n = arr.length;

        mergeSort(arr, 0, n - 1);

        System.out.println("Arreglo ordenado:");

        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }    

    private static void merge(int[] arr, int left, int mid, int right) {
        int sizeLeft = mid - left + 1;
        int sizeRight = right - mid;

        int[] tempLeft = new int[sizeLeft];
        int[] tempRight = new int[sizeRight];

        for (int i = 0; i < sizeLeft; i++) {
            tempLeft[i] = arr[left + i]; // Corregido aquí
        }

        for (int j = 0; j < sizeRight; j++) {
            tempRight[j] = arr[mid + 1 + j];
        }

        int i = 0, j = 0;
        int k = left;

        while (i < sizeLeft && j < sizeRight) {
            if (tempLeft[i] <= tempRight[j]) {
                arr[k] = tempLeft[i];
                i++;
            } else {
                arr[k] = tempRight[j];
                j++;
            }
            k++;
        }

        while (i < sizeLeft) {
            arr[k] = tempLeft[i];
            i++;
            k++;
        }

        while (j < sizeRight) {
            arr[k] = tempRight[j];
            j++;
            k++;
        }
    }    
}
