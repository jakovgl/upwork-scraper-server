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

    public P insert(P pojo) {
        R record = db.newRecord(table);
        mergeAndStore(record, pojo);

        return record.into(pojoClass);
    }

    public P update(Long id, P pojo) {
        R record = db.fetchOne(table, idField.eq(id));
        mergeAndStore(record, pojo);

        return record.into(pojoClass);
    }

    private void mergeAndStore(R record, P pojo) {
        merge(record, pojo);
        record.store();
    }

    private void merge(R record, P pojo) {
        record.from(pojo);
    }
}
