package org.tupurpcheung.learn.jdk.comment.entity;

/**
 * @description: 注释实体
 * @author: tupurp
 * @create: 2021-04-08 18:33
 */
public class Comment {
    String key;
    String value;

    public Comment(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    /**
     * @return 获取值
     * */
    public String getValue() {
        return value;
    }

    /**
     * @param value 值
     * */
    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "key='" + key + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}