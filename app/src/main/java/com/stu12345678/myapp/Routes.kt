package com.stu12345678.myapp

sealed class Routes(val route: String) {
    object HomePage : Routes("Home Page")
    object Movie1 : Routes("Movie1")
    object Movie2 : Routes("Movie2")
    object Movie3 : Routes("Movie3")
    object Movie4 : Routes("Movie4")
}
