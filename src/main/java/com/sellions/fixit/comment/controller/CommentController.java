package com.sellions.fixit.comment.controller;

import com.sellions.fixit.comment.service.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/comments")
public class CommentController {
    private CommentService commentService;

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteCommentById(@PathVariable("id") Long id) {
        commentService.deleteCommentById(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
