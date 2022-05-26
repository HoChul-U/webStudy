package springjpa.entity.primaryKey;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QLikePk is a Querydsl query type for LikePk
 */
@Generated("com.querydsl.codegen.DefaultEmbeddableSerializer")
public class QLikePk extends BeanPath<LikePk> {

    private static final long serialVersionUID = -237133800L;

    public static final QLikePk likePk = new QLikePk("likePk");

    public final StringPath part = createString("part");

    public final NumberPath<Integer> postNo = createNumber("postNo", Integer.class);

    public final NumberPath<Integer> userNo = createNumber("userNo", Integer.class);

    public QLikePk(String variable) {
        super(LikePk.class, forVariable(variable));
    }

    public QLikePk(Path<? extends LikePk> path) {
        super(path.getType(), path.getMetadata());
    }

    public QLikePk(PathMetadata metadata) {
        super(LikePk.class, metadata);
    }

}

