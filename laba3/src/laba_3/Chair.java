package laba_3;
public class Chair extends Furniture {
    /**
     * Тип стула
     */
    private String type;
    /**
     * Наличие подлокотников
     */
    private boolean hasArmrest;
    /**
     * Максимальная нагрузка
     */
    private int maxLoad;

    /**
     * Конструктор по умолчанию
     */
    Chair() {
        super();
        this.type = "";
        this.hasArmrest = false;
        this.maxLoad = 0;
    }

    /**
     * Конструктор с параметрами
     * @param height Высота
     * @param width Ширина
     * @param depth Глубина
     * @param weight Вес
     * @param name Имя
     * @param type Тип
     * @param hasArmrest Наличие подлокотников
     * @param maxLoad Максимальная нагрузка
     */
    Chair(int height, int width, int depth, int weight, String name, String type,
          boolean hasArmrest, int maxLoad) {
        super(height, width, depth, weight, name);
        this.type = type;
        this.hasArmrest = hasArmrest;
        this.maxLoad = maxLoad;
        Furniture.list.add(this);
    }

    /**
     * Метод выводит поля объекта
     */
    @Override
    public String printFields() {
        return super.printFields() +
                "Тип: " + type + "\n" +
                "Наличие подлокотников: " + hasArmrest + "\n" +
                "Максимальная нагрузка: " + maxLoad + "\n";
    }

    /**
     * Сеттер поля type
     * @param newType Новое значение типа стула
     */
    public void setType(String newType){
        this.type = newType;
    }

    /**
     * Сеттер поля maxLoad
     * @param newMaxLoad Новое значение максимальной нагрузки
     */
    public void setMaxLoad(int newMaxLoad){
        this.maxLoad = newMaxLoad;
    }

    /**
     * Сеттер поля hasArmrest
     * @param newHasArmrest Новое значение поля hasArmrest
     */
    public void setHasArmrest(boolean newHasArmrest){
        this.hasArmrest = newHasArmrest;
    }

    /**
     * Метод изменения поля экземпляра класса
     * @param name Поле name объекта
     * @param type Класс объекта
     * @param newAttribute Новое значение поля
     * @param field Название изменяемого поля
     * @return Сообщение об изменении поля
     */
    @Override
    public String editFild(String name, String type, String newAttribute, String field) {
        Furniture furniture = findFurniture(name, type);
        if(furniture != null) {
            switch (field){
                case "Тип стула" -> ((Chair) furniture).setType(MyException.checkString(newAttribute));
                case "Наличие подлокотников" -> ((Chair) furniture).setHasArmrest(MyException.checkBoolean(newAttribute));
                case "Максимальная нагрузка" -> ((Chair) furniture).setMaxLoad(MyException.checkInt(newAttribute));
                default -> {
                    return super.editFild(name, type, newAttribute, field);
                }
            }
            return "Выбранное вами поле изменено: " + "\n" + ((Chair) furniture).printFields();
        }
        else {
            return("Такого объекта не существует");
        }
    }
}

