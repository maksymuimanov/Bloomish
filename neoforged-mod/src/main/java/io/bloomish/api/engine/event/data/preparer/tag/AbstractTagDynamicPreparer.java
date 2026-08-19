package io.bloomish.api.engine.event.data.preparer.tag;

import io.bloomish.api.engine.event.data.preparer.DynamicPreparer;
import io.bloomish.api.core.util.TagUtils;
import net.minecraft.tags.TagKey;

import java.util.Map;
import java.util.Set;

public abstract class AbstractTagDynamicPreparer<T> implements DynamicPreparer {
    @Override
    public void prepare() {
        this.getTagContainers()
                .stream()
                .flatMap(TagUtils::<T>getTagKeyStream)
                .forEach(tag -> TagUtils.putTag(tag, this.getTags()));
    }

    public abstract Set<Class<?>> getTagContainers();

    public abstract Map<String, TagKey<T>> getTags();
}
