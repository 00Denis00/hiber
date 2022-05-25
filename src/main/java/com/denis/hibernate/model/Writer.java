package com.denis.hibernate.model;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "writers")
public class Writer
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "writer_id")
    private List<Post> posts;

    public Writer()
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

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public List<Post> getPosts()
    {
        return posts;
    }

    public void setPosts(List<Post> posts)
    {
        this.posts = posts;
    }

    /**
     * toString method (optional)
     */
    @Override
    public String toString()
    {
        String postsResult = "";
        for(int i = 0; i < posts.size(); i++)
        {
            Post post = posts.get(i);
            String result = "\n{" + post.toString() + "}";
            postsResult += result;
        }
        return "Id: " + id + " ; Name: " + name + " ; Posts: " + postsResult;
    }
}