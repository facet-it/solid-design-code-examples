The next line of changes. 

This inputtransformer is gaining popularity. More people are using it. There are a few who want to be able to only
add a prefix, some want to only add a suffix and there are people who want to be able to add a prefix and a suffix. 

Well that is an easy fix, we can use an extra parameter for that, to indicate the choice of the user. 

Do that change right now. 

When we look at this change, what kind of change is this?
- is it a change to 'WHAT' needs to happen?
- is it a change of 'HOW' it needs to happen?
- is it a change if the result of the function?

The answer is both a change to what needs to happen and how it needs to happen. By adding an extra parameter, 
you will change the definition of the function (and thus break a compilation dependency). But the parameter will
indicate how the input will be transformed. 

If you have done the changes, did you by any chance also took into account the unhappy paths? What if somebody wants 
to only do the prefix, but there is no prefix there? If you haven't already, fix that as well. 

The application did become a bit more complex, but at the very least, we handled the change fast. We did learn that 
change comes from users of the application. 
