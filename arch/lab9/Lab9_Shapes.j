; PairObjConstr.j
; Chris Fenton
; 03/03/2016
; Creates and prints the area of a Rectangle and Circle object

; class heirarchy
.class public Lab9_Shapes
.super java/lang/Object

; standard initializer
.method public <init>()V
  aload_0
  invokespecial	java/lang/Object/<init>()V
  return
.end method

.method public static main([Ljava.lang.String;)V
  .limit stack 5
  .limit locals 3

  ;;;;;;;;;;;;;
  ; Locals
  ;;;;;;;;;;;;;

  ; local 1 - Rectangle address
  ; local 2 - Circle address

  ; local 1
  new Rectangle
  astore 1

  ; local 2
  new Circle
  astore 2

  ; Print area for Rectangle
  aload 1
  ldc2_w 3.0
  ldc2_w 4.0
  invokespecial Rectangle/<init>(DD)V

  aload 1
  invokevirtual Rectangle/area()D

  d2f				; convert to float before printing

  getstatic  java/lang/System/out Ljava/io/PrintStream;
  swap
  invokevirtual	java/io/PrintStream/println(F)V

  ; Print area for Circle
  aload 2
  ldc2_w 5.0
  invokespecial Circle/<init>(D)V

  aload 2
  invokevirtual Circle/area()D

  d2f				; convert to float before printing

  getstatic  java/lang/System/out Ljava/io/PrintStream;
  swap
  invokevirtual	java/io/PrintStream/println(F)V
  

  return
.end method
