
## Ques1. List down 10 commands of Linux

1. `ls`  Lists the files and directories in the current directory.
    Example: ls -l (long format) or ls -a (show hidden files).

2. `cd ` Changes the current working directory.
   Example: cd /var/log (absolute path) or cd ../ (go up one level).

3. `pwd ` Displays the full path of the current directory.
    Example:  pwd

4. `cat` Used to display the entire content of a file to the screen.
   Example: cat filename.txt

5.  `grep` Searches for a specific pattern (text or regular expression) within files.
     Example: grep "error" server.log

6. `tail` Displays the last part (default is 10 lines) of a file. Very useful for watching logs.
     Example: tail -f server.log 

7. `head` Displays the first part (default is 10 lines) of a file.
     Example: head filename.csv

8. `ps ` Shows a snapshot of the currently running processes.
    Example: ps -ef (show all processes, full format).

9. `chmod ` Changes the read, write, and execute permissions of a file or directory.
      Example: chmod +x script.sh 

10. `find` A powerful command to search for files and directories based on criteria like name, size, type, etc.
     Example: find / -name "filename.txt" (search the whole system for a file).