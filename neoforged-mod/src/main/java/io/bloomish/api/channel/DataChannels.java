package io.bloomish.api.channel;

public final class DataChannels {
    public static final DataChannel BLOCK_ENTITY_TYPE_EVENT_HANDLER = new DataChannel("block_entity_type_event_handler");
    public static final DataChannel CREATIVE_MODE_TAB_EVENT_HANDLER = new DataChannel("creative_mode_tab_event_handler");
    public static final DataChannel ENTITY_ATTRIBUTE_EVENT_HANDLER = new DataChannel("entity_attribute_event_handler");
    public static final DataChannel ENTITY_RENDERER_REGISTER_LAYER_DEFINITION_EVENT_HANDLER = new DataChannel("entity_renderer_register_layer_definition_event_handler");
    public static final DataChannel ENTITY_RENDERER_REGISTER_RENDERER_EVENT_HANDLER = new DataChannel("entity_renderer_register_renderer_event_handler");
    public static final DataChannel FML_CLIENT_SETUP_EVENT_HANDLER_BOWS = new DataChannel("fml_client_setup_event_handler_bows");
    public static final DataChannel FML_CLIENT_SETUP_EVENT_HANDLER_CROSSBOWS = new DataChannel("fml_client_setup_event_handler_crossbows");
    public static final DataChannel FML_CLIENT_SETUP_EVENT_HANDLER_SHIELDS = new DataChannel("fml_client_setup_event_handler_shields");
    public static final DataChannel FML_CLIENT_SETUP_EVENT_HANDLER_INSTRUMENTS = new DataChannel("fml_client_setup_event_handler_instruments");
    public static final DataChannel FML_CLIENT_SETUP_EVENT_HANDLER_WOOD_TYPES = new DataChannel("fml_client_setup_event_handler_wood_types");
    public static final DataChannel FOV_MODIFIER_EVENT_HANDLER = new DataChannel("fov_modifier_event_handler");
    public static final DataChannel REGISTER_PARTICLE_PROVIDERS_EVENT_HANDLER = new DataChannel("register_particle_providers_event_handler");

    public static final DataChannel ATLAS_ARMOR_TRIM_PROVIDER_TRIM_PATTERNS = new DataChannel("atlas_armor_trim_provider_trim_patterns");
    public static final DataChannel ATLAS_ARMOR_TRIM_PROVIDER_TRIM_MATERIALS = new DataChannel("atlas_armor_trim_provider_trim_materials");
    public static final DataChannel LANGUAGE_PROVIDER = new DataChannel("language_provider");
    public static final DataChannel ITEM_MODEL_PROVIDER_FLAT_ITEMS = new DataChannel("item_model_provider_flat_items");
    public static final DataChannel ITEM_MODEL_PROVIDER_HANDHELD_ITEMS = new DataChannel("item_model_provider_handheld_items");
    public static final DataChannel ITEM_MODEL_PROVIDER_BOW_ITEMS = new DataChannel("item_model_provider_bow_items");
    public static final DataChannel ITEM_MODEL_PROVIDER_CROSSBOW_ITEMS = new DataChannel("item_model_provider_crossbow_items");
    public static final DataChannel ITEM_MODEL_PROVIDER_TRIMMED_ARMOR_ITEMS = new DataChannel("item_model_provider_trimmed_armor_items");
    public static final DataChannel ITEM_MODEL_PROVIDER_POTION_ITEMS = new DataChannel("item_model_provider_potion_items");
    public static final DataChannel ITEM_MODEL_PROVIDER_SPAWN_EGG_ITEMS = new DataChannel("item_model_provider_spawn_egg_items");
    public static final DataChannel ITEM_MODEL_PROVIDER_PARENT_BLOCK_ITEMS = new DataChannel("item_model_provider_parent_block_items");
    public static final DataChannel ITEM_MODEL_PROVIDER_BUTTON_PARENT_BLOCK_ITEMS = new DataChannel("item_model_provider_button_parent_block_items");

    public static final DataChannel BLOCK_STATE_PROVIDER_SINGLE_VARIANT_BLOCKS = new DataChannel("block_state_provider_single_variant_blocks");
    public static final DataChannel BLOCK_STATE_PROVIDER_COLUMN_BLOCKS = new DataChannel("block_state_provider_column_blocks");
    public static final DataChannel BLOCK_STATE_PROVIDER_BUTTON_BLOCKS = new DataChannel("block_state_provider_button_blocks");
    public static final DataChannel BLOCK_STATE_PROVIDER_DOOR_BLOCKS = new DataChannel("block_state_provider_door_blocks");
    public static final DataChannel BLOCK_STATE_PROVIDER_FENCE_GATE_BLOCKS = new DataChannel("block_state_provider_fence_gate_blocks");
    public static final DataChannel BLOCK_STATE_PROVIDER_PRESSURE_PLATE_BLOCKS = new DataChannel("block_state_provider_pressure_plate_blocks");
    public static final DataChannel BLOCK_STATE_PROVIDER_SLAB_BLOCKS = new DataChannel("block_state_provider_slab_blocks");
    public static final DataChannel BLOCK_STATE_PROVIDER_STAIRS_BLOCKS = new DataChannel("block_state_provider_stairs_blocks");
    public static final DataChannel BLOCK_STATE_PROVIDER_TRAPDOOR_BLOCKS = new DataChannel("block_state_provider_trapdoor_blocks");
    public static final DataChannel BLOCK_STATE_PROVIDER_AXIS_BLOCKS = new DataChannel("block_state_provider_axis_blocks");
    public static final DataChannel BLOCK_STATE_PROVIDER_FENCE_BLOCKS = new DataChannel("block_state_provider_fence_blocks");
    public static final DataChannel BLOCK_STATE_PROVIDER_WALL_BLOCKS = new DataChannel("block_state_provider_wall_blocks");

    public static final DataChannel BLOCK_MODEL_PROVIDER_BUTTON_BLOCKS = new DataChannel("block_model_provider_button_blocks");

    private DataChannels() {
    }
}
