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
        int result = Operations.act(firstInt.getIntValue(), sign, secondInt.getIntValue());
        System.out.println("Результат: " + result);
    }

    static void romanCalc(String[] massStr) {
        RomanOperand firstRoman = new RomanOperand(massStr[0]);
        String sign = massStr[1];
        RomanOperand secondRoman = new RomanOperand(massStr[2]);
        int result = Operations.act(firstRoman.getIntValue(), sign, secondRoman.getIntValue());
        System.out.println("Результат: " + Operations.arabicToRoman(result));
    }

    static void check(int... a) {
        for (int i : a) {
            if (i < 1 || i > 10) throw new DataInputException("Неверный ввод данных!");
        }
    }

}