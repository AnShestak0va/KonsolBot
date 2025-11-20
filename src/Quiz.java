import java.util.Random;
import java.util.Scanner;
import commands.*;

public class Quiz {
    public void run(){
        Scanner scanner = new Scanner(System.in);
        Random random  = new Random();

        String[][] questions = readingFile("questions.txt");
        System.out.println(CommandGreeting.greeting());

        String user;
        while(true){
            mixingOfQuestion(questions,random);
            for(int i=0; i< questions.length;i++){
                System.out.println("Вопрос: "+ questions[i][0]);
                System.out.print("Твой ответ: ");
                user = scanner.nextLine().toLowerCase().trim();
                if(user.equals("/стоп")){
                    System.out.println("Бот-викторина остановлен!");
                    scanner.close();
                    return;
                }
                else if(user.equals("/помощь")){
                    System.out.println(CommandHelp.help());
                }
                else {
                    if (questions[i][1].equals(user)) {
                        System.out.println("Верно!");
                    } else {
                        System.out.println("Неверно!");
                    }
                }
            }
        }
    }

    public static void mixingOfQuestion(String[][] questions, Random random){
        for (int i = questions.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            String[] temp = questions[i];
            questions[i] = questions[j];
            questions[j] = temp;
        }
    }

    public static String[][] readingFile(String fileName){
        return new String[][];
    }
}
