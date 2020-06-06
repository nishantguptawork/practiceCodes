import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static void findAllZeroSumSubArrays(final int[] arr){
        Map<Integer,List<Integer>> multiValueMap = new HashMap<>();
        int sum = 0;
        List<Integer> zeroIndexList = new ArrayList<>();
        zeroIndexList.add(-1);
        multiValueMap.put(0,zeroIndexList);
        System.out.printf("\nAll sub arrays with sum=0 are: \n",sum);
        for(int i=0;i<arr.length;++i){
            if(multiValueMap.containsKey(sum += arr[i])){
                // Fetch all starting indices with that sum
                List<Integer> startingIndices = multiValueMap.get(sum);
                for(int startIndex : startingIndices) {
                    System.out.printf("Sub array with sum=0 present between indices: (%d,%d)\n",startIndex+1,i );
                }
                //insert the new index to multimap for that sum
                multiValueMap.get(sum).add(i);
            }
            //create a new list with that index and add it to multimap
            List<Integer> newList = new ArrayList<>();
            newList.add(i);
            multiValueMap.put(sum,newList);
        }
    }


    private static void findAllSubArraysWithGivenSum(final int[] arr, int sum){
        Map<Integer,List<Integer>> multiValueMap = new HashMap<>();
        int sumTillNow = 0;
        List<Integer> zeroIndexList = new ArrayList<>();
        zeroIndexList.add(-1);
        multiValueMap.put(0,zeroIndexList);
        System.out.printf("\nAll sub arrays with given sum=%s are: \n",sum);
        for(int i=0;i<arr.length;++i){
            sumTillNow += arr[i];
            if(multiValueMap.containsKey(sumTillNow-sum)){
                // Fetch all starting indices with that sumTillNow
                List<Integer> startingIndices = multiValueMap.get(sumTillNow-sum);
                for(int startIndex : startingIndices) {
                    System.out.printf("Sub array with sum=%d present between indices: (%d,%d)\n",sum,startIndex+1,i );
                }
                //insert the new index to multimap for that sumTillNow
                List<Integer> getIndices = multiValueMap.get(sumTillNow);
                if(getIndices==null){
                    List<Integer> newList = new ArrayList<>();
                    newList.add(i);
                    multiValueMap.put(sumTillNow,newList);
                } else{
                    getIndices.add(i);
                }
            }
            //create a new list with that index and add it to multimap
            List<Integer> newList = new ArrayList<>();
            newList.add(i);
            multiValueMap.put(sumTillNow,newList);
        }
    }

    public static void main(String[] args) {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Enter the array: ");
            int[] inputArray = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            System.out.println("Enter the sum: ");
            int sum = Integer.parseInt(in.readLine());
            findAllZeroSumSubArrays(inputArray);
            findAllSubArraysWithGivenSum(inputArray, sum);
        }catch(IOException ex){
            System.out.printf("Error occured while reading input. %s", ex.getMessage());
        }

    }
}
