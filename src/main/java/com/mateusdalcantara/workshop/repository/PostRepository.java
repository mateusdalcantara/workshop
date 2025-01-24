package com.mateusdalcantara.workshop.repository;

import com.mateusdalcantara.workshop.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PostRepository extends MongoRepository<Post, String> {

}
