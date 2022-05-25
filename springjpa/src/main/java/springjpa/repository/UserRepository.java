package springjpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springjpa.entity.User;

public interface UserRepository extends JpaRepository<User,Integer> {
}
