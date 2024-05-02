public class LinearSearch {

    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i; // Return the index of the target element if found
            }
        }
        return -1; // Return -1 if target element is not found in the array
    }

    public static void main(String[] args) {
        int[] arr = {5, 9, 3, 7, 2};
        int target = 7;
        int index = linearSearch(arr, target);
        if (index != -1) {
            System.out.println("Element " + target + " found at index " + index + " using linear search.");
        } else {
            System.out.println("Element " + target + " not found in the array using linear search.");
        }
    }
}
