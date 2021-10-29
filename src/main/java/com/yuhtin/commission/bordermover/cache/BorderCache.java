package com.yuhtin.commission.bordermover.cache;

import com.yuhtin.commission.bordermover.api.Border;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Data
public class BorderCache {

    private final List<Border> borders = new ArrayList<>();

}
