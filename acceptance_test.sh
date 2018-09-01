#!/bin/bash
CALCULATOR_PORT=$(docker-compose port cipipeline_calculator_1 4000 | cut -d: -f2)
test $(curl ec2-13-232-251-18.ap-south-1.compute.amazonaws.com:4000/add?a=1\&b=2) -eq 3
