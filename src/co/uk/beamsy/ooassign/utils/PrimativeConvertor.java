package co.uk.beamsy.ooassign.utils;

public class PrimativeConvertor {

    public static Character[] CharArrToCharacterArr (char[] chars) {
        Character[] characters = new Character[chars.length];
        for (int i = 0; i < chars.length; i++) {
            characters[i] = chars[i];
        }
        return characters;
    }

    public static char[] CharacterArrToCharArr (Character[] characters) {
        char[] chars = new char[characters.length];
        for (int i = 0; i < characters.length; i++) {
            chars[i] = characters[i];
        }
        return chars;
    }
}
