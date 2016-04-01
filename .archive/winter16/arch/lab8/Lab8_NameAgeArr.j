; Lab8_NameAgeArr.j
; Chris Fenton, 02/25/2016
; Takes sets of names and ages from the command line
; and creates an array of NageAge objects

; class heirarchy
.class public Lab8_NameAgeArr
.super java/lang/Object

; standard initializer
.method public <init>()V
  aload_0
  invokespecial java/lang/Object/<init>()V
  return
.end method

.method public static main([Ljava.lang.String;)V
  .limit stack 4
  .limit locals 13

;;;;;;;;;;;;;;;;;;;
; Check Input
;;;;;;;;;;;;;;;;;;;

  ; arraylength > 0
  aload_0
  arraylength
  ifle HelpText

  ; arraylength % 2 == 0
  aload_0
  arraylength
  iconst_2
  irem
  ifeq Begin

HelpText:
  ldc "Usage: java Lab8_NameAgeArr <even number of two or more integers>"
  jsr PrintlnString
  goto Done

;;;;;;;;;;;;;;;;;;;
; Locals
;;;;;;;;;;;;;;;;;;;

Begin:

  ; local 0 - Args array address
  ; local 1 - NameAge object array address
  ; local 2 - NameAge object address
  ; local 3 - Counter var

  ; initialize locals

  ; local 1 - NameAge array
  aload_0
  arraylength
  iconst_2
  idiv                ; args arraylength / 2
  anewarray NameAge
  astore 1

  ; local 3 - counter var
  iconst_0
  istore 3            ; initialize counter var to 0

Loop:

  ; create NameAge object and store to local 2
  new NameAge
  dup
  invokespecial NameAge/<init>()V
  astore 2

  ; set name field with 1st args element
  aload 2
  aload 0
  iload 3
  aaload
  putfield NameAge/name Ljava/lang/String;

  iinc 3 1            ; increment counter var

  ; set age field with 2nd args element
  aload 2
  aload 0
  iload 3
  aaload
  invokestatic java/lang/Integer.parseInt(Ljava/lang/String;)I
  putfield NameAge/age I

  iinc 3 1            ; increment counter var

  ; print NameAge fields
  jsr PrintNameAge

  ; counter < arraylength
  iload 3
  aload 0
  arraylength
  if_icmplt Loop

Done:
  return

;;;;;;;;;;;;;;;;;;;
; Subroutines
;;;;;;;;;;;;;;;;;;;

PrintlnString:
  astore 10

  getstatic  java/lang/System/out Ljava/io/PrintStream;
  swap
  invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

  ret 10          ; return local 10

PrintNameAge:
  astore 11

  ; print NameAge fields
  getstatic  java/lang/System/out Ljava/io/PrintStream;
  aload 2
  getfield NameAge/name Ljava/lang/String;
  invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V

  getstatic  java/lang/System/out Ljava/io/PrintStream;
  ldc " "
  invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V

  getstatic  java/lang/System/out Ljava/io/PrintStream;
  aload 2
  getfield NameAge/age I
  invokevirtual java/io/PrintStream/println(I)V

  ret 11            ; return local 11

.end method
