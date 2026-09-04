# Data Provider Structure

Priority: high

Scope: All data generation code

## Rule

MUST follow the established data provider structure in the Bloomish framework.

## Rationale

Consistent data provider structure makes the codebase predictable and easier to maintain.

## Exceptions

None

## Verification

- Check that data providers extend the appropriate base classes
- Verify that providers follow the naming conventions
- Ensure that providers are registered in the correct location

---

# Block State Providers

Priority: high

Scope: Block state data generation

## Rule

MUST use the appropriate BlockStateProvider for each block type (e.g., StairsBlockStateProvider for stairs).

## Rationale

Different block types have different state requirements. Specialized providers handle this correctly.

## Exceptions

When creating a new block type that doesn't have an existing provider

## Verification

- Check that the correct provider is used for each block type
- Verify that block states are generated correctly
- Ensure that all block properties are handled

---

# Model Providers

Priority: high

Scope: Model data generation

## Rule

MUST use the appropriate ModelProvider for each model type.

## Rationale

Different model types require different generation logic.

## Exceptions

None

## Verification

- Check that the correct model provider is used
- Verify that models are generated with correct textures
- Ensure that model properties are set correctly

---

# Data Consistency

Priority: critical

Scope: All generated data

## Rule

MUST ensure generated data is consistent with registered objects.

## Rationale

Inconsistent data between registration and generation causes resource loading errors.

## Exceptions

None

## Verification

- Check that all registered blocks have corresponding block state data
- Verify that all registered items have corresponding model data
- Ensure that data generation covers all registered objects

---

# Data Generator Registration

Priority: high

Scope: Data generator setup

## Rule

MUST register all data providers in the data generator setup method.

## Rationale

Unregistered providers will not generate data, leading to missing resources.

## Exceptions

None

## Verification

- Check that all providers are registered
- Verify that providers are registered in the correct order
- Ensure that the data generator entry point is correct

---

# Asset vs Data Generators

Priority: high

Scope: Data generation categorization

## Rule

MUST correctly categorize generators as asset generators (client resources) or data generators (server data).

## Rationale

Asset and data generators run at different times and produce different outputs.

## Exceptions

None

## Verification

- Check that asset generators are registered in the asset generator
- Verify that data generators are registered in the data generator
- Ensure that generators are in the correct category

---

# Texture References

Priority: medium

Scope: Model data generation

## Rule

MUST use consistent texture naming conventions and reference textures correctly.

## Rationale

Incorrect texture references cause missing texture errors in-game.

## Exceptions

None

## Verification

- Check that texture names follow the established convention
- Verify that texture references are correct
- Ensure that all referenced textures exist
