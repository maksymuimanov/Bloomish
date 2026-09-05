package io.bloomish.api.channel.transformer;

public interface ObjectTransformer<I, O> {
    O transform(I input);
}
