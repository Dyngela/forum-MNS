package forum.NE.DTO;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class NewCommentDTO {
    private Long idComment;
    private Long idMessage;
    private Long idUser;
    private String content;
    private Timestamp date;

    public NewCommentDTO(Long idComment, Long idMessage, Long idUser, String content, Timestamp date) {
        this.idComment = idComment;
        this.idMessage = idMessage;
        this.idUser = idUser;
        this.content = content;
        this.date = date;
    }
}
