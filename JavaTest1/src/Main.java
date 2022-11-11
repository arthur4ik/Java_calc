import java.util.Scanner;
import java.util.HashMap;
import java.util.TreeMap;




class Main {
    static Scanner s = new Scanner(System.in);

    public static void main(String[] args) throws RomanAndArabianExceptions {
        System.out.print("Input: ");
        System.out.println("Output: " + calc(s.nextLine()));

    }

    public static String calc(String input) throws RomanAndArabianExceptions  {

        Converter converter = new Converter();
        String[] data = new String[2];

        if (input.contains("+")) {
            data = input.split("\\+");
            if(data.length>2){
                throw new RomanAndArabianExceptions(" Формат математической операции не удовлетворяет заданию - два операнда и один оператор!");
            }
            if(converter.isRoman(data[0]) != converter.isRoman(data[1])){

                throw new RomanAndArabianExceptions("Числа должны находиться в одной системе счисления!! 5+5 || V+V");

            }
            if (converter.isRoman(data[0]) == converter.isRoman(data[1])) {
                int a, b;


                boolean isRoman = converter.isRoman(data[0]);
                if (isRoman) {
                    a = converter.romanToInt(data[0]);
                    b = converter.romanToInt(data[1]);

                } else {
                    a = Integer.parseInt(data[0]);
                    b = Integer.parseInt(data[1]);
                }
                int result;

                if (input.contains("+")) {
                    result = a + b;

                    if (isRoman) {
                        if (result < 0){
                            throw new RomanAndArabianExceptions("В римской системе счисления, нет отрицательных чисел!");
                        }
                        return converter.intToRoman(result);
                    } else {
                        return Integer.toString(result);
                    }


                }
            }

        }

        if (input.contains("-")) {
            data = input.split("-");
            if(data.length>2){
                throw new RomanAndArabianExceptions(" Формат математической операции не удовлетворяет заданию - два операнда и один оператор!");
            }
            if(converter.isRoman(data[0]) != converter.isRoman(data[1])){

                throw new RomanAndArabianExceptions("Числа должны находиться в одной системе счисления!! 5+5 || V+V");

            }
            if (converter.isRoman(data[0]) == converter.isRoman(data[1])) {
                int a, b;

                boolean isRoman = converter.isRoman(data[0]);
                if (isRoman) {
                    a = converter.romanToInt(data[0]);
                    b = converter.romanToInt(data[1]);

                } else {
                    a = Integer.parseInt(data[0]);
                    b = Integer.parseInt(data[1]);
                }
                int result;
                if (input.contains("-")) {
                    result = a - b;

                    if (isRoman) {
                        if (result < 0){
                            throw new RomanAndArabianExceptions("В римской системе счисления, нет отрицательных чисел!");
                        }
                        return converter.intToRoman(result);
                    } else {

                        return Integer.toString(result);
                    }


                }
            }

        }

        if (input.contains("/")) {
            data = input.split("/");
            if(data.length>2){
                throw new RomanAndArabianExceptions(" Формат математической операции не удовлетворяет заданию - два операнда и один оператор!");
            }
            if(converter.isRoman(data[0]) != converter.isRoman(data[1])){

                throw new RomanAndArabianExceptions("Числа должны находиться в одной системе счисления!! 5+5 || V+V");

            }
            if (converter.isRoman(data[0]) == converter.isRoman(data[1])) {
                int a, b;

                boolean isRoman = converter.isRoman(data[0]);
                if (isRoman) {
                    a = converter.romanToInt(data[0]);
                    b = converter.romanToInt(data[1]);

                } else {
                    a = Integer.parseInt(data[0]);
                    b = Integer.parseInt(data[1]);
                }
                int result;
                if (input.contains("/")) {
                    result = a / b;
                    if (isRoman) {
                        if (result < 0){
                            throw new RomanAndArabianExceptions("В римской системе счисления, нет отрицательных чисел!");
                        }
                        return converter.intToRoman(result);
                    } else {
                        return Integer.toString(result);
                    }


                }
            }

        }

        if (input.contains("*")) {
            data = input.split("\\*");
            if(data.length>2){
                throw new RomanAndArabianExceptions(" Формат математической операции не удовлетворяет заданию - два операнда и один оператор!");
            }
            if(converter.isRoman(data[0]) != converter.isRoman(data[1])){

                throw new RomanAndArabianExceptions("Числа должны находиться в одной системе счисления!! 5+5 || V+V");

            }
            if (converter.isRoman(data[0]) == converter.isRoman(data[1])) {
                int a, b;
                boolean isRoman = converter.isRoman(data[0]);
                if (isRoman) {
                    a = converter.romanToInt(data[0]);
                    b = converter.romanToInt(data[1]);

                } else {
                    a = Integer.parseInt(data[0]);
                    b = Integer.parseInt(data[1]);
                }
                int result;
                if (input.contains("*")) {
                    result = a * b;
                    if (isRoman) {
                        if (result < 0){
                            throw new RomanAndArabianExceptions("В римской системе счисления, нет отрицательных чисел!");
                        }
                        return converter.intToRoman(result);
                    } else {
                        return Integer.toString(result);
                    }


                }
            }

        }

        return "Вы ввели (что-то не то!) или (как-то не так!)";



    }


}

class RomanAndArabianExceptions extends Exception {
    RomanAndArabianExceptions(String description){
        super(description);
    }
}

class Converter {
    TreeMap<Character, Integer> romanKeyMap = new TreeMap<>();
    TreeMap<Integer, String> arabianKeyMap = new TreeMap<>();

    Converter() {
        romanKeyMap.put('I', 1);
        romanKeyMap.put('V', 5);
        romanKeyMap.put('X', 10);
        romanKeyMap.put('L', 50);
        romanKeyMap.put('C', 100);
        romanKeyMap.put('D', 500);
        romanKeyMap.put('M', 1000);

        arabianKeyMap.put(1000, "M");
        arabianKeyMap.put(900, "CM");
        arabianKeyMap.put(500, "D");
        arabianKeyMap.put(400, "CD");
        arabianKeyMap.put(100, "C");
        arabianKeyMap.put(90, "XC");
        arabianKeyMap.put(50, "L");
        arabianKeyMap.put(40, "XL");
        arabianKeyMap.put(10, "X");
        arabianKeyMap.put(9, "IX");
        arabianKeyMap.put(5, "V");
        arabianKeyMap.put(4, "IV");
        arabianKeyMap.put(1, "I");

    }


    boolean isRoman(String number) {
        return romanKeyMap.containsKey(number.charAt(0));
    }

    String intToRoman(int number) {
        String roman = "";
        int arabianKey;
        do {
            arabianKey = arabianKeyMap.floorKey(number);
            roman += arabianKeyMap.get(arabianKey);
            number -= arabianKey;
        } while (number != 0);
        return roman;


    }

    int romanToInt(String s) {
        int end = s.length() - 1;
        char[] arr = s.toCharArray();
        int arabian;
        int result = romanKeyMap.get(arr[end]);
        for (int i = end - 1; i >= 0; i--) {
            arabian = romanKeyMap.get(arr[i]);

            if (arabian < romanKeyMap.get(arr[i + 1])) {
                result -= arabian;
            } else {
                result += arabian;
            }


        }
        return result;

    }
}