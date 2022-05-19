package forum.NE.controller;

import forum.NE.DTO.NewMessageDTO;
import forum.NE.DTO.PostDTO;
import forum.NE.model.Post;
import forum.NE.service.MessageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/posts")
public class MessageController {
    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping("")
    public ResponseEntity<List<PostDTO>> findAll(@RequestParam("pageStart") int pageStart,
                                                 @RequestParam("size") int numberOfResult) {
        List<PostDTO> messages = messageService.findAll(pageStart, numberOfResult);
        return new ResponseEntity<>(messages, HttpStatus.OK);
    }


    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody NewMessageDTO post) {
        messageService.save(post);
        return new ResponseEntity<>(null, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long idPost) {
        messageService.delete(idPost);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
