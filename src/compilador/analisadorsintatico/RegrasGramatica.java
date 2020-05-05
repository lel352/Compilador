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
public class RegrasGramatica {

    private Map<Integer, String[]> listRegras = new HashMap<Integer, String[]>();

    public RegrasGramatica() {
        listRegras.put(1, new String[]{"13", "14", "33", "45", "37"});
        listRegras.put(2, new String[]{"46", "47", "48"});
        listRegras.put(3, new String[]{"1", "49", "35", "12", "33", "50"});
        listRegras.put(4, new String[]{"15"});
        listRegras.put(5, new String[]{"14", "51"});
        listRegras.put(6, new String[]{"38", "14", "51"});
        listRegras.put(7, new String[]{"15"});
        listRegras.put(8, new String[]{"49", "35", "12", "33", "50"});
        listRegras.put(9, new String[]{"15"});
        listRegras.put(10, new String[]{"5", "14", "52", "45", "33", "47"});
        listRegras.put(11, new String[]{"15"});
        listRegras.put(12, new String[]{"41", "49", "35", "12", "40"});
        listRegras.put(13, new String[]{"15"});
        listRegras.put(14, new String[]{"23", "53", "54", "16"});
        listRegras.put(15, new String[]{"3", "55", "19", "48", "56"});
        listRegras.put(16, new String[]{"20", "55", "17", "53"});
        listRegras.put(17, new String[]{"4", "53", "24", "55"});
        listRegras.put(18, new String[]{"11", "41", "57", "58", "40"});
        listRegras.put(19, new String[]{"21", "14", "59"});
        listRegras.put(20, new String[]{"18", "41", "60", "61", "40"});
        listRegras.put(21, new String[]{"22", "55", "7", "62", "16"});
        listRegras.put(22, new String[]{"14", "51", "34", "63", "33"});
        listRegras.put(23, new String[]{"15"});
        listRegras.put(24, new String[]{"8"});
        listRegras.put(25, new String[]{"14"});
        listRegras.put(26, new String[]{"33", "53", "54"});
        listRegras.put(27, new String[]{"15"});
        listRegras.put(28, new String[]{"41", "55", "64", "40"});
        listRegras.put(29, new String[]{"15"});
        listRegras.put(30, new String[]{"38", "55", "64"});
        listRegras.put(31, new String[]{"15"});
        listRegras.put(32, new String[]{"2", "53"});
        listRegras.put(33, new String[]{"15"});
        listRegras.put(34, new String[]{"14"});
        listRegras.put(35, new String[]{"38", "57", "58"});
        listRegras.put(36, new String[]{"15"});
        listRegras.put(37, new String[]{"10"});
        listRegras.put(38, new String[]{"55"});
        listRegras.put(39, new String[]{"38", "60", "61"});
        listRegras.put(40, new String[]{"15"});
        listRegras.put(41, new String[]{"8", "65", "35", "53", "66"});
        listRegras.put(42, new String[]{"38", "8", "65"});
        listRegras.put(43, new String[]{"15"});
        listRegras.put(44, new String[]{"33", "66"});
        listRegras.put(45, new String[]{"15"});
        listRegras.put(46, new String[]{"67", "68"});
        listRegras.put(47, new String[]{"32", "69", "70"});
        listRegras.put(48, new String[]{"43", "69", "70"});
        listRegras.put(49, new String[]{"69", "70"});
        listRegras.put(50, new String[]{"28", "67"});
        listRegras.put(51, new String[]{"31", "67"});
        listRegras.put(52, new String[]{"27", "67"});
        listRegras.put(53, new String[]{"26", "67"});
        listRegras.put(54, new String[]{"30", "67"});
        listRegras.put(55, new String[]{"29", "67"});
        listRegras.put(56, new String[]{"15"});
        listRegras.put(57, new String[]{"71", "72"});
        listRegras.put(58, new String[]{"32", "69", "70"});
        listRegras.put(59, new String[]{"43", "69", "70"});
        listRegras.put(60, new String[]{"6", "69", "70"});
        listRegras.put(61, new String[]{"15"});
        listRegras.put(62, new String[]{"39", "71", "72"});
        listRegras.put(63, new String[]{"36", "71", "72"});
        listRegras.put(64, new String[]{"25", "71", "72"});
        listRegras.put(65, new String[]{"15"});
        listRegras.put(66, new String[]{"8"});
        listRegras.put(67, new String[]{"41", "55", "40"});
        listRegras.put(68, new String[]{"9", "71"});
        listRegras.put(69, new String[]{"57"});
    }
    
    public String[] getGramatica(int regra){
         return listRegras.get(regra);
    }    
        
}
