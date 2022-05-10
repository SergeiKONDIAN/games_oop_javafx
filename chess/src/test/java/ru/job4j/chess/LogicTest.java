package ru.job4j.chess;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;
import ru.job4j.chess.firuges.black.QueenBlack;

import static ru.job4j.chess.firuges.Cell.*;

public class LogicTest {

    @Test
    public void testNotFound()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        try {
            logic.move(Cell.C1, Cell.H6);
        } catch (FigureNotFoundException e) {
        }
    }

    @Test
    public void testOccupied()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(C1));
        logic.add(new QueenBlack(D2));
        try {
            logic.move(Cell.C1, Cell.H6);
        } catch (OccupiedCellException e) {
        }
    }

    @Test
    public void testImpossible()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(C1));
        try {
            logic.move(Cell.C1, A8);
        } catch (ImpossibleMoveException e) {
        }
    }
}