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

### Performance testing

The program has simple tests (for now) for inserting 100000 notes in trie with different Markov chain orders.


### Unit testing  

 
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

#### MarkovGenerator

MarkovGenerator class acts as a service class for melody and rhythm generation and handling midi. Therefore
only one method (combining notes differernt properties together) is tested since other functionality is other 
classes responsibility. 

#### SequenceCreator

SequenceCreator is tested if given a simple trie 'createSequence' method returns a right sequence. Also
if getting random node works when given array of nodes where one node is given some weight and other
ones are weighted zero. Hence only one node could be picked.


#### Test coverage report  


![image](https://github.com/Faktatykki/tira-labra-markovjukebox/blob/main/markovjukebox/documentation/testcoverage.png)

