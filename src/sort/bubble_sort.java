package sort;
// BigO = O(n^2)
// bubble sort = pairs of adjacent elemetns are compared, and the elemetns swapped if they are not in order.

//               small data set = okay-ish
//               large data set = bad
public class bubble_sort {
    public static void main(String[] args) {
            int array[] = {9,1,8,2,7,3,6,4,5};
            bubbleSort(array);

            for(int i : array){
                System.out.print(i);
            }
    }

    private static void bubbleSort(int[] array) {
        for(int i = 0; i <= array.length - 1; i++){
            for(int j = i + 1; j <= array.length - 1 ; j++){
                if(array[i] < array[j]){
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }
}
