package group144.tetin;


import org.junit.Test;

import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;

import static org.junit.Assert.*;

public class ReflectorTest {
    @Test
    public void printStructureWithTypeTest() throws ClassNotFoundException, IOException {
        Reflector reflector = new Reflector();
        ClassLoader printedClassLoader = new URLClassLoader(new URL[]{new URL("file://")});
        Class<?> printedClass = printedClassLoader.loadClass("group144.tetin.ClassWithType");
        String excepted = "package group144.tetin.ResultOfReflection;\n" +
                "\n" +
                "public class ClassWithType<A, B> extends Object  {\n" +
                "\tpublic final Object first = null;\n" +
                "\tpublic final Object second = null;\n" +
                "\n" +
                "\tpublic String toString ()  { \n" +
                "\t\treturn null;\n" +
                "\t}\n" +
                "\n" +
                "\tClassWithType (A arg0, B arg1)  {\n" +
                "\t}\n" +
                "}";
        assertEquals(excepted, reflector.printStructure(printedClass));
    }

    @Test
    public void printStructureWithExceptionsTest() throws ClassNotFoundException, IOException {
        Reflector reflector = new Reflector();
        ClassLoader printedClassLoader = new URLClassLoader(new URL[]{new URL("file://")});
        Class<?> printedClass = printedClassLoader.loadClass("group144.tetin.ClassWithExceptions");
        String excepted = "package group144.tetin.ResultOfReflection;\n" +
                "\n" +
                "public class ClassWithExceptions extends Object  {\n" +
                "\n" +
                "\tpublic void methodWithTwoExceptions () throws Exception, NullPointerException { \n" +
                "\t}\n" +
                "\n" +
                "\tpublic void methodWithException () throws Exception { \n" +
                "\t}\n" +
                "\n" +
                "\tClassWithExceptions ()  {\n" +
                "\t}\n" +
                "}";
        assertEquals(excepted, reflector.printStructure(printedClass));
    }

    @Test
    public void diffSimilarClassesTest() throws ClassNotFoundException, IOException {
        Reflector reflector = new Reflector();
        ClassLoader printedClassLoader = new URLClassLoader(new URL[]{new URL("file://")});
        Class<?> printedClass = printedClassLoader.loadClass("group144.tetin.List");
        reflector.printStructure(printedClass);

        ClassLoader buildClassLoader = new URLClassLoader(new URL[]{new URL("file://")});
        Class<?> buildedClass = buildClassLoader.loadClass("group144.tetin.ResultOfReflection.List");

        assertTrue(reflector.diffClasses(printedClass, buildedClass));
    }

    @Test
    public void diffDifferentClassesTest() throws ClassNotFoundException, IOException {
        Reflector reflector = new Reflector();
        ClassLoader printedClassLoader = new URLClassLoader(new URL[]{new URL("file://")});
        Class<?> printedClass = printedClassLoader.loadClass("group144.tetin.List");

        ClassLoader buildClassLoader = new URLClassLoader(new URL[]{new URL("file://")});
        Class<?> buildedClass = buildClassLoader.loadClass("group144.tetin.InsertionSorter");

        assertFalse(reflector.diffClasses(printedClass, buildedClass));
    }
}