# PRACTICAL WORK REPORT: Advanced Java (Threads & Sockets)

**Student:** BADR EDDINE TOUBANI
**Teacher:** Prof. Loubna Aminou
**Module:** Object-Oriented Programming (Java)
**Academic Year:** 2025/2026

---

## 1. Introduction
This practical work focuses on two advanced pillars of Java programming:

1. **Concurrency (Multithreading):** Understanding how to manage multiple threads accessing shared resources simultaneously, identifying race conditions, and solving them using synchronization.
2. **Network Programming (Sockets):** Implementing communication between machines using both the reliable TCP protocol (Client-Server architecture) and the fast, connectionless UDP protocol.

---

## 2. Part I: Multithreading & Synchronization

### Scenario 1: Bank Account Withdrawal (The Race Condition)

#### Problem Description
We simulated a bank account with a balance of **500**. Two clients (threads) try to withdraw money simultaneously: Client 1 wants **450**, and Client 2 wants **100**. Mathematically, 500 - 450 = 50, so the second withdrawal of 100 should fail. Without synchronization, both transactions may succeed, leaving the bank with a negative balance.

#### Technical Analysis
This error occurs due to a **"Check-Then-Act" Race Condition**. The withdrawal operation involves three non-atomic steps:
1. Read: Get current balance.
2. Check: Is `balance >= amount`?
3. Write: Set `balance = balance - amount`.

Without synchronization, Thread A can read the balance and be paused, allowing Thread B to read the same old balance and both pass the check.

#### Solution Implementation
To fix this, the `withdraw` method is `synchronized`, creating a monitor lock on the `BankAccount` object so only one thread can access it at a time.

**Execution Output (example):**
```
Client 1 attempts to withdraw 450
Client 1 completed withdrawal. Remaining balance: 50
Client 2 attempts to withdraw 100
Client 2 insufficient funds. Current balance: 50
```


### Scenario 2: Bus Seat Booking (Shared Resources)

#### Problem Description
A bus has **3 seats**. Two users try to book **2 seats** each simultaneously. Total demand (4) > Supply (3). Without protection, the system might overbook.

#### Solution Implementation
The `bookSeats()` method is `synchronized` to protect the `availableSeats` variable. The first thread to access the method books seats; the second sees the updated value and fails to book properly.

---

## 3. Part II: Socket Programming

### Magic Number Game (TCP Sockets)

#### Architecture: Client-Server
We used TCP because it guarantees ordered, reliable delivery—important for game logic. The server listens on port 9999 and spawns a `PlayerHandler` thread for each new connection. The `MAGIC_NUMBER` is shared among all players.


### Chat Application (UDP Sockets)

#### Protocol: UDP
The chat uses UDP (connectionless, fast, no delivery guarantees). The `UDPSender` sends `DatagramPacket`s to `UDPReceiver` on port 1234. The receiver prints messages as they come.

---

## 4. How to compile & run (examples)

1. Compile all sources (from project root):

```bash
javac -d TP4/bin TP4/src/**/**/*.java
```

(If your shell doesn't expand `**`, compile per package or use an IDE.)

2. Run thread demos:

```bash
java -cp TP4/bin threads.scenario1.BankTest
java -cp TP4/bin threads.scenario2.BusTest
```

3. Run server and clients for game:

```bash
# In one terminal:
java -cp TP4/bin sockets.game.GameServer

# In other terminal(s):
java -cp TP4/bin sockets.game.GameClient
```

4. Run UDP chat (receiver first):

```bash
# Receiver (listens on port 1234):
java -cp TP4/bin sockets.udp.UDPReceiver

# Sender:
java -cp TP4/bin sockets.udp.UDPSender
```

---

## 5. Conclusion
This TP demonstrates thread safety with `synchronized`, how to spot race conditions, and basic TCP/UDP socket programming in Java.

---

If you want, I can compile the TP4 sources and run a quick smoke test for you. ✅
