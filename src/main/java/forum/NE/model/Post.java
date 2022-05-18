package forum.NE.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;


@Entity
@Table(name = "Post")
@Getter
@Setter
public class Post implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = false, nullable = false, name = "IDPost")
    private Long idMessage;

    @Column(length = 255, unique = false, nullable = false, name = "content")
    private String content;

    @Column(unique = false, nullable = false, name = "date")
    private Timestamp date;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Comment> comments;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "IDUser")
    private Users user;

}