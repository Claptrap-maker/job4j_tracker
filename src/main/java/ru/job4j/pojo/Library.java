package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book ozhegov = new Book("Dictionary", 874);
        Book king = new Book("The Dead Zone", 540);
        Book austen = new Book("Pride and Prejudice", 416);
        Book martin = new Book("Clean Code", 464);
        Book[] books = new Book[] {
            ozhegov, king, austen, martin
        };
        for (int i = 0; i < books.length; i++) {
            System.out.println(books[i].getTitle() + " " + books[i].getPages());
        }
        Book temp = books[0];
        books[0] = books[3];
        books[3] = temp;
        for (int i = 0; i < books.length; i++) {
            System.out.println(books[i].getTitle() + " " + books[i].getPages());
        }
        for (int i = 0; i < books.length; i++) {
            if ("Clean Code".equals(books[i].getTitle())) {
                System.out.println(books[i].getTitle() + " " + books[i].getPages());
            }
        }
    }
}
