## Weekly Report 3


### What have I done this week?

Created quite a primitive generator only for melodies but the whole process works from reading a MIDI-file
as an input and creating a new MIDI-file based on input as an output. 


### How program has progressed?

The very basic idea architecture wise is fairly clear now. The program produces melodies with a hard coded
rhythm, which is a big step from last week. With these data structure's I've built I can implement, with 
very small alterations, the very same principalities to generate rhythm and note durations etc. 

I was struggling with the fact that Java has very few libraries for proper MIDI-parsing but I ended up
finding one (jMusic) with decent documentation and tutorials. 


### What have I learned this week?

Addition to learning more from the whole process of music generation with Markov Chain, I learned how to
handle MIDI-data with jMusic and what MIDI actually consists. 


### What was left unclear?

Pitch values are ranging from 0 to 127 so that is quite simple to implement in terms of array. Duration and rhythm
value of notes are doubles so I have to figure that out regarding my Trie implementation.


### What next?

Figure out how to generate rest of the components of music (which should be straightforward) and I'm planning to
do some major refactoring to make the code more reusable. If I have time I'll jump into making an UI.

