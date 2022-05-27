package com.protfolio.sessioneighth.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Entity(name = "tbl_personal_info")
@Table
public class PersonalInfo {

    @Id
    @Getter
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @Setter
    @Getter
    @Column
    private String name;

    @Setter
    @Getter
    @Column
    private String email;

    @Setter
    @Getter
    @Column
    private int age;

    @Setter
    @Getter
    @Column
    private String address;

    @Setter
    @Getter
    @Column(name = "cv_url")
    private String cvURL;

    @Setter
    @Column
    @Getter
    private String description;

    @Setter
    @Getter
    @Column(name = "phone_number")
    private String phoneNumber;

}
