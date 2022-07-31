package com.upworkscraper.upworkscraper.repositories;

import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.Table;
import org.jooq.UpdatableRecord;

public abstract class AbstractRepository<R extends UpdatableRecord, P> {

    protected final DSLContext db;
    private final Table<R> table;
    private final Field<Long> idField;
    private final Class<P> pojoClass;

    public AbstractRepository(DSLContext db, Table<R> table, Field<Long> idField, Class<P> pojoClass) {
        this.db = db;
        this.table = table;
        this.idField = idField;
        this.pojoClass = pojoClass;
    }

    public P findById(Long id) {
        return db.select()
                .from(table)
                .where(idField.eq(id))
                .fetchOneInto(pojoClass);
    }

    public P
}
