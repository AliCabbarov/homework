package model;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Type {
    private String packageName;
    private String classType;
    private Method[] methods;
    private Field[] fields;
    private Constructor<User>[] constructors;

    public Type(String packageName, String classType, Method[] methods, Field[] fields, Constructor<User>[] constructors) {
        this.packageName = packageName;
        this.classType = classType;
        this.methods = methods;
        this.fields = fields;
        this.constructors = constructors;
    }



    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getClassType() {
        return classType;
    }

    public void setClassType(String classType) {
        this.classType = classType;
    }

    public Method[] getMethods() {
        return methods;
    }

    public void setMethods(Method[] methods) {
        this.methods = methods;
    }

    public Field[] getFields() {
        return fields;
    }

    public void setFields(Field[] fields) {
        this.fields = fields;
    }

    public Constructor<User>[] getConstructors() {
        return constructors;
    }

    public void setConstructors(Constructor<User>[] constructors) {
        this.constructors = constructors;
    }

    @Override
    public String toString() {
        return "Type{" +
                "packageName='" + packageName + '\'' +
                ", classType='" + classType + '\'' +
                ", methods=" + Arrays.toString(methods) +
                ", fields=" + Arrays.toString(fields) +
                ", constructors=" + Arrays.toString(constructors) +
                '}';
    }
}
