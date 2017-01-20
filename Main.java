import java.util.*;

/**
 * A simple program that takes letters representing note values and outputs
 * the chord those notes create.
 * Author: Calvin Clark
 */
public class Main {
    private static String[] notes = new String[]{"C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B"};
    /**
     * Prints the prompts to the command line and initializes the scanner to read in
     * the notes.
     */
    public static void makeChord() {
        System.out.println("Notes should be represented as a letter, with # or b for sharp/flat");
        int[] notes = new int[12];
        int numNotes = 0;
        while(numNotes == 0){
            try {
                System.out.print("Number of notes: ");
                Scanner sc = new Scanner(System.in);
                numNotes = sc.nextInt();
                for (int i = 0; i < numNotes; i++) {
                    notes[newNote()]++;
                }
            }
            catch(RuntimeException r){
                System.out.println("Enter a valid number value.");
            }
        }
        System.out.print(chord(notes));
    }

    /**
     * Converts a chord into an array of intervals within that chord.
     * @param chord the int[] representing the current chord
     * @return an array of intervals within the chord
     */
    public static List<Integer> findIntervals(int[] chord){
        List<Integer> intervals = new ArrayList<>();
        for(int i=0; i<chord.length-1; i++){
            intervals.add(chord[i+1]-chord[i]);
        }
        return intervals;
    }

    /**
     * Asks the user for the next note and converts it to an int
     * @return the int representing the next note
     */
    public static int newNote(){
        boolean flat = false;
        System.out.print("Next note: ");
        Scanner scan = new Scanner(System.in);
        String note = scan.next();
        if(note.substring(1).equals("b")){
            flat = true;
            note = note.substring(0, 1);
        }
        for(int i = 0; i < notes.length; i++){
            if(note.equals(notes[i])){
                if(flat){
                    return i-1;
                }
                return i;
            }
        }
        System.out.println("Invalid Note");
        return(newNote());
    }

    /**
     * Converts the chord's int[] to a chord name
     * @param notes the notes within the chord
     * @return a string of the chord name
     */
    public static String chord(int[] notes){
        int size = 0;
        for(int i=0; i<notes.length; i++){
            if(notes[i]>0){
                size++;
            }
        }
        int count = 0;
        int[] chord = new int[size];
        for(int i=0; i<notes.length; i++){
            if(notes[i]>0){
                chord[count] = i;
                count++;
            }
        }
        List<Integer> intervals = findIntervals(chord);
        if(intervals.size() == 1){
            if (intervals.contains(7)) {
                return (numToNote(chord[0]) + "5");
            }
            if(intervals.contains(5)){
                return (numToNote(chord[1]) + "5");
            }
        }
        if((intervals.size() == 0)) {
            return (numToNote(chord[0]));
        }
        if(intervals.size() == 2) { //chord is a triad
            if(intervals.contains(6)){ //diminished fifth
                int location = 0;
                if(intervals.get(1) == 6){
                    location = 2;
                }
                else{
                    location = 1;
                }
                return(numToNote(chord[location]) + "dim");
            }
            if(intervals.get(0) == 3){ //minor third
                if(intervals.get(1) == 4){ //major third
                    return(numToNote(chord[0]) + "min");
                }
                if(intervals.get(1) == 3){//minor third
                    return(numToNote(chord[0]) + "dim");
                }
            }
            if(intervals.get(0) == 4){ //major third
                if(intervals.get(1) == 3){ //minor third
                    return(numToNote(chord[0]));
                }
                if(intervals.get(1) == 5){ //perfect fourth
                    return(numToNote(chord[2]) + "min");
                }
                if(intervals.get(1) == 4){ //major third
                    return(numToNote(chord[0]) + "aug");
                }
            }
            if(intervals.get(0) == 5){ //perfect fourth
                if(intervals.get(1) == 4){ //major third
                    return(numToNote(chord[1]));
                }
            }
        }
        return("Unknown Chord");


    }

    /**
     * Converts a number back to a note
     * @param num the number to be converted
     * @return a string of the note name
     */
    public static String numToNote(int num){
        return (notes[num]);
    }
    public static void main(String[] args){
        makeChord();
    }

}
