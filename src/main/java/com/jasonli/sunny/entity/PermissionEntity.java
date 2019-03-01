package com.jasonli.sunny.entity;

import com.jasonli.sunny.entity.base.RootEntity;
import com.jasonli.sunny.enums.ActiveEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * 操作权限
 *
 * @author lijunsong
 * @date 2019/3/1 19:32
 * @since 1.0
 */
@Data
@Entity
@DynamicUpdate
@DynamicInsert
@NoArgsConstructor
@Table(name = "tm_permission")
@EqualsAndHashCode(callSuper = true)
public class PermissionEntity extends RootEntity {
    @Column(columnDefinition = "权限", length = 20)
    private String permission;

    @Column(columnDefinition = "描述", length = 500)
    private String desc;

    /**
     * 状态
     */
    @Column(columnDefinition = "状态", length = 10)
    private ActiveEnum status;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "permission")
    private Set<RoleEntity> roleEntities = new HashSet<>();
}
