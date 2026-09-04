# Migrate NeoForge Version

## Purpose

Update the mod to work with a new NeoForge version.

## Prerequisites

- Check the target NeoForge version requirements
- Review `.ai/rules/compatibility.md` and `.ai/rules/neoforge.md`
- Update gradle.properties with the new version
- Check Minecraft version compatibility

## Steps

1. **Update build configuration**
   - Update NeoForge version in gradle.properties
   - Update related dependencies if needed
   - Check for plugin updates

2. **Review breaking changes**
   - Check NeoForge changelog for breaking changes
   - Identify deprecated/removed APIs
   - Review event system changes
   - Check registry system changes

3. **Update code for API changes**
   - Replace deprecated NeoForge APIs
   - Update event handlers if event types changed
   - Update registry usage if changed
   - Update capability usage if changed

4. **Update networking**
   - Check for networking API changes
   - Update channel registration if needed
   - Update packet handling if changed

5. **Update data generation**
   - Check for data generation API changes
   - Update provider base classes if needed
   - Verify data generator setup

6. **Test the migration**
   - Verify the mod loads correctly
   - Test all NeoForge-specific features
   - Check event handling works
   - Verify data generation works

## Verification

- Mod loads successfully with new NeoForge version
- All NeoForge features work correctly
- Event handlers fire correctly
- Data generation works
- No deprecated NeoForge APIs are used
- Code follows NeoForge rules
- Tests pass
