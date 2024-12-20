package com.example.services.impl;

import com.example.models.PostComment;
import com.example.repositories.PostCommentRepository;
import com.example.services.PostCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostCommentServiceImpl implements PostCommentService {
    private final PostCommentRepository postCommentRepository;

    @Autowired
    public PostCommentServiceImpl(PostCommentRepository postCommentRepository) {
        this.postCommentRepository = postCommentRepository;
    }

    @Override
    public PostComment save(PostComment comment) {
        return postCommentRepository.saveAndFlush(comment);
    }
}
