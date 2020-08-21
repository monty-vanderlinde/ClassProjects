#!/bin/sh

# Get the full physical path to the directory of this script
# Alternatively, if a path is provided, then use it instead
[ "$#" -eq 0 ] && dir="$(realpath -P "$0")" && dir="${dir%/*}" || dir="$(realpath -P "$1")"

jar="$dir"/"${dir##*/}".jar

[ ! -f "$jar" ] && printf "The jar file was not found!\nPlease run compile.sh first.\n"

java -jar "$jar"
