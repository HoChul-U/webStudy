//package springjpa.entity;
//
//
//import static org.assertj.core.api.Assertions.assertThat;
//
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
//import springjpa.entity.primaryKey.LikePk;
//import springjpa.repository.LikeRepository;
//import springjpa.repository.PostRepository;
//
//@ExtendWith(SpringExtension.class)
//@WebAppConfiguration
//@Transactional
//@ContextHierarchy({
//    @ContextConfiguration(classes = RootConfig.class),
//    @ContextConfiguration(classes = WebConfig.class)
//})
//class LikeTest {
//    @PersistenceContext
//    private EntityManager entityManager;
//    @Autowired
//    private LikeRepository likeRepository;
//    @Autowired
//    private PostRepository postRepository;
//
//
//    @Test
//    public void testLikeEntity(){
//        LikePk pk = new LikePk("조회수", 1, 1);
//        User user = entityManager.find(User.class, 1);
//        Post post = entityManager.find(Post.class, 1);
//        Like like = entityManager.find(Like.class, pk);
////        like.setPk(pk);
////        like.setPost(post);
////        like.setUser(user);
//    }
//}