package com.lu.dao;


import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
public class User {
    @TableId(type = IdType.ASSIGN_ID)//   主键策略  雪花算法 长度64bit 19位 一个符号位
    private Long id;
    private String name;
    private Integer age;
    private String email;
    @TableField(fill = FieldFill.INSERT)//  插入时自动填充
    private Date createTime;
    @TableField(fill = FieldFill.INSERT_UPDATE)//  更新时自动填充
    private Date updateTime;

    @Version    // 乐观锁 版本控制
    @TableField(fill = FieldFill.INSERT)
    private Integer version;
    @TableLogic //   逻辑删除
    @TableField(fill = FieldFill.INSERT)
    private Integer deleted;
}
