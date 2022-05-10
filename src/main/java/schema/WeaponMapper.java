package schema;

import domain.interfaces.IWeapon;

import java.util.ArrayList;

public class WeaponMapper {

    public static WeaponDTO toDto(IWeapon weapon) {
        return new WeaponDTO(weapon.getId(), weapon.getName(), weapon.getCategory(),
                weapon.getSpecs(), weapon.getImagePath(), weapon.getRateOfFire(),
                weapon.getDamage(), weapon.getRating()
        );
    }

    public static ArrayList<WeaponDTO> toDto(ArrayList<IWeapon> weapons) {
        ArrayList<WeaponDTO> weaponsDto = new ArrayList<>();

        for (IWeapon weapon : weapons) {
            weaponsDto.add(toDto(weapon));
        }

        return weaponsDto;
    }
}
