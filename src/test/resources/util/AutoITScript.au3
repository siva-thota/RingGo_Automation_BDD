WinWaitActive("","Chrome Legacy Window","120")
If WinExists("","Chrome Legacy Window") Then
Send("myRingGoTest{TAB}")
Send("W4t3Rf4lls{ENTER}")
EndIf
