# Instructions

### Cloning the repository 
  
  
Clone the repository to your chosen directory    

``` 
git@github.com:Faktatykki/tira-labra-markovjukebox.git  
``` 

### Running the program


Run program:  

```
mvn compile exec:java -Dexec.mainClass=Main  
```

This executes a program and opens the user interface.  


### Input
  
Program takes MIDI-files as an input and outputs the generated song as a MIDI-file. UI gives instructions in which form
can input files be given.

  
  
### Creating reports

Jacoco coverage report:

```
mvn jacoco:report
```
If that didn't work, try: 

```
mvn clean jacoco:prepare-agent install jacoco:report
```

Create JavaDoc:
```
mvn javadoc:javadoc
```
JavaDoc file can be found in:
*target/site/apidocs/index.html*

Checkstyle: 

```
mvn jxr:jxr checkstyle:checkstyle
```

Errors can be found in *target/site/checkstyle.html*

