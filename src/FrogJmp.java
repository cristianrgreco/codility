public class FrogJmp {

    public int solution(int X, int Y, int D) {
        if (X >= Y) {
            return 0;
        }

        int steps = 0;

        do {
            steps++;
            X += D;
        } while (X < Y);

        return steps;
    }

    public static void main(String[] args) {
        assert new FrogJmp().solution(10, 85, 30) == 3;
        assert new FrogJmp().solution(1, 1, 3) == 0;
    }

}
