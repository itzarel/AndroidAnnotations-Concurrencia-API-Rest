#!/bin/bash

find . -name "*.iml" -type f -delete

find . -name ".idea" -type d -print0 | xargs -0 rm -Rf
find . -name "build" -type d -print0 | xargs -0 rm -Rf

exit
