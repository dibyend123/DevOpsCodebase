#!/bin/bash
test $(curl http://ec2-52-66-166-134.ap-south-1.compute.amazonaws.com:8765/DevOpsCal/add?a=10\&b=20) -eq 30
