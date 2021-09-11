import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayOps {

    // Arrays.toString(a)
    // Arrays.copyOf(a, newSize)
    // Arrays.copyOfRange(a, start, end)
    // Arrays.sort()
    // Arrays.binarySearch(a, value)
    // Arrays.binarySearch(a, start, end, value)
    // Arrays.asList(a)
    // Arrays.compare(a, b)
    // Arrays.mismatch(a, b)

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7};

        int[] b = new int[10];
        for (int i = 0; i < 10; i++) {
            b[i] = i+1;
        }

        int[] arr = {1, 2, 3, 4, 5, 6, 7};

        // Iterate // length
        for (int i = 0; i < arr.length; i++) {
            System.out.println(String.format("%s -> %s", i, arr[i]));
        }
        // Add // Update (only to existing position)
        arr[0] = 100;
        // Remove (cannot be directly deleted, use placeholder, flag or new copy)

        int[] arr2 = new int[5];
        // Iterate on un-initalized array // toString
        System.out.println(Arrays.toString(arr2));

        // Arrays.copyOf(arr, newSize)
        int[] arr3 = Arrays.copyOf(arr, arr.length+1);
        System.out.println(Arrays.toString(arr3));

        // Arrays.copyOfRange(arr, from, to)
        int[] arr4 = Arrays.copyOfRange(arr, 1, 4);
        System.out.println(Arrays.toString(arr4));

        // Arrays.binarySearch(arr, key) // sort
        int[] arr5 = {7, 1, 44, 0};
        Arrays.sort(arr5);
        System.out.println(Arrays.toString(arr5));
        int r1 = Arrays.binarySearch(arr5, 44);
        System.out.println(r1);
        System.out.println(Arrays.binarySearch(arr5, 2));
        System.out.println(Arrays.binarySearch(arr5, 100));

        // Arrays.binarySearch(arr, from, to, key)
        System.out.println(Arrays.binarySearch(arr5, 1, 3, 7));
        System.out.println(Arrays.binarySearch(arr5, 1, 3, 44));

        // asList
        Integer[] arr6 = {1, 2, 3};
        List<Integer> arr6List = Arrays.asList(arr6);
        System.out.println(arr6List);
        System.out.println(arr6List.getClass());
        arr6List = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println(arr6List);
        System.out.println(arr6List.getClass());
        arr6List = new ArrayList<>(Arrays.asList(1, 2, 3));
        System.out.println(arr6List);
        System.out.println(arr6List.getClass());

        // compare
        int[] arr7 = {1, 2, 3};
        int[] arr8 = {1, 2, 3, 4, 5};
        int[] arr9 = {1, 2, 3};
        System.out.println(Arrays.compare(arr7, arr9));
        System.out.println(Arrays.compare(arr7, arr8));
        System.out.println(Arrays.compare(arr8, arr9));

        // mismatch
        System.out.println(Arrays.mismatch(arr7, arr9));
        System.out.println(Arrays.mismatch(arr7, arr8));
        System.out.println(Arrays.mismatch(arr8, arr9));
    }
}
