; Lab5_AverageLoop.j
; Chris Fenton, 2/4/2016
; Input an arbitray number of integer arguments
; on the command line and print out their
; average to the console

; Certification:
; I tested this program and it works with positive
; and negative integers. When there are no args passed,
; it prints out NaN because it is dividing by zero.
; It also will fail with an error if you give it any
; string that doesn't convert to an integer (including floats).
; It also seems to perform well with sets of integers over 20.

; class heirarchy
.class public Lab5_AverageLoop
.super java/lang/Object

; standard initializer
.method public <init>()V
  aload_0
  invokespecial java/lang/Object/<init>()V
  return
.end method

.method public static main([Ljava.lang.String;)V
  .limit stack 2
  .limit locals 4

  ; local[1] counter variable
  ldc 0       ;push 1
  istore 1    ;local[1] = 1

  ; local[2] array length
  aload_0     ;push array address
  arraylength ;push array length
  ldc 1       ;push 1
  isub        ;push arraylength - 1
  istore 2    ;local[2] = arraylength - 1

  ; local[3] running total
  ldc 0       ;push 0
  istore 3    ;local[3] = 0

while:

  ; if local[1] <= arraylength
  iload 2     ;array length
  iload 1     ;counter
  if_icmplt done

  ; push the string in args[0] on the stack
  aload_0          ;load args array address from local #0
  iload 1          ;load arg array index at the counter position
  aaload           ;load address of string from array of addresses

  ; call Integer.parseInt to convert the string on stack to an integer
  invokestatic java/lang/Integer.parseInt(Ljava/lang/String;)I

  iload 3       ;push running total on stack
  iadd          ;add running total and arg
  istore 3      ;local[3] = new sum

  ; increment the counter
  iload 1       ;push counter on the stack
  ldc 1         ;push 1 on the stack
  iadd          ;add 1 to the counter
  istore 1      ;local[1] = incremented counter

  goto while    ;jump to while label

done:

  iload 3       ;push sum on the stack
  i2f           ;convert sum to float
  iload 1       ;push counter on the stack
  i2f           ;convert counter to float
  fdiv          ;push sum / counter on the stack

  ; print out average as a float
  getstatic  java/lang/System/out Ljava/io/PrintStream;
  swap
  invokevirtual java/io/PrintStream/println(F)V

  return

.end method

