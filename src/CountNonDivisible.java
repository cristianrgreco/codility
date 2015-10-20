import java.util.Arrays;

public class CountNonDivisible {

    int[] solution(int[] A) {
        int[] results = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            results[i] = 0;
            for (int j = 0; j < A.length; j++) {
                if (i == j) continue;
                if (A[i] % A[j] != 0) {
                    results[i]++;
                }
            }
        }
        return results;
    }

    public static void main(String[] args) {
        assert Arrays.equals(new CountNonDivisible().solution(new int[]{3, 1, 2, 3, 6}), new int[]{2, 4, 3, 2, 0});
    }

}
