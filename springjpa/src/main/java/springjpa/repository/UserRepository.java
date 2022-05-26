package springjpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import springjpa.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    User queryById(String id);

    @Query("select u from User u where u.id = ?1 and u.pwd = ?2")
    User loginCheck(String userId, String userPwd);
}
