package com.protfolio.sessioneighth.model;

import lombok.Setter;

import javax.persistence.*;


@Entity(name = "tbl_personal_info")
@Table
public class PersonalInfo {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @Setter
    @Column
    private String name;

    @Setter
    @Column
    private String email;

    @Setter
    @Column
    private int age;

    @Setter
    @Column
    private String address;

    @Setter
    @Column(name = "cv_url")
    private String cvURL;

    @Setter
    @Column
    private String description;

    @Setter
    @Column(name = "phone_number")
    private String phoneNumber;

}
