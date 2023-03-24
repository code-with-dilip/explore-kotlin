package com.explorekotlin.higher_order_functions

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class HigherOrderFunctionSpec : StringSpec({

    "operation test"{
        val result = operation(2,3 ) {x ,y -> x *y}
        result shouldBe  6
    }

})