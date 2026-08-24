package io.bloomish.api.engine.event.data;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.concurrent.CompletableFuture;

public interface DataGatherer {
    void gatherData(GatherDataEvent event);

    PackOutput getPackOutput(GatherDataEvent event);

    DataGenerator getDataGenerator(GatherDataEvent event);

    ExistingFileHelper getExistingFileHelper(GatherDataEvent event);

    CompletableFuture<HolderLookup.Provider> getLookupProvider(GatherDataEvent event);
}
