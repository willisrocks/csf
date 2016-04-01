; NameAge.j
; Chris Fenton, 02/24/2016
; Build a record with name and age fields

; class heirarchy
.class public NameAge
.super java/lang/Object

.field public name Ljava/lang/String;
.field public age I

; standard initializer
.method public <init>()V
  aload_0
  invokespecial java/lang/Object/<init>()V
  return
.end method
