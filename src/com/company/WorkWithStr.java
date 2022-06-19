package com.company;

class WorkWithStr {
    static String findOperand(String exp) {
        String [] operands= {"+", "-", "*", "/"};

        String operator = "";
        for (String operand : operands) {
            if (exp.contains(operand)) {
                operator = operand;
            }
        }
        return operator;
    }

    static String [] findNumb(String exp, String operand){
        String[] userNumb = new String[0];
            userNumb = exp.split("\\" + operand);
            return userNumb;
    }
}
