mvn-multi-module-assembly
=========================

A sample project using modules in maven with assembly plugin.

Modules

- api       : A public exposable api.
- in-memory : A impl of the api repositories implemented with an in-memory list. Depends on api.
- main      : An entry point to use the same repository impl. Depends on in-memory.
- dist      : Module that builds a zip archive of all libraries requried to run main


Uses the maven assembly plugin to create a zip file or jars required to run the sample project.
