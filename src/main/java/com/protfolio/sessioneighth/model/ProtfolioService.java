package com.protfolio.sessioneighth.model;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "tbl_protfolio_service")
@Table
public class ProtfolioService implements Comparable<ProtfolioService> {

    public ProtfolioService(String serviceName, String serviceDescription, String serviceIcon) {
        this.serviceName = serviceName;
        this.serviceDescription = serviceDescription;
        this.serviceIcon = serviceIcon;
    }

    @Id
    @Getter
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @Getter
    @Setter
    @Column(name = "service_name")
    private String serviceName;

    @Getter
    @Setter
    @Column(name = "service_description")
    private String serviceDescription;

    @Getter
    @Setter
    @Column(name = "service_icon")
    private String serviceIcon;

    @Override
    public int compareTo(ProtfolioService o) {
        return this.serviceName.compareTo(o.serviceName);
    }

    @Override
    public String toString() {
        return "ProtfolioService{" +
                "id=" + id +
                ", serviceName='" + serviceName + '\'' +
                ", serviceDescription='" + serviceDescription + '\'' +
                ", serviceIcon='" + serviceIcon + '\'' +
                '}';
    }
}
