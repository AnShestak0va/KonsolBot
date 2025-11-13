import java.util.Scanner;
import java.util.Random;

public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Random random  = new Random();

        String [][] questions = {
                {"Какая пустыня является самой большой в мире?","антарктида"},
                {"Кто был первым человеком, ступившим на Луну?","нил армстронг"},
                {"Как звали создателя знаменитого сыщика Шерлока Холмса?","дойл"},
                {"Какое животное является самым крупным на планете?","синий кит"},
                {"Кто написал знаменитую картину 'Чёрный квадрат'","малевич"},
                {"Какой химический элемент обозначается символом 'Au'","золото"},
                {"Какой фильм является самым кассовым в истории кинематографа?","аватар"},
                {"Какой русский композитор известен своими блестящими балетами 'Лебединое озеро', 'Спящая красавица' и 'Щелкунчик'?","чайковский"},
                {"Какая планета Солнечной системы является самой горячей?","венера"},
                {"Сколько колец изображено на олимпийском флаге и что они символизируют?","5"}
        };

        System.out.println("Привет! Это консольный бот - викторина!");
        System.out.println("Он будет задавать вопросы, пока ты не решишь остановиться!");
        System.out.println("Когда решишь закончить напиши 'стоп'!");

        String user;
        while(true){
            System.out.println("Хочешь продолжить?");
            user = scanner.nextLine().toLowerCase().trim();
            if(user.equals("стоп")){
                System.out.println("Бот-викторина остановлен!");
                scanner.close();
                return;
            }
            mixingOfQuestion(questions,random);
            for(int i=0; i< questions.length;i++){
                System.out.println("Вопрос: "+ questions[i][0]);
                System.out.print("Твой ответ: ");
                user = scanner.nextLine().toLowerCase().trim();
                if(questions[i][1].equals(user)){
                    System.out.println("Верно!");
                }
                else{
                    System.out.println("Неверно!");
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
}