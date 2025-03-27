package com.library;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;

    public Library() {
        books = new ArrayList<>();
    }

    public boolean addBook(Book book) {
        for (Book b : books) {
            if (b.getId().equals(book.getId())) {
                System.out.println("Book ID must be unique.");
                return false;
            }
        }
        if (book.getTitle().isEmpty() || book.getAuthor().isEmpty()) {
            System.out.println("Title and Author cannot be empty.");
            return false;
        }
        if (!book.getAvailability().equalsIgnoreCase("Available") && 
            !book.getAvailability().equalsIgnoreCase("Checked Out")) {
            System.out.println("Invalid availability status. Use 'Available' or 'Checked Out'.");
            return false;
        }
        books.add(book);
        return true;
    }

    public void viewBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available.");
        } else {
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }

    public Book searchBook(String keyword) {
        for (Book book : books) {
            if (book.getId().equalsIgnoreCase(keyword) || book.getTitle().equalsIgnoreCase(keyword)) {
                return book;
            }
        }
        return null;
    }

    public boolean updateBook(String id, String title, String author, String genre, String status) {
        for (Book book : books) {
            if (book.getId().equalsIgnoreCase(id)) {
                book.setTitle(title);
                book.setAuthor(author);
                book.setGenre(genre);
                book.setAvailability(status);
                return true;
            }
        }
        return false;
    }

    public boolean deleteBook(String id) {
        return books.removeIf(book -> book.getId().equalsIgnoreCase(id));
    }
}
