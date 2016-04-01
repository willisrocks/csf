; NameAgePrint.j
; Chris Fenton, 02/24/2016
; Prints a name and an age

; class heirarchy
.class public NameAgePrint
.super java/lang/Object

; standard initializer
.method public <init>()V
  aload_0
  invokespecial java/lang/Object/<init>()V
  return
.end method

.method public static main([Ljava.lang.String;)V
  .limit stack 4
  .limit locals 3

  ; make a new NameAge object, initialize it, and save the handle
  new NameAge
  dup                 ; need a copy for the astore
  invokespecial NameAge/<init>()V
  astore_1            ; Pair object in local 1

  ; store the first command line argument in the name field

  ; the Pair object
  aload_1

  ; push the reference to the first command line argument onto the stack
  aload_0         ;load args array address from local #0
  iconst_0        ;arg array index (args[0])
  aaload          ;load address of string from array of addresses
  ;invokestatic java/lang/Integer.parseInt(Ljava/lang/String;)I

  putfield NameAge/name Ljava/lang/String;

  ; store the second command line argument in the age field

  ; the Pair object
  aload_1

  ; push the reference to the second command line argument onto the stack
  aload_0         ;load args array address from local #0
  iconst_1        ;arg array index (args[0])
  aaload          ;load address of string from array of addresses
  invokestatic java/lang/Integer.parseInt(Ljava/lang/String;)I

  putfield NameAge/age I


  ; Now retrieve both fields of the Pair object and print them

  getstatic  java/lang/System/out Ljava/io/PrintStream;
  aload_1
  getfield NameAge/name Ljava/lang/String;
  invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

  getstatic  java/lang/System/out Ljava/io/PrintStream;
  aload_1
  getfield NameAge/age I
  invokevirtual java/io/PrintStream/println(I)V

  return
.end method
