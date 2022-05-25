package springjpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springjpa.entity.Post;

public interface PostRepository extends JpaRepository<Post,Integer> {
}
