package springjpa.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import springjpa.entity.primaryKey.LikePk;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "LikesViewCounts")
@Entity
public class Like {
    @EmbeddedId
    LikePk pk;

    @MapsId("userNo")
    @ManyToOne
    @JoinColumn(name = "user_no")
    User user;

    @MapsId("postNo")
    @ManyToOne
    @JoinColumn(name = "post_no")
    Post post;
}
