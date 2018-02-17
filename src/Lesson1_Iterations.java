import java.util.ArrayList;

/**
 * Created by josearce on 11/13/17.
 */
public class Lesson1_Iterations {

    public static void main(String[] args) {
        // Prints "Hello, World" to the terminal window.
        solution(1041);
    }

    public static int solution(int N) {
        // write your code in Java SE 8
        int n = N;
        int count = 0;
        ArrayList<Integer> ceros = new ArrayList<>();

        while(n > 0){
            int a = n % 2;
            if(a == 0){
                count++;
            } else {
                ceros.add(count);
                count = 0;
            }
            n = n / 2;
        }

        int size = ceros.size();
        int max = 0;
        for (int counter = 1; counter < size; counter++) {
            int value = ceros.get(counter);
            if (value > max){
                max = value;
            }
        }

        return max;
    }
}
