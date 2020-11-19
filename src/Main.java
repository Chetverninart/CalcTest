import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        String[] massStr = input();
        try {
            intCalc(massStr);
        } catch (NumberFormatException e) {
            romanCalc(massStr);
        }
    }

    static String[] input(){
        String[] massStr;
        String line;
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите выражение: ");
        line = scan.nextLine();
        scan.close();
        massStr = line.split(" ");
        if (massStr.length != 3) throw new DataInputException("Неверный ввод данных!");
        return massStr;
    }

    static void intCalc(String[] massStr) {
        ArabicOperand firstInt = new ArabicOperand(massStr[0]);
        String sign = massStr[1];
        ArabicOperand secondInt = new ArabicOperand(massStr[2]);
        check(firstInt.getIntValue(), secondInt.getIntValue());
        int[] result = act(firstInt.getIntValue(), sign, secondInt.getIntValue());
        if (result[1] == 0) System.out.printf("Результат: %d", result[0]);
        else System.out.printf("Результат: %d (остаток: %d)",result[0], result[1]);
    }

    static void romanCalc(String[] massStr) {
        RomanOperand firstRoman = new RomanOperand(massStr[0]);
        String sign = massStr[1];
        RomanOperand secondRoman = new RomanOperand(massStr[2]);
        int[] result = act(firstRoman.getIntValue(), sign, secondRoman.getIntValue());
        if (result[1] == 0) System.out.printf("Результат: %s", Translate.arabicToRoman(result[0]));
        else System.out.printf("Результат: %s (остаток: %s)", Translate.arabicToRoman(result[0]),
                                                              Translate.arabicToRoman(result[1]));
    }

    static void check(int... a) {
        for (int i : a) {
            if (i < 1 || i > 10) throw new DataInputException("Неверный ввод данных!");
        }
    }

    static int[] act(int first, String act, int second) {
        int[] result = new int[2];
        switch (act) {
            case "+": result[0] = (first + second); break;
            case "-": result[0] = (first - second); break;
            case "*": result[0] = (first * second); break;
            case "/": result[0] = (first / second);
                      result[1] = (first % second); break;
            default: throw new DataInputException("Неверный ввод данных!");
        }
        return result;
    }

}