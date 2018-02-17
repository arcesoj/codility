/**
 * Created by josearce on 12/16/17.
 */
public class Lesson5_PrefixSums {

    public static void main(String[] args) {
        //System.out.println(readingMaterial());
        //System.out.println(CountDiv());
        //System.out.println(sum_count(1, 10));
        System.out.println(PassingCars());
    }

    static int PassingCars() {

        int[] A = {0,1,0,1,1};
        int firstCero = -1;
        int firstOne = -1;
        int sumOne = 0;

        for (int i = 0; i < A.length; i++) {

            if(firstCero == -1 && A[i] == 0) {
                firstCero = i;
            }

            if(firstOne == -1 && A[i] == 1 && firstCero >= 0) {
                firstOne = i;
            }

            if(firstCero >= 0 && A[i] == 1){
                sumOne += 1;
            }
        }

        if(firstCero >= 0){
            int posibi = 0;
            int otherCero = 0;
            for(int i = firstCero; i < A.length; i++){

                if(A[i] == 0) {
                    posibi += sumOne - otherCero;

                    if(posibi > 1000000000){
                        break;
                    }
                } else {
                    otherCero++;
                }

            }

            if(posibi > 1000000000){
                return -1;
            }

            return posibi;
        }

        return 0;
    }

    /*
    static int PassingCars(){

        int[] A = {0,0,0,1,1};
        int count = 0;

        for(int i = 0; i < A.length; i++){

            if(A[i] == 0) {

                for(int j = i; j < A.length; j++){

                    if(A[j] == 1) {
                        count++;
                    }

                }
            }

            if(count > 1000000000){
                break;
            }
        }

        return count;
    }
    */

    static int CountDiv(){

        int A = 6;
        int B = 11;
        int K = 2;
        int count = 0;
        int L = B - A;

        for(int i = 0; i < L + 1; i++){

            int j = A + i;
            System.out.println(j);

            if(j % K == 0){
                count++;
            }

        }

        return count;
    }

    static int sum_count(int i, int j){

        int L = 11;
        int[] aux = new int[L];
        int[] arr = new int[L];

        for(int r = 0; r < L; r++){
            arr[r] = r;
        }

        aux[0] = 0;
        for(int k = 1; k < L; k++) {
            aux[k] = aux[k - 1] + arr[k];
        }

        return aux[j] - aux[i - 1];
    }

    /*
    def mushrooms(A, k, m):
    2 n = len(A)
    3 result = 0
    4 pref = prefix_sums(A)
    5 for p in xrange(min(m, k) + 1):
    6 left_pos = k - p
    7 right_pos = min(n - 1, max(k, k + m - 2 * p))
    8 result = max(result, count_total(pref, left_pos, right_pos))
    9 for p in xrange(min(m + 1, n - k)):
    10 right_pos = k + p
    11 left_pos = max(0, min(k, k - (m - 2 * p)))
    12 result = max(result, count_total(pref, left_pos, right_pos))
    13 return result

     */

    public static int readingMaterial(){

        int[] A = { 0, 0, 7, 5, 0, 0, 9};
        int K = 4;
        int M = 6;

        int result = 0;
        int n = A.length;
        int pref = prefix_sums(A);

        int rangeA = min(M, K) + 1;

        for(int i = 0; i < rangeA; i++) {
            int left_pos = K - i;
            int right_pos = min(n-1, max(K, K + M - 2 * i));
            result = max(result, count_total(pref, left_pos, right_pos, A));
        }

        int rangeB = min(M + 1, n - K);

        for(int j = 0; j < rangeB; j++){
            int right_pos = K + j;
            int left_pos = max(0, min(K, K - (M - 2 * j)));
            result = max(result, count_total(pref, left_pos, right_pos, A));
        }

        return result;
    }

    static int count_total(int a, int b, int c, int[] A){

        int count = 0;

        for(int i = b; i < c; i++){
            count += A[b];
        }

        return count;
    }

    static int min(int a, int b){
        return (a < b) ? a : b;
    }

    static int max(int a, int b ){
        return (a > b) ? a : b;
    }

    static int prefix_sums(int[] A){

        int sum = 0;

        for(int i = 0; i < A.length; i++){
            sum += A[i];
        }

        return sum;
    }
}
