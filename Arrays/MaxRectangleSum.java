/*
problem: https://www.codingninjas.com/codestudio/guided-paths/data-structures-algorithms/content/118820/offering/1381874?leftPanelTab=0
https://youtu.be/yCQN096CwWM
*/
public class MaximumRectangleSum {
    public static int findMaxRectangleSum(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < rows; i++) {
            int[] temp = new int[cols];
            for (int j = i; j < rows; j++) {
                for (int k = 0; k < cols; k++) {
                    temp[k] += matrix[j][k];
                }

                // Apply Kadane's algorithm to find the maximum sum of a subarray
                int currentSum = 0;
                for (int num : temp) {
                    currentSum = Math.max(num, currentSum + num);
                    maxSum = Math.max(maxSum, currentSum);
                }
            }
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, -1, -4, -20},
                {-8, -3, 4, 2, 1},
                {3, 8, 10, 1, 3},
                {-4, -1, 1, 7, -6}
        };

        int maxSum = findMaxRectangleSum(matrix);
        System.out.println("Maximum Rectangle Sum: " + maxSum);
    }
}
