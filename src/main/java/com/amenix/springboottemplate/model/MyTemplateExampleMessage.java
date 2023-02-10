package com.amenix.springboottemplate.model;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

public class MyTemplateExampleMessage implements Cloneable{

    private String id;
    private String message;
    private String author;
    private LocalDateTime createDate;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyTemplateExampleMessage that = (MyTemplateExampleMessage) o;
        return id.equals(that.id) && message.equals(that.message) && author.equals(that.author) && createDate.equals(that.createDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, message, author, createDate);
    }

    @Override
    public String toString() {
        return "MyTemplateExampleMessage{" +
                "id='" + id + '\'' +
                ", message='" + message + '\'' +
                ", author='" + author + '\'' +
                ", createDate=" + createDate +
                '}';
    }


    @Override
    public MyTemplateExampleMessage clone() {
        try {
            MyTemplateExampleMessage clone = (MyTemplateExampleMessage) super.clone();
            clone.setId(UUID.randomUUID().toString());
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
