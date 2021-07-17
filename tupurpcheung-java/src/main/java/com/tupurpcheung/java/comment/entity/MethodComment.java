package com.tupurpcheung.java.comment.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: tupurp
 * @create: 2021-04-08 18:32
 */
public class MethodComment {
    private String methodName;
    private List<Comment> commentList;

    public MethodComment(String methodName) {
        this.methodName = methodName;
        this.commentList  = new ArrayList<>();
    }

    public MethodComment(String methodName, List<Comment> commentList) {
        this.methodName = methodName;
        this.commentList = commentList;
    }

    public String getMethodName() {
        return methodName;
    }

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }

    public void addComment(Comment comment){
        commentList.add(comment);
    }
}