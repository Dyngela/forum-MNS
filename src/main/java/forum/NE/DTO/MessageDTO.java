package forum.NE.DTO;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class MessageDTO {
    private Long idMessage;
    private String content;
    private String title;
    private LocalDate date;
    private List<CommentMessageDTO> comments;
    private Long UserId;
}

@Getter
@Setter
class CommentMessageDTO {
    private Long idComment;
    private String content;
    private LocalDate date;
    private Long UserId;
}
