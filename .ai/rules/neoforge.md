# NeoForge Lifecycle

Priority: critical

Scope: All NeoForge event handlers

## Rule

MUST properly respect NeoForge lifecycle events and register handlers at the appropriate time.

## Rationale

Incorrect lifecycle handling can cause crashes, data loss, or mod loading failures.

## Exceptions

None

## Verification

- Check that event handlers are registered in the correct mod event
- Verify that common setup is done in FMLCommonSetupEvent
- Ensure that client-side setup is done in client-specific events

---

# Registry Objects

Priority: critical

Scope: All block, item, and other registry objects

## Rule

MUST use DeferredRegister for all registry objects and register them in the appropriate registry event.

## Rationale

DeferredRegister ensures proper registration order and handles registry replacement correctly.

## Exceptions

None

## Verification

- Check that DeferredRegister is used for all registrable objects
- Verify that registries are created with the correct mod ID
- Ensure that registry objects are not registered outside the proper event

---


# Networking

Priority: high

Scope: All network communication

## Rule

MUST use NeoForge's networking system (SimpleChannel) for all custom network packets.

## Rationale

NeoForge's networking system handles version compatibility, threading, and packet registration.

## Exceptions

None

## Verification

- Check that network channels are created with the proper version
- Verify that packets are registered on both client and server
- Ensure that packet handlers use the correct network thread context

---

# Capabilities

Priority: high

Scope: All capability providers and users

## Rule

MUST use NeoForge's capability system for attaching data to objects.

## Rationale

Capabilities provide a standard, extensible way to attach data to game objects.

## Exceptions

None

## Verification

- Check that capabilities are registered in the appropriate event
- Verify that capability providers implement the correct interface
- Ensure that capability injection is done on both client and server

---

# Client-Side Only Code

Priority: critical

Scope: All code that only runs on the client

## Rule

MUST properly segregate client-side code using DistExecutor or client-only classes.

## Rationale

Client-side code will crash dedicated servers if not properly segregated.

## Exceptions

None

## Verification

- Check that client-only code is guarded by DistExecutor or @OnlyIn
- Verify that client-only classes are in separate packages
- Ensure that client-only code is not referenced from common code

---

# Resource Loading

Priority: medium

Scope: All resource loading code

## Rule

MUST use NeoForge's resource loading system and respect resource reload events.

## Rationale

Proper resource handling ensures resources can be hot-reloaded and are available when needed.

## Exceptions

None

## Verification

- Check that resources are loaded through the proper resource managers
- Verify that resource reload listeners are registered if needed
- Ensure that resource locations use the correct namespace
