; Arr.j
; Array test program

; class heirarchy
.class public Arr
.super java/lang/Object

; standard initializer
.method public <init>()V
  aload_0
  invokespecial java/lang/Object/<init>()V
  return
.end method

.method public static main([Ljava.lang.String;)V
  .limit stack 6
  .limit locals 4

  ; local #1 - array var
  bipush 10       ; push 10 to stack
  newarray int    ; create array w/ 10 elements
  astore 1        ; store array in local #1

  ; local #2 - counter var
  iconst_0        ; push 0 to stack
  istore 2        ; store counter var in local #2

Loop:
  iload 2         ; push counter to stack
  bipush 10       ; push 10 to stack
  if_icmpge Done  ; i < 10

  aload 1         ; push array address to stack
  iload 2         ; push counter var to stack
  iload 2             ; dup counter var for val
  iastore         ; array[i] = i

  ; push array[i] to stack
  aload 1         ; push array at local #1 to stack
  iload 2         ; push counter var at local #2 to stack
  iaload          ; push array[i] to stack

  jsr PrintInt    ; print array[i]

  iinc 2 1        ; increment counter at #1

  goto Loop

Done:
  return

; PrintInt subroutine
PrintInt:
  astore 3        ; store return at local #3

  getstatic  java/lang/System/out Ljava/io/PrintStream;
  swap
  invokevirtual java/io/PrintStream/println(I)V

  ret 3           ; return local #3

.end method
