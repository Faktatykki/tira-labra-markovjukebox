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

The program has simple tests (for now) for inserting and searching with sequence sizes of 10, 100, 1000, 10000, 100000, 1000000 in/from trie with Markov chain orders of 1, 2, 3, 4 and 5.


### Unit testing  

 
#### Trie  

Trie data structure's methods are tested from 1st to 4th order of Markov Chain. This is executed by testing  
inserting with certain arrays of elements to Trie. Insert function's funcionality is validated by testing  
search method with beforehand known sequences. Also some borderline cases are tested but could be still  
elaborated.  

#### MidiHandler  

Midihandler is still in development since some paths should be given by UI. Now there are tests for if   
method for MIDI to array of integers works (testing if returns 'List' class), reads all the notes of given  
training data MIDI-file (for testing there is MIDI-file containing 264 notes) and that 'outputScoreToMidi'  
method actually writes a new MIDI-file when generating is done.  

#### MarkovGenerator

MarkovGenerator class acts as a service class for melody and rhythm generation and handling midi. It doesn't provide any crucial logic to test with, hence no tests are required.

#### SequenceCreator

SequenceCreator is tested if given a simple trie 'createSequence' method returns a right sequence. Also
if getting random node works when given array of nodes where one node is given some weight and other
ones are weighted zero. Hence only one node could be picked.

#### GeneratorService

GeneratorService provides some functionality to generate and combine note pitches, rhythms and durations. Generating and combining is tested with small list of values from 0 to 9.

#### Generator

Generator class a general purpose class for generating pitches, rhythm or durations. Class has a parse
function to parse right component out of 'NoteObject' which is determined by a string 'melody', 'rhythm'
or 'duration'. Addition to that it is tested that generated set is not longer than given training set.


#### Test coverage report  


![image](https://github.com/Faktatykki/tira-labra-markovjukebox/blob/main/markovjukebox/documentation/testcoverage.png)

