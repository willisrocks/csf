; Lab7_ArraySums.j
; Take a argument n from the command line and
; store the sums of 0..n in the array.
; Prints out each array index and the sum at that point.

; class heirarchy
.class public Lab7_ArraySums
.super java/lang/Object

; standard initializer
.method public <init>()V
  aload_0
  invokespecial java/lang/Object/<init>()V
  return
.end method

.method public static main([Ljava.lang.String;)V
  .limit stack 6
  .limit locals 13

CheckArgLength:
  aload_0
  arraylength

  ; if arg.length < 1
  ldc 1
  if_icmpge CheckPos

  ; else
  ldc "Java Lab7_ArraySums <int>\n"
  jsr PrintString
  return

CheckPos:
  aload_0
  iconst_0
  aaload

  ; call Integer.parseInt to convert the string on stack to an integer
  invokestatic java/lang/Integer.parseInt(Ljava/lang/String;)I

  ; if arg[0] < 0
  ldc 0
  if_icmpge Locals

  ; else
  ldc "Please enter an integer greater than 0\n"
  jsr PrintString
  return

Locals:
  ; local #0 - n var
  ; push the string in args[0] on the stack
  aload_0         ;load args array address from local #0
  iconst_0        ;load arg array index 0
  aaload          ;load address of string from array of addresses

  ; call Integer.parseInt to convert the string on stack to an integer
  invokestatic java/lang/Integer.parseInt(Ljava/lang/String;)I

  ; save the input integer in local_0
  istore_0

  ; local #1 - array var
  iload 0         ; push n to stack
  newarray int    ; create array w/ n elements
  astore 1        ; store array in local #1

  ; local #2 - counter var
  iconst_0        ; push 0 to stack
  istore 2        ; store counter var in local #2

  ; local #3 - sum var
  iconst_0        ; push 0 to stack
  istore 3        ;

Loop:
  iload 2         ; push counter to stack
  iload 0         ; push n to stack
  if_icmpge Done  ; i < 10

  ; sum += i
  iload 2
  iload 3
  iadd
  istore 3

  ; array[i] = sum
  aload 1         ; push array address to stack
  iload 2         ; push counter var to stack
  iload 3         ; push sum to stack
  iastore         ; array[i] = sum

  ; print counter
  iload 2
  jsr PrintInt    ; print counter

  ; print " "
  ldc " "
  jsr PrintString

  ; print array[i]
  aload 1         ; push array at local #1 to stack
  iload 2         ; push counter var at local #2 to stack
  iaload          ; push array[i] to stack
  jsr PrintInt    ; print array[i]

  ; print new line
  jsr PrintNewLine

  iinc 2 1        ; increment counter at #1

  goto Loop

Done:
  return

; Subroutines
PrintInt:
  astore 10        ; store return at local #10

  getstatic  java/lang/System/out Ljava/io/PrintStream;
  swap
  invokevirtual java/io/PrintStream/print(I)V

  ret 10           ; return local #10

PrintString:
  astore 11        ; store return at local #11

  getstatic  java/lang/System/out Ljava/io/PrintStream;
  swap
  invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V

  ret 11           ; return local #11

PrintNewLine:
  astore 12        ; store return at local #12

  ldc ""
  getstatic  java/lang/System/out Ljava/io/PrintStream;
  swap
  invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

  ret 12           ; return local #12

.end method
