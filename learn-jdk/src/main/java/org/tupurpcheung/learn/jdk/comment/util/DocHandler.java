package org.tupurpcheung.learn.jdk.comment.util;



import com.sun.javadoc.ClassDoc;
import com.sun.javadoc.MethodDoc;
import com.sun.javadoc.RootDoc;
import com.sun.javadoc.Tag;
import org.tupurpcheung.learn.jdk.comment.constants.Constant;
import org.tupurpcheung.learn.jdk.comment.entity.ClassComment;
import org.tupurpcheung.learn.jdk.comment.entity.Comment;
import org.tupurpcheung.learn.jdk.comment.entity.MethodComment;

import java.util.ArrayList;
import java.util.List;

public class DocHandler {
    public static void handler(RootDoc rootDoc) {
        ClassDoc[] classDocs = rootDoc.classes();
        for (int i = 0; i < classDocs.length; i++) {
            ClassDoc classDoc = classDocs[i];
            String clazzName = classDoc.qualifiedName();
            ClassComment classComment = new ClassComment(clazzName);
            classComment.setCommentList(buildCommentList(classDoc.tags()));
            List<MethodComment> list = new ArrayList<>();
            MethodDoc[] methodDocs = classDoc.methods();
            for (int j = 0; j < methodDocs.length; j++) {
                MethodDoc methodDoc = methodDocs[j];
                list.add(buildMethodComment(methodDoc));

            }
            classComment.setMethodCommentList(list);
            Constant.context.add(classComment);

        }
    }

    private static MethodComment buildMethodComment(MethodDoc methodDoc) {
        String name = methodDoc.name();
        MethodComment methodComment = new MethodComment(name);
        methodComment.setCommentList(buildCommentList(methodDoc.tags()));
        return methodComment;
    }

    private static List<Comment> buildCommentList(Tag[] tags) {
        List<Comment> list = new ArrayList<>();
        for (int i = 0; i < tags.length; i++) {
            list.add(new Comment(tags[i].name(), tags[i].text()));
        }

        return list;
    }
}
