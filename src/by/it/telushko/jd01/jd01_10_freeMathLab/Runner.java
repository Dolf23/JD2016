package by.it.telushko.jd01.jd01_10_freeMathLab;


import by.it.telushko.jd01.jd01_10_freeMathLab.Vars.Var;
import by.it.telushko.jd01.jd01_10_freeMathLab.Vars.VarF;
import by.it.telushko.jd01.jd01_10_freeMathLab.Vars.VarV;

public class Runner {
    private static void one(Var v) {
        if (v != null) System.out.println(v);
    }

    public static void main(String[] args) {
        //вместо парсера ввода в DEMO использовано создание готовых объектов из строк
        //в реальном решении еще нужно программно определить тип объекта
        System.out.println("\nпроверка операций со скалярами");
        one(new VarF("1").add(new VarF("2")));
        one(new VarF("9").sub(new VarF("7")));
        one(new VarF("1.5").mul(new VarF("2")));
        one(new VarF("-4").div(new VarF("-1")));

        String vec = "{1,2,3}";
        System.out.println("\nпроверка операций с векторами справа и скалярами слева");
        one(new VarV(vec).add(new VarF("2")));
        one(new VarV(vec).sub(new VarF("1")));
        one(new VarV(vec).mul(new VarF("2")));
        one(new VarV(vec).div(new VarF("1")));

        System.out.println("\nпроверка операций со скалярами справа и векторами слева");
        one(new VarF("1").add(new VarV(vec)));
        one(new VarF("2").sub(new VarV(vec)));
        one(new VarF("1").mul(new VarV(vec)));
        one(new VarF("2").div(new VarV(vec)));

        System.out.println("\nпроверка операций с двумя векторами");
        one(new VarV(vec).add(new VarV(vec)));
        one(new VarV(vec).sub(new VarV(vec)));
        one(new VarV(vec).mul(new VarV(vec)));
        one(new VarV(vec).div(new VarV(vec)));
    }
}