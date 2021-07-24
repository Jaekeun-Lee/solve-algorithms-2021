package programmers.level1;

public class HarshadNumber {

    public boolean solution(int x) {
        int placeSum = 0;
        String num = Integer.toString(x);

        for (int i = 0; i < num.length(); i++) {
            placeSum += Integer.parseInt(num.charAt(i)+"");
        }

        return (x % placeSum == 0)? true : false;

    }

    public static void main(String[] args) {
        System.out.println(new HarshadNumber().solution(10));
    }
}
