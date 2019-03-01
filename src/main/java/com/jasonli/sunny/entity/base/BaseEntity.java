package com.jasonli.sunny.entity.base;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * @author lijunsong
 * @date 2019/3/1 17:01
 * @since 1.0
 */
@Setter
@Getter
@MappedSuperclass
public class BaseEntity extends RootEntity {
    @Column(columnDefinition = "创建人id")
    private String creator;
    @Column(columnDefinition = "修改人id")
    private String changer;
    @Column(columnDefinition = "创建时间")
    private ZonedDateTime createdDateTime;
    @Column(columnDefinition = "修改时间")
    private ZonedDateTime changedDateTime;

    @PrePersist
    public void prePersist() {
        //获取当前登录人
//        if (userInfo != null){
//            this.creator = userInfo.getId();
//        }
        this.createdDateTime = ZonedDateTime.now(ZoneId.of("UTC"));
    }

    @PreUpdate
    public void preUpdate() {
        //获取当前登录人
//        if (userInfo != null){
//            this.changer = userInfo.getId();
//        }
        this.changedDateTime = ZonedDateTime.now(ZoneId.of("UTC"));
    }
}
