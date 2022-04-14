package forum.NE.controller;

import forum.NE.DTO.MessageDTO;
import forum.NE.model.Message;
import forum.NE.service.MessageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(name = "/message")
public class MessageController {
    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping("/findAll/{pageStart}/{numberOfResult}")
    public ResponseEntity<List<MessageDTO>> findAll(@PathVariable("pageStart") int pageStart,
                                              @PathVariable("numberOfResult") int numberOfResult) {
        List<MessageDTO> messages = messageService.findAll(pageStart, numberOfResult);
        return new ResponseEntity<>(messages, HttpStatus.OK);
    }
}
