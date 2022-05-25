package springjpa.entity;

import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import springjpa.entity.primaryKey.LikePk;

@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Posts")
@Entity
@Getter
@Setter
public class Post {
    @Column(name = "post_no")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer postNo;

    @OneToOne
    @JoinColumn (name = "post_no_above")
    private Post postNoAbove;

    @ManyToOne
    @JoinColumn(name = "user_no_writer")
    private User userWriter;

    @ManyToOne
    @JoinColumn(name = "user_no_modifier")
    private User userModifier;

    @Column(name = "writed_at")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat
    private Date writedAt;


    @Column(name = "modified_at")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat
    private Date modifiedAt;

    @NotNull
    private String title;
    @NotNull
    private String content;

    @Column(name = "view_activate")
    @NotNull
    private Boolean viewActivate;

    @Column(name = "file_name")
    private String fileName;

    @OneToMany(mappedBy = "postComment")
    private List<Comment> comments;

    @OneToMany(mappedBy = "post")
    private List<Like> likes;

}