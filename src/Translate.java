class Translate {

    static int romanToArabic(String roman) {
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

    static String arabicToRoman(int arabic) {
        if (arabic < 1) throw new DataInputException("Неверный ввод данных!");
        int decades = arabic / 10;
        int units = arabic % 10;
        StringBuilder roman = new StringBuilder();
        if (decades < 4) {
            roman.append("X".repeat(decades));
        } else if (decades == 4) {
            roman.append("XL");
        } else if (decades == 9) {
            roman.append("XC");
        } else if (decades == 10) {
            roman.append("C");
        } else {
            roman.append("L");
            roman.append("X".repeat(decades - 5));
        }
        if (units < 4) {
            roman.append("I".repeat(units));
        } else if (units == 4) {
            roman.append("IV");
        } else if (units == 9) {
            roman.append("IX");
        } else {
            roman.append("V");
            roman.append("I".repeat(units - 5));
        }
        return roman.toString();
    }

}
