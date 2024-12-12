package com.example.graphqlserver;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

@Controller
public class BookController {
    @QueryMapping
    public Book bookById(@Argument String id) {
        return Book.getById(id);
    }

    @QueryMapping
    public Book getBook() {
        return Book.getById("book-1");
    }

    @QueryMapping
    public boolean setBook(@Argument String name) {
        Book.getBooks().add(new Book("new insert", name, 100, "xxx"));
        return true;
    }

    @SchemaMapping
    public Author author(Book book) {
        return Author.getById(book.authorId());
    }

    @MutationMapping
    public Book createBookWithAuthor(
            @Argument String bookName,
            @Argument int pageCount,
            @Argument Author author) {

        int id = Book.getBooks().size() + 1;

        Author newAuthor = new Author(String.valueOf(id), author.firstName(), author.lastName());
        Author.getAuthors().add(newAuthor);
        Book newBook = new Book(String.valueOf(id), bookName, pageCount, newAuthor.id());
        Book.getBooks().add(newBook);
        return newBook;
    }
}