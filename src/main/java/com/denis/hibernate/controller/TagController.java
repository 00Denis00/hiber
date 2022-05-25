package com.denis.hibernate.controller;

import com.denis.hibernate.model.Tag;
import com.denis.hibernate.repository.TagRepository;
import com.denis.hibernate.repository.hibernate.HibernateTagRepositoryImpl;

import java.util.List;

public class TagController
{
    TagRepository tagRepository = new HibernateTagRepositoryImpl(){};

    public Tag findById(Integer id)
    {
        return tagRepository.findById(id);
    }
    public void delete(Tag tag)
    {
        tagRepository.delete(tag);
    }
    public List<Tag> findAll()
    {
        return tagRepository.findAll();
    }
    public Tag save(Tag tag)
    {
        return tagRepository.save(tag);
    }
    public Tag update(Tag tag)
    {
        return tagRepository.update(tag);
    }
}
