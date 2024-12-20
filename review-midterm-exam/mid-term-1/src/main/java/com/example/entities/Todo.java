package com.example.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDate;

@Entity
@Table(name = "todos")
//public boolean insertTodo(Todo todo);
//public Todo selectTodo(int id);
//public List<Todo> selectAllTodos();
//public boolean updateTodo(Todo todo);
//public boolean updateTodo(Todo todo);
//public boolean deleteTodo(int id);
@NamedQueries({
        @NamedQuery(name = "Todo.selectAllTodos", query = "select todo from Todo todo"),
        @NamedQuery(name="Todo.deleteTodo", query = "delete from Todo todo where todo.id =: id")
})
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @JdbcTypeCode(SqlTypes.BIGINT)
    private Integer id;
    @Column(name = "description" , nullable = false, columnDefinition = "VARCHAR(255)")
    private String description;
    @Column(name = "is_done", columnDefinition = "BIT(1)")
    private boolean isDone;
    @Column(name = "target_date", nullable = false, columnDefinition = "DATETIME(6)")
    private LocalDate targetDate;
    @Column(name = "username", columnDefinition = "VARCHAR(255)")
    private String username;
    @Column(name = "title", columnDefinition = "VARCHAR(255)")
    private String title;

    public Todo() {
    }

    public Todo(Integer id, String description, boolean isDone, LocalDate targetDate, String username, String title) {
        this.id = id;
        this.description = description;
        this.isDone = isDone;
        this.targetDate = targetDate;
        this.username = username;
        this.title = title;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean getIsDone() {
        return isDone;
    }

    public void setIsDone(boolean isDone) {
        this.isDone = isDone;
    }

    public LocalDate getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(LocalDate targetDate) {
        this.targetDate = targetDate;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", isDone=" + isDone +
                ", targetDate=" + targetDate +
                ", username='" + username + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
