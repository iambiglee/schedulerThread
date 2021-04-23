package com.biglee.schedulerthread.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.sql.Timestamp;

/**
 * @author ：DELL
 * @date ：Created in 2021/4/23 15:10
 * @description：
 * @version:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class comEntity {
    @Column(name = "updatetime")
    private Timestamp updateTime;
}
