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
            int h = MyException.checkInt(in.nextLine().trim());
            System.out.print("Ширина: ");
            int w = MyException.checkInt(in.nextLine().trim());
            System.out.print("Глубина: ");
            int d = MyException.checkInt(in.nextLine().trim());
            System.out.print("Вес: ");
            int weight = MyException.checkInt(in.nextLine().trim());
            System.out.print("Имя: ");
            String name = MyException.checkString(in.nextLine().trim());
            System.out.print("Тип: ");
            String type = MyException.checkString(in.nextLine().trim());
            System.out.print("Есть ли подлокотники (true/false): ");
            boolean arms = MyException.checkBoolean(in.nextLine().trim());
            System.out.print("Максимальная нагрузка: ");
            int load = MyException.checkInt(in.nextLine().trim());

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
            int h = MyException.checkInt(in.nextLine().trim());
            System.out.print("Ширина: ");
            int w = MyException.checkInt(in.nextLine().trim());
            System.out.print("Глубина: ");
            int d = MyException.checkInt(in.nextLine().trim());
            System.out.print("Вес: ");
            int weight = MyException.checkInt(in.nextLine().trim());
            System.out.print("Имя: ");
            String name = MyException.checkString(in.nextLine().trim());
            System.out.print("Количество ножек: ");
            int legs = MyException.checkInt(in.nextLine().trim());
            System.out.print("Форма: ");
            String shape = MyException.checkString(in.nextLine().trim());
            System.out.print("Есть ящики (true/false): ");
            boolean drawers = MyException.checkBoolean(in.nextLine().trim());

            new Table(h, w, d, weight, name, legs, shape, drawers);
            System.out.println("Стол создан и добавлен в список!");
        }
        catch (Error error){
            System.out.println("Возникла ошибка: " + error.getMessage());
        }
    }


    /**
     * Метод изменения веса стола
     */
    private void editAttribute() {
        try{
            System.out.print("Введите название класса, поле объекта которого вы хотите изменить (Chair/Table): ");
            String nameClass = MyException.checkString(in.nextLine().trim());
            System.out.print("Введите имя экземпляра данного класса для изменения: ");
            String name = MyException.checkString(in.nextLine().trim());

            Furniture furniture = Furniture.findFurniture(name, nameClass);
            if(furniture != null){
                if (nameClass.equals("Chair")){
                    System.out.print("НАПОМИНАНИЕ: поля выбранного класса: \nВысота(1) \nШирина(2) \nГлубина(3) \nВес(4)" +
                            " \nТип стула(5) \nНаличие подлокотников(6) \nМаксимальная нагрузка(7)\nИмя(8) \n");
                    System.out.println("Введите номер поля, которое хотите изменить:");
                    String input = in.nextLine();
                    System.out.println("Введите новое значение поля:");
                    String newAttribute = in.nextLine();

                    switch (input) {
                        case "1" -> System.out.println(furniture.editFild(name, nameClass, newAttribute, "Высота"));
                        case "2" -> System.out.println(furniture.editFild(name, nameClass, newAttribute, "Ширина"));
                        case "3" -> System.out.println(furniture.editFild(name, nameClass, newAttribute, "Глубина"));
                        case "4" -> System.out.println(furniture.editFild(name, nameClass, newAttribute, "Вес"));
                        case "5" -> System.out.println(furniture.editFild(name, nameClass, newAttribute, "Тип стула"));
                        case "6" -> System.out.println(furniture.editFild(name, nameClass, newAttribute, "Наличие подлокотников"));
                        case "7" -> System.out.println(furniture.editFild(name, nameClass, newAttribute, "Максимальная нагрузка"));
                        case "8" -> System.out.println(furniture.editFild(name, nameClass, newAttribute, "Имя"));
                        default -> System.out.println("Неверная команда.");
                    }
                }
                else if (nameClass.equals("Table")){
                    System.out.print("НАПОМИНАНИЕ: поля выбранного класса: \nВысота(1) \nШирина(2) \nГлубина(3) \nВес(4)" +
                            " \nКоличество ножек(5) \nФорма(6) \nНаличие ящиков(7)\nИмя(8) \n");
                    System.out.println("Введите номер поля, которое хотите изменить:");
                    String input = in.nextLine();
                    System.out.println("Введите новое значение поля:");
                    String newAttribute = in.nextLine();

                    switch (input) {
                        case "1" -> System.out.println(furniture.editFild(name, nameClass, newAttribute, "Высота"));
                        case "2" -> System.out.println(furniture.editFild(name, nameClass, newAttribute, "Ширина"));
                        case "3" -> System.out.println(furniture.editFild(name, nameClass, newAttribute, "Глубина"));
                        case "4" -> System.out.println(furniture.editFild(name, nameClass, newAttribute, "Вес"));
                        case "5" -> System.out.println(furniture.editFild(name, nameClass, newAttribute, "Количество ножек"));
                        case "6" -> System.out.println(furniture.editFild(name, nameClass, newAttribute, "Форма"));
                        case "7" -> System.out.println(furniture.editFild(name, nameClass, newAttribute, "Наличие ящиков"));
                        case "8" -> System.out.println(furniture.editFild(name, nameClass, newAttribute, "Имя"));
                        default -> System.out.println("Неверная команда.");
                    }
                }
                else {
                    System.out.println("Неверное имя класса!");
                }
            }
            else {
                System.out.println("Объект не найден!");
            }
        }
        catch (Error error) {
            System.out.println("Возникла ошибка: " + error.getMessage());
        }
    }


    /**
     * Метод вывода габаритных размеров объектов списка
     */
    private void printObjectsSize() {
        System.out.println(Furniture.printSizeObjects());
    }

    /**
     * Метод вывода объектов списка
     */
    private void printList() {
        System.out.println(Furniture.printList());
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
        System.out.println("Заполнили список дефолтными объектами!");
    }
}