package com.example.services;

import com.example.models.Post;
import com.example.models.User;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface PostService {
    Optional<Post> findById(Long id);
    Post save(Post post);
    Page<Post> findByUserOrderedByDatePageable(User user, int page);
    Page<Post> findAllOrderedByTitlePageable(int page);
}
