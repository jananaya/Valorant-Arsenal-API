package types;

import java.util.Comparator;

import domain.interfaces.IWeapon;

public enum Yardstick implements Comparator<IWeapon> {
    NAME {
        @Override
        public int compare(IWeapon w1, IWeapon w2) {
            return w1.getName().compareTo(w2.getName());
        }
    },
    NUMBER_OF_SPECS {
        @Override
        public int compare(IWeapon w1, IWeapon w2) {
            return w2.getSpecs().size() - w1.getSpecs().size();
        }
    },
    CATEGORY {
        @Override
        public int compare(IWeapon w1, IWeapon w2) {
            return w1.getCategory().compareTo(w2.getCategory());
        }
    },
    DAMAGE {
        @Override
        public int compare(IWeapon w1, IWeapon w2) {
            return Float.compare(w1.getDamage(), w2.getDamage());
        }
    },
    RATE_OF_FIRE {
        @Override
        public int compare(IWeapon w1, IWeapon w2) {
            return Float.compare(w1.getRateOfFire(), w2.getRateOfFire());
        }
    },
    RATING {
        @Override
        public int compare(IWeapon w1, IWeapon w2) {
            return Float.compare(w1.getRating(), w2.getRating());
        }
    };
}