// -*- Java -*-
/*
 * <copyright>
 * 
 *  Copyright (c) 2002
 *  Institute for Information Processing and Computer Supported New Media (IICM),
 *  Graz University of Technology, Austria.
 * 
 * </copyright>
 * 
 * <file>
 * 
 *  Name:    Alphabetizer.java
 * 
 *  Purpose: Sorts circular shifts alphabetically
 * 
 *  Created: 23 Sep 2002 
 * 
 *  $Id$
 * 
 *  Description:
 *    Sorts circular shifts alphabetically
 * </file>
*/



/*
 * $Log$
*/

/**
 *  An object of the Alphabetizer class sorts all lines, that it gets
 *  from CircularShifter. Methods to access sorted lines are provided.
 *  @author  dhelic
 *  @version $Id$
*/

public class Alphabetizer{

//----------------------------------------------------------------------
/**
 * Fields
 *
 */
//----------------------------------------------------------------------

/**
 * Array holding sorted indices of lines
 *
 */

  private int sorted_[];

/**
 * CircularShifter that provides lines
 *
 */

  private CircularShifter shifter_;

//----------------------------------------------------------------------
/**
 * Constructors
 *
 */
//----------------------------------------------------------------------

//----------------------------------------------------------------------
/**
 * Methods
 *
 */
//----------------------------------------------------------------------

//----------------------------------------------------------------------
/**
 * Sorts all lines from the shifter.
 * @param shifter the source of lines
 */

  public void alpha(CircularShifter shifter){

    shifter_=shifter;

    sorted_=new int[shifter_.getLineCount()];

    for (int i=0;i<sorted_.length;i++){
      sorted_[i]=i;
    }// create the heap

    for (int i=sorted_.length/2-1;i>=0;i--)
      shiftDown(i,sorted_.length);
    // rebuild the heap

    for (int i=sorted_.length-1;i>0;i--){
      int tmp=sorted_[i];
      sorted_[i]=sorted_[0];
      sorted_[0]=tmp;
      shiftDown(0, i);
    }
  }

//----------------------------------------------------------------------
/**
 * This method builds and reconstucts the heap for the heap sort algorithm.
 * @param root heap root
 * @param bottom heap bottom
 */

  private void shiftDown(int root, int bottom){
    int l=2*root+1, r=2*root+2;
    int largest=root;
    if (l<bottom&&shifter_.getLineAsString(sorted_[l]).compareTo(shifter_.getLineAsString(sorted_[largest]))>0)
      largest=l;
    if (r<bottom&&shifter_.getLineAsString(sorted_[r]).compareTo(shifter_.getLineAsString(sorted_[largest]))>0)
      largest=r;
    if (largest!=root){
      int tmp=sorted_[largest];
      sorted_[largest]=sorted_[root];
      sorted_[root]=tmp;
      shiftDown(largest,bottom);
    }
  }

//----------------------------------------------------------------------
/**
 * Gets the line from the specified position.
 * String array representing the line is returned.
 * @param line line index
 * @return String[]
 * @see #getLineAsString
 */

  public String[] getLine(int line){
    return shifter_.getLine(sorted_[line]);
  }

//----------------------------------------------------------------------
/**
 * Gets the line from the specified position.
 * String representing the line is returned.
 * @param line line index
 * @return String[]
 * @see #getLine
 */

  public String getLineAsString(int line){
    return shifter_.getLineAsString(sorted_[line]);
  }

//----------------------------------------------------------------------
/**
 * Gets the number of lines.
 * @return int
 */

  public int getLineCount(){
    return shifter_.getLineCount();
  }

//----------------------------------------------------------------------
/**
 * Inner classes
 *
 */
//----------------------------------------------------------------------

}
