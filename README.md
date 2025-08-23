# SOLID Principles

SOLID is a set of five object-oriented design principles that help create robust, maintainable, and scalable software. Understanding and applying SOLID makes your codebase easier to understand, extend, and refactor.

## Table of Contents

- [Single Responsibility Principle (SRP)](#single-responsibility-principle-srp)
- [Open/Closed Principle (OCP)](#openclosed-principle-ocp)
- [Liskov Substitution Principle (LSP)](#liskov-substitution-principle-lsp)
- [Interface Segregation Principle (ISP)](#interface-segregation-principle-isp)
- [Dependency Inversion Principle (DIP)](#dependency-inversion-principle-dip)
- [Why Use SOLID?](#why-use-solid)
- [References](#references)

---

## Single Responsibility Principle (SRP)

A class should have one, and only one, reason to change.
- Each class should focus on a single responsibility or functionality.
- Avoid classes that handle unrelated problems.

---

## Open/Closed Principle (OCP)

Software entities should be **open for extension, but closed for modification**.
- Extend existing code by adding new functionality, not by altering current code.
- Use abstraction and interfaces to support extension.

---

## Liskov Substitution Principle (LSP)

Objects of a superclass should be replaceable with objects of a subclass without affecting the correctness.
- Subclasses must not break the behavior expected by the parent class.
- Ensure derived classes enhance, not reduce, functionality.

---

## Interface Segregation Principle (ISP)

No client should be forced to depend on methods it does not use.
- Split large interfaces into smaller, specific ones.
- Avoid “fat” interfaces that include unused functions.

---

## Dependency Inversion Principle (DIP)

High-level modules should depend on abstractions, not concrete implementations.
- Use interfaces and abstract classes to depend on abstractions.
- Enables easier swapping and testing of dependencies.

---

## Why Use SOLID?

- Improves maintainability and scalability
- Simplifies testing and refactoring
- Reduces technical debt and code smells

---

## References

- [Digital Ocean: SOLID - The First Five Principles](https://www.digitalocean.com/community/conceptual-articles/s-o-l-i-d-the-first-five-principles-of-object-oriented-design)
- [Baeldung: A Solid Guide to SOLID Principles](https://www.baeldung.com/solid-principles)
- [FreeCodeCamp: How to Write a Good README](https://www.freecodecamp.org/news/how-to-write-a-good-readme-file/)

