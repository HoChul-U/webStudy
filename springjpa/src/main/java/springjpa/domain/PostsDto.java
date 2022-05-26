package springjpa.domain;

import java.time.LocalDateTime;
import java.util.List;
import springjpa.entity.User;

public interface PostsDto {
    Integer getPostNo();

    String getPostTitle();

    UserDto getUserWriter();

    UserDto getModifier();

    LocalDateTime getWritedAt();

    Integer getCount();

    interface UserDto{
        String getId();

        String getNickname();
    }
}
