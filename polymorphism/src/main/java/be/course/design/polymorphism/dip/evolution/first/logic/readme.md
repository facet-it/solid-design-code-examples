The Start

This is the inputtransformer. It's job is to fetch the incoming line of text from console and print it back
 to the console.
 
  For now, the point would be to transform that input string by adding something to it. But that will change in
  the future. That something is now still a parameter which needs to be passed through the start method.
 
  When we analyse this class, you could say that this is how the algorithm goes:
 
  1) input
  2) transform it
  3) output it
 
  So the inputTransformer has 3 different concerns, but only 1 responsibility. At the moment it knows how to deal
  with all of the concerns.
  
  We are going to investigate the effects of change. 
  The first change is that we also want to add something to end of the line we just entered. 
  Pretty small change. 
  If we look at the method and think about hte change we are going to do: how would you define 
  that change? 
   - it is a change of 'WHAT' needs to happen in the logic
   - it is a change in 'HOW' the logic is doing what needs to be done
   - it is a change in the result of the function. 
   
   The correct answer is the first one. Since the function 'start' is a void, there is no
   result. There is however a side effect. We will need to change something to the public
   function 'start' in order to fulfill this change. 
   
   Either we add a parameter and name it postfix or we create a parameter object with a
   prefix and a postfix. 
   
   This change is an annoying change. When you need to change the 'WHAT' of an algorithm, you
   always need to change both the algorithm and all of its clients. Otherwise you break 
   compilation. 
   
   What does that mean, breaking compilation?  Java is a compiled language. So for it to run, 
   it needs to be compiled into something that the operating system of the target computer
   can understand. That means that there is a compiler that reads our code and translated it
   to, in the case of java, bytecode. 
   
   If it can't read the code, or there is a mistake in it, it cannot compile, so the program 
   cannot be executed. 
   
   So we now realize that our changes can make it so that a program cannot be compiled 
   anymore. However, the first thing we changed was just the `InputTransformer`. How come we 
   broke compilation by just changing something in the `InputTransformer` class?
   
   The `Application` class, who is the client btw, has a compile time dependency on the 
   `InputTransformer` class. You can see that by looking at the imports. This means that the 
   `Application` class has as dependency on the `InputTransformer`. The `Application` class depends on 
   the `InputTransformer` class. In other words, if the `InputTransformer` class would not be on the 
   class path, then our code would not compile. Hence this type of dependency is called a **'compile time 
   dependency'**. 
   
   What makes the `Application`class a client of the `InputTransformer` is the fact that it makes 
   use of it. It invokes a method from the programming interface of an `InputTransformer` object. The programming
   interface of a class defines **what** a client can do with an object of that class. 
   
   The compiler expects that the name of the method being invoked matches any of the methods of owning objects. It also 
   expects that the parameters match in type and in amount. If there is a result expected, then the compiler
   expects this result to be of the same type as defined in the owning object. If any of these do not match, 
   then the program will not compile. Thus, calling a method from another object, is also a dependency. Even 
   more, it is also a compile time dependency. 
   
   It goes the other way around as well. If the client is correctly calling a method from the programming api
   of any object, but then the method which was invoked has been changed, then the code will also no longer 
   compile. These dependencies are the cause of errors in other classes when you as developer have only changed
   something in one class. **Dependencies are the streets and highways where the effects of change travel on.** 
   
   But what about the implementation of the method? If we change something there, can it ever effect the 
   client (aside from the fact that hte result might be incorrect)? No, it cannot. Classes do not depend on each 
   others method implementations. **They can only depend on the programming interface**. Well, isn't that great?
   
   Lets continue with the example. 