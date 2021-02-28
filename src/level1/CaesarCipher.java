package level1;

public class CaesarCipher {

    public String solution(String string, int num) {

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i<string.length(); i++) {

            char c = string.charAt(i);

            if (Character.isLowerCase(c)) {
                c = (char) ((c + num % 26 - 'a') % 26 + 'a');
            } else if (Character.isUpperCase(c)) {
                c = (char) ((c + num % 26 - 'A') % 26 + 'A');
            }

            sb.append(c);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new CaesarCipher().solution("AB", 1));
    }
}
