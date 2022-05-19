package forum.NE.DTO;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
public class NewMessageDTO {
    private Long idMessage;
    private Long idComment;
    private Long idUser;

    private String content;
    private Timestamp date;
}

