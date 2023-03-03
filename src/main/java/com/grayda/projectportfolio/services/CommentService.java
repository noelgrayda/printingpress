package com.grayda.projectportfolio.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.grayda.projectportfolio.models.Comment;
import com.grayda.projectportfolio.repositories.CommentRepository;

@Service
public class CommentService {
	@Autowired
	CommentRepository commentRepo;
	
	// GETTING ALL Comment
	public List<Comment> s_allComment(){
		return commentRepo.findAll();
	}
	
	// ADDING NEW Comment
	public Comment s_addComment(Comment comment) {
		return commentRepo.save(comment);
	}

	//deletes an Comment
	public void s_deleteComment(Long id) {	
		Optional<Comment> optionalComment = commentRepo.findById(id);
		
		if(optionalComment.isPresent()) {
			commentRepo.deleteById(id);
		}		
	}

	// FINDING ID OF Comment
	public Comment s_findComment(Long id){
		Optional<Comment> optionalComment = commentRepo.findById(id);
		
		if(optionalComment.isPresent()) {
			return optionalComment.get();
		}
		else {
			return null;
		}		
	}
	
	public Comment s_dupComment(Comment newComment, BindingResult result) {
		Optional<Comment> optionalComment = commentRepo.findByComment(newComment.getComment());
		if(optionalComment.isPresent()) {
			result.rejectValue("comment", "Matches", "Comment already exists.");
			return null;
		}
		else {			
			return newComment;
		}
	}
}
