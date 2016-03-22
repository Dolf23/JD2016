package by.it.akhmelev.JD02_06;

public class GoF_02_Singleton {
    private static volatile GoF_02_Singleton instance;
    //конструктор класса
    private GoF_02_Singleton() {
    }
    //метод доступа к экземпляру
    public static GoF_02_Singleton getInstance() {
        GoF_02_Singleton localInstance = instance; //попытка получить объект
        if (localInstance == null) { //первая проверка (для скорости)
            synchronized (GoF_02_Singleton.class) {
                localInstance = instance; //вторая проверка для надежности
                if (localInstance == null) {
                    instance = localInstance = new GoF_02_Singleton(); //создание
                }
            }
        }
        return localInstance; //возврат
    }
    public static void main(String[ ] args) {
        System.out.print(new GoF_02_Singleton());
    }

}

