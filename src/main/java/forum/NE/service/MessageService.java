package forum.NE.service;

import forum.NE.DTO.PostDTO;
import forum.NE.exceptions.ExceptionHandler;
import forum.NE.model.Post;
import forum.NE.repository.PostRepository;
import org.apache.logging.log4j.message.Message;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {

    private final PostRepository messageRepository;
    private final ModelMapper modelMapper = new ModelMapper();


    @Autowired
    public MessageService(PostRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public List<PostDTO> findAll(int pageStart, int numberOfResult) {
        Page<Post> posts = messageRepository.findAll(PageRequest.of(pageStart, numberOfResult));
        return modelMapper.map(posts.getContent(), new TypeToken<List<PostDTO>>(){}.getType());
    }

    public void save(Post post) {
        try {
            messageRepository.save(post);
        } catch (Exception e) {
            throw new ExceptionHandler(e.getMessage());
        }
    }

    public void delete(Post post) {
        try {
            messageRepository.delete(post);
        } catch (Exception e) {
            throw new ExceptionHandler(e.getMessage());
        }
    }

}
