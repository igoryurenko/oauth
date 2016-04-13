package com.iyurenko.client.dao.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * @author iyurenko
 * @since 11.04.16.
 */
@MappedSuperclass
public abstract class AbstractIdentifier {

    @Id
    @GeneratedValue
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
