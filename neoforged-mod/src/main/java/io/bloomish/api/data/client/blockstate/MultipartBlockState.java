package io.bloomish.api.data.client.blockstate;

import io.bloomish.api.data.client.blockstate.property.BlockStateProperty;
import io.bloomish.api.util.CollectionUtils;

import java.util.List;
import java.util.Map;

public record MultipartBlockState(
        List<Part> multipart
) implements BlockState {
    public static MultipartBlockState of(Part part, Part... parts) {
        List<Part> partList = CollectionUtils.arrayListOf(part, parts);
        return new MultipartBlockState(partList);
    }

    public record Part(
            Variant apply,
            Map<String, String> when
    ) {
        public Part(Variant apply) {
            this(apply, null);
        }

        public static Part of(Variant apply, String whenKey, String whenValue) {
            return new Part(apply, Map.of(whenKey, whenValue));
        }

        public static Part of(Variant apply, BlockStateProperty property) {
            return new Part(apply, Map.of(property.getKey(), property.getValue()));
        }
    }
}
