package com.biglee.schedulerthread.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author ：DELL
 * @date ：Created in 2021/4/23 12:57
 * @description：
 * @version:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "home")
public class Home extends comEntity{

    @Id
    @GeneratedValue
    @Column
    private Integer id;

    @Column(length = 20)
    private String name;

    @Column(length = 20)
    private String city;

}
