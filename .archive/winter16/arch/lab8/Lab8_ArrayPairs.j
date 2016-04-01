; Lab7_ArraySums.j
; Take a argument n from the command line and
; store the sums of 0..n in the array.
; Prints out each array index and the sum at that point.

; class heirarchy
.class public Lab8_ArrayPairs
.super java/lang/Object

; standard initializer
.method public <init>()V
  aload_0
  invokespecial java/lang/Object/<init>()V
  return
.end method

.method public static main([Ljava.lang.String;)V
  .limit stack 6
  .limit locals 14

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
  anewarray Pair  ; create objectarray w/ n elements
  astore 1        ; store array var

  ; local #2 - counter var
  iconst_0        ; push 0 to stack
  istore 2        ; store counter var

  ; local #3 - sum var
  iconst_0        ; push 0 to stack
  istore 3        ; store sum var

  ; local #4 - prod var
  iconst_1        ; push 0 to stack
  istore 4        ; store prod var

  ; local #5 - pair object

  ; print header text
  jsr PrintHeader

Loop:
  iload 2         ; push counter to stack
  iload 0         ; push n to stack
  if_icmpge Done  ; i < n

  ; sum += i
  iload 2
  iload 3
  iadd
  istore 3

ProdStart:
  ; if counter == 0
  iload 2
  ifeq ProdFinish

  ; prod *= i
  iload 2
  iload 4
  imul
  istore 4
ProdFinish:

  ; create pair
  new Pair
  dup
  invokespecial Pair/<init>()V
  astore 5

  ; set fst field with sum
  aload 5
  iload 3
  putfield Pair/fst I

  ; set snd field with prod
  aload 5
  iload 4
  putfield Pair/snd I

  ; store Pair in array
  aload 1         ; push array address to stack
  iload 2         ; push counter var to stack
  aload 5         ; push pair address to stack
  aastore         ; array[i] = pair

  ; print counter
  iload 2
  jsr PrintInt    ; print counter

  ; print " "
  ldc "\t"
  jsr PrintString

  ; print array[i].fst
  aload 1         ; push array at local #1 to stack
  iload 2         ; push counter var at local #2 to stack
  aaload          ; push array[i] to stack
  getfield Pair/fst I
  jsr PrintInt

  ; print " "
  ldc "\t"
  jsr PrintString

  ; print array[i].snd
  ; handle i == 0
  iload 2
  ifne PrintSnd
  iconst_0
  jsr PrintInt
  goto PrintSndFinish

PrintSnd:
  ; print array[i].snd
  aload 1         ; push array at local #1 to stack
  iload 2         ; push counter var at local #2 to stack
  aaload          ; push array[i] to stack
  getfield Pair/snd I
  jsr PrintInt
PrintSndFinish:

  ; print new line
  jsr PrintNewLine

  iinc 2 1        ; increment counter at #1

  goto Loop

Done:
  return

;;;;;;;;;;;;;;
; Subroutines
;;;;;;;;;;;;;;

PrintHeader:
  astore 9

  ldc "======"
  getstatic  java/lang/System/out Ljava/io/PrintStream;
  swap
  invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V

  ldc "\t"
  getstatic  java/lang/System/out Ljava/io/PrintStream;
  swap
  invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V

  ldc "======"
  getstatic  java/lang/System/out Ljava/io/PrintStream;
  swap
  invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V

  ldc "\t"
  getstatic  java/lang/System/out Ljava/io/PrintStream;
  swap
  invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V

  ldc "======"
  getstatic  java/lang/System/out Ljava/io/PrintStream;
  swap
  invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V

  ldc ""
  getstatic  java/lang/System/out Ljava/io/PrintStream;
  swap
  invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

  ldc "i"
  getstatic  java/lang/System/out Ljava/io/PrintStream;
  swap
  invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V

  ldc "\t"
  getstatic  java/lang/System/out Ljava/io/PrintStream;
  swap
  invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V

  ldc "sum"
  getstatic  java/lang/System/out Ljava/io/PrintStream;
  swap
  invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V

  ldc "\t"
  getstatic  java/lang/System/out Ljava/io/PrintStream;
  swap
  invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V

  ldc "prodSum"
  getstatic  java/lang/System/out Ljava/io/PrintStream;
  swap
  invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V

  ldc ""
  getstatic  java/lang/System/out Ljava/io/PrintStream;
  swap
  invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

  ldc "======"
  getstatic  java/lang/System/out Ljava/io/PrintStream;
  swap
  invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V

  ldc "\t"
  getstatic  java/lang/System/out Ljava/io/PrintStream;
  swap
  invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V

  ldc "======"
  getstatic  java/lang/System/out Ljava/io/PrintStream;
  swap
  invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V

  ldc "\t"
  getstatic  java/lang/System/out Ljava/io/PrintStream;
  swap
  invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V

  ldc "======"
  getstatic  java/lang/System/out Ljava/io/PrintStream;
  swap
  invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V

  ldc ""
  getstatic  java/lang/System/out Ljava/io/PrintStream;
  swap
  invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

  ret 9            ; return local #9

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
