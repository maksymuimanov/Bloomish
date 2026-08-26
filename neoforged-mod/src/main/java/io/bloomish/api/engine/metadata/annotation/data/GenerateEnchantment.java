package io.bloomish.api.engine.metadata.annotation.data;

import io.bloomish.api.data.server.enchantment.EnchantmentDescription;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface GenerateEnchantment {
    Class<? extends EnchantmentDescription> value();
}