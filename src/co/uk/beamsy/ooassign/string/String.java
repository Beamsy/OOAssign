package co.uk.beamsy.ooassign.string;

public class String {
    private char[] contents;

    public String(char[] contents) {
        this.contents = contents;
    }

    public String() {
        this.contents = new char[1];
    }

    public void addChar(char _char) {
        char[] newArr = new char[contents.length+1];
        for (int i = 0; i < contents.length; i++) {
            newArr[i] = contents[i];
        }
        newArr[contents.length - 1] = _char;
        contents = newArr;
    }

    public char[] getContents() {
        return contents;
    }

    public char getChar(int i) throws IndexOutOfBoundsException{
        if (i > contents.length-1 || i < 0) throw new IndexOutOfBoundsException();
        return contents[i];
    }

    public String getSubString(int end) {
        end--;
        if (end > contents.length || end < 0) throw new IndexOutOfBoundsException();
        char[] sub = new char[end+1];
        for (int i = 0; i <= end; i++) {
            sub[i] = contents[i];
        }
        return new String(sub);
    }

    public String getSubString (int start, int end) {
        end--;
        start--;
        if (end > contents.length ||
                end < 0 ||
                start > end ||
                start < 0 ||
                start > contents.length)
            throw new IndexOutOfBoundsException();
        char[] sub = new char[(end-start)+1];
        for (int i = start, j = 0; i <= end; i++, j++) {
            sub[j] = contents[i];
        }
        return new String(sub);
    }

    public int length () {
        return contents.length;
    }

    public void replace (char oldChar, char newChar) {
        for (int i = 0; i < contents.length; i++) {
            if (contents[i] == oldChar) contents[i] = newChar;
        }
    }

    public void replace (char[] oldChars, char[] newChars) {
        stringiterator: for (int i = 0; i < contents.length; i++) {
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
                char[] newContents = new char[before.length+newChars.length+after.length];
                for (int j = 0; j < before.length; j++) {
                    newContents[j] = before[j];
                }
                for (int j = before.length, k = 0; j < before.length + newChars.length; j++, k++) {
                    newContents[j] = newChars[k];
                }
                for (int j = before.length + newChars.length, k = 0;
                     j < before.length + newChars.length + after.length; j++, k++) {
                    newContents[j] = after[k];
                }
                contents = newContents;
                i += newChars.length;
            }
        }
    }

    //Override Object.toString() for easier System.out.println() implementation
    @Override
    public java.lang.String toString() {
        return new java.lang.String(contents);
    }


}
