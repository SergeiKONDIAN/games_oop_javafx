package ru.job4j.chess.firuges.black;

import junit.framework.TestCase;
import org.junit.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static ru.job4j.chess.firuges.Cell.*;

public class BishopBlackTest extends TestCase {

    @Test
    public void testPosition() {
        BishopBlack bishopBlack = new BishopBlack(C1);
        assertThat(bishopBlack.position(), is(C1));
    }

    @Test
    public void testCopy() {
        BishopBlack bishopBlack1 = new BishopBlack(C1);
        Figure bishopBlack2 = bishopBlack1.copy(H6);
        assertThat(bishopBlack2.position(), is(H6));

    }

    @Test
    public void testWay() {
        BishopBlack bishopBlack = new BishopBlack(C1);
        Cell[] expected = {D2, E3, F4, G5};
        assertThat(bishopBlack.way(G5), is(expected));
    }

    @Test
    public void testWayNonDiagional() {
        BishopBlack bishopBlack = new BishopBlack(C1);
        try {
            bishopBlack.way(G6);
        } catch(ImpossibleMoveException e) {
        }
    }
}