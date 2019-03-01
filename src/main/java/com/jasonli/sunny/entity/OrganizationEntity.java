package com.jasonli.sunny.entity;

import com.jasonli.sunny.entity.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * 组织
 *
 * @author lijunsong
 * @date 2019/3/1 19:29
 * @since 1.0
 */
@Data
@Entity
@DynamicUpdate
@DynamicInsert
@NoArgsConstructor
@Table(name = "tt_org")
@EqualsAndHashCode(callSuper = true)
public class OrganizationEntity extends BaseEntity {
    @Column(columnDefinition = "名称", length = 20)
    private String name;

    @Column(columnDefinition = "描述", length = 500)
    private String desc;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "org")
    private Set<RoleEntity> roleEntities = new HashSet<>();
}
