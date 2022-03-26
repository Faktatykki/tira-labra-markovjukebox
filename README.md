# Markov's Jukebox

## Documentation

[Requirement Specification](https://github.com/Faktatykki/tira-labra-markovjukebox/blob/main/markovjukebox/documentation/requirement_specification.md)

### Weekly reports

[Week 1](https://github.com/Faktatykki/tira-labra-markovjukebox/blob/main/markovjukebox/documentation/weekly_report_1.md)  
[Week 2](https://github.com/Faktatykki/tira-labra-markovjukebox/blob/main/markovjukebox/documentation/weekly_report_2.md)


### Testaaminen

Run tests: 

```
mvn test
```
  
Jacoco coverage report:

```
mvn jacoco:report
```
If that didn't work, try: 

```
mvn clean jacoco:prepare-agent install jacoco:report
```

### JavaDoc

Create JavaDoc:
```
mvn javadoc:javadoc
```
JavaDoc file can be found in:
*target/site/apidocs/index.html*

### Checkstyle 

Checkstyle: 

```
mvn jxr:jxr checkstyle:checkstyle
```

Errors can be found in *target/site/checkstyle.html*
