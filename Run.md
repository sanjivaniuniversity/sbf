# How to Run the Java Programs

I added the instructions in `Run.md` because there is no `code.md` file in this project.

## Requirements

- Java JDK installed
- `java` and `javac` available in terminal

Verified in this workspace:

- `java 24.0.2`
- `javac 24.0.2`

## Project Files

This folder contains 4 separate Java programs:

- `HospitalManagementSystem.java`
- `InventoryManagementSystem.java`
- `ElectricityBillSystem.java`
- `VotingSystem.java`

Each file has its own `main()` method, so you run them one at a time.

## Compile All Programs

Open terminal in this folder and run:

```powershell
javac HospitalManagementSystem.java InventoryManagementSystem.java ElectricityBillSystem.java VotingSystem.java
```

## Run Any One Program

### 1. Hospital Management System

```powershell
java HospitalManagementSystem
```

### 2. Inventory Management System

```powershell
java InventoryManagementSystem
```

### 3. Electricity Bill System

```powershell
java ElectricityBillSystem
```

### 4. Voting System

```powershell
java VotingSystem
```

## Compile and Run Only One File

If you want to work with just one program, use:

```powershell
javac VotingSystem.java
java VotingSystem
```

You can replace `VotingSystem` with any of these class names:

- `HospitalManagementSystem`
- `InventoryManagementSystem`
- `ElectricityBillSystem`
- `VotingSystem`

## How the Programs Work

- After running, a menu appears in the terminal.
- Enter the number of the option you want.
- Follow the prompts to add data, search, update, or display records.
- Use the Exit option to close the program.

## Example

For Voting System:

```text
1. Register Voter
2. Cast Vote
3. Display Results
4. Declare Winner
5. Exit
```

## If `java` or `javac` Is Not Recognized

Install the JDK and then check:

```powershell
java -version
javac -version
```

If those commands work, the project should run correctly.
