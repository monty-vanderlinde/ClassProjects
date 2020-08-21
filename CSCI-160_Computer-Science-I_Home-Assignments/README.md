# CSCI 160 (Computer Science I) - Assignments
This is a list of my assignments from this class.
They have all been pre-compiled into JAR files, but can be manually recompiled on Linux systems with the compile.sh script.
Additionally, the run.sh script can be used to execute the JAR file.
Usage examples provided below

## Examples
Running the compile.sh script:
```
./compile.sh Lab101       # if compile.sh is executable
./compile.sh ./Lab101/    # any valid reference to the directory works
sh compile.sh Lab101      # if compile.sh is not executable
/bin/sh compile.sh Lab101 # explicitly specify shell path
./compile.sh              # works if compile.sh is in a project directory (i.e. Lab101/)
```
Running run.sh works the same as above, but it also need a **directory** path:
```
./run.sh Lab101            # This does work
./run.sh Lab101/Lab101.jar # This does NOT work
./run.sh                   # This also works if run.sh is in a project directory
```

