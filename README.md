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

##  Scope Functions

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