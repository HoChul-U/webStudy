package springjpa.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUser is a Querydsl query type for User
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUser extends EntityPathBase<User> {

    private static final long serialVersionUID = -1325461546L;

    public static final QUser user = new QUser("user");

    public final ListPath<Comment, QComment> comments = this.<Comment, QComment>createList("comments", Comment.class, QComment.class, PathInits.DIRECT2);

    public final StringPath id = createString("id");

    public final ListPath<Like, QLike> likes = this.<Like, QLike>createList("likes", Like.class, QLike.class, PathInits.DIRECT2);

    public final ListPath<Post, QPost> modifyPosts = this.<Post, QPost>createList("modifyPosts", Post.class, QPost.class, PathInits.DIRECT2);

    public final StringPath nickname = createString("nickname");

    public final StringPath pwd = createString("pwd");

    public final NumberPath<Integer> userNo = createNumber("userNo", Integer.class);

    public final ListPath<Post, QPost> writePosts = this.<Post, QPost>createList("writePosts", Post.class, QPost.class, PathInits.DIRECT2);

    public QUser(String variable) {
        super(User.class, forVariable(variable));
    }

    public QUser(Path<? extends User> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUser(PathMetadata metadata) {
        super(User.class, metadata);
    }

}

