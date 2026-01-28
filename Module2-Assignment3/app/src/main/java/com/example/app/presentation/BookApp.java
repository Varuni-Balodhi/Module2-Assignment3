package com.example.app.presentation;

import com.example.app.entity.Book;
import com.example.app.service.BookService;
import com.example.app.service.BookServiceImpl;

import java.util.Scanner;

public class BookApp {

    public static void main(String[] args) {

        BookService service = new BookServiceImpl();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1.Add 2.View 3.ViewAll 4.Update 5.Delete 6.Exit");
            System.out.print("Choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("ISBN: ");
                    String isbn = sc.next();
                    sc.nextLine();

                    System.out.print("Title: ");
                    String title = sc.nextLine();

                    System.out.print("Author: ");
                    String author = sc.nextLine();

                    System.out.print("Price: ");
                    double price = sc.nextDouble();

                    service.addBook(new Book(isbn, title, author, price));
                    System.out.println("Book Added");
                    break;

                case 2:
                    System.out.print("ID: ");
                    System.out.println(service.getBook(sc.nextInt()));
                    break;

                case 3:
                    service.getAllBooks().forEach(System.out::println);
                    break;

                case 4:
                    System.out.print("ID: ");
                    int id = sc.nextInt();
                    Book book = service.getBook(id);
                    System.out.print("New Price: ");
                    book.setPrice(sc.nextDouble());
                    service.updateBook(book);
                    break;

                case 5:
                    System.out.print("ID: ");
                    service.deleteBook(sc.nextInt());
                    break;

                case 6:
                    System.exit(0);
            }
        }
    }
}
