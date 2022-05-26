package springjpa.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import springjpa.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment,Integer> {
}
