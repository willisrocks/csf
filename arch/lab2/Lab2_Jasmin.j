; class heirarchy
.class public PrintInt
.super java/lang/Object

; standard initializer
.method public <init>()V
  aload_0
  invokespecial java/lang/Object/<init>()V
  return
.end method

.method public static main([Ljava.lang.String;)V
  .limit stack 20

  ; push System.out onto the stack
  getstatic  java/lang/System/out Ljava/io/PrintStream;

  ; push push our calculation on the stack
  ldc 28
  ldc 30
  iadd
  ldc 14
  ldc 15
  isub
  imul

  ; push System.out onto the stack


  ; call PrintStream.println()
  invokevirtual java/io/PrintStream/println(I)V
  return
.end method

