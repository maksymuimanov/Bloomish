# Migrate to Fabric

## Purpose

Migrate the mod from NeoForge to Fabric mod loader.

## Prerequisites

- Understand Fabric modding architecture
- Review Fabric documentation
- Assess the complexity of migration
- Plan for maintaining both versions if needed

## Steps

1. **Assess migration scope**
   - Identify NeoForge-specific APIs used
   - Identify Fabric equivalents
   - Assess data generation differences
   - Plan for shared code if maintaining both versions

2. **Update build configuration**
   - Replace Gradle plugins with Fabric plugins
   - Update dependencies to Fabric equivalents
   - Configure Fabric mod metadata
   - Update loom configuration

3. **Migrate core mod logic**
   - Replace mod entry point
   - Migrate event system to Fabric events
   - Update registry system to Fabric registry
   - Migrate capabilities to Fabric attachments

4. **Migrate networking**
   - Replace NeoForge networking with Fabric networking
   - Update packet handling
   - Update channel registration

5. **Migrate data generation**
   - Replace NeoForge data generation with Fabric data generation
   - Update provider base classes
   - Update data generator setup

6. **Update client-side code**
   - Replace client-only annotations
   - Migrate rendering code if applicable
   - Update resource loading

7. **Test the migration**
   - Verify the mod loads on Fabric
   - Test all features
   - Check data generation
   - Verify client and server functionality

## Verification

- Mod loads successfully on Fabric
- All features work correctly
- Data generation works
- No NeoForge-specific code remains
- Code follows Fabric conventions
- Tests pass
