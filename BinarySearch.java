public class BinarySearch {

    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid; // Return the index of the target element if found
            } else if (arr[mid] < target) {
                left = mid + 1; // Continue searching in the right half
            } else {
                right = mid - 1; // Continue searching in the left half
            }
        }

        return -1; // Return -1 if target element is not found in the array
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 7, 9};
        int target = 7;
        int index = binarySearch(arr, target);
        if (index != -1) {
            System.out.println("Element " + target + " found at index " + index + " using binary search.");
        } else {
            System.out.println("Element " + target + " not found in the array using binary search.");
        }
    }
}

/*
* Time Complexity:
Linear Search: O(n) - Linear search has a time complexity of O(n) because it has to potentially iterate through all n elements of the array in the worst case scenario.
Binary Search: O(log n) - Binary search has a time complexity of O(log n) because it repeatedly halves the search interval in each iteration, resulting in a logarithmic time complexity.
Use Cases:
Linear Search:
Use linear search when the array is not sorted or when you need to find the first occurrence of an element.
Suitable for small arrays or when the array is unordered.
Binary Search:
Use binary search when the array is sorted.
Ideal for large sorted arrays where efficiency is crucial.
Useful in scenarios where repeated searching needs to be performed on the same sorted array.
* */