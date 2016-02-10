; Lab6_Fact.j
; Chris Fenton
; 2/9/2016
; Print the factorial of an integer passed as a command line argument

; Certification:
; This program works for positive integers and returns with a message
; if no argument is passed or the argument isn't a positive integer.
; This program will not work on floating point numbers and will exit with an error.

; class heirarchy
.class public Lab6_Fact
.super java/lang/Object

; standard initializer
.method public <init>()V
  aload_0
  invokespecial	java/lang/Object/<init>()V
  return
.end method

.method public static main([Ljava.lang.String;)V
  .limit stack 2
  .limit locals 3

  check_len:
    ;push array length to stack
    aload_0
    arraylength

    ldc 1
    if_icmpge check_pos   ;if (args.length < 1)

    ;Other wise, print out error message and exit
    getstatic  java/lang/System/out Ljava/io/PrintStream;
    ldc "Integer required: java sumInt <int>"
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
    return

  check_pos:
    ;push args[0] to stack
    aload_0
    iconst_0
    aaload

    ; call Integer.parseInt to convert the string on stack to an integer
    invokestatic java/lang/Integer.parseInt(Ljava/lang/String;)I

    ldc 1
    if_icmpge setup    ;if (n < 1)

    ;Other wise, print out error message and exit
    getstatic  java/lang/System/out Ljava/io/PrintStream;
    ldc "Please enter a positive number"
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
    return

  setup:
    ;push args[0] to stack, convert to int, and store to local[0]
    aload_0
    iconst_0
    aaload
    invokestatic java/lang/Integer.parseInt(Ljava/lang/String;)I
    istore_0

    ;push counter var i to stack and store to local[1]
    ldc 1
    istore_1

    ;push sum var sum to stack and store to local[2]
    ldc 1
    istore_2

  loop:
    iload 1         ;push counter var to stack
    iload 0         ;push n to stack

    if_icmpgt done  ;while (i <= n)

    iload 1         ;push counter to stack
    iload 2         ;push sum to stack
    imul            ;push counter * sum to stack
    istore_2        ;store new sum

    iinc 1 1        ;increment counter var by 1
    goto loop       ;go to the top of the loop

  done:
    ; print out sum var
    iload 2
    getstatic  java/lang/System/out Ljava/io/PrintStream;
    swap
    invokevirtual java/io/PrintStream/println(I)V
    return

.end method
