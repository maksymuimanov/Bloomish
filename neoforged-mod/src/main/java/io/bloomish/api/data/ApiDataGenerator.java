package io.bloomish.api.data;

import io.bloomish.api.data.client.ClientDataProvider;
import io.bloomish.api.data.server.ServerDataProvider;
import io.bloomish.api.engine.metadata.annotation.injection.Injected;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataProvider;
import net.neoforged.neoforge.data.event.GatherDataEvent;

@Injected
public class ApiDataGenerator implements DataGatherer {
    private final Iterable<ServerDataProvider> serverProviders;
    private final Iterable<ClientDataProvider> clientProviders;

    public ApiDataGenerator(Iterable<ServerDataProvider> serverProviders, Iterable<ClientDataProvider> clientProviders) {
        this.serverProviders = serverProviders;
        this.clientProviders = clientProviders;
    }

    @Override
    public void gatherData(GatherDataEvent event) {
        this.addServerProviders(event, this.serverProviders);
        this.addClientProviders(event, this.clientProviders);
    }

    private <P extends ClientDataProvider> void addClientProviders(GatherDataEvent event, Iterable<P> providers) {
        this.addProviders(event, event.includeClient(), providers);
    }

    private <P extends ServerDataProvider> void addServerProviders(GatherDataEvent event, Iterable<P> providers) {
        this.addProviders(event, event.includeServer(), providers);
    }

    private <P extends DataProvider> void addProviders(GatherDataEvent event, boolean runCondition, Iterable<P> providers) {
        providers.forEach(dataProvider -> this.addProvider(event, runCondition, dataProvider));
    }

    private void addProvider(GatherDataEvent event, boolean runCondition, DataProvider provider) {
        DataGenerator generator = event.getGenerator();
        generator.addProvider(runCondition, provider);
    }
}
