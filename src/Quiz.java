import java.util.Random;
import java.util.Scanner;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.io.IOException;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import commands.*;

public class Quiz {
    public void run(){
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        Map<String, List<String>> questions = readingFile("questions.txt");
        System.out.println(CommandGreeting.greeting());

        String user;
        while(true){
            List<Map.Entry<String, List<String>>> shuffledQuestions = mixingOfQuestion(questions, random);
            for(Map.Entry<String, List<String>> entry : shuffledQuestions){
                System.out.println("Вопрос: " + entry.getKey());
                System.out.print("Твой ответ: ");
                user = scanner.nextLine().toLowerCase().trim();

                if(user.equals("/стоп")){
                    System.out.println("Бот-викторина остановлен!");
                    scanner.close();
                    return;
                }
                else if(user.equals("/помощь")){
                    System.out.println(CommandHelp.help());
                    continue;
                }
                if (entry.getValue().contains(user)) {
                    System.out.println("Верно!");
                } else {
                    System.out.println("Неверно!");
                }
                System.out.println();
            }
        }
    }

    public static List<Map.Entry<String, List<String>>> mixingOfQuestion(
            Map<String, List<String>> questions, Random random){
        List<Map.Entry<String, List<String>>> entries = new ArrayList<>(questions.entrySet());
        for (int i = entries.size() - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            Map.Entry<String, List<String>> temp = entries.get(i);
            entries.set(i, entries.get(j));
            entries.set(j, temp);
        }
        return entries;
    }

    public static Map<String, List<String>> readingFile(String fileName) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(fileName));
            Map<String, List<String>> questionsMap = new HashMap<>();
            for (String line : lines) {
                String[] parts = line.split("\\|", 2);
                if (parts.length >= 2) {
                    String key = parts[0].trim();
                    // Разделяем варианты ответов и убираем пробелы
                    String[] answers = parts[1].split("\\|");
                    List<String> answerList = new ArrayList<>();
                    for (String answer : answers) {
                        answerList.add(answer.trim().toLowerCase()); // сохраняем в нижнем регистре
                    }
                    questionsMap.put(key, answerList);
                }
            }
            return questionsMap;
        }
        catch (IOException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
            return new HashMap<>();
        }
    }
}