package springjpa.entity.primaryKey;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Embeddable
public class LikePk implements Serializable {
    @Column(name = "part")
    String part;


    @Column(name = "post_no")
    Integer postNo;

    @Column(name = "user_no")
    Integer userNo;

}