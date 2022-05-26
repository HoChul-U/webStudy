//package springjpa.entity;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.junit.jupiter.api.Assertions.*;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import javax.swing.text.html.parser.Entity;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.ContextHierarchy;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//import org.springframework.test.context.web.WebAppConfiguration;
//import org.springframework.transaction.annotation.Transactional;
//import springjpa.config.RootConfig;
//import springjpa.config.WebConfig;
//
//@ExtendWith(SpringExtension.class)
//@WebAppConfiguration
//@Transactional
//@ContextHierarchy({
//    @ContextConfiguration(classes = RootConfig.class),
//    @ContextConfiguration(classes = WebConfig.class)
//})
//class UserTest {
//    @PersistenceContext
//    private EntityManager entityManager;
//
//    @Test
//    public void userEntityTest() {
//        User user = entityManager.find(User.class, 1);
//        User mergeUser = new User();
//        mergeUser.setId("test");
//        mergeUser.setPwd("test");
//        mergeUser.setNickname("test");
//        assertThat(entityManager.merge(mergeUser).getId()).isEqualTo("test");
//        assertThat(user.getNickname()).isEqualTo("관리자");
//    }
//
//}