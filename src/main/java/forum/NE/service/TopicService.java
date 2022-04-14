package forum.NE.service;

import forum.NE.DTO.TopicDTO;
import forum.NE.model.Topic;
import forum.NE.repository.TopicRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicService {

    private final TopicRepository topicRepository;
    private final ModelMapper modelMapper = new ModelMapper();

    @Autowired
    public TopicService(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }

    public List<TopicDTO> findAllTopics(int pageStart, int numberOfResult) {
        Page<Topic> topics = topicRepository.findAll(PageRequest.of(pageStart, numberOfResult));
        return modelMapper.map(topics.getContent(), new TypeToken<List<TopicDTO>>(){}.getType());
    }

    public List<TopicDTO> findAllTopicsAccordingToATitle(String title,int pageStart, int numberOfResult) {
        Page<Topic> topics = topicRepository.findAllByTitleContains(title, PageRequest.of(pageStart, numberOfResult));
        return modelMapper.map(topics.getContent(), new TypeToken<List<TopicDTO>>(){}.getType());
    }

    public void saveTopic(Topic topic) {
        topic.setMessages(null);
        topicRepository.save(topic);
    }

    public void deleteTopic(Long idTopic) {
        topicRepository.deleteById(idTopic);
    }

}
