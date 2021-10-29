package com.yuhtin.commission.bordermover.manager;

import com.yuhtin.commission.bordermover.Core;
import com.yuhtin.commission.bordermover.api.Border;
import com.yuhtin.commission.bordermover.cache.BorderCache;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.val;
import org.bukkit.Bukkit;
import org.bukkit.WorldBorder;

@NoArgsConstructor
@Data
public class BorderManager {

    private final BorderCache cache = new BorderCache();

    public void load() {
        cache.getBorders().clear();
        val config = Core.getInstance().getConfig();
        for (String key : config.getConfigurationSection("bordas").getKeys(false)) {
            cache.getBorders().add(Border.builder()
                    .worldName(config.getString("bordas." + key + ".mundo"))
                    .blocks(config.getInt("bordas." + key + ".blocos"))
                    .moveTime(config.getInt("bordas." + key + ".tempoMovimento"))
                    .timeAfter(config.getInt("bordas." + key + ".tempoDepois"))
                    .build()
            );
        }
    }

    public void processBorders() {
        for (Border border : cache.getBorders()) {
            val world = Bukkit.getWorld(border.getWorldName());
            if (world == null) continue;

            Bukkit.getScheduler().runTaskLater(
                    Core.getInstance(),
                    () -> changeBorder(border, world.getWorldBorder()),
                    border.getTimeAfter() * 20L
            );
        }
    }

    public void changeBorder(Border processor, WorldBorder border) {
        border.setSize(processor.getBlocks(), processor.getMoveTime());
    }

}
