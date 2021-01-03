Задание 13
Внесите изменения в ваш веб проект, например, измените текст на jsp. Затем
выполните откат изменений и проверьте статус выполнения операции.
Решение 13:
git add Task11Branch.jsp
git commit -m "Commit jsp"
git log
скопировал идентификатор коммита
$ git reset --hard fe3b62be33b4758a4ac2251ea585986787c76389
HEAD is now at fe3b62b first commit on master
$ git status
On branch master
Your branch is up to date with 'origin/master'.

nothing to commit, working tree clean