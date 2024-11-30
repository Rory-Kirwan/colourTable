package org.example;

public class colourTable {
    //define some basic variables
    int[][] palette;
    int currIndex;      //Used for keeping track of where the next index is in the array
    int paletteLength;

    public colourTable(int paletteLength) {
        //Write a check to make sure that the palette size is within the proper range
        //Any power of two when bitwise ANDed with itself minus 1 will be 0000...
        if ((paletteLength > 1) && (paletteLength & (paletteLength - 1)) == 0) {
            //Use a multidimensional array for the palette as it allows for each colour (represented by row) to be a combination of 3 RGB values
            this.palette = new int[paletteLength][3];
            //Index for the palette for adding and removing rows effectively
            this.currIndex = 0;
            this.paletteLength = paletteLength;
        } else {
            throw new IllegalArgumentException("\nPlease make sure the inputted length for palette is a power of two that is greater than 1 \n");
        }
    }
}