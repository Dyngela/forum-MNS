package forum.NE.controller;

import forum.NE.DTO.NewCommentDTO;
import forum.NE.model.Comment;
import forum.NE.model.Post;
import forum.NE.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/comments")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody NewCommentDTO comment) {
        commentService.save(comment);
        return new ResponseEntity<>(null, HttpStatus.ACCEPTED);
    }

    @DeleteMapping()
    public ResponseEntity<?> delete(@RequestBody Comment comment) {
        commentService.delete(comment);
        return new ResponseEntity<>(HttpStatus.GONE);
    }
}
