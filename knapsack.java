import java.io.File;
import java.util.Scanner;

public class knapsack {

    public static void main(String args[]) {
        try {
            Scanner sc = new Scanner(new File("input4.txt"));
            int maxWt = Integer.parseInt(sc.nextLine());

            String str = sc.nextLine(); // reads the line stores in string
            String[] chars = str.split(" "); // splitting the string into array of chars
            int n = chars.length;
            int[] val = new int[n];
            for (int i = 0; i < n; i++)
                val[i] = Integer.parseInt(chars[i]); // storing parsed integer

            String str2 = sc.nextLine(); // reads second line of the file
            String[] newChars = str2.split(" ");
            int[] itemWt = new int[n];
            for (int i = 0; i < n; i++)
                itemWt[i] = Integer.parseInt(newChars[i]);

            System.out.println(" " + knapSack(maxWt, itemWt, val, n));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static int knapSack(int maxWt, int itemWt[], int val[], int n) {
        int[][] matrix = new int[n + 1][maxWt + 1]; // creating matrix
        for (int j = 0; j <= maxWt; j++) {
            matrix[0][j] = 0;
        }
        if (n <= 0 || maxWt <= 0) { // looking at the base case
            return 0;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= maxWt; j++) {
                if (itemWt[i - 1] <= j) {
                    matrix[i][j] = Math.max(matrix[i - 1][j], // this will run when item weight is less than the capacity
                            // store location in matrix and than use it in next step
                            matrix[i - 1][j - itemWt[i - 1]] + val[i - 1]);
                } else {
                    matrix[i][j] = matrix[i - 1][j]; // this will run when the weight is greater than the capacity
                }
            }
        }
        return matrix[n][maxWt]; // returning the max when there n items
    }
}
