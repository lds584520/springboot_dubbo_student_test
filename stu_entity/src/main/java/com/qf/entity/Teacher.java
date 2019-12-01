package com.qf.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author lds
 * @date 2019/11/30
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Teacher extends BaseEntity {
    private String tname;
    private Integer cid;

    @TableField(exist = false)
    private  Classes cls;
}
