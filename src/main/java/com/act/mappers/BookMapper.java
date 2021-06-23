package com.act.mappers;

import com.act.entity.Author;
import com.act.entity.Book;
import com.act.entity.dto.AuthorDTO;
import com.act.entity.dto.BookDTO;

import java.util.ArrayList;
import java.util.List;

public class BookMapper {

    public List<BookDTO> convertToDto(List<Book> books){

        List<BookDTO> booksDto = new ArrayList<>();

        if(books != null){
            for(Book book: books){
                AuthorDTO author = new AuthorDTO(
                        book.getAuthor().getId(),
                        book.getAuthor().getFirstName(),
                        book.getAuthor().getMiddleName(),
                        book.getAuthor().getLastName(),
                        book.getAuthor().getAbout() );

                booksDto.add( new BookDTO(
                        book.getId(),
                        book.getTitle(),
                        book.getDescription(),
                        book.getTotalPages(),
                        book.getBookRating(),
                        book.getCategory().getCategoryName(),
                        author) );
            }
        }

        return booksDto;
    }

    public BookDTO convertToDto(Book book){
        Author author = book.getAuthor();

        AuthorDTO authorDto = new AuthorDTO(
                author.getId(),
                author.getFirstName(),
                author.getMiddleName(),
                author.getLastName(),
                author.getAbout() );

        BookDTO bookDto = new BookDTO(
                book.getId(),
                book.getTitle(),
                book.getDescription(),
                book.getTotalPages(),
                book.getBookRating(),
                book.getCategory().getCategoryName(),
                authorDto );

        return bookDto;
    }
}
