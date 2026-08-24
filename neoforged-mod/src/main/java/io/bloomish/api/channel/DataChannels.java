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

    private DataChannels() {
    }
}
