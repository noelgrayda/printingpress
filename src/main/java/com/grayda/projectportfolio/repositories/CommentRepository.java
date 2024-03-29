package com.grayda.projectportfolio.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.grayda.projectportfolio.models.Comment;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Long>{
	List<Comment> findAll();
	Optional<Comment> findByComment(String comment);
}
