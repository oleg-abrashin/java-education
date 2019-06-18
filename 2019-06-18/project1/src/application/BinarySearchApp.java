package application;

public class BinarySearchApp {

    public static void main(String[] args) {

    }

    public static int binarySearch(int[] arr, int value){
        if (value < arr[0]) return -1;
        if (value > arr[arr.length -1]) return -1-arr.length;

        if(value == arr[0]) return 0;
        if(value == arr[arr.length - 1]) return arr.length - 1;

        int left = 0;
        int right = arr.length - 1;

        while (right - left > 1){
            int middle = (right + left) / 2;
            if(arr[middle] == value)return  middle;
            if(arr[middle] > value) right = middle;
        }

        return 0;
    }

}
