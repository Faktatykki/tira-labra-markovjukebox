## Weekly Report 4


### What have I done this week? / How program has progressed?

I've done a major refactoring architecture wise and made sense how to build some kind of rhythm addition to melody. Class MarkovGenerator acts as
a service class for melody creating, rhythm creating and handling files. Top of this I began with performance tests. Only testing performance of
populating trie for now.

### What have I learned this week?

I've learned about the difficulties of handling rhythm values with this implementation of Trie data structure. Also I finally grasped how jMusic
library actually interprets MIDI-files and how different jMusic classes are viewed in regular music theory.

### What was left unclear?

If I would like to generate the rhythm and duration values the same way as the melody generation, I need to come up with something. Rhythm
and duration values use doubles which are always related to one beat. So one beat (quarter note) is 1.0 so eighth note would be value of 0.5.
Maybe instead of Trie's node's array of children I could use array list. We'll see.

### What next?

Should start building UI and figure out what to do with generating rhythm. Maybe it is good as it is.
