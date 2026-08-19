package io.bloomish.api.engine.event.data.particle;

import io.bloomish.api.core.collection.TemporalMap;
import io.bloomish.api.util.ResourceUtils;
import net.minecraft.core.Holder;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.common.data.ParticleDescriptionProvider;

import java.util.Map;

public class ApiParticleProvider extends ParticleDescriptionProvider {
    public static final Map<Holder<ParticleType<?>>, ParticleDescription> PARTICLE_SPRITES = new TemporalMap<>();

    public ApiParticleProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, existingFileHelper);
    }

    @Override
    protected void addDescriptions() {
        PARTICLE_SPRITES.forEach((particleType, description) -> {
            if (description.count() <= 1) {
                sprite(particleType.value(), ResourceUtils.parse(description.id()));
            } else {
                spriteSet(particleType.value(), ResourceUtils.parse(description.id()),
                        description.count(),
                        description.reverse());
            }
        });
    }
}
