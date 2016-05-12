#! /usr/bin/perl

# Submit a project to a Marmoset server.
# Requires curl.

# Copyright (c) 2009, David H. Hovemeyer <david.hovemeyer@gmail.com>
#
# Permission is hereby granted, free of charge, to any person
# obtaining a copy of this software and associated documentation
# files (the "Software"), to deal in the Software without
# restriction, including without limitation the rights to use,
# copy, modify, merge, publish, distribute, sublicense, and/or sell
# copies of the Software, and to permit persons to whom the
# Software is furnished to do so, subject to the following
# conditions:
# 
# The above copyright notice and this permission notice shall be
# included in all copies or substantial portions of the Software.
# 
# THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
# EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES
# OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
# NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT
# HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
# WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
# FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
# OTHER DEALINGS IN THE SOFTWARE.

use strict qw(refs vars);
use FileHandle;

$SIG{INT} = sub { die "Interrupt!\n"; };

my @requiredSubmitProperties =
	("submitURL", "courseName", "semester", "projectNumber");

if (scalar(@ARGV) != 2) {
	die "Usage: submitToMarmoset.pl <filename> <submit properties>\n";
}

my $fileName = shift @ARGV;
my $propFile = shift @ARGV;

# ----------------------------------------------------------------------
# Make sure file being submitted is readable.
# ----------------------------------------------------------------------
if (! -r $fileName) {
	die "Can't read file $fileName: $!\n";
}

# ----------------------------------------------------------------------
# Read the submit properties
# ----------------------------------------------------------------------
my $prop_fh = new FileHandle("<$propFile") || die "Couldn't open properties file $propFile: $!\n";
my %properties = ();
while (<$prop_fh>) {
	chomp;
	if (/^\s*([A-Za-z_]+)\s*=(.*)$/) {
		my $key = $1;
		my $value = $2;
		$value =~ s,^\s+,,;
		$value =~ s,\s+$,,;
#		print "Got: [$key],[$value]\n";
		$properties{$key} = $value;
	}
}
$prop_fh->close();

# ----------------------------------------------------------------------
# Check to make sure that required submit properties are present.
# ----------------------------------------------------------------------
for my $key (@requiredSubmitProperties) {
	if (!exists $properties{$key}) {
		die "Properties file $propFile missing required key $key\n";
	}
}

# ----------------------------------------------------------------------
# Get username and password.
# ----------------------------------------------------------------------
print "Enter your username: ";
my $username = <>;
chomp $username;

print "Enter your password: ";
my $password;
eval {
	system("stty -echo");
	$password = <>;
};
system("stty echo");

die "Exception reading password: $@\n" if ($@);
print "\n";
chomp $password;

#print "username: $username\n";
#print "password: $password\n";


# ----------------------------------------------------------------------
# Finish filling out submit properties.
# ----------------------------------------------------------------------
$properties{'campusUID'} = $username;
$properties{'password'} = $password;

# Marmoset requires a few more misc. properties
$properties{'submitClientTool'} = 'submitToMarmoset.pl';
$properties{'submitClientVersion'} = '0.0';

# ----------------------------------------------------------------------
# Do the upload!
# ----------------------------------------------------------------------

# The submit URL doesn't need to be submitted to the server.
my $submitURL = $properties{'submitURL'};
delete $properties{'submitURL'};


#
# YUCK: curl 7.18.2 doesn't work unless -sslv3 is hard-coded.
# Earlier versions of curl don't seem to work if that option is used.
# So, test the version explicitly.  Sigh.
#

my $curl_version = `curl --version 2>&1`;
if (! ($curl_version =~ /^curl (\d+)\.(\d+)\.(\d+)/)) {
	die "The curl program does not seem to be available: curl --version output: $curl_version\n";
}
my $curl_major = $1;
my $curl_minor = $2;
my $curl_patch = $3;

my $sslv3_opt = '';
if ($curl_major > 7 ||
	($curl_major == 7 && ($curl_minor > 18 || ($curl_minor == 18 && $curl_patch >= 2)))) {
	$sslv3_opt = '--sslv3';
}

my $cmd = "curl --insecure $sslv3_opt -F 'submittedFiles=\@${fileName}'";
for my $key (sort keys %properties) {
	my $value = $properties{$key};
	$cmd .= " -F '$key=$value'";
}
$cmd .= " $submitURL";

#print "cmd=$cmd\n";

#system($cmd)/256 == 0
#	|| die "Couldn't submit: $!\n";

my $curl_fh = new FileHandle("$cmd 2> /dev/null |") || die "Couldn't submit: $!\n";
my $output = '';
while (<$curl_fh>) {
	$output .= $_;
}
$curl_fh->close();

if ($output =~ /^Successful submission/) {
	print <<"EOF";
######################################################################
              >>>>>>>> Successful submission! <<<<<<<<<

Make sure that you log into the marmoset server to manually
check that the files you submitted are correct.

Details:

         Semester:   $properties{semester}
         Course:     $properties{courseName}
         Assignment: $properties{projectNumber}

######################################################################
EOF
} else {
	$output =~ s,^\s+,,;
	chomp $output;
	printf <<"EOF2";

!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
               SUBMISSION FAILED
!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

$output

Please try to submit again.
See your instructor if this problem persists.
EOF2
}
