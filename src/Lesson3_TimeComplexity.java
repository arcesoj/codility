import java.util.Arrays;

/**
 * Created by josearce on 11/16/17.
 */
public class Lesson3_TimeComplexity {

    public static void main(String[] args) {

        System.out.println(FrogJmpPro(1,5,2));
        System.out.println(FrogJmpPro(5,105,3));
        System.out.println(FrogJmpPro(10,85,30));

        /*
        int[] A = { 3, 1, 2, 4, 3};
        //tapeEquilibrium(A);

        int[] B = { 2, 3, 1, 5};
        //permMissingElem(B);

        FrogJmp(10, 70, 30);
        */
    }

    public static int FrogJmpPro( int X, int Y, int D){

        int diff = Y - X;
        double div = (double) diff / D;
        int num = (int) div;
        double rest = Math.abs(num - div);

        if(rest > 0) {
            return ++num;
        }

        //System.out.println(num+" "+div);

        return num;
    }

    public static int tapeEquilibriumPro(int[] A) {

        int length = A.length;
        int minusSaved = -1;

        int sumArray = 0;
        int acomulado = A[0];
        int minimun = -1;

        for(int i = 0; i < length; i++){
            sumArray += A[i];
        }

        sumArray = sumArray - acomulado;

        for(int i = 0; i < length; i++){

            int rest =  Math.abs(acomulado - sumArray);

            if(rest < minimun || i == 0){
                minimun = rest;
            }

            acomulado += A[i + 1];
            sumArray -= A[i + 1];
        }

        return minimun;
    }

    public static int permMissingElem(int[] B){

        int length = B.length;
        int[] C = Arrays.copyOf(B, length);
        Arrays.sort(C);

        int numberMissed = -1;
        for (int i = 1; i < length + 1; i++){

            int c = i - 1;
            if(i != C[c]) {
                numberMissed = i;
                break;
            }
        }

        return numberMissed;
    }

    public static int FrogJmp(int X, int Y, int D){

        int numberJump = 0;
        int currentPosition = X;

        while (currentPosition < Y) {
            currentPosition = currentPosition + D;
            System.out.println(currentPosition);
            numberJump++;
        }

        return numberJump;
    }
}
