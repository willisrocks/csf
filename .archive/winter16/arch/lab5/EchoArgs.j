; Lab5_AverageLoop.j
; Chris Fenton, 2/4/2016
; Input an arbitray number of integer arguments
; on the command line and print out their
; average to the console

; class heirarchy
.class public EchoArgs
.super java/lang/Object

; standard initializer
.method public <init>()V
  aload_0
  invokespecial java/lang/Object/<init>()V
  return
.end method

.method public static main([Ljava.lang.String;)V
  .limit stack 3
  .limit locals 3

  ; array length
  aload_0
  arraylength
  ldc 1
  isub
  istore 2

  ; counter variable
  ldc 0       ; push 1
  istore 1    ; local[1] = 1

while:

  ; if local[1] <= arraylength
  iload 2
  iload 1
  if_icmplt done

  ; push the string in args[0] on the stack
  aload_0         ;load args array address from local #0
  ;iconst_0        ;load arg array index 0
  iload 1
  aaload          ;load address of string from array of addresses

  ; print out
  getstatic  java/lang/System/out Ljava/io/PrintStream;
  swap
  invokevirtual java/io/PrintStream/println(Ljava.lang.String;)V

  ; increment the counter
  iload 1
  ldc 1
  iadd
  istore 1
  goto while

done:

  return

.end method

