
## This file contains the test case scenarios for each of the Java programming questions Q1-Q7 & Q9-Q10 as required by the assignment.

### Ques1.java (Decimal to Binary)

**Test Case 1: Standard Valid Input**
* **Input:** "123"
* **Expected Output:** "1111011"
* **Result:** Pass

**Test Case 2: Edge Case - Zero**
* **Input:** "0"
* **Expected Output:** "0"
* **Result:** Pass

**Test Case 3: Error Case - Non-Numeric Input**
* **Input:** "abc"
* **Expected Output:** "Error: Input is not a valid decimal number."
* **Result:** Pass

**Test Case 4: Error Case - Empty Input**
* **Input:** "" (empty string)
* **Expected Output:** "Error: Input cannot be null or empty."
* **Result:** Pass

**Test Case 5: Error Case - Null Input**
* **Input:** null
* **Expected Output:** "Error: Input cannot be null or empty."
* **Result:** Pass

**Test Case 6: Error Case - Negative Number**
* **Input:** "-10"
* **Expected Output:** "Error: Input must be a non-negative number."
* **Result:** Pass

### Test Cases for Ques2.java (CSV Read, Write, and Sum)

**Test Case 1: Valid File**
* **Input:** input.csv contains 10,20,30
* **Expected Output:** output.csv contains 10,20,30,60.0
* **Result:** Pass

**Test Case 2: Error Case - File Not Found**
* **Input:** input.csv does not exist.
* **Expected Output:** Console prints "CRITICAL: File not found..."
* **Result:** Pass (Error handled correctly)

**Test Case 3: Data - Non-Numeric Value**

* **Input:** input.csv contains 5,5,five
* **Expected Output:** output.csv contains 5,5,five,Error:Contains_Non-Numeric_Data
* **Result:** Pass (Row-level error handled)

**Test Case 4: Data - Malformed Line**

* Input: input.csv contains 10,20
*  Output: output.csv contains 10,20,Error:Malformed line...
* Result: Pass (Row-level error handled)

### Test Cases for Ques3.java (Read from DB)

**Test Case 1: Successful Connection and Read**

* Input: Run program with correct DB credentials and running server.
* Expected Output: Console prints "Connection successful!" and the list of employees.
* Result: Pass

**Test Case 2: Error Case - DB Server Down**

* Input: Run program with MySQL server stopped.
* Expected Output: Console prints "CRITICAL: Database connection failed: Connection refused".
* Result: Pass (Error handled correctly)

**Test Case 3: Error Case - Wrong Credentials**

* Input: Run program with PASSWORD = "wrong_password"
* Expected Output: Console prints "CRITICAL: Database connection failed: Access denied...".
* Result: Pass (Error handled correctly)

**Test Case 4: Error Case - Table Not Found**

* Input: Run program with query SELECT * FROM wrong_table
* Expected Output: Console prints "CRITICAL: Failed to retrieve data: Table '...wrong_table' doesn't exist".
* Result: Pass (Error handled correctly)

**Test Case 5: Data - Empty Table**

* Input: Run program after TRUNCATE TABLE test;

* Expected Output: Console prints "Connection successful!" and "No records found."

* Result: Pass

Test Cases for Ques4.java (HTTP Client)

Test Case 1: Server Running (Test with Q6)

Input: Run Ques6.java (server), then run Ques4.java (client).

Expected Output: Console prints "Status Code: 200" for the 127.0.0.1 URL.

Result: Pass

Test Case 2: Error Case - Server Not Running

Input: Run Ques4.java without Ques6.java running.

Expected Output: Console prints "CRITICAL ERROR: Connection refused" for the 127.0.0.1 URL.

Result: Pass (Error handled correctly)

Test Cases for Ques5.java (HashMap Store and Search)

Test Case 1: Find Existing Key

Input: "Ram"

Expected Output: "SUCCESS: Found! Ram is 36 years old."

Result: Pass

Test Case 2: Key Not Found

Input: "David"

Expected Output: "NOT FOUND: No entry exists for 'David'."

Result: Pass

Test Case 3: Case-Sensitive Search

Input: "ram" (lowercase)

Expected Output: "NOT FOUND: No entry exists for 'ram'. Note: Search is case-sensitive."

Result: Pass

Test Case 4: Error Case - Empty Input

Input: "" (empty string)

Expected Output: "SEARCH FAILED: Name cannot be null or empty."

Result: Pass (Error handled correctly)

Test Cases for Ques6.java (HTTP Server + DB)

Test Case 1: Valid Request

Input: Visit http://127.0.0.1:8999/test?value=p in a browser.

Expected Output: Browser shows 200 OK and the employee data.

Result: Pass

Test Case 2: Invalid Path

Input: Visit http://127.0.0.1:8999/wrongpath

Expected Output: Browser shows "404 Not Found".

Result: Pass (Error handled correctly)

Test Case 3: Integrated Error - DB Server Down

Input: Stop MySQL server, then visit http://127.0.0.1:8999/test?value=p

Expected Output: Browser shows "500 Internal Server Error".

Result: Pass (Error handled correctly)


### Test Cases for Ques9.html (HTML Login Page)

**Test Case 1: Valid Credentials**

* Input: Username: admin, Password: password123

* Expected Output: Green message: "Success! You are authenticated."

* Result: Pass

* Test Case 2: Invalid Username

* Input: Username: wronguser, Password: password123

* Expected Output: Red message: "Failure! Invalid username or password."

* Result: Pass

* Test Case 3: Invalid Password

* Input: Username: admin, Password: wrongpass

* Expected Output: Red message: "Failure! Invalid username or password."

* Result: Pass

* Test Case 4: Empty Username

* Input: Username: ``, Password: password123

* Expected Output: Red message: "Failure! Both fields are required."

* Result: Pass (Validation handled correctly)

### Test Cases for Ques10.java (Find Multiple Occurrences in CSV)

* Test Case 1: Valid File with Duplicates

* Input: input_q10.csv (with 3 'pending', 2 'completed')

* Expected Output: Console prints "Value: 'pending' has 3 occurrences." and "Value: 'completed' has 2 occurrences."

* Result: Pass

**Test Case 2: File with No Duplicates**

* Input: A file where all values in col3 are unique.

* Expected Output: The "Multiple Occurrences" section of the report is empty.

* Result: Pass

**Test Case 3: Error Case - File Not Found**

* Input: Run program with input_q10.csv file missing.

* Expected Output: Console prints "CRITICAL: File not found..."

* Result: Pass (Error handled correctly)

**Test Case 4: Data - Malformed Line**

* Input: input_q10.csv contains a line with only two columns.

* Expected Output: Console logs "[SKIPPING] Malformed line..." and continues.

* Result: Pass (Row-level error handled)