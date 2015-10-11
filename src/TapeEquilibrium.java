import java.lang.Math;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class TapeEquilibrium {

    public int solution(int[] A) {
        List<Integer> input = IntStream.of(A).boxed().collect(Collectors.toList());

        int ans = Integer.MAX_VALUE;

        for (int i = 1; i < input.size(); i++) {
            Integer lhs = input.subList(0, i).stream().reduce((a, b) -> a + b).get();
            Integer rhs = input.subList(i, input.size()).stream().reduce((a, b) -> a + b).get();

            int diff = Math.abs(lhs - rhs);

            if (diff < ans) {
                ans = diff;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        assert new TapeEquilibrium().solution(new int[]{3, 1, 2, 4, 3}) == 1;
        assert new TapeEquilibrium().solution(new int[]{5, 6, 2, 4, 1}) == 3;
    }

}
