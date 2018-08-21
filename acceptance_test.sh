#!/bin/bash
test $(curl http://localhost:8765/DevOpsCal/add?a=10\&b=20) -eq 30
