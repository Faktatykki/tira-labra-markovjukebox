# Markov's Jukebox

## Documentation

[Requirement Specification](https://github.com/Faktatykki/tira-labra-markovjukebox/blob/main/markovjukebox/documentation/requirement_specification.md)

#### Weekly reports

[Week 1](https://github.com/Faktatykki/tira-labra-markovjukebox/blob/main/markovjukebox/documentation/weekly_report_1.md)


#### Testaaminen

Testien suorittaminen tapahtuu komennolla: 

```
mvn test
```
  
Jacoco-testikattavuusraportin luominen tapahtuu komennolla:

```
mvn jacoco:report
```
Jos ylläoleva komento ei toimi, kannattaa kokeilla seuraavaa: 

```
mvn clean jacoco:prepare-agent install jacoco:report
```

#### JavaDoc

JavaDoc luodaan komennolla
```
mvn javadoc:javadoc
```
Tarkasteltava JavaDoc löytyy avaamalla tiedosto
*target/site/apidocs/index.html*

#### Checkstyle 

Checkstyle-tarkistukset saa suoritettua komennolla: 

```
mvn jxr:jxr checkstyle:checkstyle
```

Mahdolliset virheilmoitukset löytyvät tiedostosta *target/site/checkstyle.html*
