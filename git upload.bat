git add -A --all
echo Indtast commit besked
set /p message=
git commit -m "%message%"
git push origin master
echo %message%
pause
