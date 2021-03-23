A list of changes made to prior classes from Assignment 9:
- Added methods to the Model that were suggested by the TA who graded my
  work such as getShapeByName()
- Added a getType method to shapes that returns the shape's type as a String
  ("rectangle" or "oval"). This works around using instanceof.
- I completely removed the color class I had written before and replaced it with
  the built-in Java color class.
- Got rid of resetAnimation methods as they were never used anywhere.
- Got rid of the noAnimation class as it was not necessary.
- Changed a lot of doubles to ints to better fit with the Builder and the scale
  of JFrame.

    I started writing the views and first and experimenting with simple models.
I did not end up making an interface for both of the view implementations
because they do not really share much in common at all.
    Luckily, I had anticipated the "tweening" that is needed to make the
intermediate stages of the shapes in the middle of their transforms. I was able
use my getShapesAtFrame method from the model in the view. The view is able to
call a drawing frame that paints the current shapes on the screen.
    The Controller then creates a timer to update by the speed passed to it.
It then updates the list of shapes to the current frame and calls on the view
to refresh.
    The main class (EasyAnimator) takes inputs as it is directed and then runs
the program. I made it require the word "go" to end because I couldn't get the
loop to work otherwise.