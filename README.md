# Client-Server
CS-364 (Programming Languages) Final Project

1. A client initially contacts the server and sends it a “getWisdom” request.

2. The server responds asking the client to produce a factor of the product of two or more
large prime numbers. In this case 1689550229929.

3. The client, too lazy to look for a real factor, just guesses one factor hoping that the
server isn’t really going to check.

4. The server responds, that the provided integer is not a factor. This is easy for the Server
to check, all it has to do is check if the original number is divisible buy the proposed
factor.

5. The client actually does the work and sees that one factor is 1299827 and sends that as
a string to the server.

6. The server easily verifies that this is correct and sends the message “correct” to the
client.

7. The server then sends the wisdom Outside of a dog … to the client.

8. The transaction is complete and the server is ready to service a new getWisdom
request.
