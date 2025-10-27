package laba_3;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputCheck {
    /**
     * Регулярное выражение для типа int
     */
    private static final String REGEX1 = "^[1-9]\\d*$";
    /**
     * * Регулярное выражение для типа String
     */
    private static final String REGEX2 = "^[a-zA-Zа-яА-Я][a-zA-Zа-яА-Я0-9 ]*$";
    /**
     * * Регулярное выражение для типа boolean
     */
    private static final String REGEX3 = "^(true|false)$";
    /**
     * Скомпилированный шаблон регулярного выражения для int
     */
    private static final Pattern PATTERN1 = Pattern.compile(REGEX1);
    /**
     * Скомпилированный шаблон регулярного выражения для String
     */
    private static final Pattern PATTERN2 = Pattern.compile(REGEX2);
    /**
     * Скомпилированный шаблон регулярного выражения для boolean
     */
    private static final Pattern PATTERN3 = Pattern.compile(REGEX3);

    /**
     * Метод, проверяющий содержимое строки на соответствие типу int
     * @param number Число в строковом представлении
     * @return Число int, соответствующее регулярному выражению
     */
    public static int checkInt(String number) {
        Matcher matcher = PATTERN1.matcher(number);
        if(!(matcher.matches())){
            throw new Error("Некорректный ввод! Разрешено только целое положительное число");
        }
        return Integer.parseInt(number);
    }

    /**
     * Метод, проверяющий строку на соответствие условию
     * @param input Строка
     * @return Строка, соответствующая регулярному выражению
     */
    public static String checkString(String input) {
        Matcher matcher = PATTERN2.matcher(input);
        if(!(matcher.matches())){
            throw new Error("Некорректный ввод! Строка может содержать только символы a-z и а-я и цифры 0-9");
        }
        return input;
    }

    /**
     * Метод, проверяющий строку на содержание только true/false
     * @param bool Строка
     * @return Булевое значение
     */
    public static boolean checkBoolean(String bool) {
        Matcher matcher = PATTERN3.matcher(bool);
        if(!(matcher.matches())){
            throw new Error("Некорректный ввод! Разрешен только true/false");
        }
        return Boolean.parseBoolean(bool);
    }
}

