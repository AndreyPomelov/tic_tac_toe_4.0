package game.players;

import game.GameField;
import game.enums.PlayerSymbol;

import java.util.Random;

/**
 * Игрок-компьютер.
 */
public class ComputerPlayer extends AbstractPlayer {

    /**
     * Экземпляр игрового поля, нужен для реализации логики хода.
     */
    private final GameField FIELD;

    /**
     * Конструктор.
     *
     * @param symbol    символ игрока.
     * @param field     экземпляр игрового поля.
     */
    public ComputerPlayer(PlayerSymbol symbol, GameField field) {
        super("SkyNet", symbol);
        this.FIELD = field;
    }

    /**
     * Сделать ход. Компьютер выбирает координаты рандомно.
     *
     * @return координаты в виде строки с разделителем-пробелом, например - "2 3".
     */
    @Override
    public String makeMove() {
        System.out.printf("Ходит %s...\n", NAME);

        // Искусственная пауза для удобства восприятия процесса хода компьютера.
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Random random = new Random();
        int fieldSize = FIELD.getFieldSize();
        int row, column;

        // Случайно выбираем координаты до тех пор, пока не будет выбрана свободная ячейка.
        do {
            row = random.nextInt(fieldSize) + 1;
            column = random.nextInt(fieldSize) + 1;
        } while (FIELD.isCellOccupied(row, column));

        return String.format("%d %d", row, column);
    }
}