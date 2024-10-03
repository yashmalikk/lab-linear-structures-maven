package edu.grinnell.csc207.util;

import edu.grinnell.csc207.linear.LinkedStack;
import edu.grinnell.csc207.linear.Stack;

/**
 * Assorted utilities for working with strings.
 * 
 * @author Samuel A. Rebelsky
 * @author Your Name Here
 */ 
public class StringUtils {
  // +------------------+--------------------------------------------
  // | Provided methods |
  // +------------------+
    
  private static boolean parensMatch(Character a, Character b) { 
    if(a.equals('(') && b.equals(')')) return true;
    if(a.equals('{') && b.equals('}')) return true;
    if(a.equals('[') && b.equals(']')) return true;
    return false;
  }

  /**
   * Determine whether the parens match in string.
   */
  public static boolean checkMatching(String str) {
    Stack<Character> parens = new LinkedStack<Character>();
    for(int i = 0; i < str.length(); ++i) { 
      char c = str.charAt(i);
      if("{([".indexOf(c) != -1) { 
        try {
          parens.put(c);
        } catch(Exception e) { 

        }
      } else if("])}".indexOf(c) != -1) { 
        try {
          if(!parensMatch(parens.get(), c)) { 
            return false;
          }
        } catch (Exception e) {
          return false;
        }
      }
    }
    return parens.isEmpty();
  } // checkMatching
} // class StringUtils    

