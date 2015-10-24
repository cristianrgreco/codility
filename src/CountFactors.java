import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CountFactors {

    int solution(int N) {
        return primeFactors(N).stream()
                .collect(Collectors.groupingBy(Function.identity()))
                .entrySet().stream()
                .mapToInt(entry -> entry.getValue().size() + 1)
                .reduce((a, b) -> a * b)
                .orElse(1);
    }

    private List<Integer> primeFactors(int N) {
        List<Integer> results = new ArrayList<>();
        while (N > 1) {
            for (int i = 2; i <= N; i++) {
                if (N % i == 0) {
                    results.add(i);
                    N = N / i;
                    break;
                } else if (i > Math.sqrt(N)) {
                    results.add(N);
                    N = 0;
                    break;
                }
            }
        }
        return results;
    }

    public static void main(String[] args) {
        assert new CountFactors().solution(24) == 8;
        assert new CountFactors().solution(1) == 1;
        assert new CountFactors().solution(2) == 2;
    }

}
