/*
 * The MIT License
 *
 *   Copyright (c) 2015, Mahmoud Ben Hassine (mahmoud@benhassine.fr)
 *
 *   Permission is hereby granted, free of charge, to any person obtaining a copy
 *   of this software and associated documentation files (the "Software"), to deal
 *   in the Software without restriction, including without limitation the rights
 *   to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *   copies of the Software, and to permit persons to whom the Software is
 *   furnished to do so, subject to the following conditions:
 *
 *   The above copyright notice and this permission notice shall be included in
 *   all copies or substantial portions of the Software.
 *
 *   THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *   IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *   FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *   AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *   LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *   OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 *   THE SOFTWARE.
 */

package io.github.benas.jpopulator.randomizers;

import io.github.benas.jpopulator.api.Randomizer;

import java.util.Date;

import org.apache.commons.math3.random.RandomDataGenerator;

/**
 * A custom date randomizer that generates random dates in a range of date values.
 *
 * @author Mahmoud Ben Hassine (mahmoud@benhassine.fr)
 */
public class DateRangeRandomizer implements Randomizer<Date> {

    /**
     * The minimum date value.
     */
    private final Date minDate;

    /**
     * The maximum date value.
     */
    private final Date maxDate;

    /**
     * Public constructor.
     * @param minDate the minimum date.
     * @param maxDate the maximum date.
     */
    public DateRangeRandomizer(final Date minDate, final Date maxDate) {
        if (minDate == null) {
            throw new IllegalArgumentException("minDate must not be null");
        }
        if (maxDate == null) {
            throw new IllegalArgumentException("maxDate must not be null");
        }
        if (minDate.after(maxDate)) {
            throw new IllegalArgumentException("minDate must be before maxDate");
        }
        this.minDate = minDate;
        this.maxDate = maxDate;
    }

    @Override
    public Date getRandomValue() {
        long minDateTime = minDate.getTime();
        long maxDateTime = maxDate.getTime();
        long randomDateTime = new RandomDataGenerator().nextLong(minDateTime, maxDateTime);
        return new Date(randomDateTime);
    }

}
