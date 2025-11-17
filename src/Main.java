import java.util.Scanner;
import java.util.Random;

public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Random random  = new Random();

        String[][] questions = readingFile("questions.txt");
        System.out.println(greeting());

        String user;
        while(true){
            mixingOfQuestion(questions,random);
            for(int i=0; i< questions.length;i++){
                System.out.println("Вопрос: "+ questions[i][0]);
                System.out.print("Твой ответ: ");
                user = scanner.nextLine().toLowerCase().trim();
                if(user.equals("стоп")){
                    System.out.println("Бот-викторина остановлен!");
                    scanner.close();
                    return;
                }
                else if(user.equals("помощь")){
                    System.out.println(help());
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
    public static String greeting(){
        return """
                Привет! Это консольный бот - викторина!
                Он будет задавать вопросы, пока ты не решишь остановиться!
                Когда решишь закончить напиши 'стоп'! Если есть вопросы напиши 'помощь'!
                """;
    }
    public static String help(){
        return """
                Добро пожаловать в викторину!
                
                КАК ИГРАТЬ:
                Бот задает вопросы из различных областей знаний
                Вводите свой ответ и нажимайте Enter
                Бот сообщит, правильный ли ответ
                
                КОМАНДЫ:
                'стоп' - завершить викторину
                'помощь' - показать эту справку
                
                ПОДСКАЗКИ:
                Ответы не чувствительны к регистру
                Вопросы перемешиваются после каждого раунда
                """;
    }
    public static String[][] readingFile(String fileName){
        
    }
}