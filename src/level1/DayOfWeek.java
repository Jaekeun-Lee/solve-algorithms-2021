package level1;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/12901?language=java
 * <p>
 * 문제 설명
 * 2016년 1월 1일은 금요일입니다. 2016년 a월 b일은 무슨 요일일까요? 두 수 a ,b를 입력받아 2016년 a월 b일이 무슨 요일인지 리턴하는 함수, solution을 완성하세요.
 * 요일의 이름은 일요일부터 토요일까지 각각 { SUN,MON,TUE,WED,THU,FRI,SAT } 입니다.
 * 예를 들어 a=5, b=24라면 5월 24일은 화요일이므로 문자열 "TUE"를 반환하세요.
 * <p>
 * 제한 조건
 * 2016년은 윤년입니다.
 * 2016년 a월 b일은 실제로 있는 날입니다. (13월 26일이나 2월 45일같은 날짜는 주어지지 않습니다)
 */
public class DayOfWeek {

    public String solution(int a, int b) {
        String answer = "";
        int[] day= {31,29,31,30,31,30,31,31,30,31,30,31};
        int sum=0;
        for(int i=0;i<a-1;i++){
            sum+=day[i];
        }
        sum+=b;
        switch(sum%7){
            case 0:
                return "THU";
            case 1:
                return "FRI";
            case 2:
                return "SAT";
            case 3:
                return "SUN";
            case 4:
                return "MON";
            case 5:
                return "TUE";
            case 6:
                return "WED";
        }
        return null;
    }

    /*
    public String solution(int a, int b) throws ParseException {

        String month = a > 10 ? Integer.toString(a) : "0" + a;
        String day = b > 10 ? Integer.toString(b) : "0" + b;

        String inputDate = "2016" + month + day;

        if(inputDate.equals("20160229")) return "MON";

        DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        Date date = dateFormat.parse(inputDate);

        return new SimpleDateFormat("E",Locale.ENGLISH).format(date).toUpperCase();
    }
    */

    // 아래는 테스트로 출력해 보기 위한 코드입니다.
    public static void main(String[] args) throws ParseException {

        //입출력 예 1)
        int a = 1;
        int b = 7;
        //return = "THU"

        String result = new DayOfWeek().solution(a, b);
        System.out.println(result);
    }
}
