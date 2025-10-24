### Ques6. You have a file with comma separated values, List the third column only from the file into a new file. Now assume the third column is an integer value. Find the unique occurrence of this integer value in the file along with the count.

- cut: Get the 3rd column
- sort: Sort the numbers
- uniq -c: Count unique occurrences
- sort -nr: Sort the results to show highest count first

`cut -d ',' -f 3 data.csv | sort -n | uniq -c | sort -nr`