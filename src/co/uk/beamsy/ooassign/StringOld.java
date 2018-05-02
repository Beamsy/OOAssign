package co.uk.beamsy.ooassign;

import co.uk.beamsy.ooassign.utils.List;
import co.uk.beamsy.ooassign.utils.PrimativeConvertor;

public class StringOld {
    private List<Character> contentsList;

    public StringOld(char[] contents) {
        contentsList = contentsList.fromArray(PrimativeConvertor.CharArrToCharacterArr(contents));
    }

    public StringOld(List<Character> charList) {
        this.contentsList = charList;
    }

    public StringOld() {
        this.contentsList = new List<>();
    }

    public StringOld(java.lang.String string) {
        contentsList = contentsList.fromArray(PrimativeConvertor.CharArrToCharacterArr(string.toCharArray()));
    }

    public void addChar(char _char) {
        contentsList.addItem(_char);
    }

    public Character[] getContents() {
        return contentsList.toArray(Character.class);
    }

    public Character getChar(int i) throws IndexOutOfBoundsException{ //Gets character at index i
        if (i > contentsList.getCount()-1 || i < 0) throw new IndexOutOfBoundsException(); //Checks i is in range of array
        return contentsList.get(i); //Returns character
    }

    public StringOld getSubString(int end) {
        return getSubString(0 , end);
    }

    public StringOld getSubString (int start, int end) {
        if (end > contentsList.getCount() ||
                end < 0 ||
                start > end ||
                start < 0 ||
                start > contentsList.getCount())
            throw new IndexOutOfBoundsException();
        List<Character> sub = new List<>();
        for (int i = ++start; i < end; i++) {
            sub.addItem(contentsList.get(i));
        }
        return new StringOld(sub);
    }

    public int length () {
        return contentsList.getCount();
    }

    public void replace (char oldChar, char newChar) {
        for (int i = 0; i < contents.length; i++) {
            if (contents[i] == oldChar) contents[i] = newChar;
        }
    }

    public void replace (char[] oldChars, char[] newChars) {
        stringiterator:
        for (int i = 0; i < contents.length; i++) {
            if (contents[i] == oldChars[0]) {
                for (int j = 0; j < oldChars.length; j++) {
                    if (contents[i+j] != oldChars[j]) continue stringiterator;
                }
                char[] before = new char[0];
                if (i > 0) {
                    before = getSubString(i).getContents();
                }
                char[] after = new char[0];
                if (contents.length > i+oldChars.length) {
                    after = getSubString(i+(oldChars.length)+1, contents.length).getContents();
                }
                StringOld newContents = new StringOld(before);
                newContents.append(newChars);
                newContents.append(after);
                contents = newContents.getContents();
                i += newChars.length;
            }
        }
    }

    public int search(char[] term) {
        stringiterator: for (int i = 0; i < contents.length; i++) {
            if (contents[i] == term[0]) {
                for (int j = 0; j < term.length; j++) {
                    if (contents[i + j] != term[j]) continue stringiterator;
                }
                return i;
            }
        }
        return -1;
    }

    public int search(char term) {
        for (int i = 0; i < contents.length; i++) {
            if (contents[i] == term) {
                return i;
            }
        }
        return -1;
    }

    public void append(char[] toAdd) {
        char[] _contents = new char[contents.length + toAdd.length];
        for (int i = 0; i < contents.length; i++) {
            _contents[i] = contents[i];
        }
        for (int i = contents.length, j = 0; i < _contents.length; i++, j++) {
            _contents[i] = toAdd[j];
        }
        contents = _contents;
    }

    public boolean isEmpty() {
        return contents.length == 0;
    }
    
    public void reverse() {
    	char[] _contents = new char[contents.length];
    	for (int i = contents.length-1, j = 0; i >= 0; i--, j++) {
    		_contents[j] = contents[i];
    	}
    	contents = _contents;
    }

    //Override Object.toString() for easier System.out.println() implementation
    @Override
    public java.lang.String toString() {
        return new java.lang.String(contents);
    }


}
