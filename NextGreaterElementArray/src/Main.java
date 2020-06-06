import java.util.Stack;

public class Main {
    public static void nextGreaterElementArray(final int[] arr){
        Stack<Integer> stack = new Stack();
        for(int i=0;i<arr.length;++i){
            // Pop and check condition
            while(!stack.isEmpty() && stack.peek() < arr[i]){
                System.out.format("Next greater element for %d is %d.%n",stack.pop(),arr[i]);
            }
            stack.push(arr[i]);
        }
        while(!stack.isEmpty()){
            System.out.format("Next greater element for %d is %d.%n", stack.pop(), null);
        }
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
        int[] arr = new int[]{10,4,3,5};
        nextGreaterElementArray(arr);
        int[] arr2 = new int[]{4,3,2,1};
        nextGreaterElementArray(arr2);
    }
}
