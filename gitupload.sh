git add -A --all
echo "Indtast commit besked"
read message
git commit -m $message
git push origin master
pause

