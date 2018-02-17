import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by josearce on 11/13/17.
 */
public class Lesson2_Arrays {

    public static void main(String[] args) {
        // Prints "Hello, World" to the terminal window.

        int[] A =  { 9, 3, 9, 3, 9, 7, 9};
        OddOccurrencesInArrayPro(A);

        int[] B =  { 1, 2, 3, 4, 5};
        //{ 1, 9, 3, 9, 3, 9, 7};
        //{ 7, 1, 9, 3, 9, 3, 9};
        //{ 9, 7, 1, 9, 3, 9, 3};

        //CyclicRotation(B, 3);
    }

    public static int OddOccurrencesInArrayPro(int[] A){

        int n = A.length;
        int value = 0;

        System.out.println("Value: " +(3^1) );

        for(int i = 0; i < n; i++){
            value ^= A[i];
            System.out.println("Value: "+value+"    A["+i+"] ="+A[i]);
        }

        return value;
    }


    public static int OddOccurrencesInArray(int[] A) {
        ArrayList<Integer> pairs = new ArrayList<>();

        for(int value : A) {
            int count = 0;
            if (!pairs.contains(value)) {
                for (int repeated : A) {
                    if (value == repeated) {
                        count++;
                        if (count > 1) {
                            pairs.add(value);
                            break;
                        }
                    }
                }
            }
        }

        System.out.println(" Pairs :"+ pairs);

        int odd = -1;

        for(int value : A) {
            if(!pairs.contains(value)){
                odd = value;
            }
        }

        return odd;
    }

    public static int[] CyclicRotation(int[] A, int K) {

        int length = A.length;
        int[] B = Arrays.copyOf(A, length);

        for(int i = 0; i <= K; i++){

            B[0] = A[length - 1];

            for (int j = 1; j < length; j++) {
                B[j] = A[j - 1];
            }

            A = Arrays.copyOf(B, length);
        }

        return B;
    }

}
