package io.bloomish.api.channel;

public final class DataChannels {
    public static final DataChannel BLOCK_ENTITY_TYPE_EVENT_HANDLER = DataChannel.create();
    public static final DataChannel CREATIVE_MODE_TAB_EVENT_HANDLER = DataChannel.create();
    public static final DataChannel ENTITY_ATTRIBUTE_EVENT_HANDLER = DataChannel.create();
    public static final DataChannel ENTITY_RENDERER_REGISTER_LAYER_DEFINITION_EVENT_HANDLER = DataChannel.create();
    public static final DataChannel ENTITY_RENDERER_REGISTER_RENDERER_EVENT_HANDLER = DataChannel.create();
    public static final DataChannel FML_CLIENT_SETUP_EVENT_HANDLER_BOWS = DataChannel.create();
    public static final DataChannel FML_CLIENT_SETUP_EVENT_HANDLER_CROSSBOWS = DataChannel.create();
    public static final DataChannel FML_CLIENT_SETUP_EVENT_HANDLER_SHIELDS = DataChannel.create();
    public static final DataChannel FML_CLIENT_SETUP_EVENT_HANDLER_INSTRUMENTS = DataChannel.create();
    public static final DataChannel FML_CLIENT_SETUP_EVENT_HANDLER_WOOD_TYPES = DataChannel.create();
    public static final DataChannel FOV_MODIFIER_EVENT_HANDLER = DataChannel.create();
    public static final DataChannel REGISTER_PARTICLE_PROVIDERS_EVENT_HANDLER = DataChannel.create();

    public static final DataChannel ATLAS_ARMOR_TRIM_PROVIDER_TRIM_PATTERNS = DataChannel.create();
    public static final DataChannel ATLAS_ARMOR_TRIM_PROVIDER_TRIM_MATERIALS = DataChannel.create();
    public static final DataChannel LANGUAGE_PROVIDER = DataChannel.create();
    public static final DataChannel ITEM_MODEL_PROVIDER_FLAT_ITEMS = DataChannel.create();
    public static final DataChannel ITEM_MODEL_PROVIDER_HANDHELD_ITEMS = DataChannel.create();
    public static final DataChannel ITEM_MODEL_PROVIDER_BOW_ITEMS = DataChannel.create();
    public static final DataChannel ITEM_MODEL_PROVIDER_CROSSBOW_ITEMS = DataChannel.create();
    public static final DataChannel ITEM_MODEL_PROVIDER_TRIMMED_ARMOR_ITEMS = DataChannel.create();
    public static final DataChannel ITEM_MODEL_PROVIDER_POTION_ITEMS = DataChannel.create();
    public static final DataChannel ITEM_MODEL_PROVIDER_SPAWN_EGG_ITEMS = DataChannel.create();
    public static final DataChannel ITEM_MODEL_PROVIDER_PARENT_BLOCK_ITEMS = DataChannel.create();

    public static final DataChannel BLOCK_STATE_PROVIDER_SINGLE_VARIANT_BLOCKS = DataChannel.create();
    public static final DataChannel BLOCK_STATE_PROVIDER_COLUMN_BLOCKS = DataChannel.create();
    public static final DataChannel BLOCK_STATE_PROVIDER_BUTTON_BLOCKS = DataChannel.create();
    public static final DataChannel BLOCK_STATE_PROVIDER_DOOR_BLOCKS = DataChannel.create();
    public static final DataChannel BLOCK_STATE_PROVIDER_FENCE_GATE_BLOCKS = DataChannel.create();
    public static final DataChannel BLOCK_STATE_PROVIDER_PRESSURE_PLATE_BLOCKS = DataChannel.create();
    public static final DataChannel BLOCK_STATE_PROVIDER_SLAB_BLOCKS = DataChannel.create();
    public static final DataChannel BLOCK_STATE_PROVIDER_STAIRS_BLOCKS = DataChannel.create();
    public static final DataChannel BLOCK_STATE_PROVIDER_TRAPDOOR_BLOCKS = DataChannel.create();

    private DataChannels() {
    }
}
