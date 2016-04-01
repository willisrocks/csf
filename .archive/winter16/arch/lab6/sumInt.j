; class heirarchy
.class public SumInt
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
  ; Handle input
  ;if (args.length < 1)
  check_len:
    aload_0
    arraylength
    ldc 1
    if_icmpge check_pos

    ;Other wise, print out error message and exit
    getstatic  java/lang/System/out Ljava/io/PrintStream;
    ldc "Integer required: java sumInt <int>"
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
    return

  check_pos:
    ;int n = Integer.parseInt(args[0]);
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
    ldc 0
    istore_2

  loop:
    iload 1         ;push counter var to stack
    iload 0         ;push n to stack

    ;while (i <= n)
    if_icmpgt done

    iload 1         ;push counter to stack
    iload 2         ;push sum to stack
    iadd            ;push counter + sum to stack
    istore_2        ;store new sum

    ;increment counter var by 1
    iinc 1 1
    goto loop

  done:
    ; print out sum var
    iload 2
    getstatic  java/lang/System/out Ljava/io/PrintStream;
    swap
    invokevirtual java/io/PrintStream/println(I)V
    return

.end method
