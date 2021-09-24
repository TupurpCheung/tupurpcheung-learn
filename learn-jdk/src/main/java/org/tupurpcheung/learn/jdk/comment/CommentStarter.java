package org.tupurpcheung.learn.jdk.comment;

import com.sun.javadoc.RootDoc;
import org.tupurpcheung.learn.jdk.comment.util.DocHandler;


/**
 * @description:
 * @author: tupurp
 * @create: 2021-04-08 18:36
 */
public class CommentStarter {


    public static  boolean start(RootDoc rootDoc){
        DocHandler.handler(rootDoc);
        return true;
    }
}