package forum.NE.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "Topic")
@Getter
@Setter
public class Topic implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = false, nullable = false, name = "IDTopic")
    private Long idTopic;

    @Column(length = 50, unique = false, nullable = false, name = "TITLE")
    private String title;

    @Column(length = 255, unique = false, nullable = false, name = "content")
    private String content;

    @Column(unique = false, nullable = false, name = "date")
    private LocalDate date;

    @OneToMany(mappedBy = "topic", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private List<Message> messages;

}
