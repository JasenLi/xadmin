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
 * 数据库命名规则
 * tm = table model
 * tt = table transaction
 * tr = table relation
 * https://blog.csdn.net/Qsir/article/details/72628127
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
@Table(name = "tt_user")
@EqualsAndHashCode(callSuper = true)
public class UserEntity extends BaseEntity {
    /**
     * 姓名
     */
    @Column(name = "userName")
    private String userName;

    /**
     * 工号
     */
    @Column(name = "userCode")
    private String userCode;

    /**
     * 用户名
     */
    @Column(name = "loginName", unique = true, nullable = false)
    private String loginName;

    /**
     * 登录密码
     */
    @Column(name = "password")
    private String password;

    /**
     * 加密盐
     */
    @Column(columnDefinition = "加密盐")
    private String salt;

    /**
     * 组织id
     */
    @Column(nullable = false, length = 36)
    private String orgId;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(
            name = "tr_role_user",
            joinColumns = @JoinColumn(
                    name = "userId", referencedColumnName = "id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "roleId", referencedColumnName = "id"
            )
    )
    private Set<RoleEntity> roles = new HashSet<>();
}
