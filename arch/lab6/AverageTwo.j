; Lab5_AverageLoop.j
; Chris Fenton, 2/9/2016
; Input an arbitray number of integer arguments
; on the command line and print out their
; average to the console

; class heirarchy
.class public AverageTwo
.super java/lang/Object

; standard initializer
.method public <init>()V
  aload_0
  invokespecial java/lang/Object/<init>()V
  return
.end method

.method public static main([Ljava.lang.String;)V
  .limit stack 3
  .limit locals 1

; Check that args array length is equal to two
  aload_0         ;load args array address from local #0
  arraylength     ;push array length to stack
  ldc 2           ;push 2 to stack
  if_icmpeq body  ;if array length = 2 goto body, else print error message and return

  ; print out error message
  getstatic  java/lang/System/out Ljava/io/PrintStream;
  ldc "Usage: java AverageTwo <int> <int>"
  invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
  return

body:
  ; push the string in args[0] on the stack
  aload_0         ;load args array address from local #0
  iconst_0        ;load arg array index 0
  aaload          ;load address of string from array of addresses

  ; call Integer.parseInt to convert the string on stack to an integer
  invokestatic java/lang/Integer.parseInt(Ljava/lang/String;)I


  ; push the string in args[1] on the stack
  aload_0         ;load args array address from local #0
  iconst_1        ;load arg array index 1
  aaload          ;load address of string from array of addresses

  ; call Integer.parseInt to convert the string on stack to an integer
  invokestatic java/lang/Integer.parseInt(Ljava/lang/String;)I

  iadd
  i2f
  ldc 2.0
  fdiv

  ; print out
  getstatic  java/lang/System/out Ljava/io/PrintStream;
  swap
  invokevirtual java/io/PrintStream/println(F)V

  return
.end method

