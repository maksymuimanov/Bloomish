package io.bloomish.api.channel;

public interface ObjectTransformer<I, O> {
    O transform(I input);
}
