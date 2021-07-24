package programmers.level1;

public class CollatzConjecture {

    public int solution(long num) {
        int repeatCnt = 0;

        while (num != 1) {

            if (num % 2 == 0) {
                num = num / 2;
            } else {
                num = (num * 3) + 1;
            }

            repeatCnt++;
            if(repeatCnt>=500) return -1;
        }

        return repeatCnt;
    }


    public static void main(String[] args) {
        System.out.println(new CollatzConjecture().solution(626331));
    }
}
