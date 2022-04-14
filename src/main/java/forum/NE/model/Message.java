package forum.NE.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;


@Entity
@Table(name = "Message")
@Getter
@Setter
public class Message implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = false, nullable = false, name = "IDMessage")
    private Long idMessage;

    @Column(length = 255, unique = false, nullable = false, name = "content")
    private String content;

    @Column(length = 70, unique = false, nullable = false, name = "title")
    private String title;

    @Column(unique = false, nullable = false, name = "date")
    private LocalDate date;

    @Column(unique = false, nullable = false, name = "userId")
    private Long UserId;

    @OneToMany(mappedBy = "message", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Comment> comments;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "IDTopic")
    private Topic topic;

}
