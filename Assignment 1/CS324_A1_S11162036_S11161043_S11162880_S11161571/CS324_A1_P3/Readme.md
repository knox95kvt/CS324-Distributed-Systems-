# CS324 Assignment 1
# 2021 Part 3
###  Implementing Leader Election Protocol with Peer Register using RMI

#### LCR Algorithm
Each process sends an identifier (uid) around the ring, when a process receives a uid, it compares with its
own. If greater, it keeps passing to next process, and if less it discards, and if equal, then declares itself as
a leader.

##### Running The Code
- Run the server
- Output :

````
 CS324 Assignment 1 : Part 3 
 Implementing Leader Election Protocol with Peer Register
 using RMI system is ready
  ````
- Run Client
- Output :
````
>> Connected to server
>> Ring Initialized 
>> RingList created with dummy data set
>> Nodes Displayed 
>> Nodes of the circular linked list: 
>> Node: -1	UID: -1 is the register.
>> Node: 1	UID: 2
>> Node: 3	UID: 1
>> Node: 4	UID: 3


1	:	Append a node to the list
2	:	Display Nodes
3	:	Insert a node in between
4	:	Start the Election
````
### Team Members
- Github link click [here]
  
| Team |ID | % |
| ------ | ------ | ------ |
| Inoke Nakacia |S11162036| 100% |
| Marineta Wata |S11161571| 100% |
| Avnish Kumar  |S11162880| 100% |
| Ajnesh Prasad |S11161043| 100% |

[here]: <https://github.com/knox95kvt/Data-Structure-and-Algorithms.git>