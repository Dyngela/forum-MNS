package forum.NE.service;

import forum.NE.DTO.NewMessageDTO;
import forum.NE.DTO.PostDTO;
import forum.NE.exceptions.ExceptionHandler;
import forum.NE.model.Post;
import forum.NE.model.Users;
import forum.NE.repository.PostRepository;
import forum.NE.repository.UserRepository;
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
    private final UserRepository userRepository;
    private final ModelMapper modelMapper = new ModelMapper();


    @Autowired
    public MessageService(PostRepository messageRepository, UserRepository userRepository) {
        this.messageRepository = messageRepository;
        this.userRepository = userRepository;
    }

    public List<PostDTO> findAll(int pageStart, int numberOfResult) {
        Page<Post> posts = messageRepository.findAll(PageRequest.of(pageStart, numberOfResult));
        return modelMapper.map(posts.getContent(), new TypeToken<List<PostDTO>>(){}.getType());
    }

    public void save(NewMessageDTO post) {
        try {
            Users user = userRepository.findById(post.getIdUser()).orElseThrow(() -> new ExceptionHandler("Id user not found"));
            Post postSaved = new Post(post.getIdMessage(), post.getContent(), post.getDate(), user);
            messageRepository.save(postSaved);
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
