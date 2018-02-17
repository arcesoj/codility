import java.util.Arrays;

/**
 * Created by josearce on 11/26/17.
 */
public class Lesson4_counting_elements {

    public static void main(String[] args) {
       // PermCheck();
       // FrogRiverOne();
        System.out.println(MaxCounters().toString());
    }

    public static int MissingInteger(){

        /*int[] A = new int[1000000];

        for (int i = 0; i < A.length; i++){
            A[i] = i;
        }

        A[1000000 - 1] = 2;*/

        int[] A = {1};

        int length = A.length;
        boolean[] b = new boolean[length + 1];
        boolean majorToOne = false;

        for(int i = 0; i < length; i++){
            int value = A[i];

            if(value >= 1 && value <= length) {
                if (!b[value]) {
                    b[value] = true;
                } else if (b[value]) {
                    //repetido
                }

                majorToOne = true;
            }
        }

        if(majorToOne){
            int value = -1;
            boolean hasFalse = false;

            for(int i = 1; i < length; i++){
                if(!b[i]){
                    value = i;
                    hasFalse = true;
                    break;
                }
            }

            if(!hasFalse){
                return ++length;
            }

            return value;
        }

        return 1;
    }

    public static int[] MaxCounters(){

        int A[] = new int[7];
        A[0] = 3;
        A[1] = 4;
        A[2] = 4;
        A[3] = 6;
        A[4] = 1;
        A[5] = 4;
        A[6] = 4;

        int N = 5;
        int[] B = new int[N];
        int max = 0;
        int length = A.length;

        for(int i = 0; i < length; i++){

            int value = A[i];
            if(value > N) {
                for(int j = 0; j < N; j++){
                    B[j] = max;
                }
            } else {
                value = value - 1;
                B[value] = B[value] + 1;
                if(max < B[value]){
                    max = B[value];
                }
            }
        }

        return B;
    }

    public static int PermCheck(){

        int A[] = new int[4];
        A[0] = 1;
        A[1] = 2;
        A[3] = 3;
        A[2] = 4;

        int valueMissing = 1;
        Arrays.sort(A);

        for(int i = 0; i < A.length; i++){
            if(A[i] != i + 1){
                valueMissing = 0;
                break;
            }
        }

        return valueMissing;
    }

    public static int FrogRiverOne(){

        int X = 6;
        int A[] = new int[8];
        A[0] = 1;
        A[1] = 3;
        A[2] = 1;
        A[3] = 4;
        A[4] = 2;
        A[5] = 3;
        A[6] = 4;
        A[7] = 5;

        int seconds = -1;
        int length = A.length;

        for(int i = 0; i < length; i++) {
            if(A[i] >= X){
                seconds = i;
                break;
            }
        }

        boolean[] bitmap = new boolean[X + 1];
        for(int i = 0; i < A.length; i++){

            System.out.println("Step: "+X+" i "+A[i]);

            if(!bitmap[A[i]]){
                bitmap[A[i]] = true;
                X--;
            }

            if(X == 0) return i;
        }
        return -1;
    }

}
