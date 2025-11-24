package commands;

public class CommandGreeting {
    public static String greeting(){
        return """
                Привет! Это консольный бот - викторина!
                Он будет задавать вопросы, пока ты не решишь остановиться!
                Когда решишь закончить напиши '/стоп'! Если есть вопросы напиши '/помощь'!
                """;
    }
}
