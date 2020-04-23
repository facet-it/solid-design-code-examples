The changes continue...

The application is gaining traction. There now is a certain group of new users that want to eliminate curse words 
from the input, because ... well... somebody needs to think of the children right?

From here on, things are going to get more interesting. So we need a list of words that need to be eliminated and some way
 of telling our program that it needs to run in this mode. In the current situation that we are in... how would you 
implement this change?

And how would define this change? Is it about the WHAT, the HOW  or the result?

I sincerely hope you did not add yet another set of if/else statements to the InputTransformer class. We need to start
thinking about other ways of changing the 'HOW' together with the 'WHAT'. 

How the transformation of the input is done, seems to have become a concern. Depending on the user, there seem to be 
many different ways of transforming that input. For the `InputTransformerV3` class, this is a lot to handle. Hell, all 
this class really knows is general flow of the program, or put differently: the algorithm that keeps being repeated 
whenever there is new input. And it is pretty easy for the class if there is only 1 way of changing the input. If 
something needed to be changed, it was easy and simple to do! Easy to test and there was very little chance of 
unexpected side changes or bugs. Also, there was only a very select group of users, and they all seemed to agree
on how the input needed to be transformed. There weren't that much changes to be expected honestly. 

But with different users wanting different ways to change the input, it seems like there are all of a sudden a lot of 
changes to be expected. So basically, when there are a lot of users who want different ways (DIFFERENT HOW) of doing
the core business logic, there are a lot of reasons to change. So reasons to change come from people, namely the 
people that have an interest in what the code is doing! I think we call them stakeholders. This is important to 
remember. It is also important to realise that the `InputTransformerV3` is still only doing one thing. This class is 
still responsible for only 1 thing: controlling the flow of the program. But there are many different ways of doing 
one part of that flow. 

All of these different ways of transforming, it becomes complex to handle them all in one code unit. Doing that in one 
big complex code unit... it is bound to go wrong at some point in time. It also takes more time and focus from the 
developer that needs to do the change. Because all of these different ways of transforming the input are in one code 
unit, there is a chance that they might affect one another by accident when something needs to be changed. It also 
becomes hard to write tests for this. 

What seems to be the solution for this?

Exactly. We need to separate that concern from the `InputTransformerV3`. There are many ways of doing that 
(pick inheritance and totally fuck that up as a nice showcase of how not to it). Since this is about polymorphism, 
we are going to look into fixing this with composition. This means that we are going to extract the concern of 
transforming the input into separate classes. 

Since there are many transformations, we will use polymorphism to deal with this gracefully. Since all of these 
transform an incoming string into a new string, this can be done easily. The use of polymorphism also makes it 
unnecessary to change my workflow. Since I have extracted the details of how the transformation should happen, the
`InputTransformerV3` now only contains the flow of the transformation. The class has become very simple, it still 
does one thing and it has separated a concern. 

There is no reason anymore to change this class! Or is there ... ?



Remember: 

you only directly depend on another implementation because there is deeper bond between those classes. When you 
depend on an implementation, it will always be a compile time dependency. You are saying: i cannot compile without
you. And that is fine when two classes are cohesive in a certain context. It is also fine when you depend on an 
external library. It would make no sense for the library to expose and even have an interface. The library provides
a working implementation, a working HOW things should be done. if you don't want to depend on the library in a 
compilation manner, you need to provide your own interface and 'integrate' the library with it. 

When you depend on an abstraction, an interface for example, you do have a compilation dependency on that interface but
you don't have a compilation dependency on the implementation. You are saying: i can't compile without you telling 
me what to do. 

