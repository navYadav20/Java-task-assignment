## Ques10. Find the pid of the process which is using TCP port number 10345.

- -l : listening ports
- -t : tcp ports
- -p : show process ID (pid)

`netstat -ltnp | grep '10345'`