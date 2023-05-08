import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        scan.close();
        try {
            System.out.println(calc(input));
        } catch (Exception e) {
            System.out.println("throws Exception");
        }
    }
    public static String calc(String input) throws Exception {
        String[] s = input.split(" ");
        if (s.length != 3) throw new Exception();
        if (s[0].charAt(0) == 'I'|| s[0].charAt(0) == 'V'|| s[0].charAt(0) == 'X') {
            if (s[2].charAt(0) == 'I'|| s[2].charAt(0) == 'V'|| s[2].charAt(0) == 'X') {
                int a = rimToInt(s[0]);
                int b = rimToInt(s[2]);
                if (a == 0 || b == 0) throw new Exception();
                switch (s[1]) {
                    case "+" -> {
                        return intToRim(a + b);
                    }
                    case "-" -> {
                        if (a - b < 1) throw new Exception();
                        return intToRim(a - b);
                    }
                    case "*" -> {
                        return intToRim(a * b);
                    }
                    case "/" -> {
                        return intToRim(a / b);
                    }
                    default -> throw new Exception();
                }
            } else throw new Exception();
        } else if (s[0].charAt(0) >= '1' && s[0].charAt(0) <= '9') {
            if (s[2].charAt(0) >= '1' && s[2].charAt(0) <= '9') {
                int a = Integer.parseInt(s[0]);
                int b = Integer.parseInt(s[2]);
                if (a < 1 || a > 10 || b < 1 || b > 10 ) throw new Exception();
                return switch (s[1]) {
                    case "+" -> String.valueOf(a + b);
                    case "-" -> String.valueOf(a - b);
                    case "*" -> String.valueOf(a * b);
                    case "/" -> String.valueOf(a / b);
                    default -> throw new Exception();
                };
            } else {
                throw new Exception();
            }
        } else {
            throw new Exception();
        }
    }
    public static int rimToInt(String str){
        return switch (str) {
            case "I" -> 1;
            case "II" -> 2;
            case "III" -> 3;
            case "IV" -> 4;
            case "V" -> 5;
            case "VI" -> 6;
            case "VII" -> 7;
            case "VIII" -> 8;
            case "IX" -> 9;
            case "X" -> 10;
            default -> 0;
        };
    }
    public static String intToRim(int n){
        StringBuilder s = new StringBuilder();
        while (n > 0){
            if(n >= 100){
                s.append("C");
                n-=100;
            } else if(n >= 90){
                s.append("XC");
                n-=90;
            } else if(n >= 50){
                s.append("L");
                n-=50;
            } else if(n >= 40){
                s.append("XL");
                n-=40;
            } else if(n >= 10){
                s.append("X");
                n-=10;
            } else if(n == 9){
                s.append("IX");
                n-=9;
            } else if(n >= 5){
                s.append("V");
                n-=5;
            } else if(n == 4){
                s.append("IV");
                n-=4;
            } else {
                s.append("I");
                n-=1;
            }
        }
        return s.toString();
    }
}

