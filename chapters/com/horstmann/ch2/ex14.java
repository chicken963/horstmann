package com.horstmann.ch2;

import java.util.ArrayList;

public class ex14 {
    public class Member {
        private String name;
        private ArrayList<Member> friends;
        public Member(String name) {
            this.name = name;
            friends = new ArrayList<Member>() ;
        }

        public Member enroll(String name) {
            Member newMember = new Member(name);
            members.add(newMember);
            return newMember;
        }

       public void leave() {
            members.remove(this) ;
        }
    }

    public boolean belongsTo(ex14 n) {
        return ex14.this == n;
    }
    private ArrayList<Member> members;
}
//javap -private ex14$Member.class