#!/bin/bash
CALCULATOR_PORT=$(docker-compose port cipipeline_calculator_1 4000 | cut -d: -f2)
test $(curl ec2-52-66-15-56.ap-south-1.compute.amazonaws.com:4000/add?a=1\&b=2) -eq 3
