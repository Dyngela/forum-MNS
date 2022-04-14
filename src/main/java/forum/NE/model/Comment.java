package forum.NE.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "Comment")
@Getter
@Setter
public class Comment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = false, nullable = false, name = "IDComment")
    private Long idComment;

    @Column(length = 255, unique = false, nullable = false, name = "content")
    private String content;

    @Column(unique = false, nullable = false, name = "date")
    private LocalDate date;

    @Column(unique = false, nullable = false, name = "userId")
    private Long UserId;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "IDMessage")
    private Message message;

}
