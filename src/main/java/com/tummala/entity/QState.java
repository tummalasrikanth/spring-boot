package com.tummala.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QState is a Querydsl query type for State
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QState extends EntityPathBase<State> {

    private static final long serialVersionUID = 1706306260L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QState state = new QState("state");

    public final StringPath code = createString("code");

    public final QCountry country;

    public final StringPath name = createString("name");

    public final NumberPath<Integer> sid = createNumber("sid", Integer.class);

    public QState(String variable) {
        this(State.class, forVariable(variable), INITS);
    }

    public QState(Path<? extends State> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QState(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QState(PathMetadata metadata, PathInits inits) {
        this(State.class, metadata, inits);
    }

    public QState(Class<? extends State> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.country = inits.isInitialized("country") ? new QCountry(forProperty("country")) : null;
    }

}

