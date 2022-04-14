package forum.NE.DTO;

import forum.NE.model.Message;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class TopicDTO {
    private String title;
    private LocalDate date;
    public String content;
    private List<MessageTopicDTO> messages;
}

@Getter
@Setter
class MessageTopicDTO {
    private Long idMessage;
}
