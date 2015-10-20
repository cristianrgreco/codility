import java.util.ArrayList;
import java.util.List;

public class CommonPrimeDivisors {

    int solution(int[] A, int[] B) {
        int result = 0;
        for (int i = 0; i < A.length; i++) {
            List<Integer> set1 = primeFactors(A[i]);
            List<Integer> set2 = primeFactors(B[i]);

            if (set1.size() == 0 && set2.size() == 0) {
                result++;
            } else if (set1.stream().distinct().allMatch(set2::contains) &&
                    set2.stream().distinct().allMatch(set1::contains)) {
                result++;
            }
        }
        return result;
    }

    private List<Integer> primeFactors(int N) {
        List<Integer> results = new ArrayList<>();
        while (N > 1) {
            for (int i = 2; i <= N; i++) {
                if (N % i == 0) {
                    results.add(i);
                    N = N / i;
                    break;
                } else if (i > (int) Math.sqrt(N)) {
                    results.add(N);
                    N = 0;
                    break;
                }
            }
        }
        return results;
    }

    public static void main(String[] args) {
        assert new CommonPrimeDivisors().solution(new int[]{15, 10, 3}, new int[]{75, 30, 5}) == 1;
        assert new CommonPrimeDivisors().solution(new int[]{1}, new int[]{1}) == 1;
        assert new CommonPrimeDivisors().solution(new int[]{6059, 551}, new int[]{442307, 303601}) == 2;
    }

}
