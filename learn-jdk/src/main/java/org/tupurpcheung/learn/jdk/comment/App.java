package org.tupurpcheung.learn.jdk.comment;

import com.sun.tools.javadoc.Main;
import org.tupurpcheung.learn.jdk.comment.constants.Constant;


/**
 * @description:
 * @author: tupurp
 * @create: 2021-04-08 18:30
 */
public class App {
    public static void main(String[] args) {
        //-DjavaFileName
        //System.getProperty("");
        //处理包下面的文件 -subpackage -sourcepath
        Main.execute(new String[]{"-doclet", CommentStarter.class.getName(),
                "-encoding", "utf-8",
                args[0]});
        Constant.context.stream().forEach(classComment -> {
            System.out.println("类：" + classComment.getClassName() + "注释如下：");
            classComment.getCommentList().stream().forEach(comment -> System.out.println(comment));
            System.out.println("方法注释如下：");
            classComment.getMethodCommentList().stream().forEach(methodComment -> {
                System.out.println("方法名：" + methodComment.getMethodName());
                methodComment.getCommentList().stream().forEach(comment -> System.out.println("     " + comment));
            });
        });
    }
}