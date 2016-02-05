; Lab5_AverageLoop.j
; Chris Fenton, 2/4/2016
; Input an arbitray number of integer arguments
; on the command line and print out their
; average to the console

; class heirarchy
.class public Count
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

  ; counter variable
  ldc 1       ; push 1
  istore 1    ; local[1] = 1

  ; limit
  ldc 10      ; push 10
  istore 2    ; local[2] = 10

while:

  ; if local[1] <= local[2]
  iload 2
  iload 1
  if_icmplt done

  iload 1     ; load the counter

  ; print out
  getstatic  java/lang/System/out Ljava/io/PrintStream;
  swap
  invokevirtual java/io/PrintStream/println(I)V

  ; increment the counter
  iload 1
  ldc 1
  iadd
  istore 1
  goto while

done:

  return

.end method

