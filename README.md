# Indoor4J
A IndoorGML data loader for Java using JAXB


### What is IndoorGML?
IndoorGML is an OGC standard for an open data model and XML schema for indoor spatial information. It aims to provide a common framework of representation and exchange of indoor spatial information. It is defined as an application schema of [OGC Geographic Markup Language (GML) 3.2.1.][ogclink]

[ogclink]: http://portal.opengeospatial.org/files/?artifact_id=20509



### Goal of this loader
- Everyone can load a IndoorGML file even who doesn't know well about IndoorGML
- Approach all of information in a IndoorGML file easily like using simple java classes









### Before use this
1.  Install a java which is more than 1.8 version.
      - Check this page [oracle jdk download.][jdk_download]

[jdk_download]: https://www.oracle.com/kr/java/technologies/javase-downloads.html
2.  Set up the java environment variable in your computer.
      - If it has done set up when you were installing the java. You can ignore second one.
3.  Install a gradle
      - Check this page [gradle releases.][gralde_download]
      - It doesn't matter with any version, but I recommend you should install the latest version of Gradle.

[gralde_download]: https://gradle.org/releases/

  4. Set up the gradle environment variable in your computer.
### How to use this loader

1. Download or clone this project(Indoor4J)
2. Try to run! (you can run this project from scratch without any modification)
3. Read Indoor4J codes from a main file (Main.java)
4. Adapt Indoor4J codes to your own projects

If you are not familiar with any java IDE, you can run this project from console with a below line

```sh
$ gradle build
$ javac ./src/main/java/edu/stem/debug/Main.java
$ cd src/main/java
$ javac edu/stem/debug/Main.java
$ java edu.stem.debug.Main
```

Then you can see test logs in your terminal or cmd.

<!-- 1. Download or clone this project
1. Try to run! (you can run this project from scratch without any modification)
2. Read Indoor4J codes from a main file (Main.java)
3. Adapt Indoor4J codes to your own projects

If you are not familiar with any java IDE, you can run this project from console with a below line
```sh
$ mvn exec:java -Dexec.mainClass=edu.pnu.stem.indoor4j.Main
``` -->


### About indoor4j project files
- Sample IndoorGML File: "./sample-3d.gml"
- Demo codes: "./src/main/java/edu/stem/debug/Main.java"
- JAXB Classes: 
  - "./src/main/java/edu/stem/indoor/IndoorFeatures.java"
  - "./src/main/java/edu/stem/space/*.java"
  - "./src/main/java/edu/stem/graph/*.java"


### Todos
- Provide handy usages
- Support various platforms and languages
