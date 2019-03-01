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
 * 菜单栏
 *
 * @author lijunsong
 * @date 2019/3/1 19:31
 * @since 1.0
 */
@Data
@Entity
@DynamicUpdate
@DynamicInsert
@NoArgsConstructor
@Table(name = "tm_menu")
@EqualsAndHashCode(callSuper = true)
public class MenuEntity extends RootEntity {
    /**
     * 菜单名称
     */
    @Column(unique = true, nullable = false, length = 20)
    private String name;

    /**
     * 状态
     */
    @Column(columnDefinition = "状态", length = 10)
    private ActiveEnum status;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "menu")
    private Set<RoleEntity> roleEntities = new HashSet<>();
}
