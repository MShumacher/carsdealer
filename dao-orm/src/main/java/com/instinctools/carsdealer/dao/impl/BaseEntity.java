package com.instinctools.carsdealer.dao.impl;

import com.instinctools.carsdealer.dao.IBaseEntity;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
public abstract class BaseEntity implements IBaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(updatable = false)
    private Date created;

    @Column
    private Date updated;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(final Integer id) {
        this.id = id;
    }

    @Override
    public Date getCreated() {
        return created;
    }

    @Override
    public void setCreated(final Date created) {
        this.created = created;
    }

    @Override
    public Date getUpdated() {
        return updated;
    }

    @Override
    public void setUpdated(final Date updated) {
        this.updated = updated;
    }
}
