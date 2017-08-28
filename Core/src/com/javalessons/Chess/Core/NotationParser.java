package com.javalessons.Chess.Core;

import com.javalessons.Chess.Core.Piece.Impl.*;

import javax.swing.*;

/**
 * Created by Lite on 26.08.2017.
 */
public class NotationParser {
    private String notation;
    private ChessBoard chessBoard;

    public NotationParser(String notation, ChessBoard chessBoard) {
        this.notation = notation;
        this.chessBoard = chessBoard;
    }

    public void arrangeFigures() {
        int horisontalPosition = 0;
        int verticalPosition = 0;
        int stepOfIf = 0;
        StepsOfParsing stepsOfParsing = StepsOfParsing.firstFigures;
        char parseChar;


        for (int i = 0; i < notation.length(); i++)                                                                      // в случае обнаружения цифр(отступов)
        {
          //  System.out.println(stepOfIf);
            parseChar = notation.charAt(i);
            if (stepsOfParsing == StepsOfParsing.firstFigures) {
                if (Character.getNumericValue(parseChar) == 0 || Character.getNumericValue(parseChar) == 1 || Character.getNumericValue(parseChar) == 2 || Character.getNumericValue(parseChar) == 3 || Character.getNumericValue(parseChar) == 4 || Character.getNumericValue(parseChar) == 5 || Character.getNumericValue(parseChar) == 6 || Character.getNumericValue(parseChar) == 7 || Character.getNumericValue(parseChar) == 8 || Character.getNumericValue(parseChar) == 9) {
                    //chessBoard.content[Character.getNumericValue(parseChar)][0] = new Pawn(PlayerSide.BLACK);
                    horisontalPosition += Character.getNumericValue(parseChar);
                } else if (parseChar == 'k') {
                    chessBoard.content[horisontalPosition][verticalPosition] = new King(PlayerSide.BLACK);
                    horisontalPosition++;
                } else if (parseChar == 'K') {
                    chessBoard.content[horisontalPosition][verticalPosition] = new King(PlayerSide.WHITE);
                    horisontalPosition++;
                } else if (parseChar == 'q') {
                    chessBoard.content[horisontalPosition][verticalPosition] = new Queen(PlayerSide.BLACK);
                    horisontalPosition++;
                } else if (parseChar == 'Q') {
                    chessBoard.content[horisontalPosition][verticalPosition] = new Queen(PlayerSide.WHITE);
                    horisontalPosition++;
                } else if (parseChar == 'b') {
                    chessBoard.content[horisontalPosition][verticalPosition] = new Bishop(PlayerSide.BLACK);
                    horisontalPosition++;
                } else if (parseChar == 'B') {
                    chessBoard.content[horisontalPosition][verticalPosition] = new Bishop(PlayerSide.WHITE);
                    horisontalPosition++;
                } else if (parseChar == 'n') {
                    chessBoard.content[horisontalPosition][verticalPosition] = new Knight(PlayerSide.BLACK);
                    horisontalPosition++;
                } else if (parseChar == 'N') {
                    chessBoard.content[horisontalPosition][verticalPosition] = new Knight(PlayerSide.WHITE);
                    horisontalPosition++;
                } else if (parseChar == 'r') {
                    chessBoard.content[horisontalPosition][verticalPosition] = new Rook(PlayerSide.BLACK);
                    horisontalPosition++;
                } else if (parseChar == 'R') {
                    chessBoard.content[horisontalPosition][verticalPosition] = new Rook(PlayerSide.WHITE);
                    horisontalPosition++;
                } else if (parseChar == 'p') {
                    chessBoard.content[horisontalPosition][verticalPosition] = new Pawn(PlayerSide.BLACK);
                    horisontalPosition++;
                } else if (parseChar == 'P') {
                    chessBoard.content[horisontalPosition][verticalPosition] = new Pawn(PlayerSide.WHITE);
                    horisontalPosition++;
                } else if (parseChar == '/') {
                    verticalPosition++;
                    horisontalPosition = 0;
                } else if (parseChar == ' ') {
                    stepsOfParsing = StepsOfParsing.secondSide;
                }
            }


            else if (stepsOfParsing == StepsOfParsing.secondSide) {
                if (parseChar == 'w') {
                    chessBoard.progressOfSide = PlayerSide.WHITE;
                } else if (parseChar == 'b') {
                    chessBoard.progressOfSide = PlayerSide.BLACK;

                }
                else if (parseChar == ' ')
                {
                    stepsOfParsing = StepsOfParsing.theerdCatling;
                }
            }


            else if (stepsOfParsing == StepsOfParsing.theerdCatling) {
                //System.out.println("afterTwo");
                if (parseChar == 'k') {
                    chessBoard.castlingKingBlack = true;
                } else if (parseChar == 'K') {
                    chessBoard.castlingKingWhite = true;
                } else if (parseChar == 'q') {
                    chessBoard.castlingQueanBlack = true;
                } else if (parseChar == 'Q') {
                    chessBoard.castlingQueanWhite = true;
                } else if (parseChar == ' ') {
                    stepsOfParsing = StepsOfParsing.fourPassAttack;
                }
            }
            else if (stepsOfParsing == StepsOfParsing.fourPassAttack) {
                if (parseChar != ' ') {
                    chessBoard.passAttack = chessBoard.passAttack + parseChar;
                } else {
                    stepsOfParsing = StepsOfParsing.fiveNullStrocke;
                }
            }
            else if (stepsOfParsing == StepsOfParsing.fiveNullStrocke){
                if(parseChar != ' ')
                {
                    chessBoard.nullStrocke = chessBoard.nullStrocke + parseChar;
                }
                else
                {
                    stepsOfParsing = StepsOfParsing.sixNumStrocke;
                }
            }
            else if (stepsOfParsing == StepsOfParsing.sixNumStrocke)
            {
                if(parseChar != ' ')
                {
                    chessBoard.numStrocke = chessBoard.numStrocke + parseChar;
                }
                else
                {
                    break;
                }
            }


        }


    }
    public enum StepsOfParsing {firstFigures, secondSide, theerdCatling, fourPassAttack, fiveNullStrocke, sixNumStrocke}
}
