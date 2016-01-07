; defines the class file associated with this as jasminExample.class
.class public jasminExample
; defines jasminExample as a subclass of Object
.super java/lang/Object

; boilerplate needed for object creation
.method public <init>()V
	aload_0
	
	invokespecial java/lang/Object/<init>()V
	return
.end method

.method public static main([Ljava/lang/String;)V
	; we need two stack elements, for System.out and the string
	.limit stack 2
	
	; find System.out (an object of type PrintStream)
	; and put it on the stack
	getstatic java/lang/System/out Ljava/io/PrintStream;
	
	; find the string (characters) to be printed
	; and put it on the stack

	;;;
	ldc "Ross is a noob!"
	;;;
	
	; invoke the PrintStream/println method
	invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
	
	; ... and that’s it!
	return
.end method
