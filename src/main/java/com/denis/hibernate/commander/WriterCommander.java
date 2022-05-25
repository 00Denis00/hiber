package com.denis.hibernate.commander;

import com.denis.hibernate.controller.PostController;
import com.denis.hibernate.controller.WriterController;
import com.denis.hibernate.model.Post;
import com.denis.hibernate.model.Tag;
import com.denis.hibernate.model.Writer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WriterCommander
{
    Scanner scanner = new Scanner(System.in);
    PostController postController = new PostController();
    WriterController writerController = new WriterController();

    public void findById()
    {
        System.out.println("Enter id: ");
        scanner = new Scanner(System.in);
        Integer id = scanner.nextInt();
        Writer writer = writerController.findById(id);
        System.out.println(writer.toString());
        System.out.println();
    }

    public void delete()
    {
        System.out.println("Enter id: ");
        scanner = new Scanner(System.in);
        Integer id = scanner.nextInt();
        Writer writer = new Writer();
        writer.setId(id);
        writerController.delete(writer);
        System.out.println("Writer " + id + " was deleted");
        System.out.println();
    }

    public void update()
    {
        Writer writer = new Writer();

        System.out.println("Enter writer id: ");
        scanner = new Scanner(System.in);
        Integer id = scanner.nextInt();
        writer.setId(id);

        System.out.println("Enter new name: ");
        scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        writer.setName(name);

        writer = writerController.update(writer);
        System.out.println(writer.toString());
        System.out.println();
    }

    public void findAll()
    {
        List<Writer> writers = writerController.findAll();
        for(int i = 0; i < writers.size(); i++)
        {
            Writer writer = writers.get(i);
            System.out.println(writer.toString());
            System.out.println();
        }
    }

    public void save()
    {
        System.out.println("Enter name: ");
        scanner = new Scanner(System.in);
        String name = scanner.nextLine();

        Writer writer = new Writer();
        writer.setName(name);

        writer = writerController.save(writer);

        System.out.println(writer.toString());
        System.out.println();
    }
}
