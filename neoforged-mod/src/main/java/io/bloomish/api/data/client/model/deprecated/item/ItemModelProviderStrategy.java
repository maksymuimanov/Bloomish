package io.bloomish.api.data.client.model.deprecated.item;

import io.bloomish.api.data.client.model.deprecated.item.spec.ItemModelSpec;

public interface ItemModelProviderStrategy<T extends ItemModelSpec> {
    void registerItemModel(T spec, ApiItemModelProvider provider);
}
