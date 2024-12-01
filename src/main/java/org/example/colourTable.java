package org.example;

import java.util.Arrays;

public class colourTable {
    //define some basic variables
    Integer[][] palette;
    int currIndex;          // Used for keeping track of where the next index is in the array
    int paletteLength;
    int[] availability;     // Integer array to keep track of which entries are free 0 for empty 1 for full

    public colourTable(int paletteLength) {
        //Write a check to make sure that the palette size is within the proper range
        //Any power of two when bitwise ANDed with itself minus 1 will be 0000...
        if ((paletteLength > 1) && (paletteLength & (paletteLength - 1)) == 0) {
            //Use a multidimensional array for the palette as it allows for each colour (represented by row) to be a combination of 3 RGB values
            //initialise with null as a default value
            this.palette = new Integer[paletteLength][3];
            Arrays.fill(palette, null);

            // initialise the availability array with all 0's the same length as the palette itself
            this.availability = new int[paletteLength];
            Arrays.fill(availability, 0);

            this.currIndex = 0;
            this.paletteLength = paletteLength;
        } else {
            throw new IllegalArgumentException("\nPlease make sure the inputted length for palette is a power of two that is greater than 1 \n");
        }
    }

    public Integer[] colourTableGet(int index) {
        /* Fetches an Integer array [r,g,b] based on an index
           If no value has been assigned to this index it will return null*/
        try {
            return this.palette[index];
        } catch (IndexOutOfBoundsException e) {
            throw new IndexOutOfBoundsException("\nIndex requested out of range \n" + e.getMessage());
        }
    }

    public void colourTableSet(Integer[] input) {
        /* Takes an integer array as input and will insert
           into the matrix in the next available spot. Will
           throw an exception if it exceeds original size set in constructor */
        try {
            if (input.length == 3 && CheckRGB(input)) {
                for (int i = 0 ; i < paletteLength ; i++) {
                    if (availability[i] == 0) {
                        this.palette[i] = input;
                        this.availability[i] = 1;
                    }
                }
            } else {
                throw new IllegalArgumentException("Items being added are not within proper parameters of length and / or values should be an array of 3 integers with values in the range (inclusive) of 0 -> 255");
            }
        } catch(IndexOutOfBoundsException e){
            throw new IndexOutOfBoundsException("\nCannot add any more items to the palette please remove one and try again\n" + e.getMessage());
        }
    }

    public void colourTableSet(Integer[] input, int index) {
        /* Takes an integer array as input and will insert
           into the matrix in the next available spot. Will
           throw an exception if it exceeds original size set in constructor */
        try {
            if (input.length == 3 && CheckRGB(input)) {
                if (index != this.currIndex) {
                    this.palette[index] = input;
                    this.availability[index] = 1;
                } else {
                    for (int i = 0; i < paletteLength; i++) {
                        if (availability[i] == 0) {
                            this.palette[i] = input;
                            this.availability[i] = 1;
                        }
                    }
                }
            } else {
                throw new IllegalArgumentException("Items being added are not within proper parameters of length and / or values should be an array of 3 integers with values in the range (inclusive) of 0 -> 255");
            }
        } catch (IndexOutOfBoundsException e) {
            throw new IndexOutOfBoundsException("\nCannot add any more items to the palette please remove one and try again\n" + e.getMessage());
        }
    }


        /* ------------------------- Support functions ------------------------- */
        public boolean CheckRGB(Integer[] RGB){
            for (int i = 0; i < RGB.length ; i++){
                if ((RGB[i] < 0 || RGB[i] > 255) || i > 3) {
                    return false;
                }
            }
            return true;
        }
}