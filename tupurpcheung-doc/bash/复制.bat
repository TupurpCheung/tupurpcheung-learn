@echo off
set xcopyPath="c:\windows\system32"
set path=%xcopyPath%;%path%
xcopy .\config\* ..\webapps\ /s/e/y
::pause
exit