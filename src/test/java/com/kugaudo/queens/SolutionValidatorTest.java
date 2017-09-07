package com.kugaudo.queens;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashSet;

import org.junit.Test;

import com.kugaudo.queens.SolutionValidator.ValidationError;
import com.kugaudo.queens.SolutionValidator.ValidationErrorType;

/**
 * @author Igor Kugaudo <igor@kugaudo.com>
 */
public class SolutionValidatorTest {

	private SolutionValidator validator = new SolutionValidator();

	@Test
	public void calculateNEDiagonalIndexTest() {
		assertEquals(1, validator.calculateNEDiagonalIndex(1, 4, 4));
		assertEquals(2, validator.calculateNEDiagonalIndex(2, 4, 4));
		assertEquals(3, validator.calculateNEDiagonalIndex(3, 4, 4));
		assertEquals(4, validator.calculateNEDiagonalIndex(4, 4, 4));

		assertEquals(2, validator.calculateNEDiagonalIndex(1, 3, 4));
		assertEquals(3, validator.calculateNEDiagonalIndex(2, 3, 4));
		assertEquals(4, validator.calculateNEDiagonalIndex(3, 3, 4));
		assertEquals(5, validator.calculateNEDiagonalIndex(4, 3, 4));

		assertEquals(3, validator.calculateNEDiagonalIndex(1, 2, 4));
		assertEquals(4, validator.calculateNEDiagonalIndex(2, 2, 4));
		assertEquals(5, validator.calculateNEDiagonalIndex(3, 2, 4));
		assertEquals(6, validator.calculateNEDiagonalIndex(4, 2, 4));

		assertEquals(4, validator.calculateNEDiagonalIndex(1, 1, 4));
		assertEquals(5, validator.calculateNEDiagonalIndex(2, 1, 4));
		assertEquals(6, validator.calculateNEDiagonalIndex(3, 1, 4));
		assertEquals(7, validator.calculateNEDiagonalIndex(4, 1, 4));

		assertEquals(1, validator.calculateNEDiagonalIndex(1, 5, 5));
		assertEquals(2, validator.calculateNEDiagonalIndex(2, 5, 5));
		assertEquals(3, validator.calculateNEDiagonalIndex(3, 5, 5));
		assertEquals(4, validator.calculateNEDiagonalIndex(4, 5, 5));
		assertEquals(5, validator.calculateNEDiagonalIndex(5, 5, 5));

		assertEquals(2, validator.calculateNEDiagonalIndex(1, 4, 5));
		assertEquals(3, validator.calculateNEDiagonalIndex(2, 4, 5));
		assertEquals(4, validator.calculateNEDiagonalIndex(3, 4, 5));
		assertEquals(5, validator.calculateNEDiagonalIndex(4, 4, 5));
		assertEquals(6, validator.calculateNEDiagonalIndex(5, 4, 5));

		assertEquals(3, validator.calculateNEDiagonalIndex(1, 3, 5));
		assertEquals(4, validator.calculateNEDiagonalIndex(2, 3, 5));
		assertEquals(5, validator.calculateNEDiagonalIndex(3, 3, 5));
		assertEquals(6, validator.calculateNEDiagonalIndex(4, 3, 5));
		assertEquals(7, validator.calculateNEDiagonalIndex(5, 3, 5));

		assertEquals(4, validator.calculateNEDiagonalIndex(1, 2, 5));
		assertEquals(5, validator.calculateNEDiagonalIndex(2, 2, 5));
		assertEquals(6, validator.calculateNEDiagonalIndex(3, 2, 5));
		assertEquals(7, validator.calculateNEDiagonalIndex(4, 2, 5));
		assertEquals(8, validator.calculateNEDiagonalIndex(5, 2, 5));

		assertEquals(5, validator.calculateNEDiagonalIndex(1, 1, 5));
		assertEquals(6, validator.calculateNEDiagonalIndex(2, 1, 5));
		assertEquals(7, validator.calculateNEDiagonalIndex(3, 1, 5));
		assertEquals(8, validator.calculateNEDiagonalIndex(4, 1, 5));
		assertEquals(9, validator.calculateNEDiagonalIndex(5, 1, 5));
	}

	@Test
	public void calculateNWDiagonalIndexTest() {
		assertEquals(4, validator.calculateNWDiagonalIndex(1, 4, 4));
		assertEquals(3, validator.calculateNWDiagonalIndex(2, 4, 4));
		assertEquals(2, validator.calculateNWDiagonalIndex(3, 4, 4));
		assertEquals(1, validator.calculateNWDiagonalIndex(4, 4, 4));

		assertEquals(5, validator.calculateNWDiagonalIndex(1, 3, 4));
		assertEquals(4, validator.calculateNWDiagonalIndex(2, 3, 4));
		assertEquals(3, validator.calculateNWDiagonalIndex(3, 3, 4));
		assertEquals(2, validator.calculateNWDiagonalIndex(4, 3, 4));

		assertEquals(6, validator.calculateNWDiagonalIndex(1, 2, 4));
		assertEquals(5, validator.calculateNWDiagonalIndex(2, 2, 4));
		assertEquals(4, validator.calculateNWDiagonalIndex(3, 2, 4));
		assertEquals(3, validator.calculateNWDiagonalIndex(4, 2, 4));

		assertEquals(7, validator.calculateNWDiagonalIndex(1, 1, 4));
		assertEquals(6, validator.calculateNWDiagonalIndex(2, 1, 4));
		assertEquals(5, validator.calculateNWDiagonalIndex(3, 1, 4));
		assertEquals(4, validator.calculateNWDiagonalIndex(4, 1, 4));

		assertEquals(5, validator.calculateNWDiagonalIndex(1, 5, 5));
		assertEquals(4, validator.calculateNWDiagonalIndex(2, 5, 5));
		assertEquals(3, validator.calculateNWDiagonalIndex(3, 5, 5));
		assertEquals(2, validator.calculateNWDiagonalIndex(4, 5, 5));
		assertEquals(1, validator.calculateNWDiagonalIndex(5, 5, 5));

		assertEquals(6, validator.calculateNWDiagonalIndex(1, 4, 5));
		assertEquals(5, validator.calculateNWDiagonalIndex(2, 4, 5));
		assertEquals(4, validator.calculateNWDiagonalIndex(3, 4, 5));
		assertEquals(3, validator.calculateNWDiagonalIndex(4, 4, 5));
		assertEquals(2, validator.calculateNWDiagonalIndex(5, 4, 5));

		assertEquals(7, validator.calculateNWDiagonalIndex(1, 3, 5));
		assertEquals(6, validator.calculateNWDiagonalIndex(2, 3, 5));
		assertEquals(5, validator.calculateNWDiagonalIndex(3, 3, 5));
		assertEquals(4, validator.calculateNWDiagonalIndex(4, 3, 5));
		assertEquals(3, validator.calculateNWDiagonalIndex(5, 3, 5));

		assertEquals(8, validator.calculateNWDiagonalIndex(1, 2, 5));
		assertEquals(7, validator.calculateNWDiagonalIndex(2, 2, 5));
		assertEquals(6, validator.calculateNWDiagonalIndex(3, 2, 5));
		assertEquals(5, validator.calculateNWDiagonalIndex(4, 2, 5));
		assertEquals(4, validator.calculateNWDiagonalIndex(5, 2, 5));

		assertEquals(9, validator.calculateNWDiagonalIndex(1, 1, 5));
		assertEquals(8, validator.calculateNWDiagonalIndex(2, 1, 5));
		assertEquals(7, validator.calculateNWDiagonalIndex(3, 1, 5));
		assertEquals(6, validator.calculateNWDiagonalIndex(4, 1, 5));
		assertEquals(5, validator.calculateNWDiagonalIndex(5, 1, 5));

	}

	@Test
	public void validateIllegalQueensCountTest() {
		Cell c11 = new Cell(1, 1);
		Cell c12 = new Cell(1, 2);
		Cell c21 = new Cell(2, 1);
		ValidationError error;

		error = validator.validate(2, new HashSet<Cell>(Arrays.asList(c11)));
		assertEquals(ValidationErrorType.ILLEGAL_QUEENS_COUNT, error.getErrorType());

		error = validator.validate(2, new HashSet<Cell>(Arrays.asList(c11, c12, c21)));
		assertEquals(ValidationErrorType.ILLEGAL_QUEENS_COUNT, error.getErrorType());
	}

	@Test
	public void validateIllegalColumnIndexTest() {
		Cell c11 = new Cell(1, 1);
		Cell c01 = new Cell(0, 1);
		Cell c32 = new Cell(3, 2);
		ValidationError error;

		error = validator.validate(2, new HashSet<Cell>(Arrays.asList(c11, c32)));
		assertEquals(ValidationErrorType.ILLEGAL_COLUMN_INDEX, error.getErrorType());
		assertEquals(c32, error.getCell());

		error = validator.validate(2, new HashSet<Cell>(Arrays.asList(c11, c01)));
		assertEquals(ValidationErrorType.ILLEGAL_COLUMN_INDEX, error.getErrorType());
		assertEquals(c01, error.getCell());

	}

	@Test
	public void validateIllegalRowIndexTest() {
		Cell c11 = new Cell(1, 1);
		Cell c10 = new Cell(1, 0);
		Cell c23 = new Cell(2, 3);
		ValidationError error;

		error = validator.validate(2, new HashSet<Cell>(Arrays.asList(c11, c23)));
		assertEquals(ValidationErrorType.ILLEGAL_ROW_INDEX, error.getErrorType());
		assertEquals(c23, error.getCell());

		error = validator.validate(2, new HashSet<Cell>(Arrays.asList(c11, c10)));
		assertEquals(ValidationErrorType.ILLEGAL_ROW_INDEX, error.getErrorType());
		assertEquals(c10, error.getCell());

	}
	
	@Test
	public void validateCollisionColumnTest() {
		Cell c11 = new Cell(1, 1);
		Cell c12 = new Cell(1, 2);
		ValidationError error;

		error = validator.validate(2, new HashSet<Cell>(Arrays.asList(c11, c12)));
		assertEquals(ValidationErrorType.COLLISION_COLUMN, error.getErrorType());
		assertTrue(Arrays.asList(c11, c12).contains(error.getCell()));
	}

	@Test
	public void validateCollisionRowTest() {
		Cell c11 = new Cell(1, 1);
		Cell c21 = new Cell(2, 1);
		ValidationError error;

		error = validator.validate(2, new HashSet<Cell>(Arrays.asList(c11, c21)));
		assertEquals(ValidationErrorType.COLLISION_ROW, error.getErrorType());
		assertTrue(Arrays.asList(c11, c21).contains(error.getCell()));
	}

	@Test
	public void validateCollisionDiagonalNETest() {
		Cell c11 = new Cell(1, 1);
		Cell c22 = new Cell(2, 2);
		ValidationError error;

		error = validator.validate(2, new HashSet<Cell>(Arrays.asList(c11, c22)));
		assertEquals(ValidationErrorType.COLLISION_DIAGONAL_NORTH_EAST, error.getErrorType());
		assertTrue(Arrays.asList(c11, c22).contains(error.getCell()));
	}

	@Test
	public void validateCollisionDiagonalNWTest() {
		Cell c21 = new Cell(2, 1);
		Cell c12 = new Cell(1, 2);
		ValidationError error;

		error = validator.validate(2, new HashSet<Cell>(Arrays.asList(c21, c12)));
		assertEquals(ValidationErrorType.COLLISION_DIAGONAL_NORTH_WEST, error.getErrorType());
		assertTrue(Arrays.asList(c21, c12).contains(error.getCell()));
	}
	
	@Test
	public void validateSolutionQueens4() {
		Cell c1 = new Cell(1, 3);
		Cell c2 = new Cell(2, 1);
		Cell c3 = new Cell(3, 4);
		Cell c4 = new Cell(4, 2);
		ValidationError error;

		error = validator.validate(4, new HashSet<Cell>(Arrays.asList(c1, c2, c3, c4)));
		assertEquals(null, error);
	}
	
	@Test
	public void validateSolutionQueens8() {
		Cell c1 = new Cell(1, 4);
		Cell c2 = new Cell(2, 6);
		Cell c3 = new Cell(3, 8);
		Cell c4 = new Cell(4, 2);
		Cell c5 = new Cell(5, 7);
		Cell c6 = new Cell(6, 1);
		Cell c7 = new Cell(7, 3);
		Cell c8 = new Cell(8, 5);
		ValidationError error;

		error = validator.validate(8, new HashSet<Cell>(Arrays.asList(c1, c2, c3, c4, c5, c6, c7, c8)));
		assertEquals(null, error);
	}
}
