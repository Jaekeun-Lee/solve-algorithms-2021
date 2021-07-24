package programmers.level1;

public class StringReturn {

	public String solution(int a) {
		String answer = "";
		for (int i = 0; i < a; i++) {
			answer += (i % 2 == 0) ? "��" : "��";
		}
		return answer;
	}

	public static void main(String[] args) {

		System.out.println(new StringReturn().solution(3));
		System.out.println(new StringReturn().solution(4));
	}

}
