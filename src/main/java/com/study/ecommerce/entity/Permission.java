package com.study.ecommerce.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "permission")
public class Permission extends BaseEntity{
    @Id
    private String code;

    @Column(name = "name")
    private String name;

}
