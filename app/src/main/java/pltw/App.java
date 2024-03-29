/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package pltw;

public class App {
    public static void main(String[] args) {
        final int SIZE = 10000;
        final int RANGE = 100000;

        int[] arr = new int[SIZE];

        for (int i = 0; i < SIZE; i++)
            arr[i] = (int)(Math.random() * RANGE) + 1;

        // search for a random array element
        int intSearch = arr[(int)(Math.random() * SIZE)];

        long startTime = System.nanoTime();
        mergeSort(arr, 0, arr.length - 1);
        int result = binarySearch(arr, intSearch);
        long endTime = System.nanoTime();

        System.out.println("target: " + intSearch);
        System.out.println("found: " + result);
        System.out.println("in: " + (endTime - startTime));
        System.out.println("corect: " + (arr[result] == intSearch));
    }

    /**
   * Sorts arr[l..r] using merge()
   */
    public static void mergeSort(int arr[], int lt, int rt) { 
        if (lt < rt) { 
            // Find the middle point 
            int m = (lt + rt) / 2; 

            // Sort first and second halves 
            mergeSort(arr, lt, m); 
            mergeSort(arr , m + 1, rt); 

            // Merge the sorted halves 
            merge(arr, lt, m, rt); 
        } 
    } 

    /*
   * Helper method for mergeSort
   */
    private static void merge(int arr[], int lt, int m, int rt) { 
        // Find sizes of two subarrays to be merged 
        int n1 = m - lt + 1; 
        int n2 = rt - m; 

        // Create temp arrays 
        int left[] = new int[n1]; 
        int right[] = new int[n2]; 

        // Copy data to temp arrays
        for (int i = 0; i < n1; ++i) 
        left[i] = arr[lt + i]; 
        for (int j = 0; j < n2; ++j) 
        right[j] = arr[m + 1 + j]; 

        /* merge the temp arrays */

        // Initial indexes of first and second subarrays 
        int i = 0;
        int j = 0; 

        // Initial index of merged subarry array 
        int k = lt; 
        while (i < n1 && j < n2) { 
            if (left[i] <= right[j]) { 
                arr[k] = left[i]; 
                i++;
            }
            else { 
                arr[k] = right[j]; 
                j++; 
            } 
            k++; 
        } 

        // Copy remaining elements of L[] if any
        while (i < n1) { 
            arr[k] = left[i]; 
            i++; 
            k++; 
        } 

        // Copy remaining elements of R[] if any 
        while (j < n2) { 
            arr[k] = right[j]; 
            j++; 
            k++; 
        } 
    }

    static int binarySearch(int[] arr, int x) {
        int l = 0;
        int r = arr.length - 1;

        while(l <= r) {
            int m = (l + r) / 2;

            if(arr[m] == x) {
                return m;
            } else if(arr[m] > x) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        return -1;
    }
}
