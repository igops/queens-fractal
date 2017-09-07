package com.kugaudo.queens;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Igor Kugaudo <igor@kugaudo.com>
 */
public class SolutionValidator {
	
	ValidationError validate(int boardDimension, Set<Cell> queens) {
		if (queens.size() != boardDimension) {
			return new ValidationError(ValidationErrorType.ILLEGAL_QUEENS_COUNT);
		}

		Set<Integer> columnsTaken = new HashSet<>(boardDimension);
		Set<Integer> rowsTaken = new HashSet<>(boardDimension);
		Set<Integer> diagonalsNETaken = new HashSet<>(2 * boardDimension - 1);
		Set<Integer> diagonalsNWTaken = new HashSet<>(2 * boardDimension - 1);

		for (Cell queen : queens) {

			int col = queen.getCol();
			int row = queen.getRow();

			if (col < 1 || col > boardDimension) {
				return new ValidationError(ValidationErrorType.ILLEGAL_COLUMN_INDEX, col, row);
			}
			if (row < 1 || row > boardDimension) {
				return new ValidationError(ValidationErrorType.ILLEGAL_ROW_INDEX, col, row);
			}

			if (columnsTaken.contains(col)) {
				return new ValidationError(ValidationErrorType.COLLISION_COLUMN, col, row);
			}
			columnsTaken.add(col);

			if (rowsTaken.contains(row)) {
				return new ValidationError(ValidationErrorType.COLLISION_ROW, col, row);
			}
			rowsTaken.add(row);

			int diagonalNE = calculateNEDiagonalIndex(col, row, boardDimension);
			if (diagonalsNETaken.contains(diagonalNE)) {
				return new ValidationError(ValidationErrorType.COLLISION_DIAGONAL_NORTH_EAST, col, row);
			}
			diagonalsNETaken.add(diagonalNE);

			int diagonalNW = calculateNWDiagonalIndex(col, row, boardDimension);
			if (diagonalsNWTaken.contains(diagonalNW)) {
				return new ValidationError(ValidationErrorType.COLLISION_DIAGONAL_NORTH_WEST, col, row);
			}
			diagonalsNWTaken.add(diagonalNW);
		}
		
		return null;
	}

	int calculateNEDiagonalIndex(int col, int row, int boardDimension) {
		return boardDimension - row + col;
	}

	int calculateNWDiagonalIndex(int col, int row, int boardDimension) {
		return 2 * boardDimension - row - col + 1;
	}

	class ValidationError {
		private ValidationErrorType errorType;
		private Cell cell;

		public ValidationError(ValidationErrorType errorType) {
			this.errorType = errorType;
		}

		public ValidationError(ValidationErrorType errorType, Integer col, Integer row) {
			this(errorType);
			this.cell = new Cell(col, row);
		}

		public ValidationErrorType getErrorType() {
			return errorType;
		}

		public Cell getCell() {
			return cell;
		}
		
		public String getMessage() {
			return errorType + (cell != null ? " in cell[" + cell.getCol() + ", " + cell.getRow() + "]" : "");
		}
	}

	enum ValidationErrorType {
		ILLEGAL_QUEENS_COUNT,
		ILLEGAL_ROW_INDEX,
		ILLEGAL_COLUMN_INDEX,
		COLLISION_ROW,
		COLLISION_COLUMN,
		COLLISION_DIAGONAL_NORTH_EAST,
		COLLISION_DIAGONAL_NORTH_WEST;
	}
}
