package generator;

import datastructures.NoteObject;

import java.util.ArrayList;
import java.util.List;

public class GeneratorService {

    private final int order;
    private final int longestDuration;
    private List<NoteObject> trainingSet;
    private Generator melodyGenerator;
    private Generator rhythmGenerator;
    private Generator durationGenerator;
    private Generator dynamicGenerator;

    public GeneratorService(int order, List<NoteObject> trainingSet) {
        this.order = order;
        this.trainingSet = trainingSet;
        this.melodyGenerator = new Generator(this.order, 128, "melody");

        this.longestDuration = (int) getLongestDuration(trainingSet);

        this.rhythmGenerator = new Generator(this.order, this.longestDuration, "rhythm");
        this.durationGenerator = new Generator(this.order, this.longestDuration, "duration");
        this.dynamicGenerator = new Generator(this.order, this.longestDuration, "dynamic");
    }

    /**
     * Generates melody, rhythm and duration values based on training data set by passing the
     * training set to assigned generators.
     *
     * @return generated song as a list of NoteObjects by combining melody, rhythms and durations
     */
    public List<NoteObject> generate() {
        List<Integer> melody = this.melodyGenerator.generate(this.trainingSet);
        List<Integer> rhythm = this.rhythmGenerator.generate(this.trainingSet);
        List<Integer> duration = this.durationGenerator.generate(this.trainingSet);
        List<Integer> dynamic = this.dynamicGenerator.generate(this.trainingSet);

        List<NoteObject> generatedSong = combineGeneratedProperties(melody, rhythm, duration, dynamic);

        return generatedSong;
    }

    /**
     * Combines all generated properties (melody, rhythm, duration) and creates
     * a list of NoteObjects
     *
     * @param generatedPitches
     * @param generatedRhythms
     * @param generatedDurations
     *
     * @return list of NoteObjects which represents the generated song
     */
    public List<NoteObject> combineGeneratedProperties(List<Integer> generatedPitches, List<Integer> generatedRhythms, List<Integer> generatedDurations, List<Integer> generatedDynamics) {
        List<NoteObject> generatedSong = new ArrayList<>();

        int loopSize = getMinListSize(generatedPitches.size(), generatedRhythms.size(), generatedDurations.size(), generatedDynamics.size());

        for (int i = 0; i < loopSize; i++) {
            int pitch = generatedPitches.get(i);
            int rhythm = generatedRhythms.get(i);
            int duration = generatedDurations.get(i);
            int dynamic = generatedDynamics.get(i);
            //here optional rhythm > duration but doesnt seem to matter

            generatedSong.add(new NoteObject(pitch, rhythm, duration, dynamic));
        }

        return generatedSong;
    }

    /**
     * Finds the longest duration value of given training set which determines the
     * length of rhythm and duration TrieNodes children arrays
     *
     * @param set list of NoteObjects which represents the training set
     *
     * @return The largest duration value of given list
     */
    public double getLongestDuration(List<NoteObject> set) {

        double longest = -1;

        for (int i = 0; i < set.size(); i++) {
            double duration = set.get(i).getDuration();
            if (duration > longest) {
                longest = duration;
            }
        }

        return longest;
    }

    /**
     * Finds the smallest list size of given three lists (pitches, rhythms and durations)
     * so ArrayIndexOutOfBoundsException won't become a problem.
     *
     * @param list1
     * @param list2
     * @param list3
     *
     * @return the smallest list size value
     */
    public int getMinListSize(int list1, int list2, int list3, int list4) {
        return Math.min(Math.min(list1, list2), Math.min(list3, list4));
    }
}
