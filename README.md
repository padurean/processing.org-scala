processing.org-scala
====================

Graphics programming - sketches using Processing.org and Scala

**!NOTE**: [Processing.org](processing.org) & required libraries are supplied in the `lib` folder for **Mac OS ONLY**.
If using a different OS, please copy the equivalent ones, specific to the used OS, from the downloaded & extracted [Processing](https://processing.org/download/) folder to the `lib` folder.
The exact path where those libraries are located in the Processing folder, is OS specific - e.g. for Mac OS it is `Processing.app/Contents/Java/core/library` and their names are: `core.jar`, `gluegen-rt.jar`, `gluegen-rt-natives-macosx-universal.jar`, `jogl-all.jar` and `jogl-all-natives-macosx-universal.jar` (they are included in the `lib` folder).

After cloning, use `sbt run` to run the applet.
Use 1, 2 or 3 keys to switch between sketches.
Use `sbt one-jar` to package everything in single jar that can be run with `java -jar <jar-name>.jar`.
