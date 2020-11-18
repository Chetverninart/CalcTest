class Operand {
    String stringValue;
    int intValue;

    public Operand(String stringValue) {
        this.stringValue = stringValue;
    }

    public int getIntValue() {
        return intValue;
    }

}

class RomanOperand extends Operand {

    public RomanOperand(String stringValue) {
        super(stringValue);
        intValue = Operations.romanToArabic(stringValue);
    }

}

class ArabicOperand extends Operand {

    public ArabicOperand(String stringValue) {
        super(stringValue);
        intValue = Integer.parseInt(stringValue);
    }

}