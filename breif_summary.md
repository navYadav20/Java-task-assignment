# Brief Summary & Assignment Notes

**Submitted by:** Navneet Yadav

This document provides a summary of the challenges, assumptions, and time log for the Goldilocks technical assignment.

---

### Queries & Challenges Faced and Resolutions

As per the assignment instructions I've noted any unclear points stated my assumptions and then solved the problem.

* **Java Q3 (Database Connection):** The prompt provided a table name (`test`) but not a database name (schema).
    * **Assumption:** I created a new database named `goldilocks_db` to hold the `test` table. This is noted in the `Ques3.java` code.

* **Java Q4 (HTTP Client):** The URL `http://127.0.0.1:8999/test` pointed to a local server that was not running.
    * **Assumption:** I assumed this client was intended to be tested against the server from Q6.
    * **Resolution:** I built the `Ques4` client to handle the "Connection refused" error gracefully. I also added a test call to a public API (`api.ipify.org`) to prove the client code works correctly.

* **Java Q6 (HTTP Server):** This question required combining Q3 (DB read) and Q4 (HTTP).
    * **Assumption:** I built the server to listen on the specific port `8999` and the path `/test` to successfully answer the client from Q4.

* **DB Q2c ("records not in A and not in B"):** This was ambiguous.
    * **Assumption:** I interpreted this as finding the "symmetric difference"—records that are in *either* A or B, but *not* in both. The query reflects this.

* **Linux Q7 (JSON to CSV):** The "simple structure" was not defined.
    * **Assumption:** I assumed this meant a flat JSON object per line (e.g., `{"id": 1, "name": "Alice"}`). I provided a robust solution using `jq` and a simpler, less-reliable one using `sed`.

---

### Time Log

As requested, here is the estimated time taken per section.

* **Java Questions (Total: ~X hours)**
    * **Q1 (Decimal to Binary):** [~15 minutes]
    * **Q2 (CSV Sum):** [~30 minutes]
    * **Q3 (DB Read):** [ 1hrs (Includes DB setup & driver config)]
    * **Q4 (HTTP Client):** [ 1 hrs]
    * **Q5 (HashMap):** [~15 minutes]
    * **Q6 (HTTP Server):** [~50 minutes (Includes integrating DB logic)]
    * **Q7 (Command Line):** [~10 minutes (Includes IntelliJ config)]
    * **Q9 (HTML Login):** [35-40 minutes]
    * **Q10 (CSV Occurrences):** [30-35 minutes]
* **DB Questions (Total: ~X minutes)**
    * [  1 hrs.for all SQL queries and written answers]
* **Linux Questions (Total: ~X minutes)**
    * [ 40-50 minutes for all command-line answers]
* **Testing Questions (Total: ~X minutes)**
    * [1-1.5 hrs to write all test case scenarios]
