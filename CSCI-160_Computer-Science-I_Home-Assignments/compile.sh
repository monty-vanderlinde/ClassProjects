#!/bin/sh

# Get the full physical path to the directory of this script
# Alternatively, if a path is provided, then use it instead
[ "$#" -eq 0 ] && dir="$(realpath -P "$0")" && dir="${dir%/*}" || dir="$(realpath -P "$1")"

# Check that there is at least one .java file in the src directory
[ ! "$(find -H "$dir"/src -name "*.java" -print)" ] &&
	printf "There are no .java files in the 'src' directory!\n" &&
	exit 1

# Check that the manifest.mf file exists in this directory
[ ! -f "$dir"/manifest.mf ] &&
	printf "There is no manifest.mf file in the main project directory!\n" &&
	exit 1

# Check that the manifest.mf file declares a 'Main-Class'
[ ! "$(grep 'Main-Class:' "$dir"/manifest.mf)" ] &&
	printf "The manifest.mf file does not declare the 'Main-Class' file!\n" &&
	exit 1

# Check that the declared 'Main-Class' exists
[ ! -f "$dir"/src/"$(sed -n -e 's/Main-Class: //p' "$dir"/manifest.mf | sed -e 's/\./\//' -)".java ] &&
	printf "The declared 'Main-Class' file does not exist in the 'src' directory!\n" &&
	exit 1

# Create the build directory if it doesn't exist yet
mkdir -p "$dir"/build

# Compile all .java files into .class files in the build directory
javac -d "$dir"/build $(find -H "$dir"/src -name "*.java" -print | tr '\n' ' ')

# Compile all .class files into an executable .jar file
jar --verbose --create --file="$dir"/"${dir##*/}".jar --manifest="$dir"/manifest.mf -C "$dir"/build .
