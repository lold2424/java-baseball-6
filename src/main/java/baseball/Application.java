package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static String game = "1", end = "2";
    public static int [] result = new int[2];
    public static List<Integer> list = new ArrayList<>();
    public static List<Integer> number;
        public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");

        while (game.equals("1")) {

            uniqueNum(); // 랜덤 수 생성

            input(); // 입력

            comparison(list, number); // 볼 스트라이크 계산

            output(result); // 결과 표시

            regame(end); // 재 게임 물어보기

        }
    }

    public static void input() {
        System.out.print("숫자를 입력해주세요 : ");
        String inputNum = Console.readLine();
        String[] items = inputNum.split("");
        list.clear();
        for (String item : items) {
            list.add(Integer.parseInt(item));
        }
    }

    public static void uniqueNum() {
        if (end.equals("2")) {
            number = Randoms.pickUniqueNumbersInRange(1, 9, 3);
            end = "1";
        }
    }

    public static void comparison(List<Integer> input, List<Integer> rand) {
        result[0] = 0;
        result[1] = 0;
        for (int i = 0; i < 3; i ++) {
            if (input.get(i).equals(rand.get(i))) {
                result[0]++;
            }
            else if (rand.contains(input.get(i))) {
                result[1]++;
            }
        }
    }

    public static void output(int [] result) {
        if (result[0] == 0 && result[1] == 0) {
            System.out.println("낫싱");
        }

        else {
            if (result[1] > 0) {
                System.out.printf("%d볼", result[1]);
            }
            if (result[0] > 0) {
                System.out.printf("%d스트라이크", result[0]);
                if (result[0] == 3) {
                    end = "2";
                }
            }
            System.out.println();
        }
    }

    public static void regame(String end) {
        if (end.equals("2")) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            game = Console.readLine();
            end = game;
        }
    }
}
