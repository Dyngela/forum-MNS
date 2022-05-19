package forum.NE.DTO;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
public class PostDTO {
    private Long idMessage;
    private String content;
    private Timestamp date;
    private List<CommentMessageDTO> comments;
    private UserMessageDTO user;
}

@Getter
@Setter
class CommentMessageDTO {
    private Long idComment;
    private String content;
    private Timestamp date;
    private Long UserId;
}

@Getter
@Setter
class UserMessageDTO {
    private Long idUser;
    private String name;
    private String surname;
}

