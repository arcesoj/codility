/**
 * Created by josearce on 12/17/17.
 */
public class Lesson12_Euclidean_algorithm {

    public static void main(String[] args) {
        System.out.println(ChocolatesByNumbers(10, 4));
        System.out.println(ChocolatesByNumbers(947853, 4453));
        System.out.println(ChocolatesByNumbers(24, 18));
        System.out.println(ChocolatesByNumbers(1, 1));
    }

    static long ChocolatesByNumbers(int N, int M) {

        long result;
        long X = M;
        int count = 1;

        result = X % N;

        while(result != 0) {

            X += M;
            result = X % N;

            ++count;
        }

        return count;
    }

    static int pro(int x, int count, int n, int m, int result){

        if(result == 0){
            return count;
        }

        return pro((x + m), ++count, n, m,  x % n);
    }

}
