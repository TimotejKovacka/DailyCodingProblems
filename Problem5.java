// This problem was asked by Jane Street.
// cons(a, b) constructs a pair, and car(pair) and cdr(pair) returns the first and last element of that pair. For example, car(cons(3, 4)) returns 3, and cdr(cons(3, 4)) returns 4.
// Given this implementation of cons:
// def cons(a, b):
//     def pair(f):
//         return f(a, b)
//     return pair
// Implement car and cdr.

public class Problem5{
    
    public class Tuple {
        public final int x;
        public final int y;
        public Tuple(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public Tuple cons (int x, int y) {
        return new Tuple(x, y);
    }
    public static int car(Tuple pair) {
        return pair.x;
    }

    public static int cdr(Tuple pair) {
        return pair.y;
    }

    public static void printAnswer(boolean state){
        if (state) System.out.println("true");
        else System.out.println("false");
    }

    public static void main(String[] args) {
        Problem5 problem = new Problem5();
        Problem1.printAnswer(car(problem.cons(3, 4)) == 3);
        Problem1.printAnswer(cdr(problem.cons(3, 4)) == 4);
    }
}