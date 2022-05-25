package com.denis.hibernate.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "posts")
public class Post
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "content")
    private String content;

    @ManyToOne
    @JoinColumn(name = "writer_id")
    private Writer writer;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Tag> tags;

    public Post()
    {
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getContent()
    {
        return content;
    }

    public void setContent(String content)
    {
        this.content = content;
    }

    public List<Tag> getTags()
    {
        return tags;
    }

    public void setTags(List<Tag> tags)
    {
        this.tags = tags;
    }

    public Writer getWriter()
    {
        return writer;
    }

    public void setWriter(Writer writer)
    {
        this.writer = writer;
    }

    /**
     * toString method (optional)
     */
    @Override
    public String toString()
    {
        String tagsResult = "";
        for(int i = 0; i < tags.size(); i++)
        {
            Tag tag = tags.get(i);
            String result = "(" + tag.toString() + ")";
            tagsResult += result;
        }
        return "Id: " + id + " ; Content: " + content + " ; Tags: [" + tagsResult + "]";
    }
}
