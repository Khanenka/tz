                               Задание 11
Скопируйте веб-проект в хранилище, созданное ранее. Затем скачайте (checkout)
изменения в отдельный каталог. Попробуйте изменить что-либо в вашем проекте
ипосмотрите на статус папок в проводнике Windows.
                                Решение задания 11:
 
$ git clone https://github.com/Khanenka/jd2_hw.git ./Task11

$ git branch BestBranch
wimbi@DESKTOP-0DLL1TD MINGW64 /d (master)
$ git branch
  BestBranch
* master
  newbranch

$ git checkout BestBranch

wimbi@DESKTOP-0DLL1TD MINGW64 /d (master)
$ git checkout BestBranch
Switched to branch 'BestBranch'
D       Task11.txt
D       jd2_hw

$ git status
wimbi@DESKTOP-0DLL1TD MINGW64 /d (BestBranch)
$ git status


$ git add Task11Branch.txt

$ git commit -m "1 on BestBranch Commit"

 1 file changed, 1 insertion(+)
 create mode 100644 Task11Branch.txt

$ git checkout master
Switched to branch 'master'
D       Task11.txt
D       jd2_hw

$ cd d:/Task11/
$ git status
$ git add Task11.txt
$ git commit -m "first commit on master"
[master fe3b62b] first commit on master
 1 file changed, 1 insertion(+), 5 deletions(-)





