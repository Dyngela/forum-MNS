package forum.NE.service;

import forum.NE.DTO.NewCommentDTO;
import forum.NE.exceptions.ExceptionHandler;
import forum.NE.model.Comment;
import forum.NE.model.Post;
import forum.NE.model.Users;
import forum.NE.repository.CommentRepository;
import forum.NE.repository.PostRepository;
import forum.NE.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final PostRepository postRepository;

    public CommentService(CommentRepository commentRepository, UserRepository userRepository, PostRepository postRepository) {
        this.commentRepository = commentRepository;
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }

    public void save(NewCommentDTO comment) {
        try {
            Users user = userRepository.findById(comment.getIdUser()).orElseThrow(() -> new ExceptionHandler("User not found"));
            Post post = postRepository.findById(comment.getIdMessage()).orElseThrow(() -> new ExceptionHandler("No post to be attached"));
            Comment comment1 = new Comment();
            comment1.setDate(comment.getDate());
            comment1.setContent(comment.getContent());
            comment1.setIdComment(comment.getIdComment());
            comment1.setUser(user);
            comment1.setPost(post);
            commentRepository.save(comment1);
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
