#!/bin/bash
CALCULATOR_PORT=$(docker-compose port calculator 8080 | cut -d: -f2)
test $(curl ec2-13-126-228-146.ap-south-1.compute.amazonaws.com:$CALCULATOR_PORT/sum?a=1\&b=2) -eq 3
