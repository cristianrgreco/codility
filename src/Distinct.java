import java.util.HashSet;
import java.util.Set;

public class Distinct {

    int solution(int[] A) {
        Set<Integer> distinctValues = new HashSet<>();
        for (int aValue : A) {
            distinctValues.add(aValue);
        }
        return distinctValues.size();
    }

    public static void main(String[] args) {
        assert new Distinct().solution(new int[]{2, 1, 1, 2, 3, 1}) == 3;
    }

}
