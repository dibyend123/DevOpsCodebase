#!/bin/bash
CALCULATOR_PORT=$(docker-compose port calculator 4000 | cut -d: -f2)
test $(curl ec2-52-66-15-56.ap-south-1.compute.amazonaws.com:$CALCULATOR_PORT/sum?a=1\&b=2) -eq 3
