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
val doorNoLong : Long = doorNo.toLong() 
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

####    Escape Characters in Kotlin

- They can be done using backslash
```kotlin
   val escChar = "ABC \n DEF"

```

####  MultiLines in Kotlin

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

####  String Interpolation

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
  - It helps to cut down the boiler plate code where you don't need to explicitly call out the type the variable is going to hold 
- 
```yaml
var name = "Dilip"
```

### Loops , Ranges & Labels

####  Ranges

- Forward range can be created using the **..**

```kotlin
    val range = 1..100
    for (i in range){
        println(i)
    }

```

- Reverse range can be created using the **downTo** operator

```kotlin
val reverseRange = 100 downTo 1
    for (i in reverseRange){
        println("Reverse range is : $i")
    }
```

- You can skip values using **step** keyword 

```kotlin
for (i in reverseRange step 10){
println("Reverse range is : $i")
}
```

#### Loops


##### For Loop
- Using a forloop we can iterate over a collection

```kotlin
val names = listOf("adam","ben", "chloe")
for (name in names){
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
    }while (x < 5)
}
```

#### Labels

- You can label a piece of code using text followed by **@**
  - **loop@**
- We can use this label to break or continue a loop

- break loop
```kotlin
fun customLabelBreak(){

    loop@ for (i in 1..100) {
        for (j in 1..100) {
            println("j is $j")
            if (j==10) break@loop
        }
    }
}
```

- break **innerloop**

```kotlin
fun customLabelContinue(){

    loop@ for (i in 1..100) {
        println()
        println("i is $i")
       innerLoop@ for (j in 1..100) {
            print("j is $j")
            //if (j==10) continue@loop
           if (j==10) break@innerLoop
        }
    }
}
```

- continue **@loop**

```kotlin
fun customLabelContinue(){
    loop@ for (i in 1..100) {
        println()
        println("i is $i")
       innerLoop@ for (j in 1..100) {
            print("j is $j")
            if (j==10) continue@loop
        }
    }
}

```

### Conditionals ( if and when)

####  If and else

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

####  when block

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

    val whenResult =  when (name.length) {
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
import com.explorekotlin.basics.commons.strToLength as strLength

println("Length of the String is ${strLength(name)}")
```

### Any, Unit

- **Any** is equivalent to an Object in Java
- **Unit** is equivalent to void in Java

## Functions
###  Scope Functions

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

-   This function is more or less a side effect, and it does not change the original object      

## Higher Order Functions

-   A Higher Order Function is a type of Function which has two meanings:
    -   Your own function that takes lambda as arguments
    -   Return the function as a return type
    
### Function types
-   The Function Type Syntax is:

```
( x ,y )   ->    Unit
[parameters] [return type]
```
```
val sum = { x: Int, y: Int -> x + y }
val action = { println(42) }
```    

### Passing Function as a argument

-   Below is an Higher Order Function which takes an argument and returns a result
```
fun operation(x : Int, y :Int , op : (Int, Int)-> Int): Int {
    return op(x, y)
}

fun sum(x: Int,y: Int) = x +y

### Invoking the Higher Order Function

```

### Invoking Higher Order Functions

-   Invoking the Higher Order Function using Method Reference

```
    println(operation(1, 2, ::sum))
```

-   Invoking the Higher Order Function using Lambda

```
    println(operation(1, 2) { x, y -> x + y })

```

### Calling Functions passed as arguments

-   Use the function argument and followed by that add the paranthesis
    -   Add the necessary arguments to it
    
```
fun operation(x : Int, y :Int , op : (Int, Int)-> Int): Int {
    return op(x, y)
}
```

##  Inline Functions

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

- In the above **inlineOperation** call actually the lamda thats passed in actually embeds the code in to the **main** function
  - You can check the **bytecode** -> Tools -> Kotlin -> Show Kotlin ByteCode

### How does this alter the method Stack Trace

- It does display a line that does not even exist because inline function inject the code in to the calling function actually
  - But when the exception is printed in the console it does give you the option to navigate in to the lamda body