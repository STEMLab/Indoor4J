# Indoor4J
A IndoorGML data loader for Java using JAXB



### What is IndoorGML?
IndoorGML is an OGC standard for an open data model and XML schema for indoor spatial information. It aims to provide a common framework of representation and exchange of indoor spatial information. It is defined as an application schema of [OGC Geographic Markup Language (GML) 3.2.1.][ogclink]

[ogclink]: http://portal.opengeospatial.org/files/?artifact_id=20509



### Goal of this loader
- Everyone can load a IndoorGML file even who doesn't know well about IndoorGML
- Approach all of information in a IndoorGML file easily like using simple java classes



### How to use this loader

1. Download or clone this project
2. Try to run! (you can run this project from scratch without any modification)
3. Read Indoor4J codes from a main file (Main.java)
4. Adapt Indoor4J codes to your own projects

If you are not familiar with any java IDE, you can run this project from console with a below line
```sh
$ mvn exec:java -Dexec.mainClass=edu.pnu.stem.indoor4j.Main
```


### About indoor4j project files
- Sample IndoorGML File: "./sample-3d.gml"
- Demo codes: "./edu/pnu/stem/indoor4j/Main.java"
- JAXB Classes: "./src/main/java/IndoorGmlParse/*.java"


### Todos
- Provide handy usages
- Support various platforms and languages
