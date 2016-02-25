; Pair.j
; Neal Nelson  2008.05.20
; Build a pair object using record fields

; class heirarchy
.class public Pair
.super java/lang/Object

.field public fst I
.field public snd I

; standard initializer
.method public <init>()V
  aload_0
  invokespecial java/lang/Object/<init>()V
  return
.end method
