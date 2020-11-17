import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String[] massStr = input();
        int first, second, result;
        String sign;
        try {
            first = Integer.parseInt(massStr[0]);
            sign = massStr[1];
            second = Integer.parseInt(massStr[2]);
            check(first, second);
            result = act(first, sign, second);
            System.out.println("Результат: " + result);
        } catch (NumberFormatException e) {
            first = romanToArabic(massStr[0]);
            sign = massStr[1];
            second = romanToArabic(massStr[2]);
            check(first, second);
            result = act(first, sign, second);
            System.out.println("Результат: " + arabicToRoman(result));
        }
    }

    public static String[] input(){
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

    public static int act(int first, String act, int second) {
        int result;
        switch (act) {
            case "+": result = (first + second); break;
            case "-": result = (first - second); break;
            case "*": result = (first * second); break;
            case "/":   if ((first % second) != 0) { throw  new DataInputException("Результат не целый"); }
                      result = (first / second); break;
            default: throw new DataInputException("Неверный ввод данных!");
        }
        return result;
    }

    public static void check(int... a) {
        for (int i : a) {
            if (i < 1 || i > 10) throw new DataInputException("Неверный ввод данных!");
        }
    }

    public static int romanToArabic(String roman) {
        int result;
        switch (roman) {
            case "I": result = 1; break;
            case "II": result = 2; break;
            case "III": result = 3; break;
            case "IV": result = 4; break;
            case "V": result = 5; break;
            case "VI": result = 6; break;
            case "VII": result = 7; break;
            case "VIII": result = 8; break;
            case "IX": result = 9; break;
            case "X": result = 10; break;
            default: throw new DataInputException("Неверный ввод данных!");
        }
        return result;
    }

    public static String arabicToRoman(int arabic) {
        if (arabic < 1) throw new DataInputException("Неверный ввод данных!");
        int decades = arabic / 10;
        int units = arabic % 10;
        String roman = "";
        if (decades < 4) {
            for (int i = 1; i <= decades; i++) {
                roman += "X";
            }
        } else if (decades == 4) {
            roman += "XL";
        } else if (decades == 9) {
            roman += "XC";
        } else if (decades == 10) {
            roman += "C";
        } else {
            roman += "L";
            for (int i = 5; i < decades; i++) {
                roman += "X";
            }
        }
        if (units < 4) {
            for (int i = 1; i <= units; i++) {
                roman += "I";
            }
        } else if (units == 4) {
            roman += "IV";
        } else if (units == 9) {
            roman += "IX";
        } else {
            roman += "V";
            for (int i = 5; i < units; i++) {
                roman += "I";
            }
        }
        return roman;
    }

}

class DataInputException extends IllegalArgumentException {

    public DataInputException(String message) {
        super(message);
    }

}