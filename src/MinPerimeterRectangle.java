import java.util.ArrayList;
import java.util.List;

public class MinPerimeterRectangle {

    int solution(int N) {
        List<Integer> results = new ArrayList<>();
        for (int i = 1; i <= Math.sqrt(N); i++) {
            if (N % i == 0) {
                int x = N / i;
                results.add(2 * (x + i));
            }
        }
        return results.stream().min(Integer::compare).orElse(0);
    }

    public static void main(String[] args) {
        assert new MinPerimeterRectangle().solution(30) == 22;
        assert new MinPerimeterRectangle().solution(1) == 4;
    }

}
