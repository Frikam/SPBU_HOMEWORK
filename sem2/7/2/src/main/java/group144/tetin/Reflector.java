package group144.tetin;

import java.io.*;
import java.lang.reflect.*;

public class Reflector {
    public String printStructure(Class<?> someClass) throws IOException {
        StringBuilder newClass = new StringBuilder();
        FileWriter fileWriter = new FileWriter( "src//test//java//group144//tetin//ResultOfReflection//" + someClass.getSimpleName() + ".java");
        printPackage(someClass, newClass);
        printClass(someClass, newClass);

        fileWriter.write(newClass.toString());
        fileWriter.close();
        return newClass.toString();
    }

    /** A method that print a package */
    private void printPackage(Class<?> someClass, StringBuilder newClass) {
        newClass.append("package " + someClass.getPackage().getName() + ".ResultOfReflection;" + "\n\n" );
    }

    private void printClass(Class<?> someClass, StringBuilder newClass) {
        writeInfo(someClass, newClass);
        printFields(someClass, newClass);
        printMethods(someClass, newClass);
        printConstructors(someClass, newClass);
        getInnerClasses(someClass, newClass);
    }

    /** A method that writing information about class */
    private void writeInfo(Class<?> someClass, StringBuilder newClass) {
        newClass.append(Modifier.toString(someClass.getModifiers()));
        newClass.append(" class " + someClass.getSimpleName());

        TypeVariable[] parameters = someClass.getTypeParameters();
        printTypeParameters(parameters, newClass);
        printSuperclass(someClass, newClass);
        printInterface(someClass, newClass);
        newClass.append(" {" + "\n");
    }

    /** A method that print super class if he exists */
    private void printSuperclass(Class<?> someClass, StringBuilder newClass) {
        if (someClass.getSuperclass() != null) {
            newClass.append(" extends " + someClass.getSuperclass().getSimpleName() + " ");
            printTypeParameters(someClass.getSuperclass().getTypeParameters(), newClass);
        }
    }

    /** A method that print type of parameters if they exists */
    private void printTypeParameters(TypeVariable[] parameters, StringBuilder newClass) {
        int length = parameters.length;

        if (length != 0) {
            newClass.append("<");
            for (int i = 0; i < length; i++) {
                newClass.append(parameters[i].getName());

                if (i < length - 1) {
                    newClass.append(", ");
                }
            }
            newClass.append(">");
        }
    }

    /** A method that prints interface of class if he exists */
    private void printInterface(Class<?> someClass, StringBuilder newClass) {
        Class[] interfaces = someClass.getInterfaces();
        int length = interfaces.length;

        if (length != 0) {
            newClass.append(" implements ");
            for (int i = 0; i < length; i++) {
                newClass.append(interfaces[i].getSimpleName());
                printTypeParameters(interfaces[i].getTypeParameters(), newClass);

                if (i < length - 1) {
                    newClass.append(", ");
                }
            }
        }
    }

    /** A method that prints fields of class */
    private void printFields(Class<?> someClass, StringBuilder newClass) {
        Field[] fields = someClass.getDeclaredFields();

        for (Field field: fields) {
            if (!getField(field).contains("$")) {
                newClass.append(getField(field));
                newClass.append(" = ");
                printReturnedValue(field.getType(), newClass);
            }
        }

        newClass.append("\n");
    }

    private String getField(Field field) {
        String modifier = Modifier.toString(field.getModifiers()) + " ";
        return "\t" + modifier + field.getType().getSimpleName() + " " + field.getName();
    }

    /** A method that prints methods of class */
    private void printMethods(Class<?> someClass, StringBuilder newClass) {
        if (someClass.getDeclaredMethods().length != 0) {
            Method[] methods = someClass.getDeclaredMethods();

            for (Method method : methods) {
                printSomeMethod(method, newClass);
            }
        }
    }

    private void printSomeMethod(Method method, StringBuilder newClass) {
        if (method.getName().contains("$")) {
            return;
        }
        newClass.append("\t" + Modifier.toString(method.getModifiers()) + " ");
        newClass.append(method.getReturnType().getSimpleName() + " ");
        newClass.append(method.getName() + " ");

        Parameter[] parameters = method.getParameters();
        printParametrs(parameters, newClass);

        printExceptions(method, newClass);
        newClass.append(" { \n");

        if (!method.getReturnType().getSimpleName().equals("void")) {
            newClass.append("\t\treturn ");
            printReturnedValue(method.getReturnType(), newClass);
        }

        newClass.append("\t}" + "\n\n");
    }

    /** A method that prints parameters of method */
    private void printParametrs(Parameter[] parameters, StringBuilder newClass) {
        int length = parameters.length;
        newClass.append("(");

        for (int i = 0; i < length; i++) {
            newClass.append(parameters[i].getParameterizedType().getTypeName() + " ");
            newClass.append(parameters[i].getName());
            if (i < length - 1) {
                newClass.append(", ");
            }
        }

        newClass.append(") ");
    }

    /** A method that prints exceptions of method */
    private void printExceptions(Method method, StringBuilder newClass) {
        Class[] exceptions = method.getExceptionTypes();
        int length = exceptions.length;
        if (length != 0) {
            newClass.append("throws ");
            for (int i = 0; i < length; i++) {
                newClass.append(exceptions[i].getSimpleName());

                if (i < length - 1) {
                    newClass.append(", ");
                }
            }
        }
    }

    /** A method that prints returned value of method */
    private void printReturnedValue(Type returnType, StringBuilder newClass) {
        String value = "";
        switch (returnType.getTypeName()) {
            case "Integer":
                value = "0";
                break;
            case "String":
                value = "0";
                break;
            case "boolean":
                value = "true";
                break;
            case "char":
                value = "0";
                break;
            case "int":
                value = "0";
                break;
            case "Double":
                value = "0.0";
                break;
            default:
                value = "null";
        }

        newClass.append(value + ";" + "\n");
    }

    /** A method that prints constructors of class */
    private void printConstructors(Class<?> someClass, StringBuilder newClass) {
        Constructor[] constructors = someClass.getDeclaredConstructors();
        int length = constructors.length;
        for (Constructor constructor : constructors) {
            newClass.append("\t" + someClass.getSimpleName() + " ");
            printParametrs(constructor.getParameters(), newClass);
            newClass.append(" {" + "");
        }
        newClass.append("\n\t}\n");
    }

    /** A method that prints inner classes of class */
    private void getInnerClasses(Class<?> someClass, StringBuilder newClass) {
        if (someClass.getDeclaredClasses().length != 0) {
            newClass.append("\n\t");
        }

        for (Class<?> innerClass : someClass.getDeclaredClasses()) {
            printClass(innerClass, newClass);
            newClass.append("\n");
        }
        newClass.append("}");
    }

    public boolean diffClasses(Class<?> firstClass, Class<?> secondClass) {
        StringBuilder diffBetweenClasses = new StringBuilder();
        getDifference(firstClass, secondClass, diffBetweenClasses);
        if (diffBetweenClasses.length() == 0) {
            System.out.println("Classes are equals");
            return true;
        }

        System.out.println("Classes aren't equals");
        System.out.print(diffBetweenClasses);
        return false;
    }

    private void getDifference(Class<?> firstClass, Class<?> secondClass, StringBuilder diffBetweenClasses) {
        getDifferenceInFields(firstClass, secondClass, diffBetweenClasses);
        getDifferenceInMethods(firstClass, secondClass, diffBetweenClasses);
    }

    private void getDifferenceInFields(Class<?> firstClass, Class<?> secondClass, StringBuilder diffBetweenClasses) {
        Field[] fieldsFromFirst = firstClass.getDeclaredFields();
        Field[] fieldsFromSecond = secondClass.getDeclaredFields();

        if (fieldsFromFirst.equals(fieldsFromSecond)) {
            return;
        }

        for (Field field : fieldsFromFirst) {
            if (!contains(fieldsFromSecond, field)) {
                diffBetweenClasses.append(getField(field));
            }
        }

        for (Field field : fieldsFromSecond) {
            if (!contains(fieldsFromFirst, field)) {
                diffBetweenClasses.append(getField(field));
            }
        }
    }

    private boolean contains(Field[] fields, Field field) {
        if (Modifier.isFinal(field.getModifiers()) && field.getName().equals("this$0$")) {
            return true;
        }
        
        String secondField = getField(field);
        for (Field i : fields) {
            String firstField = getField(i);
            if (secondField.equals(firstField)) {
                return true;
            }
        }
        return false;
    }

    private void getDifferenceInMethods(Class<?> firstClass, Class<?> secondClass, StringBuilder diffBetweenClasses) {
        Method[] methodsFromFirst = firstClass.getDeclaredMethods();
        Method[] methodsFromSecond = secondClass.getDeclaredMethods();

        if (methodsFromFirst.equals(methodsFromSecond)) {
            return;
        }

        for (Method method : methodsFromFirst) {
            if (!contains(methodsFromSecond, method)) {
                printSomeMethod(method, diffBetweenClasses);
            }
        }

        for (Method method : methodsFromSecond) {
            if (!contains(methodsFromFirst, method)) {
                printSomeMethod(method, diffBetweenClasses);
            }
        }
    }

    private boolean contains(Method[] methods, Method method) {
        StringBuilder firstMethod = new StringBuilder();
        printSomeMethod(method, firstMethod);
        for (Method i : methods) {
            StringBuilder secondMethod = new StringBuilder();
            printSomeMethod(i, secondMethod);
            if (firstMethod.toString().equals(secondMethod.toString())) {
                return true;
            }
        }
        return false;
    }
}
