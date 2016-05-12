#
# Makefile for a CS 350 lab or programming assignment.
# Do not modify this file!!!
#

COURSE_NAME = CS 350
SEMESTER = Fall $(shell date +%Y)
PROJECT_NUMBER = assign03

program_NAME := SkipList
program_C_SRCS := $(wildcard *.c)
program_CXX_SRCS := $(wildcard *.cpp)
program_C_OBJS := ${program_C_SRCS:.c=.o}
program_CXX_OBJS := ${program_CXX_SRCS:.cpp=.o}
program_OBJS := $(program_C_OBJS) $(program_CXX_OBJS)
program_INCLUDE_DIRS :=
program_LIBRARY_DIRS :=
program_LIBRARIES := $(wildcard *.a)

CXXFLAGS += -Wall
CPPFLAGS += $(foreach includedir,$(program_INCLUDE_DIRS),-I$(includedir))
LDFLAGS += $(foreach librarydir,$(program_LIBRARY_DIRS),-L$(librarydir))
LDFLAGS += $(foreach library,$(program_LIBRARIES),$(library))

.PHONY: all clean distclean

all: clean $(program_NAME)

$(program_NAME): $(program_OBJS) Flags.h
	$(CXX) $(CXXFLAGS) $(CPPFLAGS) $(program_OBJS) $(LDFLAGS) -o $(program_NAME)

clean:
	@- $(RM) $(program_NAME)
	@- $(RM) $(program_OBJS)

distclean: clean clean_submit



#######################################################
# The following is for submission to Marmoset
#######################################################

SUBMIT_URL = https://cs.ycp.edu/marmoset/bluej/SubmitProjectViaBlueJSubmitter


submit : clean submit.properties solution.zip
	perl submitToMarmoset.pl solution.zip submit.properties

solution.zip : collected-files.txt
	@echo "Creating a solution zip file"
	@zip -9 $@ `cat collected-files.txt`
	@rm -f collected-files.txt

# Create the submit.properties file that describes how
# the project should be uploaded to the Marmoset server.
submit.properties : nonexistent
	@echo "Creating submit.properties file"
	@rm -f $@
	@echo "submitURL = $(SUBMIT_URL)" >> $@
	@echo "courseName = $(COURSE_NAME)" >> $@
	@echo "semester = $(SEMESTER)" >> $@
	@echo "projectNumber = $(PROJECT_NUMBER)" >> $@

# Collect the names of all files that don't appear
# to be generated files.
collected-files.txt:
	@echo "Collecting the names of files to be submitted"
	@rm -f $@
	@find . -not \( \
				-name '*\.o' \
				-or -name '*\.exe' \
				-or -name '*~' \
				-or -name 'collected-files.txt' \
				-or -name 'submit.properties' \
				-or -type d \
			\) -print \
		| perl -ne 's,\./,,; print' \
		> $@

# This is just a dummy target to force other targets
# to always be out of date.
nonexistent :

# Remove generated files.
clean_submit : clean
	rm -rf collected-files.txt submit.properties solution.zip
