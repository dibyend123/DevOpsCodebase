#/bin/bash
echo "uHello World"
export PATH=$PATH:/usr/bin/docker
echo $PATH
docker build -t "first/caluclator" .


