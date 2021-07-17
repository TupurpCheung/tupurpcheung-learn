package com.tupurpcheung.java.comment.entity;

import java.util.List;

/**
 * @description:
 * @author: tupurp
 * @create: 2021-04-08 18:31
 */
public class ClassComment {
    private String className;
    private List<Comment> commentList;
    private List<MethodComment> methodCommentList;

    public ClassComment(String className) {
        this.className = className;
    }

    public String getClassName() {
        return className;
    }

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }

    public List<MethodComment> getMethodCommentList() {
        return methodCommentList;
    }

    public void setMethodCommentList(List<MethodComment> methodCommentList) {
        this.methodCommentList = methodCommentList;
    }
}