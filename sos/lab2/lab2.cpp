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
	   #include <cstdlib>
	   using namespace std;

void pathfun(string path) {
	cout << path << endl;

}

void dfs(arrayStack<string> & s) {
	struct stat stat_b;
	struct dirent *d;
	DIR *dir;
	string working_dir;

	// s is the stack of directories
	working_dir = s.top();
	cout << "Initial path: " << working_dir << endl;
	cout << "Let's remove trailing slash" << endl;
	if ( working_dir.length() > 0 ) {
		string::iterator it = working_dir.end() - 1;
		if ( *it == '/' ) {
			working_dir.erase(it);
		}
	}
	cout << "Updated path: " << working_dir << endl;

	while (!s.empty()) {
		// get the top of the stack. it is a string pathname
		// of the current directory or file you are working on
		string elem = s.top();

		// do the stat on that file
		if ( stat((char*)elem.data(), &stat_b) == 1 ) {
			perror("stat");
			exit(EXIT_FAILURE);
		}
		
		// pop the file
		s.pop();

		//if it is a regular file, do whatever your function is
		if ( S_ISREG(stat_b.st_mode) == 1 ) {
			cout << "***********" << endl;
			cout << "File: " << elem << endl;
			cout << "Size: " << stat_b.st_size << endl;
			cout << "***********" << endl;
		} else {
		// Otherwise it is a directory

		// Open the directory
		dir = opendir( (char*)elem.data() );
		
		//	while ( you are reading the directory) {
		while ( (d = readdir(dir)) != NULL ) {
				
				// construct the path name
				string pathname = working_dir + "/";
				cout << pathname << d->d_name << endl;

				// check for . and ..
				if ( strcmp(d->d_name, ".") != 0 && strcmp(d->d_name, "..") != 0 ) {
					// if not . or .. push on the stack
					pathname += d->d_name;
					s.push(pathname);
				}

		}
		}	

	}

	return;

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


