package todo.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by murat.duzgun on 16.8.2016.
 */

@Entity
@Table(name = "todo")
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "todo_id")
    private long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User owner;

    @NotNull
    @Column(name = "content")
    private String content;

    @Column(name = "created_date")
    private Date createdDate;

    @Column(name = "updated_date")
    private Date updatedDate;

    @PrePersist
    private void createdAt() {
        createdDate = new Date();
    }

    @PreUpdate
    private void updatedAt() {
        updatedDate = new Date();
    }
}
