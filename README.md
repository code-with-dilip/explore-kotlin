# explore-kotlin

## Adding kotest to the Project

```
plugins {
    id 'org.jetbrains.kotlin.jvm' version '1.3.41'
    id("io.kotest") version "0.2.6"

}

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion")


testImplementation ("io.kotest:kotest-runner-junit5:${kotestVersion}")
testImplementation("io.kotest:kotest-assertions-core-jvm:$kotestVersion")
testImplementation("io.kotest:kotest-framework-engine-jvm:$kotestVersion")

test {
    useJUnitPlatform()
}

```

## Basics of Kotlin

- Kotlin is a language that targets the **JVM** and **JavaScript**
- Semi Colons are optional in Kotlin
- Multiple classes per file is allowed

### val and var

- var
    - This allows you to create mutable variables in kotlin
    - This is a read write property in kotlin

```yaml
    var age: Int
      var name = "Dilip"
```

- val
    - This allows you to create immutable variables in kotlin

```yaml
    val city = "Minneapolis"
    //    city = "Detroit" // this is not allowed

```

- Kotlin is not an immutable language by default
    - But the recommendation is to use immutable varibles whenever possible
    - As we all know mutation is the root of all evil

### Working with Basic Types in Kotlin

- In kotlin everything is a type
    - Int
    - Double
    - Long
- This is different from Java. Because java has primitive types

#### Type conversion need to be explicit

```kotlin
    val doorNo = 1500 // This always maps to integer by default

```

- You have to be explicit about the type you would like to convert

```kotlin
val doorNoLong: Long = doorNo.toLong() 
```

#### String and Char

- Single quotes in Kotlin corresponds to Character

```kotlin
  val char = 'A'
```

- Double quotes in Kotlin corresponds to String

```kotlin
  val str = "ABC"
```

#### Escape Characters in Kotlin

- They can be done using backslash

```kotlin
   val escChar = "ABC \n DEF"

```

#### MultiLines in Kotlin

- MultiLines in Kotlin can be done using **three** quotes

```kotlin
    val multiLine = "ABC\n" +
        "DEF\n" +
        "GHI\n"

val multiLine1 =
    """
ABC
DEF
GHI
"""

```

#### String Interpolation

- This can be applied using the **$** symbol

```kotlin
    val message = "My name is $name"
```

- Function invocation in String Interpolation

```kotlin
val message1 = "My name is $name and the name length is ${name.length}"
```

### Type Inference in Kotlin

- Kotlin can automatically determine the types based on the values assigned to the variable
    - It helps to cut down the boiler plate code where you don't need to explicitly call out the type the variable is
      going to hold
-

```yaml
var name = "Dilip"
```

### Loops , Ranges & Labels

#### Ranges

- Forward range can be created using the **..**

```kotlin
    val range = 1..100
for (i in range) {
    println(i)
}

```

- Reverse range can be created using the **downTo** operator

```kotlin
val reverseRange = 100 downTo 1
for (i in reverseRange) {
    println("Reverse range is : $i")
}
```

- You can skip values using **step** keyword

```kotlin
for (i in reverseRange step 10) {
    println("Reverse range is : $i")
}
```

#### Loops

##### For Loop

- Using a forloop we can iterate over a collection

```kotlin
val names = listOf("adam", "ben", "chloe")
for (name in names) {
    println("Name is : $name")
}

```

##### while Loop

```kotlin
private fun whileLoop() {
    var x = 1;
    while (x < 5) {
        println("Inside while : $x")
        x++
    }
}
```

##### do-while Loop

```kotlin
private fun doWhileLoop() {
    var x = 0
    do {
        println("Inside do while : $x")
        x++
    } while (x < 5)
}
```

#### Labels

- You can label a piece of code using text followed by **@**
    - **loop@**
- We can use this label to break or continue a loop

- break loop

```kotlin
fun customLabelBreak() {

    loop@ for (i in 1..100) {
        for (j in 1..100) {
            println("j is $j")
            if (j == 10) break@loop
        }
    }
}
```

- break **innerloop**

```kotlin
fun customLabelContinue() {

    loop@ for (i in 1..100) {
        println()
        println("i is $i")
        innerLoop@ for (j in 1..100) {
            print("j is $j")
            //if (j==10) continue@loop
            if (j == 10) break@innerLoop
        }
    }
}
```

- continue **@loop**

```kotlin
fun customLabelContinue() {
    loop@ for (i in 1..100) {
        println()
        println("i is $i")
        innerLoop@ for (j in 1..100) {
            print("j is $j")
            if (j == 10) continue@loop
        }
    }
}

```

### Conditionals ( if and when)

#### If and else

- **if** is an expression in kotlin
    - This means that the last line in the if statement is assigned as a result to the variable
    - Anytime using **if** as an expression, it is mandatory to have an **else** block

```kotlin
private fun ifExpression(name: String) {
    val resultName = if (name.length == 4) {
        println("Length is 4 and the name is $name")
        name.toUpperCase()
    } else {
        println("Length is not 4 and the name is $name")
        name.toUpperCase()
    }

    println("resultName : $resultName")
}
```

#### when block

- **when** block is a nice replacement for multiple if else statements
    - This syntax is compact
    - This is kind of an equivalent to **switch-case** statement in Java

```kotlin
fun whenBlock(name: String) {

    /* when (name) {
         "Alex" -> println("Name is Alex")
         "Ben" -> println("Name is Ben")
     }*/

    when (name.length) {
        4 -> println("Length of the name is 4")
        5 -> println("Length of the name is 5")
    }


}
```

- **when** can also be an expression
    - else block is mandatory when using **when** as an expression

```kotlin

fun whenBlockExpression(name: String) {

    val whenResult = when (name.length) {
        4 -> {
            println("Length of the name is 4")
            name
        }
        5 -> {
            println("Length of the name is 5")
            name
        }
        else -> {
            println("Length of the name is not 4 or 5")
            ""
        }
    }
    println(whenResult)

}

```

### Imports

- This concept is pretty much similar to how java works

#### Named Imports

- This concept can be used if you have conflicts with different classes

```kotlin
import com.explorekotlin._1basics.commons.strToLength as strLength

println("Length of the String is ${strLength(name)}")
```

### Any, Unit

- **Any** is equivalent to an Object in Java
- **Unit** is equivalent to void in Java

## Functions

### Functions in Kotlin

- A function is something in kotlin which can do a unit of work.

#### Unit Return Type

- A function that does not return anything is represented as a **Unit** and this is equivalent to a void in java

```kotlin
fun printSomething(): Unit {
    println("printSomething")
}
```

#### Nothing Return Type

- A function with a **Nothing** return type never returns.

```kotlin
fun nothing(): Nothing {
    throw RuntimeException("Exception Occurred")
}
```

#### Function with params and return type

```kotlin
fun multiply(x: Int, y: Int): Int {
    return x + y
}
```

- Like variables, the kotlin compiler can infer the return types too.
    - You basically inline the method body to the by assigning the method body after the equal operator
    - This only works for single line method body.
        - Single expression function does not need a method block

```kotlin
fun multiply1(x: Int, y: Int) = x + y
```

### Functions with default parameters

- In the below example, we have z with the default value
    - If the value is not passed in then the default value will be used.

```kotlin
fun multiply2(x: Int, y: Int, z: Int = 1): Int {
    println("x : $x and y : $y")
    return x * y
}
```

### Functions with named parameters

- The caller of the function can invoke the function by calling out the names of the parameters
    - This makes the code more expressive

```kotlin

fun multiply2(x: Int, y: Int, z: Int = 1, w: Int): Int {
    println("x : $x and y : $y")
    return x * y * z
}
```

- Function invocation for **multiply2**

```kotlin
multiply2(2, 3, w = 3)
```

### Functions with Unlimited Parameters

- use **vararg** as a type for functions that requires indefinite number of parameters

```kotlin
fun printMultipleThings(vararg strings: String) {
    printVarargs(*strings)
}

private fun printVarargs(vararg strings: String) {
    for (string in strings) {
        println("String : $string")
    }
}
```

- Passing **vararg** as a argument to another function requires you to use a **spread** operator
    - The spread operator is *

## Classes in Kotlin

- Kotlin is an object oriented language with first class support for functional construct's

### Class in Kotlin

- Classes in kotlin are created with the **class** keyword
    - Classes can have properties
        - Here we are declaring it as var so that the properties can be set later
            - You need to have a default value if we are just declaring this as a property with **var** type
            - There will be compilation issue if we don't initialize this value

```kotlin
class Customer {
    var id: Int = 0
    var name: String = ""
}

fun main() {

    val customer = Customer()
}

```

#### Initializing Class properties using Constructor

- The traditional way of doing it is by pass through the constructor and intiailize the classs properties

```kotlin
class Customer(initId: Int, initName: String) {
    var id: Int = initId
    var name: String = initName
}
```

- But the above looks cumbersome, and a has a lot of boilerplate code
- Kotlin has a really nice way if writing concise code

- The below syntax removes a lot of boiler plate code
    - The type **var** or **val** is necessary to treat this as a property for this class

```kotlin
class Customer(var id: Int, var name: String)
```

##### Constructor with Default Values

- Using default values give you the behavior of the class with multiple constructors

```kotlin
class Customer(var id: Int, var name: String = "")


val customer = Customer(1, "Dilip")
println("customer name : ${customer.name}")

val customer1 = Customer(1) // Instance without the name

```

##### Run intialization code during Object Creation

- We can use the **init** block to achieve the same

```kotlin
class Customer(var id: Int, var name: String = "") {

    init {
        name = name.toUpperCase()
    }

}
```

#### Secondary Constructor

- You are allowed to create constructors with **construct** keyword and these are called secondary constructors

```kotlin
constructor(email : String) : this(0, email = email) {
}
```

- This constructor needs to invoke the base constructor

#### Custom Getter/Setters in Kotlin

##### Getter

- You normally need this when you need to apply some custom logic on the properties of the class
- Below is the custom getter for a property **age**

```kotlin
val age: Int
    get() {
        return LocalDate.now().year - yearOfBirth
    }
```

##### Setter

- If you would like to apply some property validation then you can use **custom setters**
    - The one key thing when using custom setters is you can set the value to the propery using the **field**
        - **field** is a special one which is also known as a backing field value holds the value of that property

```kotlin
var phoneNumber: String = ""
    set(value) {
        if (value.length < 10) {
            throw IllegalArgumentException("Phone Number should be 10 characters")
        }
        field =
            value // field is a special one which is also known as a  backing field value holds the value of that property
    }
```

### Visibility Modifiers

- The default visibility modifier in kotlin is **public**
- public
    - Default and anywhere accessible
- private
    - Visible only within the file containing declaration
- internal
    - Visible anywhere within the module
        - Module here refers to the maven module or client module
- Classes
    - private - Only available to class members
    - protected - Same as private and subclasses
    - internal - Any client inside the module

### Data classes

- Classes that are created in enterprise applications wont have any behavior
    - It just holds the data for the other classes to use and apply some business logic on top of those classes

- By adding the **data** keyword before the class
    - This automatically takes of generating the equals, toString and hashCode functions for you
    - Advantages:
        - This saves us from the boilerplate code
        - Object equality checks is available out of the box
        - This also has the copy functions similar to clone which helps us to copy properties from one to another
        - Overall the classes are not bulky and concise

```kotlin
data class CustomerData(
    val id: Int,
    var name: String = "",
    val email: String = "",
    val yearOfBirth: Int = 0
)
```

### Enum Classes

- This is also called enumerated classes
- Enum classes have the **enum** keyword attached to the class

```kotlin
enum class Priority {
    MINOR,
    NORMAL,
    MAJOR,
    CRITICAL
}
```

#### Enum Name and Ordinal

```kotlin
    val priority = Priority.CRITICAL
println(priority.name)
println(priority.ordinal)
```

- name
    - This provides the value as like its declared in the enum
- ordinal
    - This gives you the index of the enum
    - Index usually starts with 0

#### values & valueOf

- values()
    - This gives you access all the enums thats part of the Enum class

```kotlin
for (p in PriorityEnum.values()) {
    println(p.name)
}
```

- valueOf
    - This functions retrieves the **enum** for the passed in String

```kotlin
val priorityEnum = PriorityEnum.valueOf("CRITICAL")
```

- If the passed in String does not have a valid Enum then it it will throw a **java.lang.IllegalArgumentException**

#### Arguments in Enum

- You can add Custom values to enums using this approach
    - You can access the values using the constructor argument value
  ```kotlin
  println(priority.value)
  ```  

```kotlin
enum class PriorityEnum(val value: Int) {
    MINOR(-1),
    NORMAL(0),
    MAJOR(1),
    CRITICAL(2)
}

val priority = PriorityEnum.CRITICAL
println(priority.name)
println(priority.ordinal)

```

#### Overriding toString in Enum

- You can override the toString() method if you would like to return a different value for the Enum

```kotlin
MINOR(-1) {
    override fun toString(): String {
        return "MINOR PRIORITY"
    }
}
```

#### Adding member functions in Kotlin

- This is the only place you need to add a **semicolon** in kotlin

```kotlin
enum class PriorityEnum(val value: Int) {
    MINOR(-1) {
        override fun toString(): String {
            return "MINOR PRIORITY"
        }
    },
    NORMAL(0),
    MAJOR(1),
    CRITICAL(2);

    fun abc() {
    }
}
```

### Scope Functions

- Scope Functions are fundamentally there to make your code more concise and readable
- The object on which you are applying these scope functions are called Context Objects
- There are fundamentally five of them
    - let
        - returns the lambda result
    - apply
        - returns the context object
    - also
        - returns the context object
    - with
        - returns the lambda result
    - run
        - returns the lambda result

### also and apply

- This function is more or less a side effect, and it does not change the original object

## Higher Order Functions

- A Higher Order Function is a type of Function which has two meanings:
    - Your own function that takes lambda as arguments
    - Return the function as a return type

### Function types

- The Function Type Syntax is:

```
( x ,y )   ->    Unit
[parameters] [return type]
```

```
val sum = { x: Int, y: Int -> x + y }
val action = { println(42) }
```    

### Passing Function as a argument

- Below is an Higher Order Function which takes an argument and returns a result

```
fun operation(x : Int, y :Int , op : (Int, Int)-> Int): Int {
    return op(x, y)
}

fun sum(x: Int,y: Int) = x +y

### Invoking the Higher Order Function

```

### Invoking Higher Order Functions

- Invoking the Higher Order Function using Method Reference

```
    println(operation(1, 2, ::sum))
```

- Invoking the Higher Order Function using Lambda

```
    println(operation(1, 2) { x, y -> x + y })

```

### Calling Functions passed as arguments

- Use the function argument and followed by that add the paranthesis
    - Add the necessary arguments to it

```
fun operation(x : Int, y :Int , op : (Int, Int)-> Int): Int {
    return op(x, y)
}
```

## Inline Functions

- inline is a keyword which takes care of inlining the function in to the calling code itself

### Working Example

```kotlin

fun operation(op: () -> Unit) {
    println("Before Operation")
    op()
    println("after Operation")
}

inline fun inlineOperation(op: () -> Unit) {
    println("Before inlineOperation")
    op()
    println("after inlineOperation")
}


fun main() {
    operation { println("I am the operation") }
    inlineOperation { println("I am the inoperation") }
}
```

- In the above **inlineOperation** call actually the lamda thats passed in actually embeds the code in to the **main**
  function
    - You can check the **bytecode** -> Tools -> Kotlin -> Show Kotlin ByteCode

### How does this alter the method Stack Trace

- It does display a line that does not even exist because inline function inject the code in to the calling function
  actually
    - But when the exception is printed in the console it does give you the option to navigate in to the lamda body