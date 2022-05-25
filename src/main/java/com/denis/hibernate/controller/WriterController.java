package com.denis.hibernate.controller;

import com.denis.hibernate.model.Writer;
import com.denis.hibernate.repository.WriterRepository;
import com.denis.hibernate.repository.hibernate.HibernateWriterRepositoryImpl;

import java.util.List;

public class WriterController
{
    WriterRepository writerRepository = new HibernateWriterRepositoryImpl(){};

    public Writer findById(Integer id)
    {
        return writerRepository.findById(id);
    }
    public void delete(Writer writer)
    {
        writerRepository.delete(writer);
    }
    public List<Writer> findAll()
    {
        return writerRepository.findAll();
    }
    public Writer save(Writer writer)
    {
        return writerRepository.save(writer);
    }
    public Writer update(Writer writer)
    {
        return writerRepository.update(writer);
    }
}
