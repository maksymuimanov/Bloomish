package io.bloomish.api.engine.event.data;

import net.neoforged.neoforge.data.event.GatherDataEvent;

public interface DataGatherer {
    void gatherData(GatherDataEvent event);
}
