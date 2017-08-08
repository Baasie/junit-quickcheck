/*
 The MIT License

 Copyright (c) 2010-2017 Paul R. Holser, Jr.

 Permission is hereby granted, free of charge, to any person obtaining
 a copy of this software and associated documentation files (the
 "Software"), to deal in the Software without restriction, including
 without limitation the rights to use, copy, modify, merge, publish,
 distribute, sublicense, and/or sell copies of the Software, and to
 permit persons to whom the Software is furnished to do so, subject to
 the following conditions:

 The above copyright notice and this permission notice shall be
 included in all copies or substantial portions of the Software.

 THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
*/

package com.pholser.junit.quickcheck;

import java.util.HashSet;
import java.util.Set;

import com.pholser.junit.quickcheck.generator.Only;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.junit.Test;
import org.junit.runner.RunWith;

import static com.pholser.junit.quickcheck.Annotations.*;
import static java.util.Arrays.*;
import static org.junit.Assert.*;
import static org.junit.experimental.results.PrintableResult.*;
import static org.junit.experimental.results.ResultMatchers.*;

public class ChoosingTuplesOnlyFromAGivenSetTest {
    @Test public void primitiveIntegers() throws Exception {
        assertThat(testResult(PrimitiveIntegers.class), isSuccessful());
        assertEquals(defaultPropertyTrialCount(), PrimitiveIntegers.iterations);
    }

    @RunWith(JUnitQuickcheck.class)
    public static class PrimitiveIntegers {
        static int iterations;

        private static final Set<Integer> candidates = new HashSet<>(asList(1, 2, 3));

        @Property public void shouldHold(@Only({"1", "2", "3"}) int i) {
            assertTrue(candidates.contains(i));
            ++iterations;
        }
    }

    @Test public void wrapperIntegers() throws Exception {
        assertThat(testResult(WrapperIntegers.class), isSuccessful());
        assertEquals(defaultPropertyTrialCount(), WrapperIntegers.iterations);
    }

    @RunWith(JUnitQuickcheck.class)
    public static class WrapperIntegers {
        static int iterations;

        private static final Set<Integer> candidates = new HashSet<>(asList(4, 5));

        @Property public void shouldHold(@Only({"4", "5"}) Integer i) {
            assertTrue(candidates.contains(i));
            ++iterations;
        }
    }

    @Test public void primitiveLongs() throws Exception {
        assertThat(testResult(PrimitiveLongs.class), isSuccessful());
        assertEquals(defaultPropertyTrialCount(), PrimitiveLongs.iterations);
    }

    @RunWith(JUnitQuickcheck.class)
    public static class PrimitiveLongs {
        static int iterations;

        private static final Set<Long> candidates = new HashSet<>(asList(-6L, -7L, -8L));

        @Property public void shouldHold(@Only({"-6", "-7", "-8"}) long ell) {
            assertTrue(candidates.contains(ell));
            ++iterations;
        }
    }

    @Test public void wrapperLongs() throws Exception {
        assertThat(testResult(WrapperLongs.class), isSuccessful());
        assertEquals(defaultPropertyTrialCount(), WrapperLongs.iterations);
    }

    @RunWith(JUnitQuickcheck.class)
    public static class WrapperLongs {
        static int iterations;

        private static final Set<Long> candidates = new HashSet<>(asList(10L, 11L, 12L));

        @Property public void shouldHold(@Only({"10", "11", "12"}) Long ell) {
            assertTrue(candidates.contains(ell));
            ++iterations;
        }
    }

    @Test public void primitiveShorts() throws Exception {
        assertThat(testResult(PrimitiveShorts.class), isSuccessful());
        assertEquals(defaultPropertyTrialCount(), PrimitiveShorts.iterations);
    }

    @RunWith(JUnitQuickcheck.class)
    public static class PrimitiveShorts {
        static int iterations;

        private static final Set<Short> candidates =
            new HashSet<>(asList(Short.valueOf("9"), Short.valueOf("8")));

        @Property public void shouldHold(@Only({"9", "8"}) short sh) {
            assertTrue(candidates.contains(sh));
            ++iterations;
        }
    }

    @Test public void wrapperShorts() throws Exception {
        assertThat(testResult(WrapperShorts.class), isSuccessful());
        assertEquals(defaultPropertyTrialCount(), WrapperShorts.iterations);
    }

    @RunWith(JUnitQuickcheck.class)
    public static class WrapperShorts {
        static int iterations;

        private static final Set<Short> candidates =
            new HashSet<>(asList(Short.valueOf("-13"), Short.valueOf("-14")));

        @Property public void shouldHold(@Only({"-13", "-14"}) Short sh) {
            assertTrue(candidates.contains(sh));
            ++iterations;
        }
    }
}
