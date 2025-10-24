## Ques3. Write the command to find out a particular pattern in all files which is present in multiple directories (hint: recursive)


##### _Usage: grep -r [pattern] [directory_path]_

Example 1: Find "database_connection_failed" in all files inside - 

`grep -r "database_connection_failed" /var/log`

Example 2: Same search, but ignore case (-i) and show line numbers (-n)

`grep -rin "database_connection_failed" /var/log`