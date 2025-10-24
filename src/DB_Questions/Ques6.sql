-- Ques 6: In tables above find the name start with S. Find the name having 'so' in the name for A table

-- Part 1: Find names starting with 'S' (from both tables)
SELECT * FROM Table_A WHERE name LIKE 'S%';
SELECT * FROM Table_B WHERE name LIKE 'S%';

-- Part 2: Find names having "so" in the name for Table A
SELECT * FROM Table_A WHERE name LIKE '%so%';