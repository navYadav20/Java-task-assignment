## Ques8. There is a csv file with 4 columns. First column a value in integer. The length of the value can be either 14, 15, 16. Find the count of record having value as 14.


_Assumption: The file is data.csv and the delimiter is a comma (,)_

- -F ',' sets the field delimiter to a comma.
- '$1' refers to the first column (field).
- 'length($1) == 14' checks if the length of the first column is exactly 14.
- 'END {print count}' executes after all lines are processed, printing the final total.

`awk -F ',' 'length($1) == 14 { count++ } END { print count }' data.csv`