package forum.NE.service;

import forum.NE.DTO.NewCommentDTO;
import forum.NE.exceptions.ExceptionHandler;
import forum.NE.model.Comment;
import forum.NE.model.Post;
import forum.NE.repository.CommentRepository;
import forum.NE.repository.PostRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import javax.swing.text.html.Option;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CommentServiceTest {
    @Mock
    private PostRepository postRepository;
    private CommentRepository commentRepository;

    @InjectMocks
    private CommentService commentService;

    @Test
    void testSave() throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = dateFormat.parse("23/09/2007");
        long time = date.getTime();
        commentService.save(new NewCommentDTO(1L, 1L, 1L, "aze", new Timestamp(time)));
        Optional<Comment> commentSaved = commentRepository.findById(1L);
        assertTrue(commentSaved.isPresent());
    }

    @Test
    void testDelete() throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = dateFormat.parse("23/09/2007");
        long time = date.getTime();
        commentService.save(new NewCommentDTO(1L, 1L, 1L, "aze", new Timestamp(time)));
        Comment comment = commentRepository.findById(1L).orElseThrow(() -> { throw new ExceptionHandler("erreur"); });
        commentService.delete(comment);
        assertNull(comment);
    }
}
