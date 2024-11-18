import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        System.out.println("Введите выражение: ");
        String exp = scn.nextLine();
        char action;
        String[] data;
        if (exp.contains(" + ")) {
            data = exp.split(" \\+ ");
            action = '+';
        } else if (exp.contains(" - ")) {
            data = exp.split(" - ");
            action = '-';
        } else if (exp.contains(" * ")) {
            data = exp.split(" \\* ");
            action = '*';
        } else if (exp.contains(" / ")) {
            data = exp.split(" / ");
            action = '/';
        }else{
            throw new Exception("Некорректный знак действия");
        }
        if (action == '*' || action == '/') {
            if (data[1].contains("\"")) throw new Exception("Строку можно умножать или делить только на число");
        }
        for (int i = 0; i < data.length; i++) {
            data[i] = data[i].replace("\"", "");
        }
        switch (action) {
            case '+':
                printInQuotes(data[0] + data[1]);
                break;
            case '*':
                int multiplier = Integer.parseInt(data[1]);
                String result = "";
                for (int i = 0; i < multiplier; i++) {
                    result+=data[0];
                }
                printInQuotes(result);
                break;
            case '-':
                int index = data[0].indexOf(data[1]);
                if(index == -1){
                    printInQuotes(data[0]);
                }else{
                    String result1 = data[0].substring(0, index);
                    result1+=data[0].substring(index+data[1].length());
                    printInQuotes(result1);
                    break;
                }
            default:
                int newLen = data[0].length()/Integer.parseInt(data[1]);
                String result2 = data[0].substring(0,newLen);
                printInQuotes(result2);
                break;
        }
    }
    static void printInQuotes(String text){
        System.out.println("Ответ: " + "\n" + "\""+text+"\"");
    }
}