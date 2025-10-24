-- Question 8:
-- Find the count of records with name as Amitabh in both the tables.
-- -------------------------------------------------------------------
-- ASSUMPTION: This question refers to finding the count in any of the
-- tables created so far (A, B, C, D). Based on Q7, 'Amitabh'
-- is in Table_C.


-- Count from Table C (where it exists)
SELECT COUNT(*) AS amitabh_count_C FROM Table_C WHERE name = 'Amitabh';

-- Count from Table D
SELECT COUNT(*) AS amitabh_count_D FROM Table_D WHERE name = 'Amitabh';