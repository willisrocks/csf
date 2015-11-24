public class recp {


// Call recp.f1(20)
public static int f1(int a) {

int result;

if (a<5) {
result = 2;
}
else {
result = a-3-f1(a-3);
System.out.println(result+a);
}
return result;
} 

// Call recp.f2(18) 
public static int f2(int x) {
int res;
System.out.println(x*2);
if (x<5) {
res = 5;
}
else {
if (x<10) {
res = 6;
}
else {
res = f2(x-2)+1;
}
System.out.println(res);
}
return res;
}

// Call recp.f3(5)
public static int f3(int x) {
int res;
res = 2;
System.out.println(x+2);
if ((x ==1) || (x==2)) {
res = res + 3;
}
else {
res = f3(x-1)+f3(x-2)-1;
System.out.println(res+2);
}

return res;
}

// Call recp.f4(2)
public static int f4(int b) {
int res;
System.out.println(f5(b*2));
System.out.println(b+2);
if (b>4) {
res = f4(b-4);
}
else {
res = f5(b);
}

return res;
}

public static int f5(int b) {
int res;
System.out.println(b-2);
if (b>2)
res = f4(b-4)+2;
else
res = 7;
System.out.println(b+res);
return res;
}

// Call recp.f6(8,14)
public static int f6(int a, int b) {

int result,x,y;

if (b<5) {
result = 1;
x=2;
y=1;
}
else { 
x = sumpropdiv(a);
y = sumpropdiv(b);
System.out.println(x+y);
if (a>b) {
result = f6(b-2,a-1)+2;
}
else {
result = f6(a-1,b-2)-2;
}
}
System.out.println(x-y);
return result;
}

// Returns the sum of a numbers proper divisors, e.g. 10 ==> 1+2+5 ==> 8
public static int sumpropdiv (int x) {

int res,lp;
res = 0;

for (lp = 1;lp<x; lp=lp+1)
if ((x % lp)==0)
res = res+lp;
return res;
}

//=========================================

// Call recp.f7(20,12)
public static int f7(int a, int b) {

int result;
result = 1;

if (a<10) {
result = b;
}
System.out.println(a);
if (a>=10) {
result = a-f7(b-1,a-2)+2;
}
System.out.println(a-b);
return result;
}


}
