package io.bloomish.api.channel;

public final class Channels {
    public static final BiQueueChannel BLOCK_ENTITY_TYPE_EVENT_HANDLER_BI_CHANNEL = new BiQueueChannel("block_entity_type_event_handler");
    public static final BiQueueChannel CREATIVE_MODE_TAB_EVENT_HANDLER_BI_CHANNEL = new BiQueueChannel("creative_mode_tab_event_handler");
    public static final BiChannel ENTITY_ATTRIBUTE_EVENT_HANDLER_BI_CHANNEL = new BiChannel("entity_attribute_event_handler");

    private Channels() {
    }
}
