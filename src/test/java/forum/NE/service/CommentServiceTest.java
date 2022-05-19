package forum.NE.service;

import forum.NE.model.Comment;
import forum.NE.model.Post;
import forum.NE.repository.PostRepository;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootTest
public class CommentServiceTest {
    @Mock
    private PostRepository postRepository;

    @InjectMocks
    private CommentService commentService;
    private Comment comment;
    private Post post;

    @BeforeEach
    void setMochOutput() throws ParseException {

        post.setIdMessage(1L);
        post.setContent("ae");
        comment.setIdComment(1L);
        comment.setContent("A comment content");
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = dateFormat.parse("23/09/2007");
        long time = date.getTime();
        comment.setDate(new Timestamp(time));
        comment.setPost(post);


    }
}
