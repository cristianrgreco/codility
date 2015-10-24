import java.util.Arrays;
import java.util.BitSet;
import java.util.List;
import java.util.stream.Collectors;

public class CountSemiprimes {

    int[] solution(int N, int[] P, int[] Q) {
        int inputLength = P.length;

        List<Integer> primes = sieve(N);

        List<Integer> semiprimes = primes.stream()
                .flatMap(i -> primes.stream().map(j -> i * j))
                .distinct()
                .sorted()
                .collect(Collectors.toList());

        int[] results = new int[inputLength];

        for (int i = 0; i < inputLength; i++) {
            int startRange = P[i];
            int endRange = Q[i];

            results[i] = (int) semiprimes.stream().filter(p -> p >= startRange && p <= endRange).count();
        }

        return results;
    }

    private static List<Integer> sieve(int N) {
        BitSet primes = new BitSet();
        primes.set(2, N, true);

        for (int i = 2; i <= Math.sqrt(N); i++) {
            if (isPrime(i)) {
                for (int j = i * i; j < N; j += i) {
                    primes.set(j, false);
                }
            }
        }

        return primes.stream().filter(primes::get).boxed().collect(Collectors.toList());
    }

    private static boolean isPrime(int N) {
        if (N < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(N); i++) {
            if (N % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        assert Arrays.equals(new CountSemiprimes().solution(26, new int[]{1, 4, 16}, new int[]{26, 10, 20}), new int[]{10, 4, 0});
    }

}
