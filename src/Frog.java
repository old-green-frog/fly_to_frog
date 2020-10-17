import java.util.Scanner;
import java.util.Arrays;


public class Frog {
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);

        System.out.print("Введите размер матрицы: ");
        int size = input.nextInt();

        float[][] matrix = new float[size][size];
        
        for (int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                System.out.printf("Введите элемент %d%d : ", i+1, j+1);
                matrix[i][j] = input.nextFloat();
            }
        }
        System.out.println("\n= " + gauss(matrix, size));
    }


    private static float result = 1;

    
    public static float gauss(float[][] arr, int size) {

        if (arr[0][0] == 0) {
            float[] empty = Arrays.copyOf(arr[0], size);
            arr[0] = arr[1];
            arr[1] = empty;
            result *= -1;
        }

        if (size == 1) {

            result *= arr[0][0];
            return result;

        }

        float match = arr[0][0];
        float[][] copyArr = new float[size-1][size-1];

        for (int i = 1; i < size; i++)
            for (int j = 1; j < size; j++)
                arr[i][j] -= arr[i][0] * arr[0][j] / match;


        for(int i = 1; i < size; i++)
            copyArr[i - 1] = Arrays.copyOfRange(arr[i], 1, size);


        return gauss(copyArr, size-1);
    }


}
