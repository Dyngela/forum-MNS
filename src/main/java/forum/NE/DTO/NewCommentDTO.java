package forum.NE.DTO;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class NewCommentDTO {
    private Long idMessage;
    private Long idUser;
    private String content;
    private Timestamp date;
}
