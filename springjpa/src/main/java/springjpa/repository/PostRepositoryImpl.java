package springjpa.repository;

import com.querydsl.core.types.Projections;
import java.util.List;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import springjpa.domain.PostPickDto;
import springjpa.entity.Post;
import springjpa.entity.QPost;
import springjpa.entity.QUser;

public class PostRepositoryImpl extends QuerydslRepositorySupport
    implements PostRepositoryCustom {
    public PostRepositoryImpl() {
        super(Post.class);
    }

    @Override
    public List<PostPickDto> pickPosts(Integer postNo) {
        QPost post = QPost.post;
        QUser user = QUser.user;
        QUser modifyUser = new QUser("modifyUser");


        return from(post)
            .innerJoin(post.userWriter, user)
            .on(post.userWriter.userNo.eq(user.userNo))
            .leftJoin(post.userModifier, modifyUser)
            .on(post.userModifier.userNo.eq(modifyUser.userNo))
            .where(post.postNo.eq(postNo))
            .select(
                Projections.bean(PostPickDto.class,
                    post.postNo,
                    post.title,
                    post.content,
                    post.userWriter.id,
                    post.userWriter.nickname,
                    post.userModifier.id,
                    post.userModifier.nickname,
                    post.writedAt,
                    post.modifiedAt
                ))
            .fetch();
    }
}
