package io.bloomish.api.engine.event.data.client.model.item;

import io.bloomish.api.engine.event.data.client.model.item.spec.ItemModelSpec;

public interface ItemModelProviderStrategy<T extends ItemModelSpec> {
    void registerItemModel(T spec, ApiItemModelProvider provider);
}
