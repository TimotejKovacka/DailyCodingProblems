// This problem was asked by Stripe.
// Given an array of integers, find the first missing positive integer in linear time and constant space. 
// In other words, find the lowest positive integer that does not exist in the array. The array can contain duplicates and negative numbers as well.
// For example, the input [3, 4, -1, 1] should give 2. The input [1, 2, 0] should give 3.
// You can modify the input array in-place

import java.util.ArrayList;

public class Problem4{
    public static int solution(ArrayList<Integer> list){
        ArrayList<Integer> positive = new ArrayList<>();
        for (int i : list) {
            if (i > 0) positive.add(i);
        }
        for (int i = 0; i < positive.size(); i++){
            int absolute = Math.abs(positive.get(i));
            if (absolute -1 < positive.size() && positive.get(absolute-1) > 0) positive.set(absolute-1, -positive.get(absolute-1));
        }
        for (int i = 0; i < positive.size(); i++){
            if (positive.get(i) > 0) return i+1;
        }
        return positive.size() + 1;
    }
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < args.length; i++){
            list.add(Integer.parseInt(args[i]));
        }
        System.out.print(Problem4.solution(list));
        
    }
}