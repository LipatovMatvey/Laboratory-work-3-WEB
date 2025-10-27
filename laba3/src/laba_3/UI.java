package laba_3;
import java.util.Scanner;

public class UI {
    /**
     * Объект класса Scanner для чтения ввода из консоли
     */
    Scanner in = new Scanner(System.in);

    /**
     * Метод запуска пользовательского интерфейса
     */
    public void run() {
        while(true) {
            System.out.println("Выберите команду:");
            System.out.println("1 -> Создать стул");
            System.out.println("2 -> Создать стол");
            System.out.println("3 -> Вывести габаритный размер всех объектов");
            System.out.println("4 -> Упорядочить объекты по названию");
            System.out.println("5 -> Изменить поле объекта");
            System.out.println("6 -> Вывести количество предметов мебели, весом меньше среднего");
            System.out.println("7 -> Вывести все элементы списка");
            System.out.println("8 -> Заполнить список дефолтными значениями");
            System.out.println("0 -> Выход");
            System.out.print("Номер команды: ");

            String input = in.nextLine().trim();

            switch (input) {
                case "1" -> createChair();
                case "2" -> createTable();
                case "3" -> printObjectsSize();
                case "4" -> { Furniture.sortByName(); printList(); }
                case "5" -> editAttribute();
                case "6" -> printCount();
                case "7" -> printList();
                case "8" -> createDefaultObjects();
                case "0" -> { System.out.println("Выход"); return; }
                default -> System.out.println("Неверная команда. Повторите ввод");
            }
        }

    }

    /**
     * Метод создания объекта класса Chair
     */
    private void createChair() {
        try{
            System.out.println("Создание стула:");
            System.out.print("Высота: ");
            int h = InputCheck.checkInt(in.nextLine().trim());
            System.out.print("Ширина: ");
            int w = InputCheck.checkInt(in.nextLine().trim());
            System.out.print("Глубина: ");
            int d = InputCheck.checkInt(in.nextLine().trim());
            System.out.print("Вес: ");
            int weight = InputCheck.checkInt(in.nextLine().trim());
            System.out.print("Имя: ");
            String name = InputCheck.checkString(in.nextLine().trim());
            System.out.print("Тип: ");
            String type = InputCheck.checkString(in.nextLine().trim());
            System.out.print("Есть ли подлокотники (true/false): ");
            boolean arms = InputCheck.checkBoolean(in.nextLine().trim());
            System.out.print("Максимальная нагрузка: ");
            int load = InputCheck.checkInt(in.nextLine().trim());

            new Chair(h, w, d, weight, name, type, arms, load);
            System.out.println("Стул создан и добавлен в список!");
        }
        catch (Error error) {
            System.out.println("Возникла ошибка: " + error.getMessage());
        }
    }

    /**
     * Метод создания объекта класса Table
     */
    private void createTable() {
        try{
            System.out.println("Создание стола:");
            System.out.print("Высота: ");
            int h = InputCheck.checkInt(in.nextLine().trim());
            System.out.print("Ширина: ");
            int w = InputCheck.checkInt(in.nextLine().trim());
            System.out.print("Глубина: ");
            int d = InputCheck.checkInt(in.nextLine().trim());
            System.out.print("Вес: ");
            int weight = InputCheck.checkInt(in.nextLine().trim());
            System.out.print("Имя: ");
            String name = InputCheck.checkString(in.nextLine().trim());
            System.out.print("Количество ножек: ");
            int legs = InputCheck.checkInt(in.nextLine().trim());
            System.out.print("Форма: ");
            String shape = InputCheck.checkString(in.nextLine().trim());
            System.out.print("Есть ящики (true/false): ");
            boolean drawers = InputCheck.checkBoolean(in.nextLine().trim());

            new Table(h, w, d, weight, name, legs, shape, drawers);
            System.out.println("Стол создан и добавлен в список!");
        }
        catch (Error error){
            System.out.println("Возникла ошибка: " + error.getMessage());
        }
    }

    /**
     * Метод изменения поля объекта
     */
    private void editAttribute() {
        try{
            System.out.print("Введите имя объекта, поле которого вы хотите изменить: ");
            String name = InputCheck.checkString(in.nextLine().trim());

            Furniture furniture = Furniture.findFurniture(name);
            String objectType = Furniture.objectType(name);

            if(furniture != null) {
                System.out.println("Поля, доступные к изменению: ");
                System.out.println(furniture.printFieldsNull());
                System.out.print("Введите номер изменяемого поля: ");
                String input = in.nextLine().trim();
                System.out.print("Введите новое значение поля: ");
                String newAttribute = in.nextLine().trim();

                if (objectType.equals("Chair")) {
                    switch (input) {
                        case "1" -> System.out.println(furniture.editField(name, newAttribute, "Высота"));
                        case "2" -> System.out.println(furniture.editField(name, newAttribute, "Ширина"));
                        case "3" -> System.out.println(furniture.editField(name, newAttribute, "Глубина"));
                        case "4" -> System.out.println(furniture.editField(name, newAttribute, "Вес"));
                        case "5" -> System.out.println(furniture.editField(name, newAttribute, "Имя"));
                        case "6" -> System.out.println(furniture.editField(name, newAttribute, "Тип стула"));
                        case "7" -> System.out.println(furniture.editField(name, newAttribute, "Наличие подлокотников"));
                        case "8" -> System.out.println(furniture.editField(name, newAttribute, "Максимальная нагрузка"));
                        default -> System.out.println("Неверный номер изменяемого поля.");
                    }
                }
                else {
                    switch (input) {
                        case "1" -> System.out.println(furniture.editField(name, newAttribute, "Высота"));
                        case "2" -> System.out.println(furniture.editField(name, newAttribute, "Ширина"));
                        case "3" -> System.out.println(furniture.editField(name, newAttribute, "Глубина"));
                        case "4" -> System.out.println(furniture.editField(name, newAttribute, "Вес"));
                        case "5" -> System.out.println(furniture.editField(name, newAttribute, "Имя"));
                        case "6" -> System.out.println(furniture.editField(name, newAttribute, "Количество ножек"));
                        case "7" -> System.out.println(furniture.editField(name, newAttribute, "Форма"));
                        case "8" -> System.out.println(furniture.editField(name, newAttribute, "Наличие ящиков"));
                        default -> System.out.println("Неверная команда.");
                    }
                }
            }
            else {
                System.out.println("Объекта с таким именем не существует!");
            }
        }
        catch (Error error) {
            System.out.println("Возникла ошибка: " + error.getMessage());
        }
    }

    /**
     * Метод вывода габаритов объектов списка
     */
    private void printObjectsSize() {
        System.out.println(Furniture.printSizeObjects());
    }

    /**
     * Метод вывода объектов списка
     */
    private void printList() {
        System.out.print(Furniture.printList());
    }

    /**
     * Метод вывода кол-ва предметов весом меньше среднего
     */
    private void printCount() {
        if(!Furniture.getList().isEmpty()){
            System.out.println("Количество предметов мебели, весом меньше среднего = " + Furniture.countBelowAvgWeight());
        }
        else {
            System.out.println("Список пуст!");
        }
    }

    /**
     * Метод, заполняющий коллекцию дефолтными значениями
     */
    private void createDefaultObjects() {
        Furniture.defaultObjects();
    }
}