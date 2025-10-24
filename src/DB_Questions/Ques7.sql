-- Question 7:There are 2 table C and D (with 2 columns id and name). In table C name has the first name and name in Table D is last name.  Make a table with id, full name (first name space second name)
---------------------------------
-- This query selects the id and a new "full_name" column by
-- joining C and D on their id and concatenating the names.
-- CONCAT_WS (Concat With Separator) adds the space ' ' between them.
SELECT
    C.id,
    CONCAT_WS(' ', C.name, D.name) AS full_name
FROM
    Table_C AS C
JOIN
    Table_D AS D ON C.id = D.id;