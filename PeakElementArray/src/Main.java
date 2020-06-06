public class Main {

//    // Recursive with errors
//    private static boolean isPeak(int[] arr, int index){
//        if(index == 0 && arr.length!=1 && arr[index] < arr[index+1])
//            return true;
//        else if(index == arr.length-1 && arr[index] > arr[index-1])
//            return true;
//        else if(arr[index]> arr[index-1] && arr[index] > arr[index+1])
//            return true;
//        else
//            return false;
//    }
//
//
//    private static int peakElementUtil(int[] arr, int start, int end){
//        if(start<end) {
//            int mid = (start + end) / 2;
//            if (isPeak(arr, mid))
//                return mid;
//            else if (arr[mid] < arr[mid + 1])
//                return peakElementUtil(arr, mid + 1, end);
//            else
//                return peakElementUtil(arr, start, mid - 1);
//        }
//        else
//            return -1;
//    }
//
//    public static int peakElement(int[] arr){
//        return peakElementUtil(arr, 0,arr.length);
//    }


    public static int peakElement(int[] arr){
        if(arr.length==1)
            return arr[0];
        int start = 0;
        int end = arr.length-1;
        while(start<end){
            int mid = ( start + end ) /2 ;
            if(arr[mid] > arr[mid+1] && arr[mid]>arr[mid-1])
                return arr[mid];
            else if(arr[mid]<arr[mid+1])
                start = mid+1;
            else
                end = mid-1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {4,3,5,1};
        int peak = peakElement(arr);
        System.out.format("Peak element for array is %d",arr[peak]);
        System.out.println("Hello World!");
    }
}
