Задание 11
Скопируйте веб-проект в хранилище, созданное ранее. Затем скачайте (checkout)
изменения в отдельный каталог. Попробуйте изменить что-либо в вашем проекте
ипосмотрите на статус папок в проводнике Windows.
Решение:
1)$ git status
On branch master
Untracked files:
  (use "git add <file>..." to include in what will be committed)
        Task11Branch.txt

2)$ git add Task11Branch.txt

3)$ git commit -m "commit MasterBranch"
[master 4c2391a] commit MasterBranch
 1 file changed, 1 insertion(+)
 create mode 100644 Task11Branch.txt
4)$ git branch BestBranch

5)$ git branch
  BestBranch
* master

6)$ vim Task11Branch.txt

7)$ cat Task11Branch.txt
hello bestbranch

8)$ git status
On branch BestBranch
Changes not staged for commit:
  (use "git add/rm <file>..." to update what will be committed)
  (use "git restore <file>..." to discard changes in working directory)
        deleted:    Task11.txt
        modified:   Task11Branch.txt

no changes added to commit (use "git add" and/or "git commit -a")

9)$ git add Task11Branch.txt

10)$ git commit -m "Best branch commit"
[BestBranch ca4dbbc] Best branch commit
 1 file changed, 1 insertion(+), 1 deletion(-)
11)$ vim Task11Branch.txt

12)$ cat Task11Branch.txt
Master Branch Neww!

13)$ git add Task11Branch.txt

14)$ git commit -m "Master cimmit new"
[master bc6dea9] Master cimmit new
 1 file changed, 1 insertion(+), 1 deletion(-)

15)$ git merge BestBranch
Auto-merging Task11Branch.txt
CONFLICT (content): Merge conflict in Task11Branch.txt
Automatic merge failed; fix conflicts and then commit the result.

16)$ vim Task11Branch.txt

17)$ cat Task11Branch.txt
HEAD
Master Branch Neww!
hello bestbranch
BestBranch
and last commit

18)$ git add Task11Branch.txt

19)$ git commit -m "commit "
[master a375a32] commit
