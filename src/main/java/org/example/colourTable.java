package org.example;

import org.jetbrains.annotations.Nullable;

import java.util.Arrays;

public class colourTable {
    //define some basic variables
    Integer[][] palette;
    int currIndex;          // Used for keeping track of where the next index is in the array
    int paletteLength;

    public colourTable(int paletteLength) {
        //Write a check to make sure that the palette size is within the proper range
        //Any power of two when bitwise ANDed with itself minus 1 will be 0000...
        if ((paletteLength > 1) && (paletteLength & (paletteLength - 1)) == 0) {
            //Use a multidimensional array for the palette as it allows for each colour (represented by row) to be a combination of 3 RGB values
            //initialise with null as a default value
            this.palette = new Integer[paletteLength][3];
            Arrays.fill(palette, null);

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
                    if (palette[i] == null) {
                        this.palette[i] = input;
                    }
                }
            } else {
                throw new IllegalArgumentException("Please input an Integer array of size 3 with values between 0 and 255 inclusive");
            }
        } catch (IndexOutOfBoundsException e) {
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
                } else {
                    for (int i = index; i < paletteLength; i++) {
                        if (palette[i] == null) {
                            this.palette[i] = input;
                        }
                    }
                    for (int i = 0; i < paletteLength; i++) {
                        if (palette[i] == null) {
                            this.palette[i] = input;
                        }
                    }
                }
            } else {
                throw new IllegalArgumentException("Please input an Integer array of size 3 with values between 0 and 255 inclusive");
            }
        }catch (IndexOutOfBoundsException e) {
            throw new IndexOutOfBoundsException("\nCannot add any more items to the palette please remove one and try again\n" + e.getMessage());
        }
    }

    public void DelColour(int index){
        /* Delete the colour from the array at a given index */
        try {
            palette[index] = null;
        } catch (IndexOutOfBoundsException e) {
            throw new IndexOutOfBoundsException("\nIndex requested out of range \n" + e.getMessage());
        }
    }


        /* ------------------------- Support functions ------------------------- */
        public boolean CheckRGB(Integer[] RGB){
            try {
                for (int i = 0; i < RGB.length; i++) {
                    if (i > 3 || RGB[i] < 0 || RGB[i] > 255) {
                        return false;
                    }
                }
                return true;
            } catch (IllegalArgumentException e){
                throw new IllegalArgumentException("Please input an Integer array of size 3 with values between 0 and 255" + e.getMessage());
            }
        }
}