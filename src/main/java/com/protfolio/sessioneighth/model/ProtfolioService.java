package com.protfolio.sessioneighth.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class ProtfolioService implements Comparable<ProtfolioService> {

    @Getter
    private String serviceName;
    @Getter
    private String serviceDescription;
    @Getter
    private String serviceIcon;

    @Override
    public int compareTo(ProtfolioService o) {
        return this.serviceName.compareTo(o.serviceName);
    }
}
