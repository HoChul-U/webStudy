//package springjpa.relation;
//
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.ContextHierarchy;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//import org.springframework.test.context.web.WebAppConfiguration;
//import org.springframework.transaction.annotation.Transactional;
//import springjpa.config.RootConfig;
//import springjpa.config.WebConfig;
//import springjpa.entity.Comment;
//import springjpa.entity.Post;
//import springjpa.entity.User;
//import springjpa.repository.CommentRepository;
//import springjpa.repository.PostRepository;
//import springjpa.repository.UserRepository;
//
//@ExtendWith(SpringExtension.class)
//@WebAppConfiguration
//@Transactional
//@ContextHierarchy(
//    {@ContextConfiguration(classes = RootConfig.class),
//        @ContextConfiguration(classes = WebConfig.class)}
//
//
//)
//public class OneToManyTest {
//    @Autowired
//    PostRepository postRepository;
//    @Autowired
//    UserRepository userRepository;
//    @Autowired
//    CommentRepository commentRepository;
//
//    @PersistenceContext
//    EntityManager entityManager;
//
//    @Test
//    public void postToCommentsTest(){
//        List<Comment> comments = new ArrayList<>();
//        User user = new User();
//        user.setId("a");
//        user.setPwd("a");
//        user.setUserNo(null);
//        user.setNickname("a");
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
//        Comment comment1 = new Comment();
//        comment1.setPostComment(post1);
//        comment1.setUser(user);
//        comment1.setContent("test");
//        comments.add(comment1);
//
//        // TODO:// 이부분은 Repository 가 없는데 왜 실행이 될까?(comment)
//        post1.setComments(comments);
//        userRepository.flush();
//        postRepository.flush();
//    }
//
//
//}
//
