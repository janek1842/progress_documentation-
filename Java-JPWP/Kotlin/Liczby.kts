class Liczby(val x: Int, val y: Int) {

    public fun getNWD(): Int {
        var gcd = 1
        var i = 1
        while (i <= x && i <= y) {
            // Checks if i is factor of both integers
            if (x % i == 0 && y % i == 0)
                gcd = i
            ++i
        }
        return gcd
    }
}