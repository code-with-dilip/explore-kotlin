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
- Kotlin is a language that allows you to write concise and expressive code

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
      - A quick thing to note is that different branches can execute different result

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
    - You are allowed to have multiple conditions in the same check

```kotlin
fun whenBlock(name: String) {

    /* when (name) {
         "Alex" -> println("Name is Alex")
         "Ben" -> println("Name is Ben")
     }*/

    when (name.length) {
        4, 6 -> println("Length of the name is 4")
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
- Classes have first class support in Kotlin
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

- There are some Classes that are created in enterprise applications won't have any behavior
    - It just holds the data for the other classes to use and apply some business logic on top of those classes

- By adding the **data** modifier before the class
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

### objects in Kotlin

- **object** helps us to create **singleton's** in Kotlin
- You can access the properties inside the class without the instance of the object

```kotlin
object CommonUtil {
    const val appName = "EXPLORE_KOTLIN"
}
```

##  Inheritance in Kotlin

- In kotlin, the base class for any class is **Any**
- In Kotlin, all classes are final by default which means we cannot extend a class
- You need to use the **open** modifier to allow a class to be extended
  - The **open** modifier is needed in the functions if the subclass is going to override a behavior
  
```kotlin
open class Person{
    open fun validate(){
        println("Inside Person validate")
    }

}

class Customer : Person() {
    override fun validate(){
        super.validate()
        println("Inside Customer validate")
    }

}
```

#### Using super keyword

- To call the parent class function we can use the **super** keyword.

```kotlin
class Customer : Person() {
    override fun validate(){
        super.validate()
        println("Inside Customer validate")
    }

```

- **super** keyword and constructor
  - Basically you need to take out the braces in the class creation and use the super keyword along with your constructor() keyword 
  
```kotlin
class Customer : Person {

    constructor() : super() {

    }
    override fun validate(){
        super.validate()
        println("Inside Customer validate")
    }

}
```

#### Second level of Inheritance

- We need to make sure the Customer class has **open** modifier in it

```kotlin

class SpecialCustomer : Customer(){

    fun validate1() {
        super.validate()
    }

}
```

- Let's say that we dont want this class to override to **validate()** function
  - We can add the **final** keyword to that class
  
```kotlin
   final override fun validate(){
        super.validate()
        println("Inside Customer validate")
    }
```

#### Inheritance in data Classes

- You cannot add a open modifier to data classes
  - Inheritance is not supported in data classes
  - But you can still extend a regular class from **data** class

```kotlin
open class Animal(open val name: String)

data class WildAnimal(
    override val name: String,
    val type: String,
    val country: String,
    val age: Int
) : Animal(name)


data class DomesticAnimal(
    override val name: String,
    val type: String,
    val country: String,
    val age: Int
) : Animal(name)

```


#### Abstract Classes in Kotlin
- They are normally created with the **abstract** keyword
  - You cannot create an instance of this class
  - This class can have **state**
  - This class can have member functions
  - You can make certain behaviors abstract and mandate the classes that extends it implement it.

```kotlin
abstract class AbstractPerson{
    var isAlive : Boolean = true
    abstract fun action()

    fun alive(): String {
        return isAlive.toString()
    }
}

class Employee : AbstractPerson(){
    override fun action() {
        TODO("Not yet implemented")
    }

}
```

### Interfaces in Kotlin


- You can only field's of type **val**

```kotlin
interface CourseRepository {
    val isCoursePublished : Boolean
        get() = false

    fun saveCourse(course: Course): Int {
        println("course : $course")
        return course.id
    }

    fun getById(id: Int): Course

}
```

- You are just allowed to have properties declared in the interface of type **val**
  - There is no way we can alter the state of the property in interfaces
- You are allowed to manage the state of the variable in the subclass that's implementing it.

```kotlin
class SqlCourseRepository : CourseRepository {

    override fun getById(id: Int): Course {
        TODO("Not yet implemented")
    }
    override var isCoursePublished: Boolean = false
        get() {
            return true
        }
    set(value) {
        field = value
    }
}
```

#### Override member functions

- We can override member functions in the implementation class
  - One key thing to note here is that , we dont need the open modifier in the parent class

- But you still need the **override** modifier in the subclass.

```kotlin
override fun saveCourse(course: Course): Int {
        println("course in SqlCourseRepository : $course")
        return course.id
    }
```


#### Handling Ambiguity from Subclass

- Lets say you have a class that implements two interfaces
  - Both the interface have the same function
  - You have to call the default implementation of that class then you need to provide the type and then call the appropriate function
    ```kotlin
    super<A>.doSomething()
    ```
```kotlin
interface A {

    fun doSomething(){
        println("Do Something in A")
    }
}

interface B {
    fun doSomething(){
        println("Do Something in B")
    }
}

class AB : A, B {
    override fun doSomething() {
        super<A>.doSomething()
        println("Do something in AB")

    }

}
```

#### Interface vs Abstract Classes
- Abstract classes are allowed to have state but not the **Interface**
- You can have subclasses that implements multiple **Interface** but not the abstract class


### Generics in Kotlin

- If you would like to create generic classes then you would use generic Types
    - In this case, we are declaring an interface with a  generic Type **T** 
  
```kotlin
interface Repository<T>{
    fun getById(id: Int) : T
    fun getAll() : List<T>
}
```

- The implementation of the Repository is below, which actually takes care of implementing the actual functionality.

```kotlin
class GenericRepositoryImpl<T> : Repository<T> {
    override fun getById(id: Int): T {
        TODO("Not yet implemented")
    }

    override fun getAll(): List<T> {
        TODO("Not yet implemented")
    }
}
```

#### Generic Types at the method level

- This approach will only makes sense if we have different types returned by different functions

```kotlin
interface Repo {
    fun <T> getById() : T
    fun <R> getAll() : List<R>
}

class RepoImpl : Repo{
    override fun <T> getById(): T {
        TODO("Not yet implemented")
    }

    override fun <R> getAll(): List<R> {
        TODO("Not yet implemented")
    }
}
```
## Working with nulls

- One of the important concept thats used in many programming languages is the support null references
  - Null references are troublesome and can introduce the most popular exception which is the **Null-Pointer Exception** in runtime.
- Kotlin by default is a null safety programming language.

### Null references in Kotlin
- The reason why nulls are needed in the app:
  - Sometimes you might have to declare the value as null 
  - If nulls are not supported in Java then it might cause issues with  interoperability in Java
- A nullable type in kotlin is declared using the **?**

```aidl
String?
```

- Trying to execute a function on a null reference without the **elvis** or the **null-assertion** operator will cause a compilation error in kotlin
  - This is much better than the if null check that we perform traditionally and it cuts down a lot of boiler plate code

```aidl
    var name1 : String? = null
    //println(name1?.length)
    println(name1!!.length)
```

### Functions that return nullabla types

```aidl
fun upperCase(name : String?)  : String?{
    return name?.uppercase()
}

```

## Kotlin Tidbits

### Type Casting in Kotlin

- Kotlin does have the support for typecasting as like Java
- We can check the type of cast using the **is** operator

#### Smart Cast

- One of the important thing about this is Kotlin can apply smart cast once the object resolves to a particulat type

```aidl
fun checkTypeOfPerson(person: Person) {
    if(person is Employee){
        person.vacationDays(10)
    }

}
```

#### Type Casting Manually

- Type casting can be done usint the **as** operator

```aidl
val castValue = count as String
```

#### Safe TypeCasting

- We can use the elvis operator to apply the casting safely.
  - Without the **?**, if the casting fails then it will throw an exception

```aidl
val castValue1 = count as? String
```
### Pair and Triples in Kotlin

- Pair and Triples are handy when you have a function that's going to return multiple values as a  **return** value.

```kotlin

val namePair = nameAndLength("Dilip")
    println("${namePair.first} and ${namePair.second}")

    val nameTriple = nameAndLengthAndAge("Dilip", 33)
    println("${nameTriple.first} and ${nameTriple.second} and the age is ${nameTriple.third}")

```

### Deconstructing Values

- This feature in kotlin allows us to write more expressive code.
  - Here we can provide proper names to the values that are returned from the function
  - This is much better than calling first and second in the **Pair** type 
  
```kotlin
val (name, length) = namePair
    println("$name and $length")
```

- We can also deconstruct regular objects

```aidl
val customer = CustomerData(1, "Dilip", yearOfBirth = 1987)
    val (id, name2,email,yob ) = customer
    println("$id and $name2 and $yob" )
```

#### Object Destructuring on a collection
- Object destructuring can be applied on a collection too.
- We can apply object de-structuring on a collection using the below approach 

```aidl
val pairsList = listOf(nameAndLength("Dilip"), nameAndLength("Scooby"))

    for ((name, length) in pairsList){
        println("$name and $length")
    }
```

### Exceptions in Kotlin

- Throwable is the base class for exceptions and errors in Kotlin

#### Try/Catch Block

- Exceptions can be handled using the **try/catch** block in kotlin
  - You can also use the finally block to take some actions before the call returns

```kotlin
try {
        checkIsNumber("A")
    } catch (ex: NotANumberException) {
        println("NotANumberException observed in ${ex.message}")
    } catch (ex: Exception) {
        println("Exception is $ex")
    }finally {
        println("Inside Finally Block")
    }
```

#### Using try/catch block as an expression

- The last statement in each branch is the value that gets assigned to the **result**
  - In the event of an exception here the values of the result will be Unit because we are just printing the exception and moving on
  - The code in the **finally** block will not be assigned as a result of this expression
```aidl
val result = try {
        checkIsNumber("A")
    } catch (ex: NotANumberException) {
        println("NotANumberException observed in ${ex.message}")
    } catch (ex: Exception) {
        println("Exception is $ex")
    }finally {
        println("Inside Finally Block")
    }
```

### Declaring Constants

- Constants can be declaring in multiple ways

#### Creating an object
  - Define the constant values there

```aidl
object Constants {
    const val courseName = "Kotlin Programming"
    const val courseName1 = "Kotlin Programming"
}
```

#### Creating a class level property

```aidl
val courseName1 = "Kotlin Programming"
```


#### Creating a property using the const modifier

```aidl
const val courseName = "Kotlin Programming"
```

### Annotations in Kotlin

- Kotlin using Reflection 

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


## Getting Functional

### Higher Order Functions

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

#### Calling Functions passed as arguments

- Use the function argument and followed by that add the paranthesis
  - Add the necessary arguments to it

```
fun operation(x : Int, y :Int , op : (Int, Int)-> Int): Int {
    return op(x, y)
}
```

### Lambda Expression

- Lambda syntax allow you to create a behavior without having to create a function

```groovy
{ x, y -> x + y })
(parameters) -> body
```
- Invoking the Higher Order Function using Lambda
- In this example, we dont need to explicitly call out the types as types are already defined in the actual funciton
  
```
    println(operation(1, 2) { x, y -> x + y })
```

#### Extracting Lambda to a variable

- In this case, we need to explicitly call out the types

```groovy
val sumLamda = {x: Int,y: Int -> x-y}
```

#### Passing the last lambda argument without the brackets

- Kotlin allows the convention of not having to pass it as a single argument

```kotlin


fun unaryOperation(x: Int, op: (Int) -> Int) {
  val result = op(x)
  println("result : $result")
}

unaryOperation(1) { x -> x * x }

```

####  Multiline Lambda Body

```kotlin
    transaction("Dilip"){
        val result = it.uppercase()
        println(result)
        println("MultiLine Lamda")
    }
```

#### Create Anonymous Function

- You can create a function without the name

```kotlin
fun anonymousFunc(){

    unaryOperation(3, fun(x : Int) : Int {
        return x * x
    })
}
```

### Closures in Kotlin

- The concept of accessing a local variable inside lambda is a closure

```kotlin
fun outsideFun(){
    val number = 10
    unaryOperation(10) {
        println(number+1)
        val number1 = number+1
        it * number1
    }
}

```

## Interoperabillity in Java

- Kotlin is a language that works really well with Java classes
- Let's say you have a java project and you want to introduce kotlin then it's totally possible
  - The advantage here is that you don't have to completely put the effort to change your existing code
    - All you need in this case is the kotlin compiler added to your class path

### Talking with Java from Kotlin

- All the classes that's tied to Java should reside in src/main/Java directory
- Kotlin can interact with Java class just like interacting with any other class
  - But one thing to call out is that, we will need to use the kotlin conventions to interact with Java class
  

#### Accessing a Java class from Kotlin 

- In here all the variables are accessed using the kotlin conventions
  - Even though there is a setter/getter method, we still access the field using kotlin convention 

```kotlin
val customer = CustomerJava()
customer.email = "dilip@abc.com"
customer.name = "Dilip"
customer.printDetails()
```


#### Inheritance in Kotlin

- You can implement an interface without any issues as like you implement the interface in kotlin
- The **Return** type of the functions can be null

```kotlin
class CustomerRepositoryImpl : CustomerRepository? {
    override fun findById(id: Int?): CustomerJava {
        TODO("Not yet implemented")
    }

    override fun findCustomers(): MutableList<CustomerJava>? {
        TODO("Not yet implemented")
    }
}
```

### Working in Nulls in InterOperability

- In Java , null is a valid return type for any function
  - Java does not have a concept of a nullable or non-nullable type
- So, the kotlin code that interacts with Java code needs to handle it in their end.

#### Platform Types in Kotlin

- A Java class that returns a String will have the return type as **String!**
  - The exclamation in the return types infers to a platform type, in this case its the JVM
  - There is no equivalent to this in Kotlin

- Example of a platform type return type  
- 
```
customer.nonNull()
```

- We can change the behavior that can add specific things to the language
  - This makes sure that the return type matches to what kotlin expects 
  
```
public @NotNull String nonNull(){

        return "I am not null";
    }
```

### Talking with Kotlin from Java

- When interacting with kotlin classes using Java you need to use the Java Conventions 


#### Creating a instance of a Kotlin Class

- Fields that are non-nullable types in kotlin expect the java code to pass a valid value
  - Passing null will through Runtime Exceptions
  
```java
Customer returningCustomer = new Customer(1, "dilip",
                "abc@dilip.com", 1987);
returningCustomer.setName("dilp1");
```
- You can access and modify the properties using the setter method in kotlin
  - Even though kotlin classes does not have one

#### Accessing a property as a field

- The below declaration allows Java class to access that property as a field 
```kotlin
@JvmField
var property = "Value"
```

#### Handling Default values using @JvmOverloads

- Java does not have the **default** value concept
- If you would like to have the java code compile for a kotlin function then we need to use **@JvmOverloads** annotation  

```kotlin
@JvmOverloads
    fun printString(str: String = "default"){
        println("str : $str ")
    }
```

#### Changing the function name using @JvmName

- Changing the function name

```kotlin
@JvmName("changedName")
    fun changeName(){
        println("changeName")
    }
```

```
customer.changedName();
```

#### Throwing Checked Exceptions using @Throws

- Kotlin does not have a concept of checked exceptions 

```  
  @Throws(IOException::class)
    fun readFile(fileName: String){
        if (fileName == ""){
            throw  IOException("File Name is empty")
        }
    }
```

###  Interacting with Top Level Functions & Variables

- The regular syntax is to use the FileName and invoke the class 

```kotlin
KotlinTopLevelFunctionsKt.prefix("abc", "def");
```

- If the function name gets changes then this will introduce breaking change in the code.
  - You can annotate the class like below.
  - Make sure the JvmName is given before the package name declaration
  
```kotlin
@file:JvmName(name="CommonUtilities")
package com.explorekotlin._10interoperability
```

- Interacting with a regular field
  - Regular variables can be accessed using the getter function, because thats the convention that java uses to access the fields

```kotlin
val name = "KOTLIN_FILE"
System.out.println(CommonUtilities.getName());
```

- Interacting with a constant field

```kotlin
const val NAME_CONSTANT = "KOTLIN_FILE"
System.out.println(CommonUtilities.NAME_CONSTANT);
```

### Interaction with Kotlin Extension Functions in Java

- You can only access an extension function by their namne of the class and then pass the instance to it.

```kotlin
ReturningCustomerKt.extenstion(returningCustomer);
```

## Kotlin Standard Libraries

### Collections

- Kotlin does not have collections of their own.
- But they provide interfaces or helper classes to deal with Collections in Kotlin
  - Mutable and Immutable Collections

#### listOf & mutableListOf

- Immutable List can be created like below

```kotlin
val names = listOf("adam", "ben", "chloe")
println(names)

val emptyList = emptyList<String>()
println(emptyList)
```

- Mutable List can be created using below

```kotlin
val namesMutable = mutableListOf("adam", "ben", "chloe")
    namesMutable.add("anna")
    println(namesMutable)
```


#### hashMapOf & mutableMapOf

- hashMapOf 
  - This is used to create immutable map
  
```kotlin
val hashMap = hashMapOf(Pair("dilip", 33),Pair("scooby", 4),Pair("yaash", 2)  )
    println(hashMap)

    val hashMap1 = hashMapOf("dilip" to  33 ,"scooby"  to  4,"yaash" to  2)
    println(hashMap1)
```

- mutableMapOf
  - This is used to create a mutable map

```kotlin
    val mutableMap = mutableMapOf("dilip" to  33 ,"scooby"  to  4,"yaash" to  2)
    mutableMap.put("abc", 100)
    println(mutableMap)
```


## MetaProgramming

- This allows us to introspect the code and change the behavior of the code at runtime
  - Behavior of the code can be modified on properties, functions and more
- You can achieve this using **Reflection**
  - You can achieve this by using two method
    - Using the Java Reflection API
    - Using the Kotlin Reflection API

### Using Java Reflection API

- The **.javaclass** in this example allows you start leveraging the java reflection api 

```groovy
fun introspected(obj: Any){

    println("className using Reflection ${obj.javaClass.simpleName}")
    obj.javaClass.fields.forEach {
        println("Field name : ${it.name} and type is ${it.type}")
    }
    println("Functions:\n")

    obj.javaClass.methods.forEach {
        println("Method name is : ${it.name}")
    }
}

```


### Using Kotlin Reflection API

- The KClass is the reflection class for **Kotlin**

#### Accessing the Member properties of the fields

```kotlin
    classInfo.memberProperties
        .forEach {
            println("Name ${it.name} of type ${it.returnType}")
        }
```

#### Creating a Constructor using Kotlin Reflection API

```kotlin
    val constructor = ::Transaction
```

```
val transaction = constructor.call(1, 2000.0, "20000")
```

- Creating an instance using the **callBy** function of the constructor reference 

```groovy
val transaction1 = constructor.callBy(mapOf(constructor.parameters[0] to 2,constructor.parameters[1] to 2000.0, constructor.parameters[2] to "20000"))
```


### Annotations in Kotlin

- Annotations in Kotlin 

```groovy
@Table(name = "Contact_Table")
data class Contact(val id: Int, @Field(name="column_name")val name: String, val email: String)
```


```groovy
@Target(AnnotationTarget.FIELD)
@MustBeDocumented
@Repeatable
@Retention(AnnotationRetention.RUNTIME)
annotation class  Field(val name: String)
```
- @MustBeDocumented
  - This states that this information must be present in the generated source code
- @Target(AnnotationTarget.FIELD)
  - This mandates that the annotation should be used against the field
- @Retention(AnnotationRetention.RUNTIME)
  - This annotation information is retained in runtime

- Using the annotation in the actual class

```groovy
@Table(name = "Contact_Table")
data class Contact(val id: Int, @Field(name="column_name")val name: String, val email: String)
```

#### Accessing the annotation information using the Kotlin Reflection API


```groovy
val annotation = Contact::class.annotations.find { it.annotationClass.simpleName == "Table" }
println(annotation)
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