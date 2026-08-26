package io.bloomish.api.data;

import net.neoforged.neoforge.data.event.GatherDataEvent;

public interface DataGatherer {
    void gatherData(GatherDataEvent event);
}
