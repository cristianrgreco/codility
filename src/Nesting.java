public class Nesting {

    int solution(String S) {
        int count = 0;

        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '(') {
                count++;
            } else if (S.charAt(i) == ')') {
                if (count > 0) {
                    count--;
                } else {
                    count++;
                }
            }
        }

        return count == 0 ? 1 : 0;
    }

    public static void main(String[] args) {
        assert new Nesting().solution("(()(())())") == 1;
        assert new Nesting().solution("())") == 0;
        assert new Nesting().solution(")(") == 0;
    }

}
