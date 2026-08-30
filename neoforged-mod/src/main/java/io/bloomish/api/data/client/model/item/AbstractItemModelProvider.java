package io.bloomish.api.data.client.model.item;

import io.bloomish.api.data.AbstractMultiDataProvider;
import io.bloomish.api.data.DataTarget;
import io.bloomish.api.data.client.ClientDataProvider;
import io.bloomish.api.data.client.model.item.model.ItemModel;
import io.bloomish.api.util.RegistryUtils;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;

public abstract class AbstractItemModelProvider extends AbstractMultiDataProvider implements ClientDataProvider {
    protected static final String MODELS_PATH = "models";
    protected static final String ITEM_PATH = "item";

    protected AbstractItemModelProvider(PackOutput packOutput) {
        super(packOutput);
    }

    protected void addItemModel(Item item, ItemModel itemModel) {
        DataTarget dataTarget = DataTarget.createModAsset(MODELS_PATH, ITEM_PATH, RegistryUtils.findItemPath(item));
        this.addData(dataTarget, itemModel);
    }
}
