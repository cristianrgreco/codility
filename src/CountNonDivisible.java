import java.util.Map;
import java.util.TreeMap;

public class CountNonDivisible {

    int[] solution(int[] A) {
        Map<Integer, Integer> results = new TreeMap<>();
        for (int i = 0; i < A.length; i++) {
            results.put(A[i], 0);
            for (int j = 0; j < A.length; j++) {
                if (i == j) continue;
                if (A[i] % A[j] != 0) {
                    int currentCount = results.get(A[i]);
                    results.put(A[i], currentCount + 1);
                }
            }
        }
        System.out.println(results);
        return null;
    }

    public static void main(String[] args) {
        assert new CountNonDivisible().solution(new int[]{3, 1, 2, 3, 6}) == new int[]{2, 4, 3, 2, 0};
    }

}
