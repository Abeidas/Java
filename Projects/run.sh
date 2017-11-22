#!/bin/sh
# -----------------------------------------------------------------------------
# Start script for Java Mass JPEG Resizer Tool
# Originally created by Johannes Geppert
# Last Change (2010-03-04) by Johannes Geppert (http://www.jgeppert.com)
# -----------------------------------------------------------------------------

echo "Starting Java Mass JPEG Resizer Tool"
java -Xms256m -Xmx512m -jar `./jmjrst.jar`

exit 0