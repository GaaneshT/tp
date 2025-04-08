---
layout: page
title: Gaanesh's Project Portfolio Page
---

### Project: TutorSynch

Given below are my contributions to the project.

* **Feature #1**: Added the `sort` command. [\#97](https://github.com/AY2425S2-CS2103-F15-2/tp/pull/97)
    * **What it does**: Allows users to sort the existing list of students by name in alphabetical order without affecting newly added students (which appear at the bottom until another `sort` is performed).
    * **Highlights**:
        - Involves a new command that interacts with the `Model` to reorder the internal list of `Person` objects.
        - Required additional parser logic (a `SortCommandParser` that rejects extra arguments).
        - Needed system tests to ensure correct behavior even when the address book is empty or partially sorted.

* **Feature #2**: Added the ability to append tags. [\#79](https://github.com/AY2425S2-CS2103-F15-2/tp/pull/79)
    * **What it does**: Introduces a new `t+/` prefix in `edit` commands that appends tags instead of overwriting them.
    * **Highlights**:
        - Works in tandem with existing `t/` (overwrite) and `t-/` (remove) prefixes.
        - Required changes in `EditPersonDescriptor` and `EditCommandParser` to handle multiple tag operations at once.
        - Wrote tests to confirm that overwriting, removing, and appending tags can coexist without conflicts.

* **Documentation**:
    * **User Guide**:
        - Documented the usage of `sort` with examples. [\#99](https://github.com/AY2425S2-CS2103-F15-2/tp/pull/99)
        - Explained new `t+/` prefix under the `edit` command, including sample use cases. [\#79](https://github.com/AY2425S2-CS2103-F15-2/tp/pull/79)
    * **Developer Guide**:
        - Added an implementation overview of `SortCommand`
        - Included a UML sequence diagram in the Developer Guide. [\#153](https://github.com/AY2425S2-CS2103-F15-2/tp/pull/153)

* **Testing**:
    * Performed smoke testing on v1.3 and v1.4 releases. [\#100](https://github.com/AY2425S2-CS2103-F15-2/tp/issues/100)
