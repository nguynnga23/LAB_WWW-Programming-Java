package com.example.repositories;

import com.example.models.Post;
import com.example.models.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    Page<Post> findByAuthorOrderByCreatedAtDesc(Pageable pageable, User user);
    Page<Post> findAllByOrderByCreatedAtDesc(Pageable pageable);
    Optional<Post> findById(Long id);
}
