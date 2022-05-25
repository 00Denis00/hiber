package com.denis.hibernate.commander;

import com.denis.hibernate.controller.TagController;
import com.denis.hibernate.model.Tag;

import java.util.List;
import java.util.Scanner;

public class TagCommander
{
    Scanner scanner = new Scanner(System.in);
    TagController tagController = new TagController();

    public void findById()
    {
        System.out.println("Enter id: ");
        scanner = new Scanner(System.in);
        Integer id = scanner.nextInt();

        Tag tag = new Tag();
        tag = tagController.findById(id);

        System.out.println(tag.toString());
        System.out.println();
    }

    public void delete()
    {
        System.out.println("Enter id: ");
        scanner = new Scanner(System.in);
        Integer id = scanner.nextInt();

        Tag tag = new Tag();
        tag.setId(id);

        tagController.delete(tag);
        System.out.println("Tag " + id + " was deleted");
        System.out.println();
    }

    public void findAll()
    {
        List<Tag> tags = tagController.findAll();
        for(int i = 0; i < tags.size(); i++)
        {
            Tag tag = tags.get(i);
            System.out.println(tag.toString());
        }
        System.out.println();
    }

    public void save()
    {
        System.out.println("Enter name: ");
        scanner = new Scanner(System.in);
        String name = scanner.nextLine();

        Tag tag = new Tag();
        tag.setName(name);

        tag = tagController.save(tag);

        System.out.println(tag.toString());
        System.out.println();
    }

    public void update()
    {
        Tag tag = new Tag();

        System.out.println("Enter tag id: ");
        scanner = new Scanner(System.in);
        Integer id = scanner.nextInt();
        tag.setId(id);

        System.out.println("Enter new name: ");
        scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        tag.setName(name);

        tag = tagController.update(tag);

        System.out.println(tag.toString());
        System.out.println();
    }
}
