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
 *  Name:    LineStorage.java
 *
 *  Purpose: LineStorage holds all input lines and provides a public interface to manipulate the lines.
 *
 *  Created: 19 Sep 2002
 *
 *  $Id$
 *
 *  Description:
 *
 * </file>
*/



/*
 * $Log$
*/

import java.util.ArrayList;

/**
 *  LineStorage holds a number of lines and provides a number of public methods
 *  to manipulate the lines. A line is defined as a set of words, and a word consists of a number of
 *  characters. Methods defined by the LineStorage class allow objects of other classes to:
 *  <ul>
 *  <li>set, read and delete a character from a particular word in a particular line
 *  <li>add a new character to a particular word in a particular line
 *  <li>obtain the number of characters in a particular word in a particular line
 *  <li>set, read and delete a word from a particular line
 *  <li>add a new word to a particular line
 *  <li>add an empty word to a particular line
 *  <li>obtain words count in a particular line
 *  <li>set, read and delete a particular line
 *  <li>add a new line
 *  <li>add an empty line
 *  <li>obtain lines count
 *  </ul>
 *  @author  dhelic
 *  @version $Id$
*/

public class LineStorage{

//----------------------------------------------------------------------
/**
 * Fields
 *
 */
//----------------------------------------------------------------------

/**
 * ArrayList holding all lines. Each line itself is represeneted as an
 * Arraylist object holding all words from that line. The ArrayList class is a
 * standard Java Collection class, which  implements the typical buffer
 * functionality, i.e., it keeps its objects in an array of a fix capacity.
 * When the current capacity is exceeded, ArrayList object resizes its array
 * automatically, and copies the elements of the old array into the new one.
 */

  private final ArrayList<Line> lines_ = new ArrayList<>();

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
 * This method sets a new character on the specified index of
 * a particular word in a particular line.
 * @param c new character
 * @param position character index in the word
 * @param word word index in the line
 * @param line line index
 * @see #getChar
 * @see #addChar
 * @see #deleteChar
 */

  public void setChar(char c, int position, int word, int line){
    lines_.get(line).setChar(c, position, word);
  }

//----------------------------------------------------------------------
/**
 * Gets the character from the specified position in the specified word
 * in a particular line.
 * @param position character index in the word
 * @param word word index in the line
 * @param line line index
 * @return char
 * @see #setChar
 * @see #addChar
 * @see #deleteChar
 */

  public char getChar(int position, int word, int line){
    return lines_.get(line).getChar(position, word);
  }

//----------------------------------------------------------------------
/**
 * Adds a character at the end of the specified word in a particular line.
 * @param c new character
 * @param word word index in the line
 * @param line line index
 * @see #setChar
 * @see #getChar
 * @see #deleteChar
 */

  public void addChar(char c, int word, int line){
    lines_.get(line).addChar(c, word);
  }

//----------------------------------------------------------------------
/**
 * Deletes the character from the specified position in the specified word
 * in a particular line.
 * @param position character index in the word
 * @param word word index in the line
 * @param line line index
 * @see #setChar
 * @see #getChar
 * @see #addChar
 */

  public void deleteChar(int position, int word, int line){
    lines_.get(line).deleteChar(position, word);
  }

//----------------------------------------------------------------------
/**
 * Gets the number of characters in this particular word.
 * @param word word index in the line
 * @param line line index
 * @return int
 */

  public int getCharCount(int word, int line){
    return lines_.get(line).getCharCount(word);
  }

//----------------------------------------------------------------------
/**
 * This method sets a new word on the specified index of a particular line.
 * Character array is taken as an argument for the word.
 * @param chars new word
 * @param word word index in the line
 * @param line line index
 * @see #getWord
 * @see #addWord
 * @see #addEmptyWord
 * @see #deleteWord
 */

  public void setWord(char[] chars, int word, int line){
    lines_.get(line).setWord(chars, word);
  }

//----------------------------------------------------------------------
/**
 * This method sets a new word on the specified index of a particular line.
 * String is taken as an argument for the word.
 * @param chars new word
 * @param word word index in the line
 * @param line line index
 * @see #getWord
 * @see #addWord
 * @see #addEmptyWord
 * @see #deleteWord
 */

  public void setWord(String chars, int word, int line){
    lines_.get(line).setWord(chars, word);
  }

//----------------------------------------------------------------------
/**
 * Gets the word from the specified position in a particular line
 * String representing the word is returned.
 * @param word word index in the line
 * @param line line index
 * @return String
 * @see #setWord
 * @see #addWord
 * @see #addEmptyWord
 * @see #deleteWord
 */

  public String getWord(int word, int line){
    return lines_.get(line).getWord(word);
  }

//----------------------------------------------------------------------
/**
 * Adds a word at the end of the specified line.
 * The method takes a character array as an argument.
 * @param chars new word
 * @param line line index
 * @see #addEmptyWord
 * @see #setWord
 * @see #getWord
 * @see #deleteWord
 */

  public void addWord(char[] chars, int line){
    lines_.get(line).addWord(chars);
  }

//----------------------------------------------------------------------
/**
 * Adds a word at the end of the specified line.
 * The method takes a string as an argument.
 * @param chars new word
 * @param line line index
 * @see #addEmptyWord
 * @see #setWord
 * @see #getWord
 * @see #deleteWord
 */

  public void addWord(String chars, int line){
    lines_.get(line).addWord(chars);
  }

//----------------------------------------------------------------------
/**
 * Adds an empty word at the end of the specified line.
 * @param line line index
 * @see #setWord
 * @see #getWord
 * @see #addWord
 * @see #deleteWord
 */

  public void addEmptyWord(int line){
    lines_.get(line).addEmptyWord();
  }

//----------------------------------------------------------------------
/**
 * Deletes the word from the specified position in a particular line.
 * @param word word index in the line
 * @param line line index
 * @see #setWord
 * @see #getWord
 * @see #addWord
 * @see #addEmptyWord
 */

  public void deleteWord(int word, int line){
    lines_.get(line).deleteWord(word);
  }

//----------------------------------------------------------------------
/**
 * Gets the number of words in this particular line.
 * @param line line index
 * @return int
 */

  public int getWordCount(int line) {
    return lines_.get(line).getWordCount();
  }

//----------------------------------------------------------------------
/**
 * This method sets a new line on the specified index.
 * This method takes two dimensional character array as an argument
 * for the line.
 * @param words new line
 * @param line line index
 * @see #getLine
 * @see #getLineAsString
 * @see #addLine
 * @see #addEmptyLine
 * @see #deleteLine
 */

  public void setLine(char[][] words, int line){
    Line curr_line=new Line();
    for (char[] word : words)
      curr_line.addWord(word);
    lines_.set(line, curr_line);
  }

//----------------------------------------------------------------------
/**
 * This method sets a new line on the specified index.
 * This method takes a string array as argument
 * @param words new line
 * @param line line index
 * @see #getLine
 * @see #getLineAsString
 * @see #addLine
 * @see #addEmptyLine
 * @see #deleteLine
 */

  public void setLine(String[] words, int line){
    Line curr_line=new Line();
    for (String word : words)
      curr_line.addWord(word);
    lines_.set(line, curr_line);
  }

//----------------------------------------------------------------------
/**
 * Gets the line from the specified position.
 * String array representing the line is returned.
 * @param line line index
 * @return String[]
 * @see #setLine
 * @see #getLineAsString
 * @see #addLine
 * @see #addEmptyLine
 * @see #deleteLine
 */

  public String[] getLine(int line){
    ArrayList<String> curr_line=lines_.get(line).words_;
    String[] res=new String[curr_line.size()];
    return curr_line.toArray(res);
  }

//----------------------------------------------------------------------
/**
 * Gets the line from the specified position.
 * A single String representing the line is returned.
 * @param line line index
 * @return String
 * @see #setLine
 * @see #getLine
 * @see #addLine
 * @see #addEmptyLine
 * @see #deleteLine
 */

  public String getLineAsString(int line){
    StringBuilder res=new StringBuilder();
    ArrayList<String> curr_line=lines_.get(line).words_;
    for (String word : curr_line){
      res.append(word);
      res.append(' ');
    }
    return res.toString().trim();
  }

//----------------------------------------------------------------------
/**
 * Adds a line at the end of the line array.
 * Two dimensional array is the argument for the new line
 * @param words new line
 * @see #addEmptyLine
 * @see #setLine
 * @see #getLine
 * @see #deleteLine
 */

  public void addLine(char[][] words){
    Line line=new Line();
    for (char[] word : words) {
      line.addWord(word);
    }
  }

//----------------------------------------------------------------------
/**
 * Adds a line at the end of the line array.
 * String array is the argument for the new line
 * @param words new line
 * @see #addEmptyLine
 * @see #setLine
 * @see #getLine
 * @see #deleteLine
 */

  public void addLine(String[] words){
    Line line=new Line();
    for (String word : words){
      line.addWord(word);
    }
    lines_.add(line);
  }

//----------------------------------------------------------------------
/**
 * Adds an empty line at the end of the lines array.
 * @see #setLine
 * @see #getLine
 * @see #getLineAsString
 * @see #addLine
 * @see #deleteLine
 */

  public void addEmptyLine(){
    lines_.add(new Line());
  }

//----------------------------------------------------------------------
/**
 * Deletes the line from the specified position.
 * @param line line index
 * @see #setLine
 * @see #getLine
 * @see #getLineAsString
 * @see #addLine
 * @see #addEmptyLine
 */

  public void deleteLine(int line){
    lines_.remove(line);
  }

//----------------------------------------------------------------------
/**
 * Gets the number of lines.
 * @return int
 */

  public int getLineCount(){
    return lines_.size();
  }

//----------------------------------------------------------------------
/**
 * Inner classes
 *
 */
//----------------------------------------------------------------------
  static class Line {
    private final ArrayList<String> words_;

    public Line() {
      words_ = new ArrayList<>();
    }

    public void setChar(char c, int position, int word){
      char[] curr_word=words_.get(word).toCharArray();
      curr_word[position]=c;
      words_.set(word, String.valueOf(curr_word));
    }

    public char getChar(int position, int word){
      return words_.get(word).toCharArray()[position];
    }

    public void addChar(char c, int word){
      String new_word=words_.get(word)+c;
      words_.set(word,new_word);
    }

    public void deleteChar(int position, int word){
      char[] curr_word=words_.get(word).toCharArray();
      char[] new_word=new char[curr_word.length-1];
      System.arraycopy(curr_word,0,new_word,0,position);
      System.arraycopy(curr_word,position+1,new_word,position,curr_word.length-position-1);
      words_.set(word, String.valueOf(new_word));
    }

    public int getCharCount(int word){
      return words_.get(word).length();
    }

    public void setWord(char[] chars, int word){
      words_.set(word, String.valueOf(chars));
    }

    public void setWord(String chars, int word){
      words_.set(word, chars);
    }

    public String getWord(int word){
      return words_.get(word);
    }

    public void addWord(char[] chars){
      words_.add(String.valueOf(chars));
    }

    public void addWord(String chars){
      words_.add(chars);
    }

    public void addEmptyWord(){
      words_.add("");
    }

    public void deleteWord(int word){
      words_.remove(word);
    }

    public int getWordCount(){
      return words_.size();
    }
  }
}
