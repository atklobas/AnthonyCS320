#!/bin/bash
antlr4 json.g4
javac json*.java
cat test.txt | java org.antlr.v4.gui.TestRig json value -gui
