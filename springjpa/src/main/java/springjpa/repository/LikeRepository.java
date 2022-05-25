package springjpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springjpa.entity.Like;
import springjpa.entity.primaryKey.LikePk;

public interface LikeRepository extends JpaRepository<Like, LikePk> {
}
