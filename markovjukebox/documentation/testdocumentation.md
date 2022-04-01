# Test Documentation

## Executing tests


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
  

### Unit testing  

Class 'MarkovGenerator' is excluded from test coverage due to next week's (week 4) refactoring.  
 
#### Trie  

Trie data structure's methods are tested from 1st to 4th order of Markov Chain. This is executed by testing  
inserting with certain arrays of elements to Trie. Insert function's funcionality is validated by testing  
search method with beforehand known sequences. Also some borderline cases are tested but could be still  
elaborated.  

#### MidiHandler  

Midihandler is still in development since some paths should be given by UI. Now there are tests for if   
method for MIDI to array of integers works (testing if returns 'List' class), reads all the notes of given  
training data MIDI-file (for testing there is MIDI-file containing 1252 notes) and that 'outputScoreToMidi'  
method actually writes a new MIDI-file when generating is done.  

#### Test coverage report  


![image](https://github.com/Faktatykki/tira-labra-markovjukebox/blob/main/markovjukebox/documentation/testcoverage.png)

