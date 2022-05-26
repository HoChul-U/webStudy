//package springjpa.entity;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//import java.util.Date;
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.ContextHierarchy;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//import org.springframework.test.context.web.WebAppConfiguration;
//import org.springframework.test.util.ReflectionTestUtils;
//import org.springframework.transaction.annotation.Transactional;
//import springjpa.config.RootConfig;
//import springjpa.config.WebConfig;
//import springjpa.repository.CommentRepository;
//import springjpa.repository.PostRepository;
//import springjpa.repository.UserRepository;
//
//@ExtendWith(SpringExtension.class)
//@WebAppConfiguration
//@Transactional
//@ContextHierarchy({
//    @ContextConfiguration(classes = RootConfig.class),
//    @ContextConfiguration(classes = WebConfig.class)
//})
//class CommentTest {
//    @PersistenceContext
//    private EntityManager entityManager;
//    @Autowired
//    private UserRepository userRepository;
//    @Autowired
//    private PostRepository postRepository;
//    @Autowired
//    private CommentRepository commentRepository;
//
//
//    @Test
//    public void testCommentEntity() {
//        User user = new User();
//        user.setNickname("t");
//        user.setUserNo(null);
//        user.setPwd("t");
//        user.setId("t");
//        userRepository.save(user);
//
//        Post post1 = new Post();
//        post1.setUserWriter(user);
//        post1.setWritedAt(new Date());
//        post1.setTitle("test");
//        post1.setContent("tttt");
//        post1.setViewActivate(true);
//        postRepository.save(post1);
//
//
//        Comment mergeComment = new Comment();
//        mergeComment.setCommentNo(5);
//        mergeComment.setContent("test");
//        mergeComment.setUser(user);
//        mergeComment.setPostComment(post1);
//        Comment comment = entityManager.find(Comment.class, 1);
//        entityManager.merge(mergeComment);
//        assertThat(ReflectionTestUtils.invokeGetterMethod(comment, "commentNo")).isEqualTo(1);
//        assertThat(entityManager.find(Comment.class, 5).getContent()).isEqualTo("test");
//    }
//}
