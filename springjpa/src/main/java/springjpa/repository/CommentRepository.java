package springjpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springjpa.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment,Integer> {
}
