## Ques2. Write the command to find out a particular pattern in a file.

 _Usage: grep [pattern] [filename]_


Example 1: Find the word "error", ignoring case - 

`grep -i "error" application.log`

Example 2: Show the line number where the pattern matches - 

`grep -n "error" application.log`