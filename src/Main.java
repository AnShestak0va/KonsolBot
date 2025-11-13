import java.util.Scanner;
import java.util.Random;

public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Random random  = new Random();

        String [][] questions = {
                {}
        };

        System.out.println("Hi! This is a console quiz bot!");
        System.out.println("He will ask questions until you decide to stop!");
        System.out.println("When you decide to finish, write a 'stop'!");

        String user;
        while(true){
            System.out.println("Do you want to continue?");
            user = scanner.nextLine().toLowerCase().trim();
            if(user.equals("stop")){
                System.out.println("The quiz bot has been stopped!");
                return;
            }

        }

    }
}