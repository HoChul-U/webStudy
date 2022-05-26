//package springjpa.relation;
//
//import java.util.Date;
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
//import springjpa.entity.Post;
//import springjpa.entity.User;
//import springjpa.repository.PostRepository;
//import springjpa.repository.UserRepository;
//
//@ExtendWith(SpringExtension.class)
//@WebAppConfiguration
//@Transactional
//@ContextHierarchy({
//    @ContextConfiguration(classes = RootConfig.class),
//    @ContextConfiguration(classes = WebConfig.class)
//
//})
//public class ManyToOneTest {
//    @Autowired
//    UserRepository userRepository;
//
//    @Autowired
//    PostRepository postRepository;
//
//    @Test
//    public void postToUserWriterTest(){
//
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
//        Post post2 = new Post();
//        post2.setUserWriter(user);
//        post2.setWritedAt(new Date());
//        post2.setTitle("test2");
//        post2.setContent("tttt2");
//        post2.setViewActivate(true);
//        postRepository.save(post2);
//
//        postRepository.flush();
//    }
//    @Test
//    public void postToModifyUserTest(){
//        User user = new User();
//        user.setId("a");
//        user.setPwd("a");
//        user.setUserNo(null);
//        user.setNickname("a");
//        userRepository.save(user);
//
//        User modifyUser = new User();
//        modifyUser.setId("b");
//        modifyUser.setPwd("b");
//        modifyUser.setUserNo(null);
//        modifyUser.setNickname("b");
//        userRepository.save(modifyUser);
//
//        Post post1 = new Post();
//        post1.setUserWriter(user);
//        post1.setWritedAt(new Date());
//        post1.setModifiedAt(new Date());
//        post1.setUserModifier(modifyUser);
//        post1.setTitle("test");
//        post1.setContent("tttt");
//        post1.setViewActivate(true);
//        postRepository.save(post1);
//
//        Post post2 = new Post();
//        post2.setUserWriter(user);
//        post2.setWritedAt(new Date());
//        post1.setModifiedAt(new Date());
//        post1.setUserModifier(modifyUser);
//        post2.setTitle("test2");
//        post2.setContent("tttt2");
//        post2.setViewActivate(true);
//        postRepository.save(post2);
//
//        postRepository.flush();
//    }
//
//}
