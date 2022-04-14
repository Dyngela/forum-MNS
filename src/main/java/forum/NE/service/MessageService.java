package forum.NE.service;

import forum.NE.DTO.MessageDTO;
import forum.NE.model.Message;
import forum.NE.repository.MessageRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {

    private final MessageRepository messageRepository;
    private final ModelMapper modelMapper = new ModelMapper();


    @Autowired
    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public List<MessageDTO> findAll(int pageStart, int numberOfResult) {
        Page<Message> messages = messageRepository.findAll(PageRequest.of(pageStart, numberOfResult));
        return modelMapper.map(messages.getContent(), new TypeToken<List<MessageDTO>>(){}.getType());
    }

}
