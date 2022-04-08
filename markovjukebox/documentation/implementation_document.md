# Implementation documentation

## Structure 

#### NoteObject

Not to confuse with jMusic library's class 'Note'. NoteObject contains note's attributes (pitch, rhythm, duration).

#### Trie

Trie data structure where one can insert and search note sequences

#### TrieNode

Node of trie data structure

#### MarkovGenerator

Service class for generating rhythm and melody and handling MIDI.

#### MelodyGenerator

Generates melody sequence based on given trie utilizing 'SequenceCreator'

#### RhythmGenerator

For now placeholder for generating rhythm based on given trie

#### SequenceCreator

Creates sequence based on given trie. Has all the functionality for picking the next child node and keeping
the sequence creation uninterrupted

#### MidiHandler 

Reads midi file, converts file to 'NoteObject' arraylist and returns it. When song is generated, outputs 
given 'NoteObject' arraylist as a MIDI-file



## Time Complexity  


Inserting to trie is O(nm), where: 
  
n = Markov chain order  
m = Quantity of elements  

Searching from trie is O(n), where:  

n = Markov chain order  


##### Sources  


https://www.cs.cmu.edu/~music/cmsip/slides/05-algo-comp.pdf  
https://medium.com/hackernoon/generating-music-using-markov-chains-40c3f3f46405 
https://en.wikipedia.org/wiki/Markov_chain  
https://explodingart.com/jmusic/jmtutorial/t1.html
https://explodingart.com/jmusic/jmDocumentation/overview-summary.html  
https://eprints.qut.edu.au/6805/1/6805.pdf  

