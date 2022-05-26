package springjpa.domain;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class PostPickDto {

    PostPickDto(){}
    Integer postNo;

    String postTitle;

    String postContent;

    String userWriterId;

    String userWriterNickname;

    String userModifierId;

    String userModifierNickname;

    Date postWritedAt;

    Date postModifiedAt;

}
