package util;

import java.util.ArrayList;

public class ModArrayList extends ArrayList {
        private long previousValue;

        public ModArrayList(long initialValue) {
            super();

            previousValue = initialValue;

        }
        public void setPreviousValue(long value){
            previousValue = value;
        }
        public long getPreviousValue() {
            return previousValue;
        }
}


