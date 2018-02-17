import java.util.Arrays;

/**
 * Created by josearce on 12/20/17.
 */
public class Lesson16_Greedy_Algorithms {

    public static void main(String[] args) {

        int[] A = {1,3,7,9,9};
        int[] B = {5,6,8,9,10};

        //System.out.println(MaxNonoverlappingSegments(A, B));

        int[] M = {1,2,5};
        int K = 6;
        System.out.println(Arrays.toString(greedyCoinChanging(M, K)));
    }

    static int[] greedyCoinChanging(int[] M, int K){

        int n = M.length;
        int[] result = new int[n];

        for(int i = n - 1; K != 0; i--){
            result[i] += K / M[i];
            K %= M[i];
        }

        return result;

    }

    static int MaxNonoverlappingSegments(int[] A, int[] B){

        int x2 = 0;
        int count = 0;

        if(A.length == 0){
            return 0;
        }

        if(A.length == 1){
            return 1;
        }

        for(int i = 0; i < A.length; i++){
            if(A[i] > x2){
                x2 = B[i];
                count++;
            }
        }

        return count;
    }

}
