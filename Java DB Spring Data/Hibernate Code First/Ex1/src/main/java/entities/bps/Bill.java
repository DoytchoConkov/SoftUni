package entities.bps;

import entities.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;

@MappedSuperclass
public class Bill extends BaseEntity {
    private long number;
    private long owner;
}
