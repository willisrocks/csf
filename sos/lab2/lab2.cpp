/*
 * This version just reads the current directory
 * information and outputs the name and if it is a file or a directory.
 */
       #include <stdio.h>
       #include <string.h>
	   #include <sys/types.h>
       #include <dirent.h>
       #include <sys/types.h>
       #include <sys/stat.h>
       #include <unistd.h>
	   #include <iostream>
	   #include <string>
	   #include "arrayStack.h"
	   #include "arrayQueue.h"
	   using namespace std;

void dfs(arrayStack<string> & s) {
	struct stat stat_b;
	struct dirent *d;
	DIR *dir;

	// s is the stack of directories

	while (!s.empty()) {
		// get the top of the stack. it is a string pathname
		// of the current directory or file you are working on
		// do the stat on that file
		// pop the file
		
		//if it is a regular file, do whatever your function is

		// Otherwise it is a directory

		//	while ( you are reading the directory) {
				
				// construct the path name

				// check for . and ..

				// if not . or .. push on the stack

	}

}



int main(int argc, char **argv) {
	char buf[512];
	int cnt;
	arrayStack<string> s;

	if (argc < 2) {
		printf("usage!\n");
		return 1;
	}

	cnt = strlen(argv[1])+1;
	strncpy(buf, argv[1], cnt);

	s.push(*new string(buf));

	cout << "DFS" << endl;
	dfs(s);
	return 0;
}


