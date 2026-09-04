# Migrate Minecraft Version

## Purpose

Update the mod to work with a new Minecraft version.

## Prerequisites

- Check the target Minecraft version requirements
- Review `.ai/rules/compatibility.md` and `.ai/rules/java.md`
- Update gradle.properties with the new version
- Check NeoForge compatibility with the new Minecraft version

## Steps

1. **Update build configuration**
   - Update Minecraft version in gradle.properties
   - Update NeoForge version if needed
   - Update mappings if needed
   - Update dependency versions

2. **Review breaking changes**
   - Check Minecraft version changelog for breaking changes
   - Check NeoForge changelog for breaking changes
   - Identify deprecated/removed APIs
   - Review mapping changes

3. **Update code for API changes**
   - Replace deprecated APIs with new ones
   - Update method signatures that changed
   - Handle removed features
   - Update registry usage if changed

4. **Update data generation**
   - Check for data format changes
   - Update data providers if needed
   - Verify generated data is compatible
   - Update resource locations if changed

5. **Test the migration**
   - Verify the mod loads correctly
   - Test all major features
   - Check data generation works
   - Verify client and server functionality

6. **Update compatibility rules**
   - Update version-specific rules if needed
   - Document any version-specific workarounds

## Verification

- Mod loads successfully on new version
- All features work correctly
- Data generation produces correct output
- No deprecated APIs are used (unless necessary)
- Code follows compatibility rules
- Tests pass
