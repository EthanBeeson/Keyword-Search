# Keyword-Search

## Description
The Keyword-search / Scrabble Solver is a Java program designed to help users find valid English words 
from a given set of letters, typically for Scrabble or other word games. 
It uses a dictionary text file containing valid English words to compare against the user's input, 
returning all possible word matches based on the available letters.

## Technologies Used

This project leverages several core Java libraries and techniques to implement a word-finding solution efficiently:

### 1. **`java.io.BufferedReader` and `java.io.FileReader`**
   - These classes are used for reading the dictionary file containing the list of valid English words. 
   - `BufferedReader` is particularly useful here because it allows the program to read the file line by line,
     which is memory-efficient for handling large files like a dictionary.

### 2. **`java.util.HashMap` and `java.util.Map`**
   - Utilization of the Hashmap data structure to store and count occurences of  character in both the user-inputted
     letters and the words from the dictionary. This allows the program to compare
     whether the available letters can form valid words.

### 3. Control Structures for Word Validation
   - A combination of loops (for and while) and conditional checks (if) is used to iterate over the dictionary words and
     compare their letter composition to the user’s letters. This ensures only valid words are printed out.

