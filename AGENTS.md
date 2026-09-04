# AGENTS.md

## Project

Bloomish is a Minecraft mod/API project.

The project provides reusable APIs and abstractions for Minecraft mod
development, including block registration, block states, models and
data generation.

Before modifying code, inspect the existing implementation and follow
the established project patterns. Do not introduce a new pattern when
an existing one already solves the problem.

---

## Tech Stack

- Java: ${javaVersion}
- Gradle
- Minecraft: ${minecraftVersion}
- NeoForge: ${neoForgeVersion}

Use the versions defined in `gradle.properties` and Gradle configuration
as the source of truth.

---

## Project Structure

```text
# Main framework
neoforged-mod/src/main/java/io/bloomish

# Example mod using the framework
neoforged-example/src
├── /generated/resources
└── /main/java/io/bloomish

# AI agents module containing rules, skills, patterns and context
.ai
├── /rules
├── /skills
├── /patterns
└── /context
```

Follow the existing package structure.

Do not move classes or introduce new packages without a clear reason.

---

## Rules

Follow rules defined in:
`.ai/rules/`

---

## Skills

Use the appropriate skill when performing a common task:
`.ai/skills/`

Skills describe procedures for completing specific tasks.

Do not blindly follow a skill if it conflicts with the actual project
implementation. Existing project code is the source of truth.

---

## Context

Acknowledge with context:
`.ai/context/`

---

## Patterns

Check predefined patterns and if there is an applicable pattern you 
should use it:
`.ai/patterns/`

---

## Conventions

Use predefined conventions:
`.ai/conventions/`

---

## Anti-Patterns

Check predefined anti-patterns and avoid them:
`.ai/anti-patterns/`

---

## Workflows

Workflows describe procedures for completing end-to-end tasks:
`.ai/workflows/`

---

## Before Making Changes

Always:

1. Read the relevant code.
2. Ask questions if something is unclear.
3. Search for existing implementations of the same concept.
4. Identify the architectural pattern being used.
5. Determine whether generated files are involved.
6. Make the smallest change that satisfies the requirement.

Do not rewrite unrelated code.

---

## After Making Changes

Verify:

* compilation succeeds;
* relevant tests pass;
* generated resources are correct;
* no unrelated files were modified;
* the implementation follows existing project patterns.

If verification cannot be performed, explicitly state what was not verified.