package org.nielsen;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "product")
public class Product extends PanacheEntity {
    private String name;
    private BigDecimal value;

    @CreationTimestamp
    private Date createdAt;

    @UpdateTimestamp
    private Date updateAt;

    public Product(String name, BigDecimal value, Date createdAt, Date updateAt) {
        this.name = name;
        this.value = value;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
    }

    public Product() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }
}