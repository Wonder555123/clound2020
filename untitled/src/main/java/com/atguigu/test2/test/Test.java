//package com.atguigu.test2.test;
//
//import org.python.core.*;
//import org.python.util.PythonInterpreter;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.Properties;
//
//public class Test {
//    public static void main(String[] args) throws IOException {
//
//        Properties props = new Properties();
//        props.put("python.home", "path to the Lib folder");
//        props.put("python.console.encoding", "UTF-8");
//        props.put("python.security.respectJavaAccessibility", "false");
//        props.put("python.import.site", "false");
//        Properties preprops = System.getProperties();
//        PythonInterpreter.initialize(preprops, props, new String[0]);
//
////        System.setProperty("python.home","C:\\Users\\17574\\.m2\\repository\\org\\python\\jython\\2.7.0");
//        PythonInterpreter interpreter = new PythonInterpreter();
//        PySystemState sys = Py.getSystemState();
//        sys.path.add("D:\\Py_Charm\\cs_recovery\\v\\Lib\\site-packages");
////        sys.path.add("D:\\Py_Charm\\cs_recovery\\v\\Scripts");
//
//        System.out.println(sys.path.toString());
//        interpreter.exec("a='hello world'; ");
//        interpreter.exec("print a;");
////      进行test.py文件的加载
////        interpreter.execfile("C:\\Users\\17574\\Desktop\\test\\test.py");
//        interpreter.execfile("C:\\Users\\17574\\Desktop\\test\\test.py");
//        // 第一个参数为期望获得的函数（变量）的名字，第二个参数为期望返回的对象类型
////        PyFunction pyFunction = interpreter.get("add", PyFunction.class);
////        int a = 5, b = 10;
//
//        //调用函数，如果函数需要参数，在Java中必须先将参数转化为对应的“Python类型”
////        PyObject pyobj = pyFunction.__call__(new PyInteger(a), new PyInteger(b));
////        System.out.println("the anwser is: " + pyobj);
//
////        通过这种方式将java中的文件名传到python里。
//        PyFunction pyFunction2 = interpreter.get("encryption", PyFunction.class);
//        String str = "test";
//        pyFunction2.__call__(new PyString(str));
//
//
//    }
//}
