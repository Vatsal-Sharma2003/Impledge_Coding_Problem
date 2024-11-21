# Word Composition Problem:

Write a program that: 
1. Reads provided files (Input_01.txt and Input_02.txt) containing alphabetically sorted words list (one 
word per line, no spaces, all lower case)  
2. Identifies & display below given data in logs/console/output file   
o Longest compounded word   
o Second longest compounded word  
o Time taken to process the input file   

Note: A compounded word is one that can be constructed by combining (concatenating) shorter words 
also found in the same file

## Steps to Execute:

1. Compile the Program:

Open a terminal or IDE and compile the CompoundWordFinder.java file using the command:.

```java
javac CompoundWordFinder.java
```
2. Run the Program:

Execute the compiled file with:
```java
java CompoundWordFinder
```

3. Input Files:

Place input files (Input_01.txt, Input_02.txt, etc.) in the same directory as the program or adjust file paths in the code.  
Ensure each file contains a list of words (one word per line, all lowercase, and alphabetically sorted).
## Sample Output

1. For Input_01.txt:

```java
Processing Input_01.txt...
--------------------------------------------------------------
Longest Compound Word: ratcatdogcat
Second Longest Compound Word: catsdogcats
Time taken to process file Input_01.txt: 5 milliseconds
--------------------------------------------------------------
```

2. For Input_02.txt:

```java
Processing Input_02.txt...
--------------------------------------------------------------
Longest Compound Word: ethylenediaminetetraacetates
Second Longest Compound Word: electroencephalographically
Time taken to process file Input_02.txt: 8000 milliseconds
--------------------------------------------------------------

```
3. For Input_03.txt...

```java
Processing Input_03.txt...
--------------------------------------------------------------
Longest Compound Word: impledgevatshar
Second Longest Compound Word: sharmavatsedge
Time taken to process file Input_03.txt: 1 Milliseconds
--------------------------------------------------------------
```

## Overview

The program processes a list of words to determine the longest and second-longest compounded words. A compounded word is formed by concatenating two or more shorter words from the same list. The program:

1. Reads and parses input files line by line.  
2. Uses efficient data structures (HashSet and HashMap) for fast lookups and memorization.                                                                    
3. Sorts the words by length to process smaller words first, ensuring that they are available to form longer compounded words.   
4. Outputs the results and the processing time for each input file.

## Design

1. HashSet: Fast O(1) lookup for checking word existence.   
2. HashMap: Memoization to avoid redundant checks for repeated words.  
3. Process words by length, ensuring smaller words are used to form larger ones.  
4. Split words into prefixes and suffixes to check validity.

## Approach

1. Word Validation: Recursively check if a word can be made from smaller words in the dictionary.  
2. Sorting: Words are processed by increasing length.  
3. Memoization: Avoid redundant calculations.  
4. Execution Time: Measure time using System.currentTimeMillis().  

## References for finding some methods and functionalities used are

1. GeeksforGeeks
2. Javatpoint
