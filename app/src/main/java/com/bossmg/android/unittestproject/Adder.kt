package com.bossmg.android.unittestproject

class Adder {
    fun sum(n: Int): Long = if (n > 0) (n * (n.toLong() + 1)) / 2 else -1
}