#!/bin/bash
test $(curl http://ec2-13-232-158-67.ap-south-1.compute.amazonaws.com:8765/DevOpsCal/add?a=10\&b=20) -eq 30
