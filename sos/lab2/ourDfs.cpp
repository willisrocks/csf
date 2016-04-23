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

//void printStack(arrayStack<string> & s) {
//	cout << "Stack begin" << endl;
//	for (int i = s.stackTop; i >= 0 ; i--) {
//		cout << s.stack[i] << endl;
//	}
//	cout << "Stack end" << endl;
//}

void dfs(arrayStack<string> & s) {
	struct stat stat_b;
	struct dirent *d;
	DIR *dir;
	string str;
	//string dirname;

	// s is the stack of directories

	while (!s.empty()) {
		// get the top of the stack. it is a string pathname
		// of the current directory or file you are working on
		str = s.top();
		// do the stat on that file
		if (stat((char*)str.data(), &stat_b) != 0) {
		}

		// pop the file
		s.pop();

		//if it is a regular file, do whatever your function is
		if (S_ISREG(stat_b.st_mode)==1) {
			cout << "The filename is:" << str << endl;
			cout << "The file size is:" << stat_b.st_size << "bytes" << endl;
			cout << endl;
		} else if (S_ISDIR(stat_b.st_mode)==1) {
			// Otherwise it is a directory
			cout << "Opening " << str << endl;

			dir = opendir( (char*)str.data());
			if (dir != NULL) {
				//	while ( you are reading the directory) {
				while ((d = readdir(dir)) != NULL) {
					string dirname;
					int dType = d->d_type;

					// construct the path name
					if (dType == 0x4) {
						dirname = str + d->d_name + "/";
					} else if (dType == 0x8) {
						dirname = str + d->d_name;
					}
					// check for . and ..
					if (strcmp(d->d_name, ".") != 0 && strcmp(d->d_name, "..") != 0) {
						// if not . or .. push on the stack
						s.push((char *)dirname.data());
						cout << dirname << " pushed" << endl;
					}
				}
				closedir(dir);
				cout << "The directory is closed" << endl;
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

	cout << "DFS Started:" << endl;
	dfs(s);
	return 0;
}
