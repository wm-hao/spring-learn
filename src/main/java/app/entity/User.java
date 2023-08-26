package app.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("usera")
public class User {
    @TableId
    private Long id;
    @TableField("name")
    private String name;
    private Integer age;
    private String email;
}