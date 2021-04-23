package com.biglee.schedulerthread.entity;


import lombok.*;

import javax.persistence.*;

/**
 * @author ：DELL
 * @date ：Created in 2021/4/23 12:57
 * @description：
 * @version:
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "home")
public class Home extends comEntity{

    @Id
//    @GeneratedValue
    @Column
    private String id;

    @Column(length = 20)
    private String name;

    @Column(length = 20)
    private String city;

}
