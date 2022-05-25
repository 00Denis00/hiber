package com.denis.hibernate;

import com.denis.hibernate.commander.PostCommander;
import com.denis.hibernate.commander.TagCommander;
import com.denis.hibernate.commander.WriterCommander;

import java.util.Scanner;

public class DeveloperRunner
{
    public static final String ANSI_BLUE = "\u001B[38;5;33m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static void main(String[] args)
    {
        System.out.println(ANSI_BLUE + "To select TAG write \"TAG\"" + ANSI_RESET);
        System.out.println(ANSI_BLUE + "To select POST write \"POST\"" + ANSI_RESET);
        System.out.println(ANSI_BLUE + "To select WRITER write \"WRITER\"" + ANSI_RESET);
        System.out.println(ANSI_BLUE + "To end the program write \"END\"" + ANSI_RESET);
        System.out.println();
        boolean end = false;
        boolean menu = false;
        Scanner scanner = new Scanner(System.in);
        while(end == false)
        {
            String select = scanner.nextLine();
            if(select.equals("TAG"))
            {
                menu = false;
                System.out.println(ANSI_BLUE + "To create a new tag write \"create\"" + ANSI_RESET);
                System.out.println(ANSI_BLUE + "To update the tag write \"update\"" + ANSI_RESET);
                System.out.println(ANSI_BLUE + "To delete the tag write \"delete\"" + ANSI_RESET);
                System.out.println(ANSI_BLUE + "To get the tag write \"get\"" + ANSI_RESET);
                System.out.println(ANSI_BLUE + "To view tags write \"show\"" + ANSI_RESET);
                System.out.println(ANSI_BLUE + "To return to the main menu write \"menu\"" + ANSI_RESET);
                System.out.println();
                TagCommander tagCommander = new TagCommander();
                while(menu == false)
                {
                    String command = scanner.nextLine();
                    if(command.equals("create"))
                    {
                        tagCommander.save();
                    }
                    else if(command.equals("update"))
                    {
                        tagCommander.update();
                    }
                    else if(command.equals("delete"))
                    {
                        tagCommander.delete();
                    }
                    else if(command.equals("get"))
                    {
                        tagCommander.findById();
                    }
                    else if(command.equals("show"))
                    {
                        tagCommander.findAll();
                    }
                    else if(command.equals("menu"))
                    {
                        menu = true;
                        System.out.println("You are in the main menu");
                        System.out.println();
                    }
                    else
                    {
                        System.out.println("Command was not recognized. Try again!");
                    }
                }
            }
            else if(select.equals("POST"))
            {
                menu = false;
                System.out.println(ANSI_BLUE + "To create a new post write \"create\"" + ANSI_RESET);
                System.out.println(ANSI_BLUE + "To update the post write \"update\"" + ANSI_RESET);
                System.out.println(ANSI_BLUE + "To delete the post write \"delete\"" + ANSI_RESET);
                System.out.println(ANSI_BLUE + "To get the post write \"get\"" + ANSI_RESET);
                System.out.println(ANSI_BLUE + "To view posts write \"show\"" + ANSI_RESET);
                System.out.println(ANSI_BLUE + "To return to the main menu write \"menu\"" + ANSI_RESET);
                System.out.println();
                PostCommander postCommander = new PostCommander();
                while(menu == false)
                {
                    String command = scanner.nextLine();
                    if(command.equals("create"))
                    {
                        postCommander.save();
                    }
                    else if(command.equals("update"))
                    {
                        postCommander.update();
                    }
                    else if(command.equals("delete"))
                    {
                        postCommander.delete();
                    }
                    else if(command.equals("get"))
                    {
                        postCommander.findById();
                    }
                    else if(command.equals("show"))
                    {
                        postCommander.findAll();
                    }
                    else if(command.equals("menu"))
                    {
                        menu = true;
                        System.out.println("You are in the main menu");
                        System.out.println();
                    }
                    else
                    {
                        System.out.println("Command was not recognized. Try again!");
                    }
                }
            }
            else if(select.equals("WRITER"))
            {
                menu = false;
                System.out.println(ANSI_BLUE + "To create a new writer write \"create\"" + ANSI_RESET);
                System.out.println(ANSI_BLUE + "To update the writer write \"update\"" + ANSI_RESET);
                System.out.println(ANSI_BLUE + "To delete the writer write \"delete\"" + ANSI_RESET);
                System.out.println(ANSI_BLUE + "To get the writer write \"get\"" + ANSI_RESET);
                System.out.println(ANSI_BLUE + "To view writers write \"show\"" + ANSI_RESET);
                System.out.println();
                WriterCommander writerCommander = new WriterCommander();
                while(menu == false)
                {
                    String command = scanner.nextLine();
                    if(command.equals("create"))
                    {
                        writerCommander.save();
                    }
                    else if(command.equals("update"))
                    {
                        writerCommander.update();
                    }
                    else if(command.equals("delete"))
                    {
                        writerCommander.delete();
                    }
                    else if(command.equals("get"))
                    {
                        writerCommander.findById();
                    }
                    else if(command.equals("show"))
                    {
                        writerCommander.findAll();
                    }
                    else if(command.equals("menu"))
                    {
                        menu = true;
                        System.out.println("You are in the main menu");
                        System.out.println();
                    }
                    else
                    {
                        System.out.println("Command was not recognized. Try again!");
                    }
                }
            }
            else if(select.equals("END"))
            {
                end = true;
            }
            else
            {
                System.out.println("Command was not recognized. Try again!");
            }
        }
    }
}
