public class Calc {
    public static String calc(String input) {

        int result = 0;
        Arab arab = new Arab();
        String[] actions = {"+", "-", "/", "*"};

        String[] regexActions = {"\\+", "-", "/", "\\*"};


        int actionIndex = 1;
        int actionIndex1 = 0;

        for (int i = 0; i < actions.length; i++) {
            if (input.contains(actions[i])) {
                if (input.lastIndexOf(actions[i]) != input.indexOf(actions[i]))
                    throw new NumberFormatException("Знаков больше одного");
                actionIndex--;
                actionIndex1 = i;
            }
        }

        if (actionIndex < 0) {
            throw new NumberFormatException("Неверное выражение");

        }


        String[] data = input.split(regexActions[actionIndex1]);

        if (arab.isRoman(data[0]) == arab.isRoman(data[1])) {
            int a, b;

            boolean isRoman = arab.isRoman(data[0]);
            if (isRoman) {

                a = arab.romanToInt(data[0]);
                b = arab.romanToInt(data[1]);

            } else {

                a = Integer.parseInt(data[0]);
                b = Integer.parseInt(data[1]);
            }

            if (a < 0 || b < 0 || a > 10 || b > 10) {
                System.out.println("Введенное выражение не удовлетворяет условиям");

            }

            switch (actions[actionIndex1]) {
                case "+":
                    result = a + b;
                    break;
                case "-":
                    result = a - b;
                    break;
                case "*":
                    result = a * b;
                    break;
                default:
                    result = a / b;
                    break;
            }
           

            if (isRoman) {

                System.out.println(arab.intToRoman(result));
            } else {

                System.out.println(result);
            }
        } else {
            System.out.println("Введенные числа не одного формата");
        }


        return result + "";
    }
}


