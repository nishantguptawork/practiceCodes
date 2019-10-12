import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        /**
         * Problem: Find all pairs of elements in given array for given sum
         * Input: [1,2,3,4,5], sum = 5
         * Output: [(1,2),(1,4)]
         */
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        try {
            int[] inputArray = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int sum = Integer.parseInt(in.readLine());
            Map<Integer,Integer> map = new HashMap<>();
            for(int i=0;i<inputArray.length;++i){
                int element = inputArray[i];
                if(map.containsKey(sum-element)){
                    System.out.printf("Pair found with given sum (%d,%d)\n",map.get(sum-element),element );
                }
                map.put(element,i);
            }
        } catch(IOException ex){
            System.out.println("Error while reading input.");
        }
    }
}
