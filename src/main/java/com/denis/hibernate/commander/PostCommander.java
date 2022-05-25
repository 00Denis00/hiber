package com.denis.hibernate.commander;

import com.denis.hibernate.controller.PostController;
import com.denis.hibernate.model.Post;
import com.denis.hibernate.model.Tag;
import com.denis.hibernate.model.Writer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PostCommander
{
    Scanner scanner = new Scanner(System.in);
    PostController postController = new PostController();

    public void findById()
    {
        System.out.println("Enter id: ");
        scanner = new Scanner(System.in);
        Integer id = scanner.nextInt();
        Post post = postController.findById(id);
        System.out.println(post.toString());
        System.out.println();
    }

    public void delete()
    {
        System.out.println("Enter id: ");
        scanner = new Scanner(System.in);
        Integer id = scanner.nextInt();
        Post post = new Post();
        post.setId(id);
        postController.delete(post);
        System.out.println("Post " + id + " was deleted");
        System.out.println();
    }

    public void update()
    {
        Post post = new Post();

        System.out.println("Enter post id: ");
        scanner = new Scanner(System.in);
        Integer id = scanner.nextInt();
        post.setId(id);
        System.out.println("Enter new content: ");
        scanner = new Scanner(System.in);
        String content = scanner.nextLine();
        post.setContent(content);

        post = postController.update(post);
        System.out.println(post.toString());
        System.out.println();
    }

    public void findAll()
    {
        List<Post> posts = postController.findAll();
        for(int i = 0; i < posts.size(); i++)
        {
            Post post = posts.get(i);
            System.out.println(post.toString());
        }
        System.out.println();
    }

    public void save()
    {
        Post post = new Post();

        System.out.println("Enter content: ");
        scanner = new Scanner(System.in);
        String content = scanner.nextLine();
        post.setContent(content);

        System.out.println("Enter writer id: ");
        scanner = new Scanner(System.in);
        int writerId = scanner.nextInt();
        Writer writer = new Writer();
        writer.setId(writerId);
        post.setWriter(writer);

        System.out.println();

        List<Tag> tags = new ArrayList<>();
        String command = "continue";
        while(command.equals("continue"))
        {
            Tag tag = new Tag();
            System.out.println("Enter tag id: ");
            scanner = new Scanner(System.in);
            int tagId = scanner.nextInt();
            tag.setId(tagId);
            tags.add(tag);

            System.out.println("To continue write \"continue\"");
            System.out.println("To stop write \"stop\"");
            scanner = new Scanner(System.in);
            command = scanner.nextLine();
        }
        post.setTags(tags);

        post = postController.save(post);
        System.out.println(post.toString());
        System.out.println();
    }
}
