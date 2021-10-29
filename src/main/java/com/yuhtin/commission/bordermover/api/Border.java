package com.yuhtin.commission.bordermover.api;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Border {

    private final String worldName;

    private final int timeAfter;
    private final int moveTime;
    private final int blocks;

}
