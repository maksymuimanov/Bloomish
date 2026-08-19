package io.bloomish.example.tag;

import io.bloomish.api.core.engine.metadata.annotation.data.tag.AddTagContainer;
import io.bloomish.api.core.engine.metadata.constant.TagContainerType;
import io.bloomish.api.core.util.TagUtils;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

@AddTagContainer(TagContainerType.ITEM)
public final class ExampleItemTags {
    public static final TagKey<Item> REPAIRS_EXAMPLE_ARMOR = TagUtils.createItem("repairs_example_armor");
}
