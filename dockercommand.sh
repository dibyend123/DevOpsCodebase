#/bin/bash
echo "uHello World"
echo $PATH
ls -lrt /usr/bin|grep docker
which docker
echo $(whoami)
echo $(id)

sudo which docker
git --version
docker build -t "first/caluclator" .


