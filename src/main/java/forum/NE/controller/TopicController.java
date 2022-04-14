package forum.NE.controller;

import forum.NE.DTO.TopicDTO;
import forum.NE.model.Topic;
import forum.NE.service.TopicService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(name = "/topic")
public class TopicController {
    private final TopicService topicService;

    public TopicController(TopicService topicService) {
        this.topicService = topicService;
    }

    @GetMapping("/findAllTopics/{pageStart}/{numberOfResult}")
    public ResponseEntity<List<TopicDTO>> findAllTopics(@PathVariable("pageStart") int pageStart,
                                                        @PathVariable("numberOfResult") int numberOfResult) {
        List<TopicDTO> topics = topicService.findAllTopics(pageStart, numberOfResult);
        return new ResponseEntity<>(topics, HttpStatus.OK);
    }

    @GetMapping("/findAllTopicsAccordingToATitle/{pageStart}/{numberOfResult}/{title}")
    public ResponseEntity<List<TopicDTO>> findAllTopics(@PathVariable("pageStart") int pageStart,
                                                        @PathVariable("numberOfResult") int numberOfResult,
                                                        @PathVariable("title") String title) {
        List<TopicDTO> topics = topicService.findAllTopicsAccordingToATitle(title, pageStart, numberOfResult);
        return new ResponseEntity<>(topics, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody Topic topic) {
        topicService.saveTopic(topic);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        topicService.deleteTopic(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
