package org.jsack.tifsa.Sql

/**
 * Created by cfitz on 1/29/17.
 */
class SampleTest extends spock.lang.Specification {
    def "sum of two numbers"(a, b, c) {
        expect:
        a + b == c

        where:
        a | b | c
        1 | 2 | 3
        3 | 4 | 7
        -1 | 2 | 1
    }
}
