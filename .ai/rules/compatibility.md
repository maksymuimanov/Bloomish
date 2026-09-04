# Minecraft Version Compatibility

Priority: critical

Scope: All code

## Rule

MUST ensure code is compatible with the Minecraft version specified in gradle.properties.

## Rationale

The mod must work correctly with the target Minecraft version. Using features from other versions will cause crashes.

## Exceptions

None

## Verification

- Check that only APIs available in the target Minecraft version are used
- Verify that mappings are correct for the target version
- Ensure that no version-specific features are used without proper guards

---

# NeoForge Version Compatibility

Priority: critical

Scope: All code

## Rule

MUST ensure code is compatible with the NeoForge version specified in gradle.properties.

## Rationale

NeoForge APIs change between versions. Using incompatible APIs will cause loading failures.

## Exceptions

None

## Verification

- Check that only APIs available in the target NeoForge version are used
- Verify that event handlers use the correct event types
- Ensure that deprecated APIs are not used unless necessary

---


# Data Compatibility

Priority: high

Scope: All data storage

## Rule

MUST handle data migration when data structures change between versions.

## Rationale

Users may have existing worlds with old data formats. Proper migration prevents data loss.

## Exceptions

When the data format is experimental and migration is not required

## Verification

- Check that data versioning is handled
- Verify that old data can be migrated to new formats
- Ensure that data changes are backward compatible when possible

---

# Protocol Compatibility

Priority: high

Scope: Network packets

## Rule

MUST handle network protocol versioning to allow for future changes.

## Rationale

Network protocols may need to change. Versioning prevents crashes when connecting different versions.

## Exceptions

None

## Verification

- Check that network packets include version information
- Verify that protocol mismatches are handled gracefully
- Ensure that network changes don't break existing clients
