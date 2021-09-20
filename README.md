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
