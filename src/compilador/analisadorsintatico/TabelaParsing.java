/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compilador.analisadorsintatico;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Leandro
 */
public class TabelaParsing {

    private int tabelaParsing[][] = new int[75][50];

     TabelaParsing() {
        tabelaParsing[44][13] = 1;
        tabelaParsing[45][1] = 2;
        tabelaParsing[45][5] = 2;
        tabelaParsing[45][33] = 2;
        tabelaParsing[45][37] = 2;
        tabelaParsing[46][1] = 3;
        tabelaParsing[46][5] = 4;
        tabelaParsing[46][23] = 4;
        tabelaParsing[46][33] = 4;
        tabelaParsing[46][37] = 4;
        tabelaParsing[47][5] = 10;
        tabelaParsing[47][23] = 11;
        tabelaParsing[47][37] = 11;
        tabelaParsing[48][37] = 11;
        tabelaParsing[48][23] = 14;
        tabelaParsing[49][14] = 5;
        tabelaParsing[50][5] = 9;
        tabelaParsing[50][14] = 8;
        tabelaParsing[50][23] = 14;
        tabelaParsing[50][33] = 9;
        tabelaParsing[50][37] = 9;
        tabelaParsing[51][34] = 7;
        tabelaParsing[51][35] = 7;
        tabelaParsing[51][38] = 6;
        tabelaParsing[52][1] = 13;
        tabelaParsing[52][5] = 13;
        tabelaParsing[52][23] = 13;
        tabelaParsing[52][41] = 12;
        tabelaParsing[53][2] = 23;
        tabelaParsing[53][3] = 15;
        tabelaParsing[53][4] = 17;
        tabelaParsing[53][11] = 18;
        tabelaParsing[53][14] = 22;
        tabelaParsing[53][16] = 23;
        tabelaParsing[53][18] = 20;
        tabelaParsing[53][20] = 16;
        tabelaParsing[53][21] = 19;
        tabelaParsing[53][22] = 21;
        tabelaParsing[53][24] = 23;
        tabelaParsing[53][33] = 23;
        tabelaParsing[53][37] = 23;
        tabelaParsing[54][16] = 23;
        tabelaParsing[54][33] = 26;
        tabelaParsing[55][8] = 46;
        tabelaParsing[55][9] = 46;
        tabelaParsing[55][14] = 46;
        tabelaParsing[55][32] = 46;
        tabelaParsing[55][41] = 46;
        tabelaParsing[55][43] = 46;
        tabelaParsing[56][2] = 33;
        tabelaParsing[56][16] = 33;
        tabelaParsing[56][24] = 33;
        tabelaParsing[56][33] = 33;
        tabelaParsing[56][37] = 33;
        tabelaParsing[57][14] = 34;
        tabelaParsing[58][38] = 35;
        tabelaParsing[58][40] = 36;
        tabelaParsing[59][2] = 29;
        tabelaParsing[59][16] = 29;
        tabelaParsing[59][24] = 29;
        tabelaParsing[59][33] = 29;
        tabelaParsing[59][37] = 29;
        tabelaParsing[59][41] = 28;
        tabelaParsing[60][8] = 38;
        tabelaParsing[60][9] = 38;
        tabelaParsing[60][10] = 37;
        tabelaParsing[60][14] = 38;
        tabelaParsing[60][32] = 38;
        tabelaParsing[60][41] = 38;
        tabelaParsing[60][43] = 38;
        tabelaParsing[61][38] = 39;
        tabelaParsing[61][40] = 40;
        tabelaParsing[62][8] = 41;
        tabelaParsing[63][8] = 24;
        tabelaParsing[63][14] = 25;
        tabelaParsing[64][38] = 30;
        tabelaParsing[64][40] = 31;
        tabelaParsing[65][35] = 43;
        tabelaParsing[65][38] = 42;
        tabelaParsing[66][16] = 45;
        tabelaParsing[66][33] = 44;
        tabelaParsing[67][8] = 49;
        tabelaParsing[67][9] = 49;
        tabelaParsing[67][14] = 49;
        tabelaParsing[67][32] = 47;
        tabelaParsing[67][41] = 49;
        tabelaParsing[67][43] = 48;
        tabelaParsing[68][2] = 56;
        tabelaParsing[68][7] = 56;
        tabelaParsing[68][16] = 56;
        tabelaParsing[68][17] = 56;
        tabelaParsing[68][19] = 56;
        tabelaParsing[68][24] = 56;
        tabelaParsing[68][26] = 53;
        tabelaParsing[68][27] = 52;
        tabelaParsing[68][28] = 50;
        tabelaParsing[68][29] = 55;
        tabelaParsing[68][30] = 54;
        tabelaParsing[68][31] = 51;
        tabelaParsing[68][33] = 56;
        tabelaParsing[68][37] = 56;
        tabelaParsing[68][38] = 56;
        tabelaParsing[68][40] = 56;
        tabelaParsing[69][8] = 57;
        tabelaParsing[69][9] = 57;
        tabelaParsing[69][14] = 57;
        tabelaParsing[69][41] = 57;
        tabelaParsing[70][2] = 61;
        tabelaParsing[70][6] = 60;
        tabelaParsing[70][7] = 61;
        tabelaParsing[70][16] = 61;
        tabelaParsing[70][17] = 61;
        tabelaParsing[70][19] = 61;
        tabelaParsing[70][24] = 61;
        tabelaParsing[70][26] = 61;
        tabelaParsing[70][27] = 61;
        tabelaParsing[70][28] = 61;
        tabelaParsing[70][29] = 61;
        tabelaParsing[70][30] = 61;
        tabelaParsing[70][31] = 61;
        tabelaParsing[70][32] = 58;
        tabelaParsing[70][33] = 61;
        tabelaParsing[70][37] = 61;
        tabelaParsing[70][38] = 61;
        tabelaParsing[70][40] = 61;
        tabelaParsing[70][43] = 59;
        tabelaParsing[71][8] = 66;
        tabelaParsing[71][9] = 68;
        tabelaParsing[71][14] = 69;
        tabelaParsing[71][41] = 67;
        tabelaParsing[72][2] = 65;
        tabelaParsing[72][6] = 65;
        tabelaParsing[72][7] = 65;
        tabelaParsing[72][16] = 65;
        tabelaParsing[72][17] = 65;
        tabelaParsing[72][19] = 65;
        tabelaParsing[72][24] = 65;
        tabelaParsing[72][25] = 64;
        tabelaParsing[72][26] = 65;
        tabelaParsing[72][27] = 65;
        tabelaParsing[72][28] = 65;
        tabelaParsing[72][29] = 65;
        tabelaParsing[72][30] = 65;
        tabelaParsing[72][31] = 65;
        tabelaParsing[72][32] = 65;
        tabelaParsing[72][33] = 65;
        tabelaParsing[72][36] = 63;
        tabelaParsing[72][37] = 65;
        tabelaParsing[72][38] = 65;
        tabelaParsing[72][39] = 62;
        tabelaParsing[72][40] = 65;
        tabelaParsing[72][43] = 65;

    }

    public int regra(int x, int y) {
        int pos = tabelaParsing[x][y];
        return pos;
    }
}
