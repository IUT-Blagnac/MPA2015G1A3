rem echo off
set SPRINTDIR=%~dp0
set SRCDIR=./src/
set BINDIR=./bin/

set RUNTEST=1

@echo ///////////////////////////////////////////////////////
@echo // COMPILATION de la librairie
@echo ///////////////////////////////////////////////////////
javac -cp .;%BINDIR% -d %BINDIR% %SRCDIR%Models/CSVReader.java
javac -cp .;%BINDIR% -d %BINDIR% %SRCDIR%Models/CSVWriter.java
javac -cp .;%BINDIR%;-d %BINDIR% %SRCDIR%Tests/CSVTests.java
javac -cp .;%BINDIR% -d %BINDIR% %SRCDIR%Models/Participant.java
javac -cp .;%BINDIR% -d %BINDIR% %SRCDIR%Models/Project.java
javac -cp .;%BINDIR% -d %BINDIR% %SRCDIR%Models/Student.java
javac -cp .;%BINDIR% -d %BINDIR% %SRCDIR%Models/Subject.java
javac -cp .;%BINDIR% -d %BINDIR% %SRCDIR%Models/TabModels.java
javac -cp .;%BINDIR% -d %BINDIR% %SRCDIR%Views/LoadWindow.java
javac -cp .;%BINDIR% -d %BINDIR% %SRCDIR%Views/TabAbout.java
javac -cp .;%BINDIR% -d %BINDIR% %SRCDIR%Views/TabGroups.java
javac -cp .;%BINDIR% -d %BINDIR% %SRCDIR%Views/TabParticipants.java
javac -cp .;%BINDIR% -d %BINDIR% %SRCDIR%Views/TabSubjects.java
javac -cp .;%BINDIR% -d %BINDIR% %SRCDIR%Views/MainWindow.java
javac -cp .;%BINDIR% -d %BINDIR% %SRCDIR%Views/AddWindow.java
javac -cp .;%BINDIR% -d %BINDIR% %SRCDIR%Views/ViewWindow.java
javac -cp .;%BINDIR% -d %BINDIR% %SRCDIR%Controler/OPTI.java

@echo ///////////////////////////////////////////////////////
@echo // COMPILATION de l'IHM
@echo ///////////////////////////////////////////////////////
javac -cp .;%BINDIR% -d %BINDIR% %SRCDIR%OPTI.java

@echo ///////////////////////////////////////////////////////
@echo // EXECUTION des tests
@echo ///////////////////////////////////////////////////////
if "%RUNTEST%"=="1" (
 cd %BINDIR%
 java -cp .;../tools/junit.jar OPTIlibTest
 cd %SPRINTDIR%
)