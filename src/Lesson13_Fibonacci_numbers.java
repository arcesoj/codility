import java.util.Arrays;

/**
 * Created by josearce on 12/17/17.
 */
public class Lesson13_Fibonacci_numbers {

    public static void main(String[] args) {

        int L = 5;
        int[] A = {4,4,5,5,1};
        int[] B = {3,2,4,3,1};

        System.out.println(Arrays.toString(Ladder(A,B,L)));

    }

    static int[] Ladder(int[] A, int[] B, int L){

        int[] result = new int[L];

        for(int i = 0; i < L; i++){
            int j = (int) Math.pow(2, B[i]);
            result[i] = fibonacciDynamic(A[i] += 2) % j;
        }

        return result;
    }

    static int fibonacciDynamic(int n){

        int[] result = new int[n];

        result[0] = 0;
        result[1] = 1;

        for(int i = 2; i < n; i++) {
            result[i] = result[i - 1] + result[i - 2];
        }

        return result[n - 1];
    }

}
