package com.kugaudo.queens;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.Test;

/**
 * @author Igor Kugaudo <igor@kugaudo.com>
 */
public class FractalSolutionGeneratorTest {

    private FractalSolutionGenerator generator = new FractalSolutionGenerator();
    private SolutionValidator validator = new SolutionValidator();

    @Test
    public void allocate5_QueensFractalTest() {
        // fractal start = [5/2 + 1, 5/2 + 1]
        Set<Cell> solution = generator.allocateQueensFractal(3, 3, 5);

        assertEquals(5, solution.size());
        assertEquals(null, validator.validate(5, solution));

        assertTrue(solution.contains(new Cell(1, 4)));
        assertTrue(solution.contains(new Cell(2, 1)));
        assertTrue(solution.contains(new Cell(3, 3)));
        assertTrue(solution.contains(new Cell(4, 5)));
        assertTrue(solution.contains(new Cell(5, 2)));
    }

    @Test
    public void allocate8_QueensFractalTest() {
        // fractal start = [1/2 + 1, 1*4 + 1/2 + 1]
        Set<Cell> solution = generator.allocateQueensFractal(1, 5, 8);

        assertEquals(8, solution.size());
        assertEquals(null, validator.validate(8, solution));
    }

    @Test
    public void allocate25_QueensFractalTest() {
        // fractal start = [5*5/2 + 1, 5*5/2 + 1]
        Set<Cell> solution = generator.allocateQueensFractal(13, 13, 5, 5);

        assertEquals(25, solution.size());
        assertEquals(null, validator.validate(25, solution));
    }

    @Test
    public void allocate40_QueensFractalTest() {
        // fractal start = [5/2 + 1, 5*4 + 5/2 + 1]
        Set<Cell> solution = generator.allocateQueensFractal(3, 23, 5, 8);

        assertEquals(40, solution.size());
        assertEquals(null, validator.validate(40, solution));
    }

    @Test
    public void allocate125_QueensFractalTest() {
        // fractal start = [5*5*5/2 + 1, 5*5*5/2 + 1]
        Set<Cell> solution = generator.allocateQueensFractal(63, 63, 5, 5, 5);

        assertEquals(125, solution.size());
        assertEquals(null, validator.validate(125, solution));
    }

    @Test
    public void allocate200_QueensFractalTest() {
        // fractal start = [5*5/2 + 1, 5*5*4 + 5*5/2 + 1]
        Set<Cell> solution = generator.allocateQueensFractal(13, 113, 5, 5, 8);

        assertEquals(200, solution.size());
        assertEquals(null, validator.validate(200, solution));
    }

    @Test
    public void allocate625_QueensFractalTest() {
        // fractal start = [5*5*5*5/2 + 1, 5*5*5*5/2 + 1]
        Set<Cell> solution = generator.allocateQueensFractal(313, 313, 5, 5, 5, 5);

        assertEquals(625, solution.size());
        assertEquals(null, validator.validate(625, solution));
    }

    @Test
    public void allocate1000_QueensFractalTest() {
        // fractal start = [5*5*5/2 + 1, 5*5*5*4 + 5*5*5/2 + 1]
        Set<Cell> solution = generator.allocateQueensFractal(63, 563, 5, 5, 5, 8);

        assertEquals(1000, solution.size());
        assertEquals(null, validator.validate(1000, solution));
    }

    @Test
    public void allocate5000_QueensFractalTest() {
        // fractal start = [5*5*5*5/2 + 1, 5*5*5*5*4 + 5*5*5*5/2 + 1]
        Set<Cell> solution = generator.allocateQueensFractal(313, 2813, 5, 5, 5, 5, 8);

        assertEquals(5000, solution.size());
        assertEquals(null, validator.validate(5000, solution));
    }

    @Test
    public void allocate390_625_QueensFractalTest() {
        // fractal start = [390625/2 + 1, 390625/2 + 1]
        Set<Cell> solution = generator.allocateQueensFractal(195313, 195313, 5, 5, 5, 5, 5, 5, 5, 5);

        assertEquals(390625, solution.size());
        assertEquals(null, validator.validate(390625, solution));
    }

    @Test
    public void allocate3_125_000_QueensFractalTest() {
        // fractal start = [390625/2 + 1, 390625*4 + 390625/2 + 1]
        long now;
        now = System.currentTimeMillis();
        Set<Cell> solution = generator.allocateQueensFractal(195313, 1757813, 5, 5, 5, 5, 5, 5, 5, 5, 8);
        System.out.println("3'125'000 queens placed in " + (System.currentTimeMillis() - now) / 1000 + "s");

        assertEquals(3125000, solution.size());
        now = System.currentTimeMillis();
        assertEquals(null, validator.validate(3125000, solution));
        System.out.println("Validation took " + (System.currentTimeMillis() - now) / 1000 + "s");
    }

}
