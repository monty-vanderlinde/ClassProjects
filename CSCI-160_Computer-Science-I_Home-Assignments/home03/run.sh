#!/bin/sh
dir="$(pwd -P "$0")"
jar="$dir"/"${dir##*/}".jar
[ -f "$jar" ] && java -jar "$jar" ||
	printf "The jar file was not found!\nPlease run compile.sh first.\n"
