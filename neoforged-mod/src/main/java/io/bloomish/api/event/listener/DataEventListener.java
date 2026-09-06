package io.bloomish.api.event.listener;

import io.bloomish.api.bean.Bean;
import io.bloomish.api.data.DataGatherer;
import net.neoforged.neoforge.data.event.GatherDataEvent;

@Bean
public class DataEventListener {
    private final DataGatherer dataGatherer;

    public DataEventListener(DataGatherer dataGatherer) {
        this.dataGatherer = dataGatherer;
    }

    @ListenEvent
    public void listen(GatherDataEvent event) {
        this.dataGatherer.gatherData(event);
    }
}
