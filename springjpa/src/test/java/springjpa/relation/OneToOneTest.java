//package springjpa.relation;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//import java.util.Date;
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.ContextHierarchy;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//import org.springframework.test.context.web.WebAppConfiguration;
//import org.springframework.transaction.annotation.Transactional;
//import springjpa.config.RootConfig;
//import springjpa.config.WebConfig;
//import springjpa.entity.Post;
//import springjpa.entity.User;
//
//@ExtendWith(SpringExtension.class)
//@WebAppConfiguration
//@Transactional
//@ContextHierarchy({
//    @ContextConfiguration(classes = RootConfig.class),
//    @ContextConfiguration(classes = WebConfig.class)
//})
//public class OneToOneTest {
//    @PersistenceContext
//    EntityManager entityManager;
//
//    @Test
//    public void oneToOnePostNoAboveTest() {
//        User user = new User();
//        user.setUserNo(null);
//        user.setId("test");
//        user.setPwd("test");
//        user.setNickname("test");
//        entityManager.persist(user);
//
//        Post post1 = new Post();
//        post1.setPostNo(null);
//        post1.setContent("test");
//        post1.setTitle("test");
//        post1.setUserWriter(user);
//        post1.setWritedAt(new Date());
//        post1.setViewActivate(true);
//
//        entityManager.persist(post1);
//
//        Post post2 = new Post();
//        post2.setPostNo(null);
//        post2.setContent("test2");
//        post2.setTitle("test2");
//        post2.setUserWriter(user);
//        post2.setPostNoAbove(post1);
//        post2.setWritedAt(new Date());
//        post2.setViewActivate(true);
//
//        entityManager.persist(post2);
//        assertThat(post2.getPostNoAbove().getTitle()).isEqualTo("test");
//    }
//}
