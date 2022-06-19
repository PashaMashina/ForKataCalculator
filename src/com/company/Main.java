package com.company;

import java.util.Scanner;

public class Main {
    public static String calc(String userStr) throws Exception {
        int x = 0, y = 0, resultInt = 0;
        String xStr, yStr;
        boolean romOrNot = false;
        String resultStr;

        String[] numbers;
        String operand = WorkWithStr.findOperand(userStr);

        numbers = WorkWithStr.findNumb(userStr, operand);

        if(operand.equals("")){
            Exception notMath = new Exception("Строка не является математической операцией");
            throw notMath;
        }

        if(numbers.length>2){
            Exception not2 = new Exception("Формат математической операции не удовлетворяет заданию - два операнда и один оператор");
            throw not2;
        }

        xStr = numbers[0];
        yStr = numbers[1];

        try {
            try {
                x = RomanNumerals.romanToArabic(xStr);
                y = RomanNumerals.romanToArabic(yStr);
                romOrNot = true;
            }catch (IllegalArgumentException ex){
                x = Integer.parseInt (xStr);
                y = Integer.parseInt (yStr);
                romOrNot = false;
            }
        }catch (NumberFormatException ex){
            Exception different = new Exception("Используются одновременно разные системы счисления");
            throw different;
        }

        if(x<0 || x>10 || y <0 || y > 10){
            Exception limited = new Exception("Калькулятор работает только с числами от 0 до 10");
            throw limited;
        }

        switch (operand){
            case ("+"):
                resultInt = x + y;
                break;
            case ("-"):
                resultInt = x - y;
                if(romOrNot && x>=y){
                    Exception notNeg = new Exception("В римской системе нет отрицательных чисел");
                    throw notNeg;
                }
                break;
            case ("/"):
                resultInt = x / y;
                break;
            case ("*"):
                resultInt = x * y;
                break;
            default: System.out.println();
        }


        if(romOrNot){
            resultStr = RomanNumerals.arabicToRoman(resultInt);
        }else {
            resultStr = Integer.toString(resultInt);
        }
        return resultStr;
    }
    public static void main(String[] args) throws Exception {

        System.out.println("Введите выражение:");

        Scanner scanner = new Scanner(System.in);

        String userStr = scanner.nextLine().replaceAll("\\s","");

        System.out.println(calc(userStr));
    }
}
