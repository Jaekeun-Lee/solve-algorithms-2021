package programmers.level1;

public class SumBetweenTwoIntegers {

    public long solution(int a, int b) {
        long answer = 0;

        if (a != b) {
            for (int i = Math.min(a, b); i <= Math.max(a, b); i++) {
                answer += i;
            }
        } else {
            answer = a;
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(new SumBetweenTwoIntegers().solution(3, 5));
    }
}
