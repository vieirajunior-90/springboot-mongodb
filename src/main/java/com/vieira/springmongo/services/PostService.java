package com.vieira.springmongo.services;

import com.vieira.springmongo.models.Post;
import com.vieira.springmongo.repositories.PostRepository;
import com.vieira.springmongo.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public List<Post> findAll() {
        return postRepository.findAll();
    }
    public Post findById(String id) {
        return postRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Post not found"));
    }

    @Transactional
    public void delete(String id) {
        Post post = findById(id);
        postRepository.delete(post);
    }
    public List<Post> findByTitleContainingIgnoreCase(String text) {
        return postRepository.findByTitleContainingIgnoreCase(text);
    }
}
