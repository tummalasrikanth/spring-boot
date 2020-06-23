package com.tummala.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCountry is a Querydsl query type for Country
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCountry extends EntityPathBase<Country> {

    private static final long serialVersionUID = 1937783065L;

    public static final QCountry country = new QCountry("country");

    public final NumberPath<Integer> cid = createNumber("cid", Integer.class);

    public final StringPath code = createString("code");

    public final StringPath name = createString("name");
    
    public final StringPath population = createString("population");
    
    public final SetPath<State, QState> states = this.<State, QState>createSet("states", State.class, QState.class, PathInits.DIRECT2);

    public QCountry(String variable) {
        super(Country.class, forVariable(variable));
    }

    public QCountry(Path<? extends Country> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCountry(PathMetadata metadata) {
        super(Country.class, metadata);
    }

}

