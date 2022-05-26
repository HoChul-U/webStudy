package springjpa.repository;

import java.util.List;
import org.springframework.data.repository.NoRepositoryBean;
import springjpa.domain.PostPickDto;

@NoRepositoryBean
public interface PostRepositoryCustom {

    List<PostPickDto> pickPosts(Integer postNo);
}
