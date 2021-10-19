# CS324 Assignment 1 
# 2021 Part 2
###  Implementing Leader Election Protocol using RMI

#### LCR Algorithm 
Each process sends an identifier (uid) around the ring, when a process receives a uid, it compares with its
own. If greater, it keeps passing to next process, and if less it discards, and if equal, then declares itself as
a leader.

##### Running The Code
- Run the server
- Output :

```` Server Connected ````
- Run Client
- Output :
````>> Server Connected
>> Ring Initialized
>> RingList created with dummy data set
>> Displaying of Nodes
>> Nodes of the circular linked list: 
    >> Node: -1	UID: -1 is the register.
    >> Node: 1	UID: 4
    >> Node: 2	UID: 2
    >> Node: 3	UID: 3
    >> Node: 4	UID: 1

>> Election protocol Starting
>> Leader index: 1	Leader UID: 4
>> NotifyAll !
````

### Team Members
Github link click [here]

| Team |ID | % |
| ------ | ------ | ------ |
| Inoke Nakacia |S11162036| 100% |
| Marineta Wata |S11161571| 100% |
| Avnish Kumar  |S11162880| 100% |
| Ajnesh Prasad |S11161043| 100% |

[here]: <https://github.com/knox95kvt/Data-Structure-and-Algorithms.git>