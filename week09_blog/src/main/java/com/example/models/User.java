package com.example.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.util.Collection;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String mobile;
    private Instant lastLogin;
    private String firstName;
    private String middleName;
    private String lastName;
    private String intro;
    private String profile;
    private Instant registeredAt;

    private String passwordHash;
    private String email;

    @OneToMany(mappedBy = "user")
    private Set<PostComment> comments;

    @OneToMany(mappedBy = "author")
    private Set<Post> posts;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Collection<Role> roles;
}
