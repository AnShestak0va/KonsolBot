import java.util.Scanner;
import java.util.Random;

public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Random random  = new Random();

        String [][] questions = {
                {}
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
                return;
            }

        }

    }
}