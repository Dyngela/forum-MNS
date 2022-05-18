package forum.NE.service;

import forum.NE.exceptions.ExceptionHandler;
import forum.NE.model.Comment;
import forum.NE.repository.CommentRepository;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public void save(Comment comment) {
        try {
            commentRepository.save(comment);
        } catch (Exception e) {
            throw new ExceptionHandler(e.getMessage());
        }
    }
    public void delete(Comment comment) {
        try {
            commentRepository.delete(comment);
        } catch (Exception e) {
            throw new ExceptionHandler(e.getMessage());
        }
    }
}
