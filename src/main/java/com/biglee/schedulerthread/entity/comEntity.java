package com.biglee.schedulerthread.entity;

import lombok.Data;

import javax.persistence.Column;
import java.sql.Timestamp;

/**
 * @author ：DELL
 * @date ：Created in 2021/4/23 15:10
 * @description：
 * @version:
 */
@Data
public abstract class comEntity {
    @Column(name = "updatetime")
    private Timestamp updateTime;
}
