Note - Class Diagram is for the binary tree. The code for both solutions is included in their respective folders,
although only the binary tree is fully coded. The composite pattern contains proof-of-concept classes for the questions,
and not the game itself.

The solution I have chosen for this mock 20 Questions game is a binary tree. This can be accomplished with three
classes, a Questions class acting as a node, a Game class to interact with the user, and a Main class as the driver.
The Main class contains the main() function, which begins by locating the file containing the questions, initializing a
BufferedReader to later parse the file, and a root Questions. The static function setTree() is then called and passed
the root node, the BufferedReader, and the file. The BufferedReader and file are initiallized in main() to prevent
excessive memory allocation that would be caused by the recursive nature of setTree(). setTree() then parses through
the file, setting every 'no' answer it can find, until it reaches a denoted end. The recursion backs up one level,
checks for a 'yes', and sets it if possible. setTree() continues this pattern until the entire tree has been created.
While doing so, setTree() will pass Questions a true exitOnNo if it find the character '0' at the end of the line. This
character is arbitrary and can be removed after parsing the file, but has been left in for testing purposes. With the
completed tree, main() now initializes a Game object and passes it the root node, and then calls Game's start(). The
Game class serves to handle user-input, display the appropriate questions, and traverse the tree as required.

No design patterns have been applied, although an argument could be made for the composite pattern. However, due to the
fact that questions will need to be linked regardless, the composite pattern would create unnecessary bloat, while a
binary tree parses a single text file once to build the tree. One advantage boasted by the composite pattern would be
greater performance at the cost of a larger code base, as each class could initialize its children as needed, and in the
event that questions become loaded with data, this may be preferable. That said, in this specific text-parsing instance,
the binary tree is better. As more maintainability, the binary tree would need helper functions added to it to allow
the user to parse the tree and set the children properly, and due to the nature of the Questions node, it would be easy
to add new data to it. Once the helper functions are complete, the tree itself could be abstracted from the user, and
the UI could ask the user for the parent question as well as any information the child needs. The tree would be parsed
until the parent question is found, and then the children would be set, as well as written out to the file so as to
allow setTree() to properly set it the next time the game is started. The composite pattern would simply require the
user to write a new class for the question, and then have the chosen parent initialize a class object as required. I
personally am against this solution as the example game would require a minimum of 20 classes in this example, where
a binary tree can do it in three, two if Game's functions were moved to Main.

(another possible text file design)
Question 1 {Question 2 [Question 4], [Question 5] },{Question 3 [Question 6], [Question7]}
