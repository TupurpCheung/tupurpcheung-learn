package com.tupurpcheung.java.gof.proxy.compiler;

import javax.tools.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * 动态代理类
 *
 * 只支持实现了一个接口的类，且方法不能有参数
 *
 * */
public class Proxy {

   private static  final   String rootDiskName = "c:/";
   private static  final   String clazzName = "com.tupurp.proxy.$Proxy0";
   private static  final   String fileName = "c:/com/tupurp/proxy/$Proxy0.java";

    /*
    * @param interfaces 目标对象（被代理对象）实现的接口
    * @param invocationHandler 调用处理器
    * */
    public  static Object newInstance(Class<?> inter, InvocationHandler invocationHandler)throws Exception{
        createJavaFile(inter);
        compileJavaFile(fileName);
        Class clazz = loadClass();
        Constructor ctr = clazz.getConstructor(InvocationHandler.class);
        return ctr.newInstance(invocationHandler);
    }


    /*创建java文件*/
    private static String createJavaFile(Class<?> inter){
        String rt = "\r\n";
        String methodStr = "";

        Method[] methods = inter.getMethods();

        String src =
                "package com.tupurp.proxy;" + rt +
                        "import java.lang.reflect.Method;" + rt +
                        "import com.tupurp.learn.gof.proxy.compiler.InvocationHandler;" + rt +
                        "public class $Proxy0 implements "+inter.getName()+"{" + rt +
                        "    InvocationHandler h;" + rt +
                        "    public $Proxy0(InvocationHandler h) {" + rt +
                        "        this.h = h;" + rt +
                        "     }" + rt ;
        for(Method m : methods){
            methodStr +=
                    "    @Override" + rt +
                            "    public void " + m.getName() + "() {" + rt +
                            "        try{" + rt +
                            "          Method md = " + inter.getName() + ".class.getMethod(\"" +m.getName()+"\");" + rt +
                            "           h.invoke(this, md);" + rt +
                            "        }catch(Exception e){e.printStackTrace();}" + rt +
                            "    }" + rt;
        }

        src = src + methodStr + "}";

        //先把源代码写到下面：
        File f = new File(fileName);
        FileWriter fw = null;
        try {
            fw = new FileWriter(f);
            fw.write(src);
            fw.flush();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return fileName;
    }

    /*编译Java文件*/
    private  static void compileJavaFile(String filePath){
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        //System.out.println(compiler.getClass().getName());    //com.sun.tools.javac.api.JavacTool
        // 建立DiagnosticCollector对象
        DiagnosticCollector<JavaFileObject> diagnostics = new DiagnosticCollector<JavaFileObject>();
        //通过fileMgr管理要编译的文件
        StandardJavaFileManager fileMgr = compiler.getStandardFileManager(null, null, null);
        //拿到编译的内容
        Iterable<? extends JavaFileObject> units = fileMgr.getJavaFileObjects(filePath);
        //编译的任务
        //编译
        JavaCompiler.CompilationTask t = compiler.getTask(null, fileMgr, diagnostics, null, null, units);
        t.call();

        /*打印错误*/
        for (Diagnostic diagnostic : diagnostics.getDiagnostics()) {
            System.out.printf(
                    "Code: %s%n" +
                            "Kind: %s%n" +
                            "Position: %s%n" +
                            "Start Position: %s%n" +
                            "End Position: %s%n" +
                            "Source: %s%n" +
                            "Message: %s%n",
                    diagnostic.getCode(), diagnostic.getKind(),
                    diagnostic.getPosition(), diagnostic.getStartPosition(),
                    diagnostic.getEndPosition(), diagnostic.getSource(),
                    diagnostic.getMessage(null));
        }
        try {
            fileMgr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
    * 加载class
    * */
    private static Class loadClass(){
        //生成了代理类class之后，将其load到内存，并且生成一个对象
        URL[] urls = new URL[1];
        try {

            urls = new URL[] {new URL("file:/" + rootDiskName)};
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
         URLClassLoader ul = new URLClassLoader(urls);
       // URLClassLoader ul =  new URLClassLoader(urls,Thread.currentThread().getContextClassLoader());
        Class clazz = null;    //class com.tupurp.proxy.$Proxy0
        try {

            clazz = ul.loadClass(clazzName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return clazz;
    }
}
