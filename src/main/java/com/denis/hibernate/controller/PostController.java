package com.denis.hibernate.controller;

import com.denis.hibernate.model.Post;
import com.denis.hibernate.repository.PostRepository;
import com.denis.hibernate.repository.hibernate.HibernatePostRepositoryImpl;

import java.util.List;

public class PostController
{
    PostRepository postRepository = new HibernatePostRepositoryImpl(){};

    public Post findById(Integer id)
    {
        return postRepository.findById(id);
    }
    public void delete(Post post)
    {
        postRepository.delete(post);
    }
    public List<Post> findAll()
    {
        return postRepository.findAll();
    }
    public Post save(Post post)
    {
        return postRepository.save(post);
    }
    public Post update(Post post)
    {
        return postRepository.update(post);
    }
}
