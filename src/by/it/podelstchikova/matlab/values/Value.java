package by.it.podelstchikova.matlab.values;

import by.it.podelstchikova.matlab.interfaces.IValue;

import java.util.Arrays;

public abstract class Value implements IValue {

    public String value;

    public Value(double value){
        this.value = String.valueOf(value);
    }

    public Value(double[] value){
        this.value = Arrays.toString(value);
    }

    public Value(double[][] value){
        StringBuilder stringBuilder = new StringBuilder();
        for (double[] d : value){
            stringBuilder.append(Arrays.toString(d));
        }

        this.value = stringBuilder.toString();
    }

    public Value(String variableName){
        this.value = variableName;
    }

    @Override
    public String toString(){
        return "Type: " + this.getClass().getSimpleName() + "; Value: " + value;
    }

    @Override
    public String getValue() {
        return value;
    }
}
