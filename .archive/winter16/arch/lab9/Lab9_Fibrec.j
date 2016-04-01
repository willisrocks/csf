; Lab9_Fibrec.j
; Chris Fenton
; 03/03/2016

; Recursive Fibonacci Calculator

.class public Lab9_Fibrec
.super java/lang/Object

; boilerplate needed for object creation
.method public <init>()V
  aload_0

  invokespecial java/lang/Object/<init>()V
  return
.end method

.method public static main([Ljava/lang/String;)V
  .limit locals 3
  .limit stack 2
  ;;;;;;;;;;;;;;;;
  ; locals
  ;;;;;;;;;;;;;;;;

  ; local 0 - ArgsArray address
  ; local 1 - int n

  ; local 1
  aload_0
  iconst_0
  aaload
  invokestatic java/lang/Integer.parseInt(Ljava/lang/String;)I
  istore 1
  
  ; call recursive method
  iload 1
  invokestatic Lab9_Fibrec/fib(I)I

  ; print
  getstatic  java/lang/System/out Ljava/io/PrintStream;
  swap
  invokevirtual	java/io/PrintStream/println(I)V

  return
.end method

; fib() recursive function to calculate nth fibonacci number
.method static fib(I)I
  .limit locals 1
  .limit stack 4

  iload_0			; push arg
  iconst_1			; push 1
  if_icmple Exit	; if arg <= return 1


  ; n - 1
  iload_0
  iconst_1
  isub
  
  ; invoke fib(n-1)
  invokestatic Lab9_Fibrec/fib(I)I

  ; n - 2
  iload_0
  ldc 2
  isub

  ; invoke fib(n-2)
  invokestatic Lab9_Fibrec/fib(I)I
 
  ; return fib(n-1) + fib(n-2)
  iadd
  ireturn

Exit:
  iload_0
  ireturn

.end method 
