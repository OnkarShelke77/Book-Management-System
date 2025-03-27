package com.library;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n--- Library Management System ---");
            System.out.println("1. Add Book");
            System.out.println("2. View All Books");
            System.out.println("3. Search Book");
            System.out.println("4. Update Book");
            System.out.println("5. Delete Book");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Book ID: ");
                    String id = scanner.nextLine();
                    
                    System.out.print("Enter Title: ");
                    String title = scanner.nextLine();
                    
                    System.out.print("Enter Author: ");
                    String author = scanner.nextLine();
                    
                    System.out.print("Enter Genre: ");
                    String genre = scanner.nextLine();
                    
                    System.out.print("Enter Availability (Available/Checked Out): ");
                    String availability = scanner.nextLine();

                    Book book = new Book(id, title, author, genre, availability);
                    if (library.addBook(book)) {
                        System.out.println("Book added successfully!");
                    }
                    break;

                case 2:
                    library.viewBooks();
                    break;

                case 3:
                    System.out.print("Enter Book ID or Title to search: ");
                    String keyword = scanner.nextLine();
                    Book searchedBook = library.searchBook(keyword);
                    if (searchedBook != null) {
                        System.out.println("Book found: " + searchedBook);
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter Book ID to update: ");
                    String updateId = scanner.nextLine();
                    
                    System.out.print("New Title: ");
                    String newTitle = scanner.nextLine();
                    
                    System.out.print("New Author: ");
                    String newAuthor = scanner.nextLine();
                    
                    System.out.print("New Genre: ");
                    String newGenre = scanner.nextLine();
                    
                    System.out.print("New Availability (Available/Checked Out): ");
                    String newStatus = scanner.nextLine();
                    
                    if (library.updateBook(updateId, newTitle, newAuthor, newGenre, newStatus)) {
                        System.out.println("Book updated successfully.");
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;

                case 5:
                    System.out.print("Enter Book ID to delete: ");
                    String deleteId = scanner.nextLine();
                    
                    if (library.deleteBook(deleteId)) {
                        System.out.println("Book deleted successfully.");
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;

                case 6:
                    System.out.println("Exiting...");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid option. Try again.");
                    break;
            }
        }
        scanner.close();
    }
}
