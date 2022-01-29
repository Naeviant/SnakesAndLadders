# Snakes & Ladders

A game engine for the well-known board game *Snakes & Ladders*.

Full documentation coming soon.

### Running the Project

From the `src` directory, use the following commands:

`rm Driver.class`

`rm .\SnakesAndLadders\*.class`

`javac .\SnakesAndLadders\* .\Driver.java`

`java Driver`

### Building the Documentation

To build the documentation, use following command:

`javadoc .\src\SnakesAndLadders\* -d docs -private -noqualifier java.lang:java.util -link https://docs.oracle.com/en/java/javase/11/docs/api/`

Documentation is generated into the `docs` directory. Open the `index.html` file to view them.