package com.kugaudo.queens;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import com.kugaudo.queens.SolutionValidator.ValidationError;

/**
 * @author Igor Kugaudo <igor@kugaudo.com>
 */
public class SolutionLoader {

    public static void main(String[] args) {
        int boardDimension = Integer.valueOf(args[0]);
        String pathToQueensFile = args[1];

        Set<Cell> queens = new HashSet<>(boardDimension);
        BufferedReader reader = null;
        try {
            File f = new File(pathToQueensFile);
            reader = new BufferedReader(new FileReader(f));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] coords = line.split(",");
                int col = Integer.valueOf(coords[0].trim());
                int row = Integer.valueOf(coords[1].trim());
                queens.add(new Cell(col, row));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Loaded " + queens.size() + " of " + boardDimension);
        System.out.println("Validating...");

        SolutionValidator validator = new SolutionValidator();
        ValidationError error = validator.validate(boardDimension, queens);

        if (error == null) {
            System.out.println("The board is valid");
        } else {
            System.out.println(error.getMessage());
        }
    }

}
