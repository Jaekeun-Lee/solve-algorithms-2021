package programmers.weekly;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/83201
 *
 * 당신은 각 학생들이 받은 점수의 평균을 구하여, 기준에 따라 학점을 부여하려고 합니다.
 * 만약, 학생들이 자기 자신을 평가한 점수가 유일한 최고점 또는 유일한 최저점이라면 그 점수는 제외하고 평균을 구합니다.
 *
 * No.	0	    1	    2	    3	    4
 * 0	100	    90	    98	    88	    65
 * 1	50	    45	    99	    85	    77
 * 2	47	    88	    95	    80	    67
 * 3	61	    57	    100	    80	    65
 * 4	24	    90	    94	    75	    65
 * 평균	45.5	81.25	97.2	81.6	67.8
 * 학점	F	    B	    A	    B	    D
 *
 * 0번 학생이 받은 점수는 0번 열에 담긴 [100, 50, 47, 61, 24]입니다.
 * 자기 자신을 평가한 100점은 자신이 받은 점수 중에서 유일한 최고점이므로, 평균을 구할 때 제외합니다.
 *
 * 0번 학생의 평균 점수는 (50+47+61+24) / 4 = 45.5입니다.
 * 4번 학생이 받은 점수는 4번 열에 담긴 [65, 77, 67, 65, 65]입니다. 자기 자신을 평가한 65점은 자신이 받은 점수 중에서 최저점이지만 같은 점수가 2개 더 있으므로, 유일한 최저점이 아닙니다. 따라서, 평균을 구할 때 제외하지 않습니다.
 * 4번 학생의 평균 점수는 (65+77+67+65+65) / 5 = 67.8입니다.
 * 제외할 점수는 제외하고 평균을 구한 후, 아래 기준에 따라 학점을 부여합니다.
 *
 * 평균	                학점
 * 90점 이상	            A
 * 80점 이상 90점 미만	B
 * 70점 이상 80점 미만	C
 * 50점 이상 70점 미만	D
 * 50점 미만	            F
 *
 * 학생들의 점수가 담긴 정수형 2차원 배열 scores가 매개변수로 주어집니다. 이때, 학생들의 학점을 구하여 하나의 문자열로 만들어서 return 하도록 solution 함수를 완성해주세요.
 */
public class MutualEvaluation {

    public String solution(int[][] scores) {

        StringBuilder sb = new StringBuilder();

        for (int row = 0; row < scores.length; row++) {

            int sum = 0;
            int max = -1;
            int min = 101;
            int length = scores.length;
            boolean isUnique = true;
            int selfScore = scores[row][row];

            for (int col = 0; col < scores.length; col++) {

                min = Math.min(scores[col][row], min);
                max = Math.max(scores[col][row], max);

                if (row != col && selfScore == scores[col][row]) {
                    isUnique = false;
                }

                sum += scores[col][row];

            }
            if (isUnique && (max == selfScore || min == selfScore)) {
                length -= 1;
                sum -= selfScore;
            }
            sb.append(this.scoreToGrade(sum / length));
        }

        return sb.toString();
    }

    private String scoreToGrade(int score) {

        switch (score / 10) {
            case 10:
            case 9:
                return "A";
            case 8:
                return "B";
            case 7:
                return "C";
            case 6:
            case 5:
                return "D";
            default:
                return "F";
        }

    }


    //테스트를 위한 main 메소드
    public static void main(String[] args) {

        // expect = "FBABD"
        int[][] scores = {{100, 90, 98, 88, 65}, {50, 45, 99, 85, 77}, {47, 88, 95, 80, 67}, {61, 57, 100, 80, 65}, {24, 90, 94, 75, 65}};

        // expect = "BBF"
//        int[][] scores = {{75, 50, 100}, {75, 100, 20}, {100, 100, 20}};

        // expect = "DA"
//        int[][] scores = {{50,90}, {50,87}};

        System.out.println(new MutualEvaluation().solution(scores));

    }
}
