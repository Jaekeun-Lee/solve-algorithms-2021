package programmers.level1;

import java.util.Arrays;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/12910?language=java
 *
 * 문제 설명
 * array의 각 element 중 divisor로 나누어 떨어지는 값을 오름차순으로 정렬한 배열을 반환하는 함수, solution을 작성해주세요.
 * divisor로 나누어 떨어지는 element가 하나도 없다면 배열에 -1을 담아 반환하세요.
 */
public class DivisionArray {

    public int[] solution(int[] arr, int divisor) {
        int[] answer = Arrays.stream(arr).filter(i -> (i % divisor == 0)).toArray();
        return answer.length == 0 ? new int[]{-1} : Arrays.stream(answer).sorted().toArray();
    }

    // 아래는 테스트로 출력해 보기 위한 코드입니다.
    public static void main(String[] args) {

        //입출력 예 1)
        int[] arr = {5, 9, 7, 10};
        int divisor = 5;
        //return = [5, 10]

        //입출력 예 2)
        /*
        int[] arr = {2, 36, 1, 3};
        int divisor = 1;
        //return = [1, 2, 3, 36]
        */

        //입출력 예 3)
        /*
        int[] arr = {3, 2, 6};
        int divisor = 10;
        //return = [-1]
        */

        int[] rtrArray = new DivisionArray().solution(arr, divisor);
        Arrays.stream(rtrArray).forEach(num -> System.out.println(num));

    }
}
