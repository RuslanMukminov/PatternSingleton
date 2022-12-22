import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Logger logger = Logger.getInstance();

        logger.log("Старт программы");

        System.out.println("Доброго времени суток!");

        logger.log("Просим пользователя ввести входные данные для списка");
        int n = inputInt("Введите размер списка: ");
        int m = inputInt("Введите верхнюю границу для значений: ");
        List<Integer> integerList = randomList(n, m);
        System.out.println("Вот случайный список: " + integerList);

        logger.log("Просим пользователя ввести входные данные для фильтрации");
        int f = inputInt("Введите порог для фильтра: ");
        List<Integer> filteredList = new Filter(f).filterOut(integerList);
        logger.log("Выводим результат на экран");
        System.out.println("Отфильтрованный список: " + filteredList);

        logger.log("Завершение программы");
    }

    public static int inputInt(String s) {
        int input;
        Logger logger = Logger.getInstance();
        while (true) {
            System.out.print(s);
            if (sc.hasNextInt()) {
                input = sc.nextInt();
                if (input > 0) {
                    break;
                }
            }
            logger.log("Некорректный ввод пользователем");
            sc.nextLine();
        }
        return input;
    }

    public static List<Integer> randomList(int n, int m) {
        Logger logger = Logger.getInstance();
        logger.log("Создаём и наполняем список");
        List<Integer> result = new ArrayList<>();
        Random random = new Random();
        int maxValue = m + 1;
        for (int i = 0; i < n; i++) {
            result.add(random.nextInt(maxValue));
        }
        return result;
    }
}
