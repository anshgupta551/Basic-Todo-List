package com.ansh.todo.model;

import java.sql.Date;

public class TodoItem {
    String title;
    String description;

    Boolean isDone;

    Date dueDate;

    public TodoItem() {
    }

    @Override
    public String toString() {
        return "TodoItem [title=" + title + ", description=" + description + ", isDone=" + isDone + ", dueDate="
                + dueDate + "]";
    }

    public TodoItem(String title, String description, Boolean isDone, Date dueDate) {
        this.title = title;
        this.description = description;
        this.isDone = isDone;
        this.dueDate = dueDate;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getIsDone() {
        return isDone;
    }

    public void setIsDone(Boolean isDone) {
        this.isDone = isDone;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }
}
