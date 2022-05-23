package com.protfolio.sessioneighth.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public abstract class Resume {

    private String years;
    private String title;
    private String subtitle;
    private String description;
}
