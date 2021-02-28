package level1;

import java.util.Arrays;

public class FindStringKim {

	public static int findKim(String[] list) {

		int index = Arrays.asList(list).indexOf("Kim");
		return index;
	}

	public static void main(String[] args) {
		String[] list = { "Jane", "Steve", "Kim" };

		System.out.println("�輭���� " + findKim(list) + "�� �ִ�.");
	}

}
