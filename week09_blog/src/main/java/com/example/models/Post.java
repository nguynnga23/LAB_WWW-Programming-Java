package com.example.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "post")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private Boolean published;
    private String title;
    private String content;

    @ManyToOne
    @JoinColumn(name = "parentId", nullable = true)
    private Post parent;

    private String metaTitle;
    private String summary;

    private Instant createdAt;
    private Instant updatedAt;
    private Instant publishedAt;

    @OneToMany(mappedBy = "parent")
    private Set<Post> posts;

    @ManyToOne
    @JoinColumn(name = "authorId")
    private User author;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private Set<PostComment> postComments;

    // Thiết lập thời gian tạo và cập nhật tự động
    @PrePersist
    public void onCreate() {
        this.createdAt = Instant.now();
        this.updatedAt = Instant.now();
    }

    @PreUpdate
    public void onUpdate() {
        this.updatedAt = Instant.now();
    }
}
