package co.uk.beamsy.ooassign;


import co.uk.beamsy.ooassign.utils.List;

public class String {

    private StringContainer container;

    public String() {
        container = new StringContainer();
    }

    public String(char[] cs) {
        container = new StringContainer();
        for (int i = 0; i < cs.length; i++) {
            container.addCharacter(cs[i]);
        }
    }

    public String(Character[] cs) {
        container = new StringContainer();
        for (int i = 0; i < cs.length; i++) {
            container.addCharacter(cs[i]);
        }
    }

    public String(java.lang.String str) {
        this(str.toCharArray());
    }

    private String(StringContainer sc) {
        this.container = sc;
    }

    public int getLength() {
        return container.length;
    }

    public void append (Character[] cs) {
        for (int i = 0; i < cs.length; i++) {
            container.addCharacter(cs[i]);
        }
    }

    public void append (char[] cs) {
        for (int i = 0; i < cs.length; i++) {
            container.addCharacter(cs[i]);
        }
    }

    public void append (String s) {
        container.append(s.container);
    }

    public char getChar (int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= getLength()) throw new IndexOutOfBoundsException();
        return container.getCharacterAtIndex(index);
    }

    public String getSubString (int end) {
        return getSubString(0, end);
    }

    public String getSubString (int start, int end) {
        return new String(container.getSubContainer(start, end));
    }

    public void replace (Character oldChar, Character newChar) {

    }

    private class StringContainer implements Iterable {

        private StringMember first;
        private StringMember last;
        private int length = 0;

        protected StringContainer () {

        }

        private void addMember (StringMember sm) {
            last.setNext(sm);
            last = sm;
        }

        protected void addCharacter(Character c) {
            if (last != null) {
                addMember(new StringMember(c, last));
            } else {
                last = new StringMember(c, null);
                first = last;
            }
            length++;
        }

        protected void append (StringContainer sc) {
            StringMember scMember = sc.first;
            do {
                this.addMember(scMember);
                scMember = scMember.next;
            } while (scMember.next != null);

        }

        protected Character[] asCharacterArray() {
            StringMember member = first;
            Character[] arr = new Character[length];
            for (int i = 0; i < length; i++) {
                arr[i] = first.c;
                member = member.next;
            }
            return arr;
        }

        protected StringContainer getSubContainer(int startIndex, int endIndex) {
            StringContainer newContainer = new StringContainer();
            StringMember member = getMemberAtIndex(startIndex);
            for (int i = startIndex; i < endIndex; i++) {
                newContainer.addCharacter(member.c);
                member = member.next;
            }
            return newContainer;
        }

        protected Character getCharacterAtIndex(int index) {
            return getMemberAtIndex(index).c;
        }

        private StringMember getMemberAtIndex (int index) {
            StringMember member;
            if (index < length / 2) {
                member = first;
                for (int i = 0; i < index; i++) {
                    member = member.next;
                }
            } else {
                member = last;
                for (int i = length; i > index; i--) {
                    member = member.previous;
                }
            }
            return member;
        }

        private void setMemberAtIndex (int index, StringMember newMember) {
            StringMember oldMember = getMemberAtIndex(index);
            oldMember.previous.setNext(newMember);
            oldMember.next.setPrevious(newMember);
            oldMember = null;
        }

        private List<StringMember> getMembersOfChar (Character character) {
            List<StringMember> memberList = new List<>();
            StringMember member = first;
            do {
                if (member.c == character) {
                    memberList.addItem(member);
                }
                member = member.next;
            } while (member.next != null);
            return memberList;
        }

        private void replaceMembersOfChar (Character oldChar, Character newChar) {
            List<StringMember> memberList = getMembersOfChar(oldChar);
            for (StringMember member: memberList
                 ) {

            }
        }

        

        private class StringMember {
            private Character c;
            private StringMember previous;
            private StringMember next;

            private StringMember(Character c, StringMember previous) {
                this.c = c;
                this.previous = previous;
                previous.setNext(this);
            }

            public void setNext(StringMember next) {
                this.next = next;
            }

            public void setPrevious(StringMember previous){
                this.previous = previous;
            }

            public Character getC() {
                return c;
            }

            public StringMember getPrevious() {
                return previous;
            }

            public StringMember getNext() {
                return next;
            }
        }
    }

}
