package programmers.level1;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42862
 *
 *
 * 학생들의 번호는 체격 순으로 매겨져 있어, 바로 앞번호의 학생이나 바로 뒷번호의 학생에게만 체육복을 빌려줄 수 있습니다.
 * 예를 들어, 4번 학생은 3번 학생이나 5번 학생에게만 체육복을 빌려줄 수 있습니다.
 * 체육복이 없으면 수업을 들을 수 없기 때문에 체육복을 적절히 빌려 최대한 많은 학생이 체육수업을 들어야 합니다.
 *
 * 전체 학생의 수 n,
 * 체육복을 도난당한 학생들의 번호가 담긴 배열 lost,
 * 여벌의 체육복을 가져온 학생들의 번호가 담긴 배열 reserve가 매개변수로 주어질 때,
 * 체육수업을 들을 수 있는 학생의 최댓값을 return 하도록 solution 함수를 작성해주세요.
 *
 *
 * 전체 학생의 수는 2명 이상 30명 이하입니다.
 * 체육복을 도난당한 학생의 수는 1명 이상 n명 이하이고 중복되는 번호는 없습니다.
 * 여벌의 체육복을 가져온 학생의 수는 1명 이상 n명 이하이고 중복되는 번호는 없습니다.
 * 여벌 체육복이 있는 학생만 다른 학생에게 체육복을 빌려줄 수 있습니다.
 * 여벌 체육복을 가져온 학생이 체육복을 도난당했을 수 있습니다. 이때 이 학생은 체육복을 하나만 도난당했다고 가정하며,
 * 남은 체육복이 하나이기에 다른 학생에게는 체육복을 빌려줄 수 없습니다.
 *
 *
 * n	lost	reserve	    return
 * 5	[2, 4]	[1, 3, 5]	5
 * 5	[2, 4]	[3]	        4
 * 3	[3]	    [1]	        2
 *
 */
public class Uniform {


    public int solution(int n, int[] lost, int[] reserve) {


        List<Integer> reserveList = Arrays.stream(reserve).boxed().collect(Collectors.toList());
        List<Integer> lostList = Arrays.stream(lost).boxed().collect(Collectors.toList());

        Collections.sort(reserveList);
        Collections.sort(lostList);

        //여분 체육복이 있지만 도난당한 학생
        for (int i = 0; i < lostList.size(); i++) {
            for (int j = 0; j < reserveList.size(); j++) {
                if (lostList.get(i) == reserveList.get(j)) {
                    lostList.remove(lostList.indexOf(lostList.get(i)));
                    reserveList.remove(reserveList.indexOf(reserveList.get(j)));
                    i--;
                    break;
                }
            }
        }

        //빌려주기
        for (int i = 0; i < lostList.size(); i++) {
            for (int j = 0; j < reserveList.size(); j++) {
                if (lostList.get(i) + 1 == reserveList.get(j) || lostList.get(i) - 1 == reserveList.get(j)) {
                    lostList.remove(lostList.indexOf(lostList.get(i)));
                    reserveList.remove(reserveList.indexOf(reserveList.get(j)));
                    i--;
                    break;
                }

            }
        }

        return n - lostList.size();
    }


    // 테스트를 위한 main메소드 입니다.
    public static void main(String[] args) {
        //n	lost	reserve	    return
        //5	[2, 4]	[1, 3, 5]	5

        System.out.println(new Uniform().solution(5, new int[]{2, 4}, new int[]{1, 3, 5}));
    }
}
