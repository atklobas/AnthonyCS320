parent(michael, jack).
parent(john, michael).
parent(john,arthur).
parent(sandy,jack).
parent(sandy,anny).
parent(bob, anny).
male(michael).
male(jack).
male(bob).
male(john).
male(arthur).
female(anny).
female(sandy).

brother(A,B):-male(A),parent(X,A),parent(X,B),A\=B.

uncle(A,B):-brother(A,X),parent(X,B).

halfsibling(A,B):-parent(X,A),parent(X,B),parent(Y,A),parent(Z,B),Y\=Z,X\=Z,X\=Y,A\=B.
