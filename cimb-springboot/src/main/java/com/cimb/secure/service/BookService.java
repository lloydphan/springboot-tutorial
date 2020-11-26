package com.cimb.secure.service;

import com.cimb.secure.domain.Book;
import com.cimb.secure.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements IService<Book> {

    @Autowired
    private BookRepository bookRepository;

    public Page<Book> findAll(Pageable pageable, String searchText) {
        return bookRepository.findAllBooks(pageable, searchText);
    }

    @Override
    public Page<Book> findAll(Pageable pageable) {
        return bookRepository.findAll(pageable);
    }

    @Override
    public Book findById(Long id) {
        return bookRepository.findById(id).get();
    }

    @Override
    public Book saveOrUpdate(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Boolean deleteById(Long id) {
        boolean isDelete = false;
        try {
            bookRepository.deleteById(id);
            isDelete = true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return isDelete;
    }
}
