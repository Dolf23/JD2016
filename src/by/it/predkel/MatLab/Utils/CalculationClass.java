package by.it.predkel.MatLab.Utils;

import by.it.predkel.MatLab.FloatVar;
import by.it.predkel.MatLab.MatrixVar;
import by.it.predkel.MatLab.OtherClasses.Patterns;
import by.it.predkel.MatLab.Var;

import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Admin on 18.03.2016.
 */
public class CalculationClass {

    private static TreeMap<String,Var> assignment=new TreeMap<>();
    static String[] expression;
    static ArrayList<Var> varArr = new ArrayList<>();
    static StringBuilder[] exp;
    public static void input(String rLine) throws IOException,IllegalArgumentException,ArithmeticException {
        expression = rLine.trim().split(" ");
        exp=new StringBuilder[rLine.trim().split(" ").length];
        for (int i = 0; i < expression.length; i++)
            exp[i] = new StringBuilder(expression[i]);

        Pattern pat = Pattern.compile(Patterns.exMat);
        Pattern pat1 = Pattern.compile(Patterns.exVec);
        Pattern pat2 = Pattern.compile(Patterns.exVal);

        if (expression[1].trim().equals("=")) {//проверка на наличие присваивания
            if (expression.length == 3) { //если обычное присваивание
                assignment.put(exp[0].toString().trim(), InputExpression.findExprission(exp[2].toString()));
            } else if (exp.length > 3) {
                checkMap(2);
                if ((exp[2] != null) & (exp[3] != null) & (exp[4] != null)) {
                    Var my = myOperation(exp[2], exp[3], exp[4]);
                    assignment.put(exp[0].toString().trim(), my);
                    one(my);
                } else System.out.print("Некорректные данные");
            }
        } else {
            if ((exp[0] != null) & (exp[1] != null) & (exp[2] != null)) {
                Var my = myOperation(exp[0], exp[1], exp[2]);
            /*
            for (int i = 0; i < exp.length; i += 2) {
                Matcher mat = pat.matcher(exp[i]);
                Matcher mat1 = pat1.matcher(exp[i]);
                Matcher mat2 = pat2.matcher(exp[i]);
                if ((mat.matches()) || (mat1.matches())) {// определение переменных и запись в коллекции
                    varArr.add(new MatrixVar(exp[i].toString()));
                } else if (mat2.matches()) {
                    varArr.add(new FloatVar(exp[i].toString()));
                } else
                    throw new IllegalArgumentException();
            }
            return myOperation(0).toString();
        }*/
                one(my);
            }
        }
        System.out.print("Ошибочка");
    }


    private static void one(Var v){
        if (v!=null) v.outPut();
    }

    public TreeMap<String,Var> getMyMap(){
        return assignment;
    }

    public static void sortvar() {
        if (!assignment.isEmpty()) {
            Set set = assignment.entrySet();
            Iterator it = set.iterator();
            while (it.hasNext()) {
                Map.Entry me = (Map.Entry) it.next();
                System.out.println(me);
            }
        }else
            System.out.println("Присваиваний не было");
    }

    public static Var myOperation(StringBuilder op1,StringBuilder oper,StringBuilder op2) throws IOException {//1 если с присваиванием и 0 если без(лень через флаг делать)
            switch (oper.toString().trim().charAt(0)) {
                case '+':
                    return (InputExpression.findExprission(op1.toString()).add(InputExpression.findExprission(op2.toString())));
                case '-':
                    return (InputExpression.findExprission(op1.toString()).sub(InputExpression.findExprission(op2.toString())));
                case '*':
                    return (InputExpression.findExprission(op1.toString()).mul(InputExpression.findExprission(op2.toString())));
                case '/':
                    return (InputExpression.findExprission(op1.toString()).div(InputExpression.findExprission(op2.toString())));
            }
        return null;
    }
    public static void checkMap(int k){//с какой позиции заменять перенные на значения
        Pattern pat34=Pattern.compile("[a-zA-Z]+([0-9]+)?");
        for (int i=k;i<exp.length;i++){
            Matcher mat34=pat34.matcher(exp[i]);
            if (mat34.matches()){
                exp[i].delete(0,exp[i].length());
                exp[i]=new StringBuilder(assignment.get(expression[i]).toString());
            }
        }
    }
}
