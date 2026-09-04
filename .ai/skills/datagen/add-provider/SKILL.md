# Add Provider

## Purpose

Add a new data generation provider to the Bloomish data generation system.

## Prerequisites

- Understand the existing data generation structure in `neoforged-mod/src/main/java/io/bloomish/api/data/`
- Review `.ai/rules/datagen.md`
- Identify the type of provider needed (client, server, blockstate, model, etc.)
- Check if a similar provider already exists

## Steps

1. **Identify provider type**
   - Determine if it's an asset generator (client) or data generator (server)
   - Identify the specific category (blockstate, model, language, etc.)
   - Check existing providers in the same category

2. **Create the provider class**
   - Extend the appropriate base class from Bloomish
   - Place in the correct package under `api/data/client/` or `api/data/server/`
   - Follow existing naming conventions
   - Implement required methods

3. **Implement data generation logic**
   - Follow the pattern of existing providers
   - Use Bloomish's data gathering utilities
   - Ensure data is consistent with registered objects
   - Handle all necessary cases

4. **Register the provider**
   - Register in `ApiDataGenerator` or appropriate entry point
   - Register in the correct category (asset or data)
   - Ensure proper ordering if dependencies exist

5. **Test the provider**
   - Run data generation
   - Verify generated files are correct
   - Check for missing data
   - Ensure data format is correct

## Verification

- Provider extends correct base class
- Provider is in correct package
- Provider follows existing patterns
- Provider is registered correctly
- Generated data is correct
- Data generation completes without errors
- Code follows datagen rules
