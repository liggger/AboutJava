package com.liggger.jparest.dao;

import com.liggger.jparest.bean.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource(path = "bs", collectionResourceRel = "bs", itemResourceRel = "b")
public interface BookDao extends JpaRepository<Book, Integer> {

    @RestResource(path = "byname", rel = "findbyname")
    List<Book> findBookByNameContaining(@Param("name") String name);
}
