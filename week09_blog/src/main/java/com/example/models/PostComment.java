package com.example.models;

import com.example.models.Post;
import com.example.models.User;
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
@Table(name = "post_comment")
public class PostComment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String title;
    private Boolean published;
    private String content;
    private Instant publishedAt;
    private Instant createdAt;

    @ManyToOne
    @JoinColumn(name = "parentId")
    private PostComment parent;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @OneToMany(mappedBy = "parent")
    private Set<PostComment> postComments;

    @ManyToOne
    @JoinColumn(name = "postId")
    private Post post;

    // Phương thức sẽ được gọi tự động trước khi thực thể được lưu vào cơ sở dữ liệu
    @PrePersist
    public void onCreate() {
        this.createdAt = Instant.now();  // Gán thời gian tạo
        this.publishedAt = this.published ? Instant.now() : null; // Gán thời gian công bố nếu đã được công bố
    }

    // Nếu có yêu cầu cập nhật khi thay đổi, bạn có thể sử dụng @PreUpdate
    @PreUpdate
    public void onUpdate() {
        this.publishedAt = this.published ? Instant.now() : this.publishedAt;
    }
}
