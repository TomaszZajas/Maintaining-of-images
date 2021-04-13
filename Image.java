

import java.util.Arrays;
public class Image {

    private int[][] pixels;

    private int width;
    
    private int height;

    public Image(int[][] pixels){
        this.pixels = pixels;
        
        this.height = pixels.length;
        
        this.width = pixels[0].length;
    }


    public String toString(){
        String print = "";
        //cycles through each row and each column printing out individual values
        //and going down a line after the end of each row
        for(int row = 0; row < pixels.length; row++){
            
            for(int col = 0; col < pixels[0].length; col++){
                print += pixels[row][col] + " ";
                
            }
            
            print = print + "\n";
        }
        
        return print;
    }
    
    
    public void flip(boolean horizontal){
        int[] temp1; //temporary array where a row is stored
        
        int temp2;
        
        int wide = this.width; //width of array stored in seperate variable
        
        if(horizontal == true){
            //cycles through each row swapping it with the opposite row
            for(int row = 0; row < (this.height/2); row++) {
                temp1 = this.pixels[row]; 

                this.pixels[row] = this.pixels[this.height-1-row];//lets the first row equal the last row and then the 2nd row the 2nd last row etc.

                this.pixels[this.height-row-1] = temp1;//lets the last row equal the temporary array which contains the values of the first row
            }
            
        }else{
            //cycles through each individial value in the array
            for(int row = 0; row < this.height; row++){
                
                for(int col = 0; col < this.width/2; col++){
                    temp2 = this.pixels[row][col];//swaps each values individualy moving row by row

                    this.pixels[row][col] = this.pixels[row][wide-1]; //the wide value allows cycling through the values in each row

                    this.pixels[row][wide-1] = temp2;

                    wide--;
                }
                
                wide = this.width; //the variable is reset so it can repeat the process in the next row

            }
            
        }
    }

    public void rotate(boolean clockwise){
        
        int temp = this.width-1; //temporary variable for the width of the array
        
        int[][] rotatedArray = new int[this.width][this.height]; //new array that swaps the width and height of the original array
        
        if(clockwise == true){
            //cycles through every value in the original array and places its rotated position in the new array
            for(int row=0; row<this.width; row++){
                
                for(int col=0; col<this.height; col++){
                    rotatedArray[row][col] = this.pixels[this.height-1-col][row];
                }

            }
            
        }else if(clockwise == false){
            //cycles through every values in the original array
            //I used a temporary variable for the width of the original array which resets after every row
            //this allowed me to rotate the array 90 degrees anticlockwise      
            for(int row=0; row<this.width; row++){
                
                for(int col=0; col<this.height; col++){
                    rotatedArray[row][col] = this.pixels[col][temp];
                }
                temp--;
            }
            
        }

        this.pixels = rotatedArray; //lets the original array equal the new array
    }
}

        

                
        
        
        

    
    
    
    
