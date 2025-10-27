package laba_3;
import java.util.ArrayList;
import java.util.Collections;

abstract public class Furniture {
    /**
     * Высота
     */
    protected int height;
    /**
     * Ширина
     */
    protected int width;
    /**
     * Глубина
     */
    protected int depth;
    /**
     * Вес
     */
    protected int weight;
    /**
     * Имя
     */
    protected String name;
    /**
     * Список с объектами производных классов
     */
    protected static ArrayList<Furniture> list = new ArrayList<>();

    /**
     * Конструктор по умолчанию
     */
    Furniture() {
        this.height = 0;
        this.width = 0;
        this.depth = 0;
        this.weight = 0;
        this.name = "";

    }

    /**
     * Конструктор с параметрами
     * @param height Высота
     * @param width Ширина
     * @param depth Глубина
     * @param weight Вес
     * @param name Имя
     */
    Furniture(int height, int width, int depth, int weight, String name) {
        this.height = height;
        this.width = width;
        this.depth = depth;
        this.weight = weight;
        this.name = name;

    }

    /**
     * Метод вывода габаритного размера мебели
     * @return Строка с габаритным размером
     */
    public String printSize(){
        return "Габаритный размер мебели: " +
                width + "x" + depth + "x" + height;
    }

    /**
     * Сеттер поля weight
     * @param newWeight Новое значение веса
     */
    public void setWeight(int newWeight){
        this.weight = newWeight;
    }

    /**
     * Сеттер поля height
     * @param newHeight Новое значение высоты
     */
    public void setHeight(int newHeight){
        this.height = newHeight;
    }

    /**
     * Сеттер поля width
     * @param newWidth Новое значение ширины
     */
    public void setWidth(int newWidth){
        this.width = newWidth;
    }

    /**
     * Сеттер поля глубина
     * @param newDepth Новое значение глубины
     */
    public void setDepth(int newDepth){
        this.depth = newDepth;
    }

    /**
     * Сеттер поля name
     * @param name Новое имя
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Метод вывода полей объекта
     * @return Строка с полями объекта
     */
    public String printFields(){
        return "Высота: " + height + "\n" +
                "Ширина: " + width + "\n" +
                "Глубина: " + depth + "\n" +
                "Вес: " + weight + "\n" +
                "Имя: " + name + "\n";
    }

    /**
     * Метод сортирует список по именам объекта в алфавитном порядке
     */
    protected static void sortByName(){
        for (int i = 0; i < list.size() - 1; i++){
            for (int j = 0; j < list.size() - i - 1; j++){
                if (list.get(j).name.compareTo(list.get(j + 1).name) > 0){
                    Collections.swap(list, j, j + 1);
                }
            }
        }
    }

    /**
     * Метод считает количество элементов списка, значения веса которых меньше среднего значения веса по списку
     * @return Количество элементов списка
     */
    protected static String countBelowAvgWeight(){
        int sum = 0;
        int count = 0;
        if (!list.isEmpty()){
            for (Furniture f : list){
                sum += f.weight;
            }
            int middle = sum / list.size();

            for (Furniture f : list) {
                if (f.weight < middle) {
                    count++;
                }
            }
        }
        return String.valueOf(count);
    }

    /**
     * Метод находит объект в списке по имени
     * @param name Имя объекта
     * @return объект, иначе - null
     */
    protected static Furniture findFurniture(String name) {
        for(Furniture f : list) {
            if (f.name.equals(name)) {
                return f;
            }
        }
        return null;
    }

    protected static String objectType(String name) {
        for(Furniture f : list) {
            if (f.name.equals(name)) {
                return f.getClass().getSimpleName();
            }
        }
        return null;
    }


    /**
     * Метод изменения поля экземпляра класса
     * @param name Поле name объекта
     * @param newAttribute Новое значение поля
     * @param field Название изменяемого поля
     * @return Сообщение об изменении поля
     */
    public String editField(String name, String newAttribute, String field) {
        Furniture furniture = findFurniture(name);
        if(furniture != null) {
            switch (field){
                case "Высота" -> furniture.setHeight(InputCheck.checkInt(newAttribute));
                case "Ширина" -> furniture.setWidth(InputCheck.checkInt(newAttribute));
                case "Глубина" -> furniture.setDepth(InputCheck.checkInt(newAttribute));
                case "Вес" -> furniture.setWeight(InputCheck.checkInt(newAttribute));
                case "Имя" -> furniture.setName(InputCheck.checkString(newAttribute));
                default -> {
                    return "Вы ввели несуществующее поле класса";
                }
            }
            return "Выбранное вами поле изменено: " + "\n" + furniture.printFields();
        }
        else {
            return("Такого объекта не существует");
        }
    }

    /**
     * Метод возвращает список
     * @return ArrayList Список с объектами класса Furniture
     */
    public static ArrayList<Furniture> getList() {
        return list;
    }

    /**
     * Метод вывода габаритов объектов списка
     * @return Строка габаритов объекта
     */
    public static String printSizeObjects() {
        String resultString = "";
        if (!list.isEmpty()){
            for(Furniture f : list) {
                resultString += f.name + ": " + f.printSize() + "\n";
            }
        }
        else{
            resultString = "Список пуст!";
        }
        return resultString;
    }

    /**
     * Метод вывода полей всех объектов списка
     * @return Строка со свойствами всех объектов списка
     */
    public static String printList() {
        String resultString = "";
        if (!list.isEmpty()) {
            for(Furniture f : list){
                resultString += f.printFields() + "\n";
            }
        }
        else {
            resultString = "Список пуст";
        }

        return resultString;
    }

    /**
     * Метод, заполняющий коллекцию дефолтными значениями
     */
    public static void defaultObjects() {
        new Table(100, 200, 300, 50, "Стол1", 4, "Круглый", false);
        new Table(111, 222, 333, 40, "Стол2", 4, "Прямоугольный", true);
        new Chair(50, 70, 66, 10, "Стул1", "Трон", true, 150);
        new Chair(55, 77, 61, 7, "Стул2", "Игровой", true, 130);
    }

    /**
     * Метод вывода полей объекта для пользователя
     * @return Строка с полями объекта
     */
    public String printFieldsNull(){
        return "Высота(1): " + "\n" +
                "Ширина(2): " + "\n" +
                "Глубина(3): " + "\n" +
                "Вес(4): " + "\n" +
                "Имя(5): " + "\n";
    }
}