; Chris Fenton
; CSF - Arch
; Lab 4
; 10/21/2016

; defines Lab4_Average5Method as a subclass of Object
.class public Lab4_Average5Method
.super java/lang/Object

; boilerplate, same as before
.method public <init>()V
  aload_0
  invokespecial java/lang/Object/<init>()V
  return
.end method

.method public static main([Ljava.lang.String;)V
  .limit stack 20
  .limit locals 10

  ; Initialize the object since we using an instance method
  new Lab4_Average5Method
  dup
  invokespecial Lab4_Average5Method/<init>()V

  ; load values to be calculated manually
  ; later we will take these as input on the command line
  ldc 9
  ldc 8
  ldc 3
  ldc 4
  ldc 5

  ; call the average5 method
  invokevirtual Lab4_Average5Method.average5(IIIII)F

  ; push System.out onto the stack
  getstatic  java/lang/System/out Ljava/io/PrintStream;

  ; The value to print must be at the top of the stack
  swap

  ; print the result
  invokevirtual java/io/PrintStream/println(F)V

  return
.end method

; define a average5() method that takes 5 ints and returns a double
.method public average5(IIIII)F
  .limit stack 10
  .limit locals 10

  iload 1
  iload 2
  iadd
  iload 3
  iadd
  iload 4
  iadd
  iload 5
  iadd
  i2f ; convert sum to a float
  ldc 5.0
  fdiv

  freturn
.end method
