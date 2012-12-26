#!/bin/bash

#get get the script directory 
DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"

java -jar $DIR/hjwebtools.jar $1