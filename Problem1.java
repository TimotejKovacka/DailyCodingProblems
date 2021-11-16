import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

// This problem was recently asked by Google.
// Given a list of numbers and a number k, return whether any two numbers from the list add up to k.
// For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.
// Bonus: Can you do this in one pass?


public class Problem1{
    // This solution would run in O(n) for a single pass of a list but we would have to consider time complexity of sorting
    public static boolean solution(ArrayList<Integer> list, int k){
        Collections.sort(list);
        for (int i = 0, j = list.size()-1; i<j;){
            int sum = list.get(i)+list.get(j);
            if (sum < k) i++;
            else if (sum > k) j--;
            else return true;
        }
        return false;
    }
    public static void printAnswer(boolean state){
        if (state) System.out.println("true");
        else System.out.println("false");
    }

    public static void main(String args[]) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(10, 15, 3, 7));
        Problem1.printAnswer(Problem1.solution(list, 17));
    }
}