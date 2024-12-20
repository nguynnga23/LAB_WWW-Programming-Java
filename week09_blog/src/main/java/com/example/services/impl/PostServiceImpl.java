package com.example.services.impl;

import com.example.models.Post;
import com.example.models.User;
import com.example.repositories.PostRepository;
import com.example.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;

    @Autowired
    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public Optional<Post> findById(Long id) {
        return postRepository.findById(id);
    }

    @Override
    public Post save(Post post) {
        return postRepository.saveAndFlush(post);
    }

    @Override
    public Page<Post> findByUserOrderedByDatePageable(User user, int page) {
        return postRepository.findByAuthorOrderByCreatedAtDesc(PageRequest.of(subtractPageByOne(page), 5), user);
    }

    private int subtractPageByOne(int page) {
        return (page < 1) ? 0 : page - 1;
    }

    @Override
    public Page<Post> findAllOrderedByTitlePageable(int page) {
        return postRepository.findAllByOrderByCreatedAtDesc( PageRequest.of(subtractPageByOne(page), 5));
    }
}
