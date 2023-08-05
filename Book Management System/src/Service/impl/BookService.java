package Service.impl;

import Data.Data;
import Model.Author;
import Model.Book;
import Service.Methods;
import Util.InputUtil;


public class BookService implements Methods {

    @Override
    public void display() {
        if (Data.books != null) {
            System.out.println("--Book List----------------------\n" +
                    "------------------------------\n");
            for (int i = 0; i < Data.books.length; i++) {
                System.out.println(Data.books[i].getInfo() +
                        "\n------------------------------");
            }
        } else
            System.out.println("Book has not yet!!!");

    }

    @Override
    public void search() {
        boolean check = false;
        if (Data.books != null) {
            String key = InputUtil.inputRequiredString("-----------------------------\n" +
                    "Search books by (name/author): ");
            for (int i = 0; i < Data.books.length; i++) {
                if (Data.books[i].getName().contains(key) ||
                        Data.books[i].getAuthor().getName().contains(key)) {
                    check = true;
                    System.out.println("----------------------------\n" + Data.books[i].getInfo());
                }
            }
            if(!check){
                System.out.println("book not found!!!");
            }

        } else
            System.out.println("books has not yet!!!");

    }

    @Override
    public void add() {
        int registerCount = InputUtil.inputRequiredInt("how many book do you add: ");
        if (Data.books == null) {
            Data.books = new Book[registerCount];
            for (int i = 0; i < Data.books.length; i++) {
                Data.books[i] = booksFill();
            }
        } else {
            Book[] tempBooks = Data.books;
            Data.books = new Book[Data.books.length + registerCount];
            for (int i = 0; i < Data.books.length; i++) {
                if (i < tempBooks.length) {
                    Data.books[i] = tempBooks[i];
                } else {
                    Data.books[i] = booksFill();
                }

            }

        }
        System.out.println("Books save!!!");
    }

    @Override
    public void update() {
        if (Data.books != null) {
            boolean check = false;
            int updateId = InputUtil.inputRequiredInt("Update by Id: ");
            for (int i = 0; i < Data.books.length; i++) {
                if (Data.books[i].getId() == updateId) {
                    check = true;
                    System.out.println("NOTE: If you don't want to change the selected field, just press enter.");
                    String newName = InputUtil.inputRequiredString("Name: ");
                    if (newName.isBlank()) {

                    } else {
                        Data.books[i].setName(newName);
                    }
                    String newDescription = InputUtil.inputRequiredString("Description: ");
                    if (newDescription.isBlank()) {

                    } else {
                        Data.books[i].setDescription(newDescription);
                    }
                    String newAuthor = InputUtil.inputRequiredString("Author: ");
                    if (newAuthor.isBlank()) {

                    } else {
                        Data.books[i].getAuthor().setName(newAuthor);
                    }

                }

            }
            if (!check) {
                System.out.println("Book not Found!!!");
            }

        } else
            System.out.println("book has not yet!!!");

    }

    @Override
    public void remove() {
        if (Data.books != null) {
            boolean check = false;
            int deleteById = InputUtil.inputRequiredInt("Enter the delete Id: ");
            for (int i = 0; i < Data.books.length; i++) {
                if (Data.books[i].getId() == deleteById) {
                    check = true;
                    Book[] tempBooks = Data.books;
                    Data.books = new Book[Data.books.length - 1];
                    for (int j = 0; j < Data.books.length; j++) {
                        if (j < i) {
                            Data.books[j] = tempBooks[j];
                        } else {
                            Data.books[j] = tempBooks[j + 1];
                        }

                    }
                    System.out.print("-----------------" +
                            "\nDeleted successfully: " + tempBooks[i].getName() + "-" + tempBooks[i].getAuthor().getName() + "" +
                            "\n----------------------------");
                }

            }
            if (!check) {
                System.out.println("Book not Found!!!");
            }
        } else
            System.out.println("books has not yet!!!");

    }

    public Book booksFill() {
        System.out.println("Id: " + Book.getAutoIncrement());
        String name = InputUtil.inputRequiredString("Name: ");
        String description = InputUtil.inputRequiredString("Description: ");
        Author author = new Author(InputUtil.inputRequiredString("Author Name: "));
        return new Book(name, description, author);
    }
}