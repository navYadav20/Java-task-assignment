-- Ques2. There are 2 tables A and B (with 3 columns id, name, and date. Do the following.
    -- a. Find the union of A and B
    -- b. Find records which are present in A and not in B.
    -- c. Find records which are not in A and not in B.
    -- d. Find the count of records having same value of name more than 2 times in table A

-- 2-a. Find the union of A and B
SELECT id, name, `date` FROM Table_A
UNION SELECT id, name, `date` FROM Table_B;


-- 2-b. Find records which are present in A and not in B.
SELECT A.*
FROM Table_A AS A
LEFT JOIN Table_B AS B ON A.id = B.id
WHERE B.id IS NULL;


-- 2-c. Find records which are not in A and not in B.
--
-- ASSUMPTION: This question is interpreted as "Find the symmetric difference",
-- meaning records that are in EITHER A OR B, but not in both.
-- The literal interpretation of "records not in A and not in B" would
-- refer to an external set of data, which is not provided.

-- This query first finds records in A but not B, then finds records in B but not A,
-- and combines them with UNION ALL.
SELECT A.* FROM Table_A AS A
 LEFT JOIN Table_B AS B ON A.id = B.id WHERE B.id IS NULL
UNION ALL
SELECT B.* FROM Table_B AS B
 LEFT JOIN Table_A AS A ON B.id = A.id WHERE A.id IS NULL;


-- 2-d. Find the count of records having same value of name more than 2 times in table A
-- group by 'name' and use the HAVING clause to filter groups
SELECT
    name,
    COUNT(id) AS name_count
FROM
    Table_A
GROUP BY
    name
HAVING
    name_count > 2;