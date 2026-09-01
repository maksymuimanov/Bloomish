package io.bloomish.api.data.client.blockstate;

import java.util.List;
import java.util.Map;

public record MultipartBlockState(
        List<Part> multipart
) implements BlockState {
    public record Part(
            Variant apply,
            Map<String, String> when
    ) {
        public Part(Variant apply) {
            this(apply, null);
        }

        public Part(Variant apply, String whenKey, String whenValue) {
            this(apply, Map.of(whenKey, whenValue));
        }
    }
}
