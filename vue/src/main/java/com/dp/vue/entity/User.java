package com.dp.vue.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * Description: vue
 * Created by DP on 2020/10/21 14:35
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors
@ToString
public class User {
    private Integer id;
    private String username;
    private int age;
    private String content;
}
