package com.aryan.advancedspring.Vehicles;

/*
====================================================================================
ENGINE INTERFACE — ABSTRACTION LAYER
====================================================================================

Purpose:
- Defines contract for all engine types.
- Promotes loose coupling.
- Enables multiple implementations:
    PetrolEngine
    DieselEngine

Spring injects based on this interface type.

Dependency resolution rule:
- Spring injects by TYPE first.
- Interface allows flexible substitution.
*/

public interface Engine {

    /*
    Method to be implemented by concrete classes.
    Polymorphism enables runtime behavior selection.
    */
    void EngineType();
}