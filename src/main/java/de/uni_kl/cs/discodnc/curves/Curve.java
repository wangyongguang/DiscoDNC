/*
 * This file is part of the Disco Deterministic Network Calculator.
 *
 * Copyright (C) 2017+ The DiscoDNC contributors
 *
 * disco | Distributed Computer Systems Lab
 * University of Kaiserslautern, Germany
 *
 * http://discodnc.cs.uni-kl.de
 *
 *
 * The Disco Deterministic Network Calculator (DiscoDNC) is free software;
 * you can redistribute it and/or modify it under the terms of the 
 * GNU Lesser General Public License as published by the Free Software Foundation; 
 * either version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 */

package de.uni_kl.cs.discodnc.curves;

import de.uni_kl.cs.discodnc.numbers.Num;

/**
 * Interface for wide-sense increasing, plain curves.
 */
public interface Curve {

    // --------------------------------------------------------------------------------------------------------------
    // Generic functionality
    // --------------------------------------------------------------------------------------------------------------
    /**
     * Create and return a linear segment that lies on the positive x axis of the Cartesian
     * coordinate system.
     *
     * @return the positive x-axis
     */
    static LinearSegment getXAxis() {
        // Need to create it anew as the number representation might have changed.
        return LinearSegment.createHorizontalLine(0.0);
    }

    // --------------------------------------------------------------------------------------------------------------
    // Curve copying
    // --------------------------------------------------------------------------------------------------------------
    Curve copy();

    void copy(Curve curve);
    
    // --------------------------------------------------------------------------------------------------------------
    // Curve segments
    // --------------------------------------------------------------------------------------------------------------
    LinearSegment getSegment(int pos);

    int getSegmentCount();

    int getSegmentDefining(Num x);

    void addSegment(LinearSegment s);

    void addSegment(int pos, LinearSegment s);

    void removeSegment(int pos);
    
    // --------------------------------------------------------------------------------------------------------------
    // Curve properties
    // --------------------------------------------------------------------------------------------------------------
    boolean isDelayedInfiniteBurst();

    boolean isDiscontinuity(int pos);

    boolean isRealDiscontinuity(int pos);

    boolean isUnrealDiscontinuity(int pos);

    boolean isWideSenseIncreasing();

    boolean isConcaveIn(Num a, Num b);

    boolean isConvexIn(Num a, Num b);

    @Override
    boolean equals(Object obj);

    @Override
    int hashCode();

    @Override
    String toString();

    // --------------------------------------------------------------------------------------------------------------
	// Curve function values
    // --------------------------------------------------------------------------------------------------------------
	Num f(Num x);

    Num fLimitRight(Num x);

    Num f_inv(Num y);

    Num f_inv(Num y, boolean rightmost);

    Num getLatency();

    Num getBurst();

    Num getGradientLimitRight(Num x);
}
