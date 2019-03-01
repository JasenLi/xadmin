package com.jasonli.sunny.entity;

import com.jasonli.sunny.entity.base.BaseEntity;
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
 * 数据库命名规则
 * tm = table model
 * tt = table transaction
 * tr = table relation
 *
 * @author lijunsong
 * @date 2019/3/1 16:59
 * @since 1.0
 */
@Data
@Entity
@DynamicUpdate
@DynamicInsert
@NoArgsConstructor
@Table(name = "tt_role")
@EqualsAndHashCode(callSuper = true)
public class RoleEntity extends BaseEntity {
    /**
     * 角色名称
     */
    @Column(name = "roleName", nullable = false)
    private String roleName;

    /**
     * 角色代码
     */
    @Column(name = "roleCode")
    private String roleCode;

    /**
     * 角色目录
     */
    @Column(name = "roleCatalog")
    private String roleCatalog;

    /**
     * 所在组织Id
     */
    @Column(columnDefinition = "组织Id")
    private String orgId;

    /**
     * 描述
     */
    @Column(name = "description")
    private String description;

    /**
     * 状态
     */
    @Column(columnDefinition = "状态", length = 10)
    private ActiveEnum status;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "roles")
    private Set<UserEntity> users = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "tr_role_org",
            joinColumns = @JoinColumn(
                    name = "roleId", referencedColumnName = "id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "orgId", referencedColumnName = "id"
            )
    )
    private Set<OrganizationEntity> orgEntities = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "tr_role_permission",
            joinColumns = @JoinColumn(
                    name = "roleId", referencedColumnName = "id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "permissionId", referencedColumnName = "id"
            )
    )
    private Set<PermissionEntity> permissions = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "tr_role_menu",
            joinColumns = @JoinColumn(
                    name = "roleId", referencedColumnName = "id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "menuId", referencedColumnName = "id"
            )
    )
    private Set<MenuEntity> menus = new HashSet<>();

    public void addMenu(MenuEntity menu) {
        this.menus.add(menu);
    }

    public void deleteMenu(MenuEntity menu) {
        this.menus.remove(menu);
    }

    public void addUser(UserEntity user) {
        this.users.add(user);
    }

    public void deleteUser(UserEntity user) {
        this.users.remove(user);
    }

    public void addPermission(PermissionEntity permission) {
        this.permissions.add(permission);
    }

    public void deletePermission(PermissionEntity permission) {
        this.permissions.remove(permission);
    }
}
