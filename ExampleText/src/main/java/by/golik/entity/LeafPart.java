package by.golik.entity;

import java.util.Iterator;

/**
 * @author Nikita Golik
 */
    public class LeafPart implements TextElement {

        String str;

        public LeafPart(String str) {
            this.str = str;
        }

        @Override
        public void addElement(TextElement part) {
            throw new UnsupportedOperationException();

        }

        @Override
        public TextElement getElement(int index) {
            return this;
        }

        @Override
        public void parse() {
            throw new UnsupportedOperationException();
        }

        @Override
        public String toString() {
            return str;
        }
    }
