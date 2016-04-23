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
	string elem;
	string pathname;
	string dname;


	// s is the stack of directories

	while (!s.empty()) {
		// get the top of the stack. it is a string pathname
		// of the current directory or file you are working on
		string elem = s.top();
		cout << "File: " << elem << endl;
		s.pop();

		// do the stat on that file
		if ( stat((char*)elem.data(), &stat_b) == 1 ) {
			perror("stat");
			exit(EXIT_FAILURE);
		}

		// pop the file
		//s.pop();

		//if it is a regular file, do whatever your function is
		if ( S_ISREG(stat_b.st_mode) == 1 ) {
			cout << "***********" << endl;
			cout << "File: " << elem << endl;
			cout << "Size: " << stat_b.st_size << endl;
			cout << "***********" << endl << endl;
		} else if ( S_ISDIR(stat_b.st_mode) == 1 ) {
			// Otherwise it is a directory

			// Open the directory
			dir = opendir( (char*)elem.data() );
			pathname = elem;

			//	while ( you are reading the directory) {
			while ( (d = readdir(dir)) != NULL ) {

				// construct the path name
				dname = d->d_name;
				// check for . and ..
				if ( strcmp(d->d_name, ".") != 0 && strcmp(d->d_name, "..") != 0 ) {
					// if not . or .. push on the stack
					//pathname += "/" + dname;
					//pathname += (char*)d->d_name.data();
					s.push(pathname + "/" + dname);
					cout << "Pushed: " << pathname << "/" << dname << endl;
				}

			}
			closedir(dir);
		}	

		}

		return;

	}

	int main(int argc, char **argv) {
		char buf[512];
		int cnt;
		arrayStack<string> s;

		if (argc < 2) {
			//printf("usage!\n");
			//return 1;
			argv[1] = "test";
		}

		cnt = strlen(argv[1])+1;
		strncpy(buf, argv[1], cnt);

		s.push(*new string(buf));

		cout << "DFS" << endl;
		dfs(s);
		return 0;
	}


