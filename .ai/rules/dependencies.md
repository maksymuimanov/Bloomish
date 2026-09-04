# No Additional Dependencies

Priority: critical

Scope: All code

## Rule

MUST NOT add any additional dependencies beyond what is already in the project.

## Rationale

Additional dependencies increase project size, can cause conflicts, and create maintenance burden. The project should remain minimal.

## Exceptions

When the user explicitly requests a new dependency and provides justification

## Verification

- Check that no new dependencies are added to build.gradle
- Verify that no new libraries are imported
- Ensure that all used libraries are already in the project

---

# Dependency Versions

Priority: high

Scope: All dependency usage

## Rule

MUST use the dependency versions specified in gradle.properties and build configuration.

## Rationale

Consistent dependency versions ensure reproducible builds and prevent conflicts.

## Exceptions

None

## Verification

- Check that dependency versions are not hardcoded in build files
- Verify that gradle.properties is the source of truth for versions
- Ensure that dependency versions are consistent across modules

---

# Provided Dependencies

Priority: medium

Scope: Dependency configuration

## Rule

MUST mark dependencies that are provided by the runtime environment (Minecraft, NeoForge) as such.

## Rationale

Provided dependencies should not be included in the mod distribution.

## Exceptions

None

## Verification

- Check that Minecraft and NeoForge dependencies are marked as provided
- Verify that provided dependencies are not included in the final jar
- Ensure that dependency configurations are correct

---

# Transitive Dependencies

Priority: medium

Scope: Dependency management

## Rule

MUST be aware of transitive dependencies and avoid conflicts.

## Rationale

Transitive dependencies can cause version conflicts and unexpected behavior.

## Exceptions

None

## Verification

- Check that transitive dependencies do not conflict
- Verify that dependency exclusions are used when necessary
- Ensure that the dependency tree is clean
