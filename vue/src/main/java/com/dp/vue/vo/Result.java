package com.dp.vue.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Description: vue
 * Created by DP on 2020/10/28 16:17
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result {
    private boolean status;
    private String msg;
}
