package laba_3;
public class Table extends Furniture {
    /**
     * Кол-во ножек
     */
    private int legsCount;
    /**
     * Форма
     */
    private String shape;
    /**
     * Наличие ящиков
     */
    private boolean hasDrawers;

    /**
     * Конструктор по умолчанию
     */
    Table() {
        super();
        this.legsCount = 0;
        this.shape = "";
        this.hasDrawers = false;
    }

    /**
     * Конструктор с параметрами
     * @param height Высота
     * @param width Ширина
     * @param depth Глубина
     * @param weight Ширина
     * @param name Имя
     * @param legsCount Кол-во ножек
     * @param shape Форма
     * @param hasDrawers Наличие ящиков
     */
    Table(int height, int width, int depth, int weight, String name, int legsCount,
          String shape, boolean hasDrawers) {
        super(height, width, depth, weight, name);
        this.legsCount = legsCount;
        this.shape = shape;
        this.hasDrawers = hasDrawers;
        Furniture.list.add(this);
    }

    /**
     * Метод выводит поля объекта
     */
    @Override
    public String printFields() {
        return super.printFields() +
                "Форма: " + shape + "\n" +
                "Количество ножек: " + legsCount + "\n" +
                "Ящики: " + hasDrawers + "\n";
    }

    /**
     * Сеттер для legsCount
     * @param legsCount Новое значение legsCount
     */
    public void setLegsCount(int legsCount) {
        this.legsCount = legsCount;
    }

    /**
     * Сеттер для shape
     * @param shape Новое значение shape
     */
    public void setShape(String shape) {
        this.shape = shape;
    }

    /**
     * Сеттер для hasDrawers
     * @param hasDrawers Новое значение hasDrawers
     */
    public void setHasDrawers(boolean hasDrawers) {
        this.hasDrawers = hasDrawers;
    }

    /**
     * Метод изменения поля экземпляра класса
     * @param name Поле name объекта
     * @param newAttribute Новое значение поля
     * @param field Название изменяемого поля
     * @return Сообщение об изменении поля
     */
    @Override
    public String editField(String name, String newAttribute, String field) {
        Furniture furniture = findFurniture(name);
        if(furniture != null) {
            switch (field){
                case "Количество ножек" -> ((Table) furniture).setLegsCount(InputCheck.checkInt(newAttribute));
                case "Форма" -> ((Table) furniture).setShape(InputCheck.checkString(newAttribute));
                case "Наличие ящиков" -> ((Table) furniture).setHasDrawers(InputCheck.checkBoolean(newAttribute));
                default -> {
                    return super.editField(name, newAttribute, field);
                }
            }
            return "Выбранное вами поле изменено: " + "\n" + ((Table) furniture).printFields();
        }
        else {
            return("Такого объекта не существует");
        }
    }

    /**
     * Метод вывода полей объекта для пользователя
     * @return Строка с полями объекта
     */
    @Override
    public String printFieldsNull() {
        return super.printFieldsNull() +
                "Количество ножек(6): " + "\n" +
                "Форма(7): " + "\n" +
                "Наличие ящиков(8): " + "\n";
    }
}