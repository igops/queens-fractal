package com.kugaudo.queens;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Generates a solution of the queens puzzle using 5- and 8- chunk fractals
 * 
 * The pattern of 5-chunk fractal (an arrow shows a start point):
 *
 *    WW
 *          WW
 *   -> WW
 *  WW  
 *        WW
 *         
 * The pattern of 8-chunk fractal (an arrow shows a start point):
 * 
 *        WW
 *            WW
 *      WW
 *                  WW
 * -> WW           
 *                WW
 *          WW     
 *              WW
 *              
 * Each of these patterns represents a valid solution of the queens puzzle.
 * Every chunk is a fractal also.
 * 
 * At the moment I have tested this class against N * 5 and N * 5 * 8 queens.
 * 
 * @author Igor Kugaudo <igor@kugaudo.com>
 */
public class FractalSolutionGenerator {

    /**
     * Generate and return actual positions of the queens
     * 
     * @see FractalSolutionGeneratorTest for sample usages
     */
    Set<Cell> allocateQueensFractal(int col, int row, int... chunks) {

        int currentFactor = 1;
        int absFactor = 1;
        int[] remainingChunks = new int[] {};

        if (chunks.length != 0) {
            remainingChunks = new int[chunks.length - 1];
            for (int i = 0; i < chunks.length - 1; i++) {
                absFactor *= chunks[i];
                remainingChunks[i] = chunks[i];
            }
            currentFactor = chunks[chunks.length - 1];
        }

        if (currentFactor == 1) {
            return new HashSet<Cell>(Arrays.asList(new Cell(col, row)));

        } else {
            List<Set<Cell>> fractal;

            if (currentFactor == 5) {

                fractal = new ArrayList<Set<Cell>>(5);
                fractal.add(allocateQueensFractal(col, row, remainingChunks));
                fractal.add(allocateQueensFractal(col + 2 * absFactor, row - 1 * absFactor, remainingChunks));
                fractal.add(allocateQueensFractal(col + 1 * absFactor, row + 2 * absFactor, remainingChunks));
                fractal.add(allocateQueensFractal(col - 2 * absFactor, row + 1 * absFactor, remainingChunks));
                fractal.add(allocateQueensFractal(col - 1 * absFactor, row - 2 * absFactor, remainingChunks));

            } else if (currentFactor == 8) {

                fractal = new ArrayList<Set<Cell>>(8);
                fractal.add(allocateQueensFractal(col, row, remainingChunks));
                fractal.add(allocateQueensFractal(col + 1 * absFactor, row - 2 * absFactor, remainingChunks));
                fractal.add(allocateQueensFractal(col + 2 * absFactor, row - 4 * absFactor, remainingChunks));
                fractal.add(allocateQueensFractal(col + 4 * absFactor, row - 3 * absFactor, remainingChunks));
                fractal.add(allocateQueensFractal(col + 3 * absFactor, row + 2 * absFactor, remainingChunks));
                fractal.add(allocateQueensFractal(col + 5 * absFactor, row + 3 * absFactor, remainingChunks));
                fractal.add(allocateQueensFractal(col + 6 * absFactor, row + 1 * absFactor, remainingChunks));
                fractal.add(allocateQueensFractal(col + 7 * absFactor, row - 1 * absFactor, remainingChunks));

            } else {
                throw new RuntimeException("The fractal factor " + currentFactor + " is not supported");
            }

            Set<Cell> cells = new HashSet<>();
            for (Set<Cell> set : fractal) {
                cells.addAll(set);
            }
            return cells;
        }
    }
}
