## 一、Naming Conventions**

### **1.1、General Naming Conventions**

* Packages should be in all lower case

```
mypackage
```

* Types must be nouns and written in mixed case starting with upper case.

```
Line, MediaSystem
```

* Variable names must be in mixed case starting with lower case.

```
audioSystem
```

* Names representing constants (final variables) must be all uppercase using underscore to separate words.

```
COLOR_RED
```

* Names representing methods must contain a verb and written in mixed case starting with lower case.

```
computeTotalWidth()
```

* Abbreviations and acronyms should not be uppercase when used as name.

```
exportHtmlSource(); // NOT: exportHTMLSource();
```

* Private class variables should have underscore suffix.

```
class Person
{
  private String name_;
  :
}
```

* Generic variables should have the same name as their type.

```
void setTopic(Topic topic) // NOT: void setTopic(Topic value)
                           // NOT: void setTopic(Topic aTopic)
                           // NOT: void setTopic(Topic t)
```

* The name of the object is implicit, and should be avoided in a method name.

```
line.getLength();   // NOT: line.getLineLength();
```

### **1.2、Specific Naming Conventions**

* The terms get/set must be used where an attribute is accessed directly.

```
employee.getName();
employee.setName(name);
```

* is prefix should be used for boolean variables and methods.

```
isSet, isVisible, isFinished, isFound, isOpen
```

* The term compute can be used in methods where something is computed.

```
valueSet.computeAverage();
matrix.computeInverse()
```

* The term find can be used in methods where something is looked up.

```
vertex.findNearestVertex();
matrix.findSmallestElement();
node.findShortestPath(Node destinationNode);
```

* The term initialize can be used where an object or a concept is established.

```
printer.initializeFontSet();
```

* Plural form should be used on names representing a collection of objects.

```
Collection<Point>  points;
int[]              values;
```

* n prefix should be used for variables representing a number of objects.

```
nPoints, nLines
```

* No suffix should be used for variables representing an entity number

```
tableNo, employeeNo
```

* Iterator variables should be called i, j, k etc.

```
for (Iterator i = points.iterator(); i.hasNext(); ) {
  :
}

for (int i = 0; i < nTables; i++) {
  :
}
```

* Abbreviations in names should be avoided.

```
computeAverage();               // NOT: compAvg();
ActionEvent event;              // NOT: ActionEvent e;
catch (Exception exception) {   // NOT: catch (Exception e) {
```

* Negated boolean variable names must be avoided.

```
bool isError; // NOT: isNoError
bool isFound; // NOT: isNotFound
```

* Associated constants (final variables) should be prefixed by a common type name.

```
final int  COLOR_RED   = 1;
final int  COLOR_GREEN = 2;
final int  COLOR_BLUE  = 3;
```

## **二、Files**

* Java source files should have the extension .java.

```
Point.java
```

* Special characters like TAB and page break must be avoided.

* The incompleteness of split lines must be made obvious.

```
totalSum = a + b + c +
           d + e;

method(param1, param2,
       param3);

setText ("Long line split" +
         "into two parts.");

for (int tableNo = 0; tableNo < nTables;
     tableNo += tableStep) {
  ...
}
```

## **三、Statements**

### **3.1、Package and Import Statements**

* Imported classes must always be listed explicitly.

```
import java.util.List;      // NOT: import java.util.*;
import java.util.ArrayList;
import java.util.HashSet;
```

### **3.2、Types**

* Type conversions must always be done explicitly. Never rely on implicit type conversion.

```
floatValue = (int) intValue; // NOT: floatValue = intValue;
```

### 3.3、Variables**

* Variables should be initialized where they are declared and they should be declared in the smallest scope possible.

* Variables must never have dual meaning.

* Class variables should never be declared public.

* Arrays should be declared with their brackets next to the type.

```
double[] vertex;  // NOT: double vertex[];
int[]    count;   // NOT: int    count[];

public static void main(String[] arguments)

public double[] computeVertex()
```

### **3.4、Loops**

* Only loop control statements must be included in the for() construction.

```
sum = 0;                       // NOT: for (i = 0, sum = 0; i < 100; i++)
for (i = 0; i < 100; i++)                sum += value[i];
  sum += value[i];
```

* The use of do-while loops can be avoided.

### **3.5、Conditionals**

* Complex conditional expressions must be avoided. Introduce temporary boolean variables instead.

```
bool isFinished = (elementNo < 0) || (elementNo > maxElement);
bool isRepeatedEntry = elementNo == lastElement;
if (isFinished || isRepeatedEntry) {
  :
}

// NOT:
if ((elementNo < 0) || (elementNo > maxElement)||
     elementNo == lastElement) {
  :
}
```

* The conditional should be put on a separate line.

```
if (isDone)       // NOT: if (isDone) doCleanup();
  doCleanup();
```

* Executable statements in conditionals must be avoided.

```
InputStream stream = File.open(fileName, "w");
if (stream != null) {
  :
}

// NOT:
if (File.open(fileName, "w") != null)) {
  :
}
```

### **3.6、Miscellaneous**

* The use of magic numbers in the code should be avoided. Numbers other than 0 and 1can be considered declared as named constants instead.

```
private static final int  TEAM_SIZE = 11;
:
Player[] players = new Player[TEAM_SIZE]; // NOT: Player[] players = new Player[11];
```

### **3.7、Floating point constants should always be written with decimal point and at least one decimal**

```
double total = 0.0;    // NOT:  double total = 0;
double speed = 3.0e8;  // NOT:  double speed = 3e8;

double sum;
:
sum = (a + b) * 10.0;
```

## **四、Layout and Comments**

### **4.1、Layout**

* Basic indentation should be 2.

```
for (i = 0; i < nElements; i++)
  a[i] = 0;
```

* The class and interface declarations should have the following form

```
class Rectangle extends Shape
  implements Cloneable, Serializable
{
  ...
}
```

* The for statement should have the following form

```
for (initialization; condition; update) {
  statements;
}
```

### **4.2、White Space**

* a white space

```
a = (b + c) * d; // NOT: a=(b+c)*d

while (true) {   // NOT: while(true){
  ...

doSomething(a, b, c, d);  // NOT: doSomething(a,b,c,d);

case 100 :  // NOT: case 100:

for (i = 0; i < 10; i++) {  // NOT: for(i=0;i<10;i++){
  ...
    
```

* Logical units within a block should be separated by one blank line.

```
// Create a new identity matrix
Matrix4x4 matrix = new Matrix4x4();

// Precompute angles for efficiency
double cosAngle = Math.cos(angle);
double sinAngle = Math.sin(angle);
```

### **4.3、Comments**

* Javadoc comments should have the following form:

```
/**
 * Return lateral location of the specified position.
 * If the position is unset, NaN is returned.
 *
 * @param x    X coordinate of position.
 * @param y    Y coordinate of position.
 * @param zone Zone of position.
 * @return     Lateral location.
 * @throws IllegalArgumentException  If zone is <= 0.
 */
public double computeLocation(double x, double y, int zone)
  throws IllegalArgumentException
{
  ...
}
```

* There should be a space after the comment identifier.

```
// This is a comment    NOT: //This is a comment

/**                     NOT: /**
 * This is a javadoc          *This is a javadoc
 * comment                    *comment
 */                           */
```

* Comments should be indented relative to their position in the code.

```
while (true) {       // NOT:  while (true) { 
  // Do something             // Do something
  something();                  something();
}                             }
```

* All class members should be properly documented.

```
public final class License
{
  /** The license holder, i.e. the licensee. Non-null. */
  private final String licensee_;

  /** License issuer. Non-null. */
  private final String issuer_;

  /** Name of product being licensed. Non-null. */
  private final String product_;

  /** ID of product the license is valid for. Non-null. */
  private final String productId_;

  /** Last date the license is valid. Or null if it never expires. */
  private final Date expireDate_;

  :
}
```
