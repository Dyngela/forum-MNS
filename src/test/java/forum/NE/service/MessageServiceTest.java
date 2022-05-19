package forum.NE.service;

import forum.NE.DTO.NewMessageDTO;
import forum.NE.exceptions.ExceptionHandler;
import forum.NE.model.Comment;
import forum.NE.model.Post;
import forum.NE.model.Users;
import forum.NE.repository.CommentRepository;
import forum.NE.repository.PostRepository;
import forum.NE.repository.UserRepository;
import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class MessageServiceTest {

    @Mock
    private PostRepository postRepository;
    private CommentRepository commentRepository;
    private UserRepository userRepository;

    @InjectMocks
    private CommentService commentService;
    private MessageService messageService;
    @Test
    void testFindAll() {
        
        assertFalse();
    }

    @Test
    void testSave() {
        NewMessageDTO message = new NewMessageDTO();
        message.setIdMessage(1L);
        message.setContent("aze");
        message.setIdUser(1L);
        messageService.save(message);
        Optional<Post> postSaved = postRepository.findById(1L);
        assertTrue(postSaved.isPresent());
    }

    @Test
    void testDelete() {
        NewMessageDTO message = new NewMessageDTO();
        message.setIdMessage(1L);
        message.setContent("aze");
        message.setIdUser(1L);
        messageService.save(message);
        Post postSaved = postRepository.findById(1L).orElseThrow(() -> {throw new ExceptionHandler("erreur delete");});
        messageService.delete(postSaved);
        assertNull(postSaved);
    }
}
