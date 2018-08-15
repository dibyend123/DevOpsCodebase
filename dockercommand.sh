#/bin/bash
echo "uHello World"
export PATH=$PATH:/usr/bin/docker
echo $PATH
git --version
docker build -t "first/caluclator" .


