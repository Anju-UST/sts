package com.ust.book.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ust.book.Model.Book;

@Repository
public interface BookRepo extends JpaRepository<Book,Long>{

}
