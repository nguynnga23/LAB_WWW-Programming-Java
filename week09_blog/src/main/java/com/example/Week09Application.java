package com.example;

import com.example.models.Post;
import com.example.models.PostComment;
import com.example.models.User;
import com.example.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import net.datafaker.Faker;

import java.time.Instant;
import java.util.Random;

@SpringBootApplication
public class Week09Application {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PostRepository postRepository;

    @Autowired
    private PostCommentRepository postCommentRepository;

    public static void main(String[] args) {
        SpringApplication.run(Week09Application.class, args);
    }

    @Bean
    public CommandLineRunner run(UserRepository userRepository) {
        return (args) -> {
            Faker faker = new Faker();
            Random random = new Random();
//            for (int i = 0; i < 10; i++) {
//                User user = new User();
//                user.setFirstName(faker.name().firstName());
//                user.setLastName(faker.name().lastName());
//                user.setEmail(faker.internet().emailAddress());
//                user.setIntro(faker.lorem().sentence());
//                user.setLastLogin(Instant.now());
//                user.setMiddleName(faker.name().nameWithMiddle());
//                user.setMobile(faker.phoneNumber().cellPhone());
//                user.setPasswordHash(faker.internet().password());
//                user.setProfile(faker.internet().url());
//                user.setRegisteredAt(Instant.now());
//
//                userRepository.save(user);
//                System.out.println(user.toString());
//                Post post = new Post();
//                post.setAuthor(userRepository.findById(random.nextLong(10) + 1).get());
//                post.setContent(faker.lorem().paragraph());
//                post.setCreatedAt(Instant.now());
//                post.setMetaTitle(faker.lorem().sentence());
//                post.setPublished(random.nextBoolean());
//                post.setPublishedAt(Instant.now());
//                post.setSummary(faker.lorem().sentence());
//                post.setTitle(faker.lorem().sentence());
//                post.setUpdatedAt(Instant.now());
//                postRepository.save(post);
//                System.out.println(post.toString());

//                PostComment postComment = new PostComment();
//                postComment.setContent(faker.lorem().sentence());
//                postComment.setPublished(random.nextBoolean());
//                postComment.setPublishedAt(Instant.now());
//                postComment.setTitle(faker.lorem().sentence());
//                postComment.setCreatedAt(Instant.now());
//                postComment.setPost(postRepository.findById(random.nextLong(10) + 1).get());
//                postComment.setUser(userRepository.findById(random.nextLong(10) + 1).get());
//                postCommentRepository.save(postComment);
//            }

            ;

        };
    }
}