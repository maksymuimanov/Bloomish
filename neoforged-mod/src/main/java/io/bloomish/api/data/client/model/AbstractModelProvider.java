package io.bloomish.api.data.client.model;

import io.bloomish.api.data.AbstractMultiDataProvider;
import io.bloomish.api.data.DataTarget;
import io.bloomish.api.data.client.ClientDataProvider;
import io.bloomish.api.util.StringUtils;
import net.minecraft.data.PackOutput;

public abstract class AbstractModelProvider<M extends Model> extends AbstractMultiDataProvider implements ClientDataProvider {
    protected static final String MODELS_PATH = "models";

    protected AbstractModelProvider(PackOutput packOutput) {
        super(packOutput);
    }

    protected void addModel(String path, M model, String prefix, String suffix) {
        DataTarget dataTarget = DataTarget.createModAsset(MODELS_PATH, prefix, StringUtils.joinWithUnderscore(path, suffix));
        this.addData(dataTarget, model);
    }
}
