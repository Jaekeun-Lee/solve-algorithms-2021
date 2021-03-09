package level1;

public class FindPY {

    boolean solution(String target) {

        int cnt = 0;
        String changeStr = target.toLowerCase();

        for (int i = 0; i < target.length(); i++) {
            if (changeStr.charAt(i) == 'p') {
                cnt++;
            } else if (changeStr.charAt(i) == 'y') {
                cnt--;
            }
        }

        return cnt==0 ? true : false;

    }


    public static void main(String[] args) {
        System.out.println(new FindPY().solution("pPoooyY"));
    }
}
