// This problem was asked by Uber.
// Given an array of integers, return a new array such that each element at index i of the new array is the product of all the numbers in the original array except the one at i.
// For example, if our input was [1, 2, 3, 4, 5], the expected output would be [120, 60, 40, 30, 24]. If our input was [3, 2, 1], the expected output would be [2, 3, 6].
// Follow-up: what if you can't use division?



public class Problem2{
    public static int[] solution(int[] list){
        int[] output = list.clone(); // O(n) to clone
        int multiplied = 1;
        for(int i : list){ // O(n) to get product of all elements
            multiplied *= i;
        }
        for (int i = 0; i<output.length; i++){ // O(n) to calculate every element with division
            output[i] = multiplied / output[i];
        }
        return output; // Overall O(3n) = O(n)
    }
    public static void main(String[] args) {
        int[] list = new int[args.length];
        for (int i = 0; i < args.length; i++){
            list[i] = Integer.parseInt(args[i]);
        }
        for (int i : Problem2.solution(list)){
            System.out.println(i);
        }
        
    }
}