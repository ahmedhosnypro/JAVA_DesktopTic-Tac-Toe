import java.util.Scanner;
import java.util.logging.Level;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        int logsLevelInt = 0;
        for (String str : input) {
            Level level = Level.parse(str.toUpperCase());
            logsLevelInt += level.intValue();
        }
        System.out.println(logsLevelInt);
    }
}