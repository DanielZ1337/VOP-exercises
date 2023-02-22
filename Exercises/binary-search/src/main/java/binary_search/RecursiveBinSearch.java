package binary_search;

public class RecursiveBinSearch {
    public static int recursiveFind(int[] list, int key) {
        int low = 0;
        int high = list.length - 1;
        return recursiveFind(list, key, low, high);
    }

    public static int recursiveFind(int[] list, int key,
                                    int low, int high) {
        if (low > high) // The list has been exhausted without a match
        {
            return -low - 1;
        }

        int mid = (low + high) / 2;
        if (key < list[mid]) {
            return recursiveFind(list, key, low, mid - 1);
        } else if (key == list[mid]) {
            return mid;
        } else {
            return recursiveFind(list, key, mid + 1, high);
        }
    }
}
