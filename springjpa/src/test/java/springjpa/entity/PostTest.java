package springjpa.entity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;
import springjpa.config.RootConfig;
import springjpa.config.WebConfig;

@ExtendWith(SpringExtension.class)
@WebAppConfiguration
@Transactional
@ContextHierarchy({
    @ContextConfiguration(classes = RootConfig.class),
    @ContextConfiguration(classes = WebConfig.class)
})
class PostTest {
    @PersistenceContext
    private EntityManager entityManager;

    @Test
    public void postEntityTest() {
        Post post = entityManager.find(Post.class, 1);
        Post mergePost = new Post();
        User user = new User();
        user.setId("a");
        user.setPwd("a");
        user.setUserNo(1); //TODO: 왜 null 을 넣으면 안되는걸까?
        user.setNickname("a");
        mergePost.setUserWriter(user);
        mergePost.setWritedAt(new Date());
        mergePost.setTitle("test");
        mergePost.setContent("tttt");
        mergePost.setViewActivate(true);
        assertThat(post.getPostNo().intValue()).isEqualTo(1);
        assertThat(entityManager.merge(mergePost).getTitle()).isEqualTo("test");
    }

}